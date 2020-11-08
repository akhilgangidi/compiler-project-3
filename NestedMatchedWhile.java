class NestedMatchedWhile extends WhileMatchedIf implements BG {

	NonIfStmt innerAction;
  public NestedMatchedWhile(WhileBase w, NonWhileStmt n)
  {
    super(w);
    innerAction = n;
  }

  public NestedMatchedWhile(WhileBase w, NestedMatchedWhile n)
  {
    super(w);
    innerAction = n;
  }

  public NestedMatchedWhile(WhileBase w)
  {
    super(w);
  }

  public String toString(int t)
  {
  	return( super.toString(t) + T(t) + "{\n" + innerAction.toString(t + 1) + T(t) + "}\n" );
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}

