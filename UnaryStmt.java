class UnaryStmt extends NonWhileStmt implements BG {
	Name name;
  String operator;
  public UnaryStmt(Name n, String o)
  {
    name = n;
    operator = o;
  }

  public String toString(int t)
  {
  	return(T(t) + name.toString(t) + operator + ";\n");
  }

  public void typeCheck(int scope, String method) throws NewException{
    TypeClass ty = name.getType();
    if(ty.getArray()) {
      throw new NewException("Unary operator cannnot be appliied to array values");
    }
    if(!ty.getType().equals(new IntType())) {
      throw new NewException("Unary operator cannot be applied to value '" + name.toString(0) + "'");
    }
  }

  public TypeClass getType() {
    return null;
  }
}

