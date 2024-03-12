// Generated from Geometry.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GeometryParser}.
 */
public interface GeometryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GeometryParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GeometryParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometryParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GeometryParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstructionAssignment}
	 * labeled alternative in {@link GeometryParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionAssignment(GeometryParser.InstructionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstructionAssignment}
	 * labeled alternative in {@link GeometryParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionAssignment(GeometryParser.InstructionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstructionExpression}
	 * labeled alternative in {@link GeometryParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionExpression(GeometryParser.InstructionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstructionExpression}
	 * labeled alternative in {@link GeometryParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionExpression(GeometryParser.InstructionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometryParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(GeometryParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometryParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(GeometryParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometryParser#distance}.
	 * @param ctx the parse tree
	 */
	void enterDistance(GeometryParser.DistanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometryParser#distance}.
	 * @param ctx the parse tree
	 */
	void exitDistance(GeometryParser.DistanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeometryParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(GeometryParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeometryParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(GeometryParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionDistance}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDistance(GeometryParser.ExpressionDistanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionDistance}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDistance(GeometryParser.ExpressionDistanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionNumber}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumber(GeometryParser.ExpressionNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionNumber}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumber(GeometryParser.ExpressionNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionIdentifier}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionIdentifier(GeometryParser.ExpressionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionIdentifier}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionIdentifier(GeometryParser.ExpressionIdentifierContext ctx);
}