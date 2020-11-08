abstract class Stmt extends BaseGrammarTop implements BG {
	abstract public void typeCheck(int scope, String id) throws NewException;
}

