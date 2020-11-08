class MethodDecls extends BaseGrammarTop implements BG {
	MethodDecl methodDeclaration;
	MethodDecls methodDeclarations;

  public MethodDecls(MethodDecl m, MethodDecls s)
  {
  	methodDeclaration = m;
  	methodDeclarations = s;
  }

  public MethodDecls(MethodDecl m)
  {
    methodDeclaration = m;
    methodDeclarations = null;
  }

  public String toString(int t)
  {
  	return(methodDeclaration.toString(t) + 
      (methodDeclarations != null ? methodDeclarations.toString(t) : "") );
  }

  public void typeCheck(int scope) throws NewException {
    try {
		methodDeclaration.typeCheck(scope);
	} catch(NewException e) {
		try {
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

