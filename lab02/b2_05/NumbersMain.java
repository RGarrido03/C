import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class NumbersMain {
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("numbers.txt");
             FileInputStream file2 = new FileInputStream("p2.txt")) {
            SequenceInputStream sequenceInputStream = new SequenceInputStream(file, file2);
            // create a CharStream that reads from standard input:
            CharStream input = CharStreams.fromStream(sequenceInputStream);
            // create a lexer that feeds off of input CharStream:
            NumbersLexer lexer = new NumbersLexer(input);
            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create a parser that feeds off the tokens buffer:
            NumbersParser parser = new NumbersParser(tokens);
            // replace error listener:
            //parser.removeErrorListeners(); // remove ConsoleErrorListener
            //parser.addErrorListener(new ErrorHandlingListener());
            // begin parsing at program rule:
            ParseTree tree = parser.program();
            if (parser.getNumberOfSyntaxErrors() == 0) {
                // print LISP-style tree:
                // System.out.println(tree.toStringTree(parser));
                ParseTreeWalker walker = new ParseTreeWalker();
                Interpreter listener0 = new Interpreter();
                walker.walk(listener0, tree);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (RecognitionException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
