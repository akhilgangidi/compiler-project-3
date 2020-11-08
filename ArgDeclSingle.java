class ArgDeclSingle extends ArgDecl implements BG {
  public ArgDeclSingle(Type t, String i)
  {
    super(t, i);
  }

  public String toString(int t)
  {
  	return super.toString(t);
  }

  public TypeClass getType() throws NewException {
    TypeClass ty = new TypeClass(type, false, false);
    return ty;
  }
}

