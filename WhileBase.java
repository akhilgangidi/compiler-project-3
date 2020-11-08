class WhileBase extends BaseGrammarTop implements BG {
  Expr expression;
  public WhileBase(Expr e)
  {
    expression = e;
  }

  public String toString(int t)
  {
  	return(T(t) + "while(" + expression.toString(t) + ")\n");
  }

  public void typeCheck(int scope) throws NewException {
    if(expression != null) {
      TypeClass ty = expression.getType();
      expression.typeCheck(scope, "");
      if(ty.getType().toString(0) != "bool") {
        throw new NewException(ty.getType().toString(0) + " type is not allowed within while expression.");
      }
    }
  }
}

