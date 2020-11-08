class WhileNonWhile extends WhileStmt implements BG {

	NonWhileStmt nonWhileStatement;
  public WhileNonWhile(WhileBase w, NonWhileStmt n)
  {
    super(w);
    nonWhileStatement = n;

  }

  public String toString(int t)
  {
  	return( super.toString(t) + T(t) + "{\n" + nonWhileStatement.toString(t + 1) + T(t) + "}\n" );
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

