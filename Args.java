import java.util.*;

class Args extends BaseGrammarTop implements BG {
	Expr expression;
  Args arguments;
  public Args(Expr e, Args a)
  {
    expression = e;
    arguments = a;
  }

  public Args(Expr e)
  {
    expression = e;
    arguments = null;
  }

  public String toString(int t)
  {
  	return(expression.toString(t) +
	       (arguments != null ? ", " + arguments.toString(t) : "") );
  }

  public ArrayList<TypeClass> getTypes() throws NewException {
    ArrayList<TypeClass> argumentType = new ArrayList<>();
    if(arguments != null) {
     ArrayList<TypeClass> tempArr = arguments.getTypes();
     argumentType.add(expression.getType());
      for(int i = 0; i < tempArr.size(); i++) {
        argumentType.add(tempArr.get(i));
      }
    }
    else {
      argumentType.add(expression.getType());
    }
    return argumentType;
  }
}
