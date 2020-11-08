class StrLit extends TypeLit implements BG {
	String string;
  public StrLit(String s)
  {
    string  = s;
  }

  public String toString(int t)
  {
  	return string;
  }

  public TypeClass getType() throws NewException {
    StrType s = new StrType();
    TypeClass ty = new TypeClass(s,false,false);
    return ty;
  }
}

