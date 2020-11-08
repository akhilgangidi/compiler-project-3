abstract class FieldDecl extends BaseGrammarTop implements BG {
	FieldStart fieldStart;

  public FieldDecl(FieldStart f)
  {
  	fieldStart = f;
  }

  public String toString(int t)
  {
    return fieldStart.toString(t);
  }

  abstract public void typeCheck(int scope, String methodName) throws NewException;

}

