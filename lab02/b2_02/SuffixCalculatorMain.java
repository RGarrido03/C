import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class SuffixCalculatorMain {
    public static void main(String[] args) {
        try {
            // create a CharStream that reads from standard input:
            CharStream input = CharStreams.fromStream(System.in);

            // create a lexer that feeds off of input CharStream:
            SuffixCalculatorLexer lexer = new SuffixCalculatorLexer(input);

            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // create a parser that feeds off the tokens buffer:
            SuffixCalculatorParser parser = new SuffixCalculatorParser(tokens);

            // replace error listener:
            //parser.removeErrorListeners(); // remove ConsoleErrorListener
            //parser.addErrorListener(new ErrorHandlingListener());

            // begin parsing at program rule:
            ParseTree tree = parser.program();
            if (parser.getNumberOfSyntaxErrors() == 0) {
                // print LISP-style tree:
                // System.out.println(tree.toStringTree(parser));
                Interpreter visitor0 = new Interpreter();
                visitor0.visit(tree);
            }
        } catch (IOException | RecognitionException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
