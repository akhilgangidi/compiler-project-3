class MatchedIfBase extends IfBackend implements BG {
  MatchedIf matchedIf;
  Stmt statement;
  public MatchedIfBase(MatchedIf m, Stmt s)
  {
    matchedIf = m;
    statement = s;
  }

  public String toString(int t)
  {
  	return (matchedIf.toString(t) + T(t - 1) + "}\n" + T(t - 1) +
      "else\n" + T(t - 1) + "{\n" + statement.toString(t));
  }
}

