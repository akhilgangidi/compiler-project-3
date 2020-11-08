class Program extends BaseGrammarTop implements BG {
	String id;
	MemberDecls memberDeclarations;
  public Program(String i, MemberDecls m)
  {
  	id = i;
  	memberDeclarations = m;
    table = new VarTable();
  }

  public String toString(int t)
  {
  	return("class " + id + "\n{\n" + memberDeclarations.toString(t + 1) + "}\n");
  }

  public void typeCheck(int s) throws NewException {
    int scope = s;
    memberDeclarations.typeCheck(scope + 1, "class");
  }
}

