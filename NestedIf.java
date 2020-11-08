class NestedIf extends UnmatchedIf implements BG {
  IfStmt ifStatement;
  public NestedIf(IfStmt i)
  {
    ifStatement = i;
  }

  public String toString(int t)
  {
  	return ifStatement.toString(t);
  }
}

