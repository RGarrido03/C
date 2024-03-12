// Generated from Calculator.g4 by ANTLR 4.13.1
@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Integer> {

    @Override
    public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStat(CalculatorParser.StatContext ctx) {
        Integer res = visit(ctx.expr());
        System.out.println(">> " + res);
        return res;
    }

    @Override
    public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
        Integer n1 = visit(ctx.expr(0));
        Integer n2 = visit(ctx.expr(1));
        String operation = ctx.op.getText();

        return switch (operation) {
            case "-" -> n1 - n2;
            default -> n1 + n2;
        };
    }

    @Override
    public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
        return Integer.parseInt(ctx.Integer().getText());
    }

    @Override
    public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
        Integer n1 = visit(ctx.expr(0));
        Integer n2 = visit(ctx.expr(1));
        String operation = ctx.op.getText();

        return switch (operation) {
            case "/" -> n1 / n2;
            case "%" -> n1 % n2;
            default -> n1 * n2;
        };
    }
}
