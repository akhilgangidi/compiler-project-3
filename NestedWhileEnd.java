class NestedWhileEnd extends NestedMatchedWhile implements BG {

	NonWhileStmt nonWhileStatement;
  public NestedWhileEnd(WhileBase w, NonWhileStmt n)
  {
    super(w);
    nonWhileStatement = n;
  }

  public String toString(int t)
  {
  	return( super.toString(t) + T(t) +  "{\n" + nonWhileStatement.toString(t + 1) + T(t) + "}\n");
  }
}

