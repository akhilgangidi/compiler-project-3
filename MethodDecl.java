class MethodDecl extends BaseGrammarTop implements BG {

	MethodStart methodStart;
	ArgDecls argumentDeclarations;
	FieldDecls fieldDeclarations;
	Stmts statements;
	Boolean hasSemicolon;

	public MethodDecl(MethodStart m, ArgDecls a, FieldDecls f, Stmts s, OptionalSemi o)
	{
		methodStart = m;
		argumentDeclarations = a;
		fieldDeclarations = f;
		statements = s;
		hasSemicolon = o != null;
	}

	public MethodDecl(MethodStart m, FieldDecls f, Stmts s, OptionalSemi o)
	{
		methodStart = m;
		argumentDeclarations = null;
		fieldDeclarations = f;
		statements = s;
		hasSemicolon = o != null;
	}

	public String toString(int t)
	{
		return( T(t) + methodStart.toString(t) + "(" + 
			( argumentDeclarations != null ? argumentDeclarations.toString(t) : "") 
			+ ")\n" + T(t) +"{\n" + 
			(fieldDeclarations != null ? fieldDeclarations.toString(t + 1) : "") 
			+ (statements != null ? statements.toString(t + 1) : "")
			+ T(t) + "}" + (hasSemicolon ? ";\n" : "\n") );
	}

	public void typeCheck(int s) throws NewException {
		TypeClass[] argumentType = null;
		try{
			if(argumentDeclarations != null) {
				argumentType = new TypeClass[argumentDeclarations.getTypes().size()];
				for(int i = 0; i < argumentDeclarations.getTypes().size(); i++) {
					argumentType[i] = argumentDeclarations.getTypes().get(i);
				}
				TypeClass ty = new TypeClass(methodStart.returnType, false, false);
				table.insert(methodStart.id, s, ty, argumentType);
			}
			else {
				TypeClass ty = new TypeClass(methodStart.returnType, false, false);
				table.insert(methodStart.id, s, ty);
			}
			
			if(argumentDeclarations != null) {
				int scope = s+1;
				argumentDeclarations.typeCheck(scope);
			}
			if(fieldDeclarations != null) {
				int scope = s+1;
				fieldDeclarations.typeCheck(scope, methodStart.id);
			}
			if(statements != null) {
				int scope = s+1;
				statements.typeCheck(scope, methodStart.id);
			}
			if(statements == null && (methodStart.returnType.toString(0) != "void")) {
				System.out.println();
				throw new NewException("Every non-void function requires a return statement"); 
			}
		} catch(NewException e) {
			throw e;
		}
		
	}

}