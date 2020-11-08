class IfStmt extends Stmt implements BG {
  IfBase ifBase;
  IfBackend ifBackend;
  
  boolean hasFi;
  Stmt state1;
  Stmt state2;
  public IfStmt(IfBase i, IfBackend b)
  {
    ifBase = i;
    ifBackend = b;
  }
  public IfStmt(IfBase i, Stmt s1, String s)
  {
    ifBase = i;
    state1 = s1;
    state2 = null;
    hasFi = true;
  }

  public IfStmt(IfBase i, Stmt s1, Stmt s2, String s)
  {
    ifBase = i;
    state1 = s1;
    state2 = s2;
    hasFi = true;
  }
  
  public String toString(int t)
  {
    if (!hasFi)
      return ( T(t) + ifBase.toString(t) + T(t) + "{\n" + ifBackend.toString(t + 1) + T(t) + "}\n");
    else
      if (state2 == null)
        return ( T(t) + ifBase.toString(t) + state1.toString(t + 1) + T(t) + "fi\n");
      else
        return ( T(t) + ifBase.toString(t) + state1.toString(t + 1) + T(t) + "else\n"
                 + state2.toString(t + 1) + T(t) + "fi\n");
  }

  public void typeCheck(int scope, String method) throws NewException {
    try {
      ifBase.typeCheck(scope);
      if(state2 == null) {
        state1.typeCheck(scope + 1, method);
      }
      else {
        state1.typeCheck(scope + 1, method);
        state2.typeCheck(scope + 1, method);
      }
    } catch(NewException e) {
      throw e;
    }
  }

}

