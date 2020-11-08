class ValueReturn extends NonWhileStmt implements BG {
	Expr expression;
  public ValueReturn(Expr e)
  {
    expression = e;
  }

  public String toString(int t)
  {
  	return(T(t) + "return " + expression.toString(t) + ";\n");
  }

  public void typeCheck(int scope, String id) throws NewException{
    if(table.getType(id).getType().toString(0) != expression.getType().getType().toString(0)) {
      throw new NewException("Return statement is of different type compared to the method type: " + toString(0));
    }
  }

  public TypeClass getType() {
    return null;
  }
}

