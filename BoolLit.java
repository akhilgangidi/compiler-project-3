class BoolLit extends TypeLit implements BG {
	String bool;
  public BoolLit(String b)
  {
    bool = b;
  }

  public String toString(int t)
  {
  	return bool;
  }

  public TypeClass getType() throws NewException {
    BoolType b = new BoolType();
    TypeClass ty = new TypeClass(b, false, false);
    return ty;
  }
}

