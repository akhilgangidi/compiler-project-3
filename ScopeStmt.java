class ScopeStmt extends NonWhileStmt implements BG {
	FieldDecls fieldDeclarations;
  Stmts statements;
  Boolean hasSemicolon;
  public ScopeStmt(FieldDecls f, Stmts s, OptionalSemi o)
  {
    fieldDeclarations = f;
    statements = s;
    hasSemicolon = o != null;
  }

  public String toString(int t)
  {
  	return(T(t) + "{\n" + 
      (fieldDeclarations != null ? fieldDeclarations.toString(t + 1) : "") + 
      (statements != null ? statements.toString(t + 1) : "") + 
      T(t) + "}" + (hasSemicolon ? ";\n" : "\n"));
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

