import java.io.*;
import java_cup.runtime.*;

public class ExampleTypeCheckerTest {
    public static void main(String[] args) throws Exception {
		Reader reader = null;

		if(args.length == 1) {
			File input = new File(args[0]);
			if(!input.canRead()) {
			System.out.println("Error: could not read ["+input+"]");
			}
			reader = new FileReader(input);
		}
		else {
			reader = new InputStreamReader(System.in);
		}

		BaseGrammarLexer scanner = new BaseGrammarLexer(reader);
		parser parser = new parser(scanner);
		Program program = null;

		try {
			program = (Program) parser.parse().value;
		} catch(Exception e) {
			e.printStackTrace();
		}

		System.out.print(program.toString(0));

		try {
			program.typeCheck(0);
			System.out.println("Type checking complete");
		} catch (NewException e) {
			System.out.println(e.toString());
		}
    }

    public static void error(String s) {
		System.out.println(s);
    }
}
