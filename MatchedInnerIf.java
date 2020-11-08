class MatchedInnerIf extends MatchedIf implements BG {
  IfBase ifBase;
  MatchedIf matchedIf;
  MatchedIf exteriorMatchedIf;
  public MatchedInnerIf(IfBase i, MatchedIf m, MatchedIf s)
  {
    ifBase = i;
    matchedIf = m;
    exteriorMatchedIf = s;
  }

  public String toString(int t)
  {
  	return (T(t) + ifBase.toString(t) + T(t) + "{\n" + matchedIf.toString(t + 1) + T(t) + "}\n" +
      T(t) + "else\n" + T(t) + "{\n" + exteriorMatchedIf.toString(t + 1) + T(t) + "}\n");
  }
}

