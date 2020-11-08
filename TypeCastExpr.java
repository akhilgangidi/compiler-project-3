class TypeCastExpr extends ActionExpr implements BG {
	Type type;
  Expr expression;
  public TypeCastExpr(Type t, Expr e)
  {
    type = t;
    expression = e;
  }

  public String toString(int t)
  {
  	return("((" + type.toString(t) + ")" + expression.toString(t) + ")");
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

