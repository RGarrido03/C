// Generated from Geometry.g4 by ANTLR 4.13.1
@SuppressWarnings("CheckReturnValue")
public class ExecuteV extends GeometryBaseVisitor<Object> {

    @Override
    public Object visitProgram(GeometryParser.ProgramContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitInstructionAssignment(GeometryParser.InstructionAssignmentContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitInstructionExpression(GeometryParser.InstructionExpressionContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitAssignment(GeometryParser.AssignmentContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitDistance(GeometryParser.DistanceContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitPoint(GeometryParser.PointContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitExpressionDistance(GeometryParser.ExpressionDistanceContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }

    @Override
    public Object visitExpressionNumber(GeometryParser.ExpressionNumberContext ctx) {
        Object res = null;
        return Double.parseDouble(ctx.getText());
        //return res;
    }

    @Override
    public Object visitExpressionIdentifier(GeometryParser.ExpressionIdentifierContext ctx) {
        Object res = null;
        return visitChildren(ctx);
        //return res;
    }
}
