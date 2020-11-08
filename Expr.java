abstract class Expr extends NonIfStmt implements BG {
    abstract public TypeClass getType() throws NewException;
}