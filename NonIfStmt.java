abstract class NonIfStmt extends Stmt implements BG {
	abstract public void typeCheck(int scope, String id) throws NewException;
	abstract public String toString(int t);
}

