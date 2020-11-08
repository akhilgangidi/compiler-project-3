class OptionalExpr extends BaseGrammarTop implements BG {

	Expr expression;
	public OptionalExpr(Expr e)
	{
		expression = e;
	}

	public String toString(int t)
	{
		return( " = " + expression.toString(t));
	}

	public TypeClass getType() throws NewException {
		TypeClass ty;
		ty = expression.getType();
		return ty;
	}
}