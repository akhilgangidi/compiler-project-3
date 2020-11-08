class VarData {
    String id;
    int scope;
    TypeClass type;
    TypeClass[] argTypes;
    String methodName;

    VarData(String i, int s, TypeClass t) {
        id = i;
        scope = s;
        type = t;
        argTypes = new TypeClass[0];
    }

    VarData(String i, int s, TypeClass t, TypeClass[] args) {
        id = i;
        scope = s;
        type = t;
        methodName = null;
        argTypes = args;
    }

    VarData(String i, int s, TypeClass t, String m) {
        id = i;
        scope = s;
        type = t;
        argTypes = new TypeClass[0];
        methodName = m;
    }

    public String getId() {
        return id;
    }

    public int getScope() {
        return scope;
    }

    public TypeClass getType() {
        return type;
    }

    public TypeClass[] getArgTypes() {
        return argTypes;
    }

    public String getMethodName()  {
        return methodName;
    }
}