abstract class ArgDecl extends BaseGrammarTop implements BG {
	Type type;
  String id;
  public ArgDecl(Type t, String i)
  {
    type = t;
    id = i;
  }

  public String toString(int t)
  {
  	return( type.toString(t) + " " + id);
  }

  public void typeCheck(int scope) throws NewException {
    try {
      TypeClass ty = getType();
      table.insert(id, scope, ty);
    } catch(NewException e) {
      throw e; 
    }
  }

  abstract public TypeClass getType() throws NewException;
}

