import java.util.*;

class ArgDecls extends BaseGrammarTop implements BG {
	ArgDecl argumentDeclaration;
	ArgDecls argumentDeclarations;
  public ArgDecls(ArgDecl a, ArgDecls s)
  {
  	argumentDeclaration = a;
  	argumentDeclarations = s;
  }

    public ArgDecls(ArgDecl a)
  {
    argumentDeclaration = a;
    argumentDeclarations = null;
  }

  public String toString(int t)
  {
  	return(argumentDeclaration.toString(t) + (argumentDeclarations != null ? ", " + 
      argumentDeclarations.toString(t) : "") );
  }

  public void typeCheck(int scope) throws NewException {
    argumentDeclaration.typeCheck(scope);
    if(argumentDeclarations != null) {
      argumentDeclarations.typeCheck(scope);
    }
  }

  public ArrayList<TypeClass> getTypes() throws NewException {
    ArrayList<TypeClass> argumentType = new ArrayList<TypeClass>();
    if(argumentDeclarations != null) {
     ArrayList<TypeClass> tempArr = argumentDeclarations.getTypes();
     argumentType.add(argumentDeclaration.getType());
      for(int i = 0; i < tempArr.size(); i++) {
        argumentType.add(tempArr.get(i));
      }
    }
    else {
      argumentType.add(argumentDeclaration.getType());
    }
    return argumentType;
  }
}

