class IfBase extends BaseGrammarTop implements BG {
  Expr expression;
  public IfBase(Expr e)
  {
    expression = e;
  }

  public String toString(int t)
  {
  	return ("if (" + expression.toString(t) + ")\n");
  }

  public void typeCheck(int scope) throws NewException {
    try {
      expression.typeCheck(scope, "");
    } catch(NewException e) {
      throw e;
    }
  }
}

