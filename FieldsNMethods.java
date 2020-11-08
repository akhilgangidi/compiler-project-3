class FieldsNMethods extends BaseGrammarTop implements BG
{
	FieldDecl fieldDeclaration;
	FieldsNMethods fieldsAndMethods;
	MethodDecl methodDeclaration;
	MethodDecls methodDeclarations;

	public FieldsNMethods(FieldDecl f, FieldsNMethods s)
	{
		fieldDeclaration = f;
		fieldsAndMethods = s;
		methodDeclaration = null;
		methodDeclarations = null;
	}

	public FieldsNMethods(MethodDecl m, MethodDecls s)
	{
		fieldDeclaration = null;
		fieldsAndMethods = null;
		methodDeclaration = m;
		methodDeclarations = s;
	}

	public String toString(int t)
	{
		if (methodDeclaration != null)
			return (methodDeclaration.toString(t) + (methodDeclarations != null ? methodDeclarations.toString(t) : "" ));
    	return( fieldDeclaration.toString(t) + (fieldsAndMethods != null ? fieldsAndMethods.toString(t) : "") );
	}

	public void typeCheck(int scope, String methodName) throws NewException {
		if(fieldDeclaration != null) {
			try {
				fieldDeclaration.typeCheck(scope, methodName);
			} catch(NewException e) {
				try {
					if(fieldsAndMethods != null) {
						fieldsAndMethods.typeCheck(scope, methodName);
					}
				} catch(NewException e2) {
					
				}
				throw e;
			}
			if(fieldsAndMethods != null) {
				fieldsAndMethods.typeCheck(scope, methodName);
			}
		}
		else {
			try {
				methodDeclaration.typeCheck(scope);
			} catch(NewException e) {
				try{
					if(methodDeclarations != null) {
						methodDeclarations.typeCheck(scope);
					}
				} catch(NewException e2) {

				}
				throw e;
			}
			if(methodDeclarations != null) {
				methodDeclarations.typeCheck(scope);
			}
		}
	}
}