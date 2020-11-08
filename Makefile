# uses JFlex >= 1.3.2, and CUP >= 0.10j
#
# targets:
#
# make all                                                            
#    generates lexer, and parser, and compiles all *.java files
#                                                                     
# make run (or just: make)                                           
#    starts the program on a test example
#                                                                     

JAVA=java
JAVAC=javac
# Root of the project
JFLEX=$(JAVA) -jar jflex-full-1.7.0.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: runFI

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $*.java

FILE=	BaseGrammarLexer.java      parser.java    sym.java \
		NewException.java TypeClass.java VarData.java VarTable.java ArgDecl.java ArgDeclArray.java ArgDecls.java ArgDeclSingle.java \
		ArgFuncStmt.java Args.java AssmntStmt.java BG.java BinaryExpr.java \
		BoolLit.java CharLit.java Expr.java FieldDecl.java \
		FieldDeclArray.java FieldDecls.java FieldDeclSingle.java FloatLit.java \
		FuncStmt.java IfBackend.java IfBackendStmt.java IfBase.java IfStmt.java \
		IntLit.java MatchedFinalIf.java MatchedIf.java MatchedIfBase.java \
		MatchedInnerIf.java MemberDecls.java MethodDecl.java MethodDecls.java \
		Name.java NameArray.java NestedIf.java NonIfStmt.java OptionalExpr.java \
		OptionalFinal.java OptionalSemi.java ParenExpr.java PrintList.java \
		PrintLnList.java PrintLnStmt.java PrintStmt.java Program.java ReadList.java \
		ReadStmt.java ReturnType.java ScopeStmt.java Stmt.java Stmts.java \
		StrLit.java TernaryExpr.java Type.java TypeCastExpr.java TypeLit.java \
		UnaryExpr.java UnaryStmt.java ValueReturn.java VoidFuncStmt.java VoidReturn.java \
		WhileStmt.java UnmatchedIf.java FuncExpr.java VoidFuncExpr.java \
		ArgFuncExpr.java FieldStart.java FieldsNMethods.java VoidType.java \
		WhileBase.java WhileNonWhile.java WhileIf.java NestedWhile.java \
		WhileMatchedIf.java WhileMatchedIfEnd.java NestedIfWhiles.java \
		NestedWhile.java NestedWhileEnd.java NestedWhileIf.java NestedWhileEndIf.java \
		NestedMatchedWhileIf.java BaseGrammarTop.java IntType.java FloatType.java \
		CharType.java BoolType.java NonTypeCastExpr.java ActionExpr.java WhileWithFi.java\
	ExampleTypeCheckerTest.java

dump: parserD.java $(FILE:java=class)

runFI: setFI test1DEOutput.txt

setDE:
	cp BaseGrammar-tokensDE.cup BaseGrammar-tokens.cup

setFI:
	cp BaseGrammar-tokensFI.cup BaseGrammar-tokens.cup

test1DEOutput.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test1DE.txt > test1DEOutput.txt
	cat -n test1DEOutput.txt

test2DEOutput.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test2DE.txt > test2DEOutput.txt
	cat -n test2DEOutput.txt

test1FIOutput.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test1FI.txt > test1FIOutput.txt
	cat -n test1FIOutput.txt

test2FIOutput.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test2FI.txt > test2FIOutput.txt
	cat -n test2FIOutput.txt

test3Output.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test3.txt > test3Output.txt
	cat -n test3Output.txt

test4Output.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test4.txt > test4Output.txt
	cat -n test4Output.txt

test5Output.txt: all
	$(JAVA) -cp $(CP) ExampleTypeCheckerTest < test5.txt > test5Output.txt
	cat -n test5Output.txt


all: BaseGrammarLexer.java parser.java $(FILE:java=class)


clean:
	rm -f *.class *~ *.bak BaseGramamrLexer.java parser.java sym.java

BaseGrammarLexer.java: BaseGrammar.jflex
	$(JFLEX) BaseGrammar.jflex

parser.java: BaseGrammar-tokens.cup
	$(CUP) -interface < BaseGrammar-tokens.cup 

parserD.java: BaseGrammar-tokens.cup
	$(CUP) -interface -dump < BaseGrammar-tokens.cup
