class FieldDeclSingle extends FieldDecl implements BG {

	Boolean isFinal;
	OptionalExpr expression;
	public FieldDeclSingle(OptionalFinal f, FieldStart s, OptionalExpr e)
	{
		super(s);
		isFinal = true;
		expression = e;
	}

	public FieldDeclSingle(FieldStart f, OptionalExpr e)
	{
		super(f);
		isFinal = false;
		expression = e;
	}

	public String toString(int t)
	{
		return( T(t) + (isFinal ? "final " : "") + super.toString(t) + 
			(expression != null ? expression.toString(t) : "") + ";\n");
	}

	public void typeCheck(int scope, String methodName) throws NewException {
		TypeClass ty = new TypeClass(fieldStart.type, false, isFinal);
		if(isFinal && expression == null) {
			throw new NewException("final fields needs to have a value: " + this.toString(0));
		}
		else if(expression != null) {
			if(! (ty.equals(expression.getType()) || 
				(ty.equals(new TypeClass(new FloatType(), false, false)) 
				&& expression.getType().equals(new TypeClass(new IntType(), false, false))) ||
				(ty.equals(new TypeClass(new BoolType(), false, false))
				 && expression.getType().equals(new TypeClass(new IntType(), false, false))))) {
					throw new NewException("Expression must have same type as the field declaration: " + this.toString(0));
				}
		}
		table.insert(fieldStart.id, scope, ty, methodName);
	 }

}



