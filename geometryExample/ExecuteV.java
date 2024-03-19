import java.util.HashMap;
import java.util.Map;

// Generated from Geometry.g4 by ANTLR 4.13.1
@SuppressWarnings("CheckReturnValue")
public class ExecuteV extends GeometryBaseVisitor<Double> {
    private final Map<String, Double> symbolTable = new HashMap<>();

    @Override
    public Double visitProgram(GeometryParser.ProgramContext ctx) {
        Double res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Double visitInstructionAssignment(GeometryParser.InstructionAssignmentContext ctx) {
        Double res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Double visitInstructionExpression(GeometryParser.InstructionExpressionContext ctx) {
        Double res = visit(ctx.expression());
        System.out.println("Resultado: " + res);
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Double visitAssignment(GeometryParser.AssignmentContext ctx) {
        Double res = visit(ctx.expression());
        String id = ctx.Identifier().getText();

        if (res != null) {
            symbolTable.put(id, res);
        }
        return res;
    }

    @Override
    public Double visitDistance(GeometryParser.DistanceContext ctx) {
        Double res = null;
        Double[] point = visit(ctx.point(0));
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Double visitPoint(GeometryParser.PointContext ctx) {
        Double res = null;

        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Double visitExpressionDistance(GeometryParser.ExpressionDistanceContext ctx) {
        Double res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Double visitExpressionIdentifier(GeometryParser.ExpressionIdentifierContext ctx) {
        String id = ctx.Identifier().getText();

        if (!symbolTable.containsKey(id)) {
            System.err.println("ERROR: Variable '" + id + "' not found");
            return null;
        }
        return symbolTable.get(id);
    }

    @Override
    public Double visitExpressionMultDiv(GeometryParser.ExpressionMultDivContext ctx) {
        Double e1 = visit(ctx.expression(0));
        Double e2 = visit(ctx.expression(1));

        if (e1 != null && e2 != null) {
            return switch (ctx.op.getText()) {
                case "*" -> e1 * e2;
                case "/" -> {
                    if (e2 == 0) {
                        System.err.println("ERROR: Divide by zero!");
                    }
                    yield e1 / e2;
                }
                default -> throw new IllegalStateException("Unexpected value: " + ctx.op.getText());
            };
        }

        return null;
    }

    @Override
    public Double visitExpressionNumber(GeometryParser.ExpressionNumberContext ctx) {
        return Double.parseDouble(ctx.Number().getText());
    }

    @Override
    public Double visitExpressionPriority(GeometryParser.ExpressionPriorityContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitExpressionSumSub(GeometryParser.ExpressionSumSubContext ctx) {
        Double e1 = visit(ctx.expression(0));
        Double e2 = visit(ctx.expression(1));

        if (e1 != null && e2 != null) {
            return switch (ctx.op.getText()) {
                case "+" -> e1 + e2;
                case "-" -> e1 - e2;
                default -> throw new IllegalStateException("Unexpected value: " + ctx.op.getText());
            };
        }

        return null;
    }
}
