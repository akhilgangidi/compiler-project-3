class FieldDecls extends BaseGrammarTop implements BG {
	FieldDecl fieldDeclaration;
	FieldDecls fieldDeclarations;

  public FieldDecls(FieldDecl f, FieldDecls s)
  {
  	fieldDeclaration = f;
  	fieldDeclarations = s;
  }

  public FieldDecls(FieldDecl f)
  {
    fieldDeclaration = f;
    fieldDeclarations = null;
  }

  public String toString(int t)
  {
  	return(fieldDeclaration.toString(t) + (fieldDeclarations != null ? fieldDeclarations.toString(t) : "") );
  }

  public void typeCheck(int scope, String methodName) throws NewException {
    fieldDeclaration.typeCheck(scope, methodName);
    if(fieldDeclarations != null) {
      fieldDeclarations.typeCheck(scope, methodName);
    }
  }
}

