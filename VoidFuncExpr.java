class VoidFuncExpr extends FuncExpr implements BG {
  public VoidFuncExpr(String i)
  {
    super(i);
  }

  public String toString(int t)
  {
  	return(id + "()");
  }

  public void typeCheck(int scope, String method) throws NewException{
    System.out.println(id);
    try {
      table.find(id, scope);
    }
    catch(NewException e) {
      throw e;
    }
  }

  public TypeClass getType() {
    return null;
  }
}

