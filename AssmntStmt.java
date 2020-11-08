class AssmntStmt extends NonWhileStmt implements BG {
	Name name;
  Expr expression;
  public AssmntStmt(Name n, Expr e)
  {
    name = n;
    expression = e;
  }

  public String toString(int t)
  {
  	return(T(t) + name.toString(t) + " = " + expression.toString(t) + ";\n");
  }

  public void typeCheck(int scope, String method) throws NewException {
    if(expression != null) {
      if(name.getType().getType().toString(0) != expression.getType().getType().toString(0)) {
        throw new NewException("Cannot assign variables of different types: " + toString(0));
      }
      if(name.getType().getFinal()) {
        throw new NewException("Cannot reassign a final variable: " + toString(0));
      }
    }
  }

  public TypeClass getType() {
    TypeClass ty = new TypeClass(new BoolType(), false, false);
    return ty;
  }
}

