class IntLit extends TypeLit implements BG {
	int integer;
  public IntLit(int i)
  {
    integer = i;
  }

  public String toString(int t)
  {
  	return Integer.toString(integer);
  }

  public TypeClass getType() throws NewException{
    IntType i = new IntType();
    TypeClass ty = new TypeClass(i, false, false);
    return ty;
  }
}

