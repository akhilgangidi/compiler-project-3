class TypeClass {
    private boolean isFinal;
    private boolean isArray;
    private ReturnType type;

    TypeClass(ReturnType ty, boolean arr, boolean fin) {
        type = ty;
        isArray = arr;
        isFinal = fin;
    }
    
    ReturnType getType() {
        return type;
    }

    boolean getArray() {
        return isArray;
    }

    boolean getFinal() {
        return isFinal;
    }

    public String toString(int i) {
        return (isFinal ? "final " : "") + type.toString(i) + (isArray ? "[]" : "");
    }

    public boolean equals(TypeClass t) {
        return isArray == t.getArray() && type.toString(0).equals(t.getType().toString(0));
    }
}