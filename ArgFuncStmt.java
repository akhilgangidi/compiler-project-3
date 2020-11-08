class ArgFuncStmt extends FuncStmt implements BG {
	Args arguments;
  public ArgFuncStmt(String i, Args a)
  {
    super(i);
    arguments = a;
  }

  public String toString(int t)
  {
  	return(T(t) + id + "(" + arguments.toString(t) + ");\n");
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

