class WhileWithFi extends WhileStmt implements BG {

	Stmt statement;
  public WhileWithFi(WhileBase w, Stmt s)
  {
    super(w);
    statement = s;

  }

  public String toString(int t)
  {
  	return( super.toString(t) + T(t) + "{\n" + statement.toString(t + 1) + T(t) + "}\n" );
  }

  public TypeClass getType() {
    return null;
  }

  public void typeCheck(int scope, String method) throws NewException {
    if(whileBase.expression != null) {
      whileBase.typeCheck(scope);
    }
    statement.typeCheck(scope+1, method);
  }
}

