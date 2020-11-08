class WhileIf extends WhileStmt implements BG {

	IfStmt ifStatement;
  public WhileIf(WhileBase w, IfStmt i)
  {
    super(w);
    ifStatement = i;

  }

  public String toString(int t)
  {
  	return( super.toString(t) + T(t) + "{\n" + ifStatement.toString(t + 1) + T(t) + "}\n" );
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

