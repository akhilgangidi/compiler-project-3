class NestedWhileIf extends NestedMatchedWhileIf implements BG{

	NestedMatchedWhileIf nestedMatchedWhile;
	public NestedWhileIf(WhileBase w, NestedMatchedWhileIf n)
	{
		super(w);
		nestedMatchedWhile = n;
	}

 	public String toString(int t)
	{
		return( super.toString(t) + T(t) + "{\n" + nestedMatchedWhile.toString(t + 1) + T(t) + "}\n");
	}

	public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}