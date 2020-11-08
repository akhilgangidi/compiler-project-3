class VoidFuncStmt extends FuncStmt implements BG {
  public VoidFuncStmt(String i)
  {
    super(i);
  }

  public String toString(int t)
  {
  	return(T(t) + id + "();\n");
  }

  public void typeCheck(int scope, String method) throws NewException{
    table.find(id,scope);
  }

  public TypeClass getType() {
    return null;
  }
}

