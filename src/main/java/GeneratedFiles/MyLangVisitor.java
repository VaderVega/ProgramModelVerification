// Generated from /home/vader_vega/IdeaProjects/ProgramModelVerification/src/MyLang.g4 by ANTLR 4.7.2

package GeneratedFiles;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyLangParser#argDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgDef(MyLangParser.ArgDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#built}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilt(MyLangParser.BuiltContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#lit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(MyLangParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(MyLangParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#sourceItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceItem(MyLangParser.SourceItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MyLangParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MyLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(MyLangParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#funcSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncSignature(MyLangParser.FuncSignatureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code builtin}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin(MyLangParser.BuiltinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code custom}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustom(MyLangParser.CustomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(MyLangParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statmentBlock}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatmentBlock(MyLangParser.StatmentBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIf}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(MyLangParser.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWhile}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(MyLangParser.StatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementDo}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDo(MyLangParser.StatementDoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementBreak}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBreak(MyLangParser.StatementBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementExpr}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpr(MyLangParser.StatementExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(MyLangParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#thenStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenStatements(MyLangParser.ThenStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#elseStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatements(MyLangParser.ElseStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#whileCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCondition(MyLangParser.WhileConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#whileStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatements(MyLangParser.WhileStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#doCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoCondition(MyLangParser.DoConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#doStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatements(MyLangParser.DoStatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(MyLangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(MyLangParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unari}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnari(MyLangParser.UnariContext ctx);
	/**
	 * Visit a parse tree produced by the {@code place}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace(MyLangParser.PlaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexer}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexer(MyLangParser.IndexerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braces}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraces(MyLangParser.BracesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MyLangParser.LiteralContext ctx);
}