 abstract class BaseGrammarTop implements BG {
  protected static VarTable table;
  public String T(int t)
  {
  	String tabs = "";
  	for (int i = 0; i < t; i++)
  		tabs = tabs + "\t";
  	return tabs;
  }

  public String toString(int t)
  {
  	return "";
  }
}