// Generated from Numbers.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("CheckReturnValue")

public class Interpreter extends NumbersBaseListener {
    private final Map<String, Integer> values = new HashMap<>();

    @Override
    public void enterExprMap(NumbersParser.ExprMapContext ctx) {
        Integer number = Integer.parseInt(ctx.Integer().getText());
        String name = ctx.Name().getText();
        values.put(name, number);
    }

    @Override
    public void enterExprParsing(NumbersParser.ExprParsingContext ctx) {
        for (TerminalNode node : ctx.Name()) {
            String name = node.getText();
            String[] split = name.split("-");
            Arrays.stream(split).forEach(word -> {
                if (!values.containsKey(word)) {
                    System.err.println("Number " + word + " not found");
                    System.exit(1);
                }
                System.out.print(values.get(word) + " ");
            });
        }
    }
}
