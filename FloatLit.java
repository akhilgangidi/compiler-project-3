class FloatLit extends TypeLit implements BG {
	double floatingPoint; //the natural parse conversion makes this be a double
  public FloatLit(double f)
  {
    floatingPoint = f;
  }

  public String toString(int t)
  {
  	return Double.toString(floatingPoint);
  }

  public TypeClass getType() throws NewException{
    FloatType f = new FloatType();
    TypeClass ty = new TypeClass(f,false,false);
    return ty;
  }
}

