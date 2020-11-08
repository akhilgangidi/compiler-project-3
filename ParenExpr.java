class ParenExpr extends Expr implements BG {
	Expr expression;
  public ParenExpr(Expr e)
  {
    expression = e;
  }

  public String toString(int t)
  {
  	return("(" + expression.toString(t) + ")");
  }

  public void typeCheck(int scope, String method) throws NewException {
    expression.typeCheck(scope, method);
  }

  public TypeClass getType() throws NewException {
    TypeClass ty = expression.getType();
    return ty;
  }
}

