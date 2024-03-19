// Generated from Geometry.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GeometryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GeometryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GeometryParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GeometryParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstructionAssignment}
	 * labeled alternative in {@link GeometryParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionAssignment(GeometryParser.InstructionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstructionExpression}
	 * labeled alternative in {@link GeometryParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionExpression(GeometryParser.InstructionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometryParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GeometryParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometryParser#distance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistance(GeometryParser.DistanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeometryParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(GeometryParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionDistance}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDistance(GeometryParser.ExpressionDistanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionIdentifier}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionIdentifier(GeometryParser.ExpressionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultDiv(GeometryParser.ExpressionMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionNumber}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumber(GeometryParser.ExpressionNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionPriority}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPriority(GeometryParser.ExpressionPriorityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionSumSub}
	 * labeled alternative in {@link GeometryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSumSub(GeometryParser.ExpressionSumSubContext ctx);
}