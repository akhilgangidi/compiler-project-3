class CharLit extends TypeLit implements BG {
	String character; //chars may actually be multiple characters in terms of escaping.
  public CharLit(String c)
  {
    character = c;
  }

  public String toString(int t)
  {
  	return character;
  }

  public TypeClass getType() throws NewException{
    CharType c = new CharType();
    TypeClass ty = new TypeClass(c,false,false);
    return ty;
  }
}

