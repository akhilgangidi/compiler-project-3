class IfBackendStmt extends UnmatchedIf implements BG {
  NonIfStmt nonIfStatement;
  public IfBackendStmt(NonIfStmt n)
  {
    nonIfStatement = n;
  }

  public String toString(int t)
  {
  	return nonIfStatement.toString(t);
  }
}

