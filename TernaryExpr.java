class TernaryExpr extends Expr implements BG {
	Expr condition;
	Expr whenTrue;
	Expr whenFalse;

  public TernaryExpr(Expr a, Expr b, Expr c)
  {
    condition = a;
    whenTrue = b;
    whenFalse = c;
  }

  public String toString(int t)
  {
  	return ("(" + condition.toString(t) + " ? "  + whenTrue.toString(t) + " : " + whenFalse.toString(t) + ")");
  }

  public void typeCheck(int scope, String method) throws NewException {
    System.out.println("Hello");
  }

  public TypeClass getType() throws NewException{
    if(condition.getType().getType().toString(0) == "float" || condition.getType().getType().toString(0) == "int") {
      throw new NewException("Incompatible condition has been used: " + toString(0));
    }
    if(whenTrue.getType().getType().toString(0) != whenFalse.getType().getType().toString(0)) {
      throw new NewException("Both true and false types are not equal: " + toString(0));
    }
    return whenTrue.getType();
  }
}

