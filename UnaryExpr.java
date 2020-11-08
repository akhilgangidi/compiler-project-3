class UnaryExpr extends NonTypeCastExpr implements BG {
	String operator;
  Expr expression;
  public UnaryExpr(String o, Expr e)
  {
    operator = o;
    expression = e;
  }

  public String toString(int t)
  {
  	return("(" + operator + expression.toString(t) + ")");
  }

  public void typeCheck(int scope, String method) throws NewException{
    expression.typeCheck(scope, method);
  }

  public TypeClass getType() throws NewException {
    TypeClass ty = expression.getType();
    return ty;
  }
}

