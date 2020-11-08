class Name extends Expr implements BG {
  String id;
  public Name(String i)
  {
    id = i;
  }

  public String toString(int t)
  {
  	return(id);
  }

  public TypeClass getType() throws NewException{
    TypeClass ty = table.getType(id); 
    return ty;
  }

  public void typeCheck(int scope, String method) throws NewException {
    table.find(id, scope);
  }

}