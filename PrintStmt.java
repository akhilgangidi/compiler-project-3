class PrintStmt extends NonWhileStmt implements BG {
	PrintList printList;
  public PrintStmt(PrintList p)
  {
    printList = p;
  }

  public String toString(int t)
  {
  	return(T(t) + "print(" + printList.toString(t) + ");\n");
  }

  public void typeCheck(int scope, String method) throws NewException{
    if(printList != null) {
      printList.typeCheck(scope);
    }
  }

  public TypeClass getType() { 
    return null;
  }
}

