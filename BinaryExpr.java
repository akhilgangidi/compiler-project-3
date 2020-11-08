class BinaryExpr extends NonTypeCastExpr implements BG {
	Expr leftHandSide;
	String operator;
	Expr rightHandSide;

  public BinaryExpr(Expr l, String b, Expr r)
  {
    leftHandSide = l;
    operator = b;
    rightHandSide = r;
  }

  public String toString(int t)
  {
  	return ("(" + leftHandSide.toString(t) + " " + operator + " " + rightHandSide.toString(t) + ")");
  }

  public void typeCheck(int scope, String method) throws NewException{
    leftHandSide.typeCheck(scope, method);
    rightHandSide.typeCheck(scope, method);
  }

  public TypeClass getType() throws NewException{
    TypeClass left = leftHandSide.getType();
    TypeClass right = rightHandSide.getType();

    if(left.getArray() || right.getArray()) {
      throw new NewException("Binary operation cannot be applied to arrays");
    }

    if(left.equals(new TypeClass(new StrType(),false,false)) || right.equals(new TypeClass(new StrType(),false,false))) {
      if(operator == "+") {
        return new TypeClass(new StrType(),false,false);
      }
      throw new NewException("Unary operation cannot be applied to strings");
    } //
    else if(operator == "+" || operator == "-" || operator == "*" || operator == "/") {
      if(!(left.equals(new TypeClass(new FloatType(), false, false)) || left.equals(new TypeClass(new IntType(), false, false))) && right.equals(new TypeClass(new FloatType(), false, false)) || right.equals(new TypeClass(new IntType(), false, false))) {
        throw new NewException("Binary expression cannot be applied to expression: " + toString(0));
      }
      if(left.equals(new TypeClass(new FloatType(), false, false)) || right.equals(new TypeClass(new FloatType(), false, false))) {
        return new TypeClass(new FloatType(), false, false);
      }
      else {
        return new TypeClass(new IntType(), false, false);
      }
    }
    else {
      if(!left.equals(right) || left.equals(new TypeClass(new IntType(), false, false)) || left.equals(new TypeClass(new FloatType(), false, false)) || right.equals(new TypeClass(new IntType(), false, false)) || right.equals(new TypeClass(new FloatType(), false, false))) {
        throw new NewException("Cannot apply binary operation to expression: " + toString(0));
      }
      return new TypeClass(new BoolType(), false, false);
    }
  }
}

