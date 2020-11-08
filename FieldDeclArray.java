class FieldDeclArray extends FieldDecl implements BG {

	int intlit;
	public FieldDeclArray(FieldStart f, int n)
	{
		super(f);
		intlit = n;
	}

	public String toString(int t)
	{
		return( T(t) + super.toString(t) + "[" + intlit + "];\n");
	}

	public void typeCheck(int scope, String methodName) throws NewException {
		TypeClass ty = new TypeClass(fieldStart.type, false, false);
		try {
			table.insert(fieldStart.id, scope, ty, methodName);
		} catch(NewException e) {
			throw e;
		}
	}
}