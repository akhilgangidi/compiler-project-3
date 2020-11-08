class MatchedFinalIf extends MatchedIf implements BG {
  NonIfStmt nonIfStatement;
  
  public MatchedFinalIf(NonIfStmt n)
  {
    nonIfStatement = n;
  }

  public String toString(int t)
  {
  	return nonIfStatement.toString(t);
  }
}

