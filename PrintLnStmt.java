class PrintLnStmt extends NonWhileStmt implements BG {
	PrintLnList printLineList;
  public PrintLnStmt(PrintLnList p)
  {
    printLineList = p;
  }

  public String toString(int t)
  {
  	return(T(t) + "printline(" + printLineList.toString(t) + ");\n");
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

