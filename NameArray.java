class NameArray extends Name implements BG {
	Expr expression;
  public NameArray(String i, Expr e)
  {
    super(i);
    expression = e;
  }

  public String toString(int t)
  {
  	return(id + "[" + expression.toString(t) + "]");
  }

  public void typeCheck(int scope, String method) throws NewException {
    if(expression != null) {
      super.typeCheck(scope, method);
      expression.typeCheck(scope, method);
    }
   }
}