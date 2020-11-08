class NestedWhile extends WhileStmt implements BG {

	WhileStmt whileStatement;
  public NestedWhile(WhileBase w, WhileStmt n)
  {
    super(w);
    whileStatement = n;

  }

  public String toString(int t)
  {
  	return( super.toString(t) + T(t) + "{\n" + whileStatement.toString(t + 1) + T(t) + "}\n");
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

