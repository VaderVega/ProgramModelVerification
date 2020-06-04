// Generated from /home/vadervega/IdeaProjects/ProgramModelVerification/src/MyLang.g4 by ANTLR 4.7.2

package GeneratedFiles;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLangParser}.
 */
public interface MyLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLangParser#argDef}.
	 * @param ctx the parse tree
	 */
	void enterArgDef(MyLangParser.ArgDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#argDef}.
	 * @param ctx the parse tree
	 */
	void exitArgDef(MyLangParser.ArgDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#built}.
	 * @param ctx the parse tree
	 */
	void enterBuilt(MyLangParser.BuiltContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#built}.
	 * @param ctx the parse tree
	 */
	void exitBuilt(MyLangParser.BuiltContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#lit}.
	 * @param ctx the parse tree
	 */
	void enterLit(MyLangParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#lit}.
	 * @param ctx the parse tree
	 */
	void exitLit(MyLangParser.LitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(MyLangParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(MyLangParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#sourceItem}.
	 * @param ctx the parse tree
	 */
	void enterSourceItem(MyLangParser.SourceItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#sourceItem}.
	 * @param ctx the parse tree
	 */
	void exitSourceItem(MyLangParser.SourceItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MyLangParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MyLangParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MyLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MyLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(MyLangParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(MyLangParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#varSpec}.
	 * @param ctx the parse tree
	 */
	void enterVarSpec(MyLangParser.VarSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#varSpec}.
	 * @param ctx the parse tree
	 */
	void exitVarSpec(MyLangParser.VarSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#importSpec}.
	 * @param ctx the parse tree
	 */
	void enterImportSpec(MyLangParser.ImportSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#importSpec}.
	 * @param ctx the parse tree
	 */
	void exitImportSpec(MyLangParser.ImportSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#dllName}.
	 * @param ctx the parse tree
	 */
	void enterDllName(MyLangParser.DllNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#dllName}.
	 * @param ctx the parse tree
	 */
	void exitDllName(MyLangParser.DllNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#dllEntryName}.
	 * @param ctx the parse tree
	 */
	void enterDllEntryName(MyLangParser.DllEntryNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#dllEntryName}.
	 * @param ctx the parse tree
	 */
	void exitDllEntryName(MyLangParser.DllEntryNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MyLangParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MyLangParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(MyLangParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(MyLangParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(MyLangParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(MyLangParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(MyLangParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(MyLangParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#funcSignature}.
	 * @param ctx the parse tree
	 */
	void enterFuncSignature(MyLangParser.FuncSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#funcSignature}.
	 * @param ctx the parse tree
	 */
	void exitFuncSignature(MyLangParser.FuncSignatureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code builtin}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterBuiltin(MyLangParser.BuiltinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code builtin}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitBuiltin(MyLangParser.BuiltinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code custom}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterCustom(MyLangParser.CustomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code custom}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitCustom(MyLangParser.CustomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterArray(MyLangParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MyLangParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitArray(MyLangParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statmentBlock}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatmentBlock(MyLangParser.StatmentBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statmentBlock}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatmentBlock(MyLangParser.StatmentBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementIf}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIf(MyLangParser.StatementIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementIf}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIf(MyLangParser.StatementIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementWhile}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhile(MyLangParser.StatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementWhile}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhile(MyLangParser.StatementWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementDo}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDo(MyLangParser.StatementDoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementDo}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDo(MyLangParser.StatementDoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementBreak}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementBreak(MyLangParser.StatementBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementBreak}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementBreak(MyLangParser.StatementBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementExpr}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpr(MyLangParser.StatementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementExpr}
	 * labeled alternative in {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpr(MyLangParser.StatementExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(MyLangParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(MyLangParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#thenStatements}.
	 * @param ctx the parse tree
	 */
	void enterThenStatements(MyLangParser.ThenStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#thenStatements}.
	 * @param ctx the parse tree
	 */
	void exitThenStatements(MyLangParser.ThenStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#elseStatements}.
	 * @param ctx the parse tree
	 */
	void enterElseStatements(MyLangParser.ElseStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#elseStatements}.
	 * @param ctx the parse tree
	 */
	void exitElseStatements(MyLangParser.ElseStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void enterWhileCondition(MyLangParser.WhileConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void exitWhileCondition(MyLangParser.WhileConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#whileStatements}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatements(MyLangParser.WhileStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#whileStatements}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatements(MyLangParser.WhileStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#doCondition}.
	 * @param ctx the parse tree
	 */
	void enterDoCondition(MyLangParser.DoConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#doCondition}.
	 * @param ctx the parse tree
	 */
	void exitDoCondition(MyLangParser.DoConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#doStatements}.
	 * @param ctx the parse tree
	 */
	void enterDoStatements(MyLangParser.DoStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#doStatements}.
	 * @param ctx the parse tree
	 */
	void exitDoStatements(MyLangParser.DoStatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(MyLangParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(MyLangParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binary}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(MyLangParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(MyLangParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unari}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnari(MyLangParser.UnariContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unari}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnari(MyLangParser.UnariContext ctx);
	/**
	 * Enter a parse tree produced by the {@code place}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlace(MyLangParser.PlaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code place}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlace(MyLangParser.PlaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexer}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexer(MyLangParser.IndexerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexer}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexer(MyLangParser.IndexerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code braces}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBraces(MyLangParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code braces}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBraces(MyLangParser.BracesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MyLangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MyLangParser.LiteralContext ctx);
}