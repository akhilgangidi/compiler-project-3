class NestedIfWhiles extends WhileMatchedIf implements BG {

	NestedMatchedWhileIf nestedMatchedWhileIf;

  public NestedIfWhiles(WhileBase w, NestedMatchedWhileIf n)
  {
    super(w);
    nestedMatchedWhileIf = n;
  }

  public String toString(int t)
  {
  	 return( super.toString(t) + T(t) + "{\n" + nestedMatchedWhileIf.toString(t + 1) + T(t) + "}\n" );
  }

  public void typeCheck(int scope, String method) {
    
  }

  public TypeClass getType() {
    return null;
  }
}