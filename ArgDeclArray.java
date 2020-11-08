class ArgDeclArray extends ArgDecl implements BG {
  
  public ArgDeclArray(Type t, String i)
  {
    super(t, i);
  }

  public String toString(int t)
  {
  	return (super.toString(t) + "[]");
  }

  public TypeClass getType() throws NewException {
    TypeClass ty = new TypeClass(type, true, false);
    return ty;
  }
}

