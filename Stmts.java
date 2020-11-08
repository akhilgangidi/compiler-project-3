class Stmts extends BaseGrammarTop implements BG {
  Stmt statement;
  Stmts statements;
  public Stmts(Stmt s, Stmts x)
  {
    statement = s;
    statements = x;
  }

  public String toString(int t)
  {
  	return (statement.toString(t) + (statements != null ? statements.toString(t) : ""));
  }

  public void typeCheck(int scope, String id) throws NewException {
    statement.typeCheck(scope, id);
    if(statements != null) {
      statements.typeCheck(scope, id);
    }
  }

}

