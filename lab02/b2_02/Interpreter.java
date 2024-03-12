// Generated from SuffixCalculator.g4 by ANTLR 4.13.1
@SuppressWarnings("CheckReturnValue")
public class Interpreter extends SuffixCalculatorBaseVisitor<Double> {

    @Override
    public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
        Double res = visit(ctx.expr());
        if (res != null) {
            System.out.println(res);
        }
        return res;
    }

    @Override
    public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
        return Double.parseDouble(ctx.Number().getText());
    }

    @Override
    public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
        Double n1 = visit(ctx.expr(0));
        Double n2 = visit(ctx.expr(1));
        String operation = ctx.op.getText();

        return switch (operation) {
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> n1 + n2;
        };
    }
}
