class ReadStmt extends NonWhileStmt implements BG {
	ReadList readList;
  public ReadStmt(ReadList r)
  {
    readList = r;
  }

  public String toString(int t)
  {
  	return(T(t) + "read(" + readList.toString(t) + ");\n");
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

