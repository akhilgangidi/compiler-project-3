class VoidReturn extends NonWhileStmt implements BG {
  public VoidReturn()
  {
  }

  public String toString(int t)
  {
  	return(T(t) + "return;\n");
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

