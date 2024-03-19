import java.util.HashMap;
import java.util.Map;

// Generated from Calculator.g4 by ANTLR 4.13.1
@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Integer> {
    private final Map<String, Integer> variables = new HashMap<>();

    @Override
    public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStat(CalculatorParser.StatContext ctx) {
        Integer res = visit(ctx.expr() != null ? ctx.expr() : ctx.assignment());
        if (res == null) {
            return null;
        }
        System.out.println(">> " + res);
        return res;
    }

    @Override
    public Integer visitAssignment(CalculatorParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Integer res = visit(ctx.expr());
        variables.put(id, res);

        return res;
    }

    @Override
    public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
        Integer n1 = visit(ctx.expr(0));
        Integer n2 = visit(ctx.expr(1));

        if (n1 == null || n2 == null) {
            return null;
        }

        String operation = ctx.op.getText();

        return switch (operation) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            default -> throw new IllegalStateException("Unexpected operation: " + operation);
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
    public Integer visitExprId(CalculatorParser.ExprIdContext ctx) {
        String id = ctx.ID().getText();
        if (variables.containsKey(id)) {
            return variables.get(id);
        }
        System.err.println("Variable " + id + " not found");
        return null;
    }

    @Override
    public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
        Integer n1 = visit(ctx.expr(0));
        Integer n2 = visit(ctx.expr(1));

        if (n1 == null || n2 == null) {
            return null;
        }

        String operation = ctx.op.getText();

        return switch (operation) {
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            case "%" -> n1 % n2;
            default -> throw new IllegalStateException("Unexpected operation: " + operation);
        };
    }
}
