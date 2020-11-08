abstract class TypeLit extends Expr implements BG {
    public void typeCheck(int scope, String method) {
        
    }
    abstract public TypeClass getType() throws NewException;
}

