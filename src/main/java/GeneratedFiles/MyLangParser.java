// Generated from /home/vadervega/IdeaProjects/ProgramModelVerification/src/MyLang.g4 by ANTLR 4.7.2

package GeneratedFiles;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, CHAR=30, HEX=31, BITS=32, 
		BOOL=33, DEC=34, IDENTIFIER=35, STR=36, BINOP=37, UNOP=38, WS=39, COMMENT=40;
	public static final int
		RULE_argDef = 0, RULE_built = 1, RULE_lit = 2, RULE_source = 3, RULE_sourceItem = 4, 
		RULE_funcDef = 5, RULE_block = 6, RULE_body = 7, RULE_funcSignature = 8, 
		RULE_typeRef = 9, RULE_statement = 10, RULE_ifCondition = 11, RULE_thenStatements = 12, 
		RULE_elseStatements = 13, RULE_whileCondition = 14, RULE_whileStatements = 15, 
		RULE_doCondition = 16, RULE_doStatements = 17, RULE_expr = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"argDef", "built", "lit", "source", "sourceItem", "funcDef", "block", 
			"body", "funcSignature", "typeRef", "statement", "ifCondition", "thenStatements", 
			"elseStatements", "whileCondition", "whileStatements", "doCondition", 
			"doStatements", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'bool'", "'byte'", "'int'", "'uint'", "'long'", "'ulong'", 
			"'char'", "'string'", "'method'", "';'", "'begin'", "'end'", "'var'", 
			"','", "'('", "')'", "'array'", "'['", "']'", "'of'", "'if'", "'while'", 
			"'do'", "'repeat'", "'until'", "'break'", "'then'", "'else'", "'[^']'", 
			null, null, null, null, null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "CHAR", "HEX", "BITS", "BOOL", "DEC", 
			"IDENTIFIER", "STR", "BINOP", "UNOP", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MyLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ArgDefContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MyLangParser.IDENTIFIER, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public ArgDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterArgDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitArgDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitArgDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgDefContext argDef() throws RecognitionException {
		ArgDefContext _localctx = new ArgDefContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_argDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(IDENTIFIER);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(39);
				match(T__0);
				setState(40);
				typeRef();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltContext extends ParserRuleContext {
		public BuiltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBuilt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBuilt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitBuilt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltContext built() throws RecognitionException {
		BuiltContext _localctx = new BuiltContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_built);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LitContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(MyLangParser.BOOL, 0); }
		public TerminalNode STR() { return getToken(MyLangParser.STR, 0); }
		public TerminalNode CHAR() { return getToken(MyLangParser.CHAR, 0); }
		public TerminalNode HEX() { return getToken(MyLangParser.HEX, 0); }
		public TerminalNode BITS() { return getToken(MyLangParser.BITS, 0); }
		public TerminalNode DEC() { return getToken(MyLangParser.DEC, 0); }
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << HEX) | (1L << BITS) | (1L << BOOL) | (1L << DEC) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MyLangParser.EOF, 0); }
		public List<SourceItemContext> sourceItem() {
			return getRuleContexts(SourceItemContext.class);
		}
		public SourceItemContext sourceItem(int i) {
			return getRuleContext(SourceItemContext.class,i);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(47);
				sourceItem();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceItemContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public SourceItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterSourceItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitSourceItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitSourceItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceItemContext sourceItem() throws RecognitionException {
		SourceItemContext _localctx = new SourceItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sourceItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			funcDef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public FuncSignatureContext funcSignature() {
			return getRuleContext(FuncSignatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__9);
			setState(58);
			funcSignature();
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__13:
				{
				setState(59);
				body();
				}
				break;
			case T__10:
				{
				setState(60);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(63);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__11);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__26) | (1L << CHAR) | (1L << HEX) | (1L << BITS) | (1L << BOOL) | (1L << DEC) | (1L << IDENTIFIER) | (1L << STR) | (1L << UNOP))) != 0)) {
				{
				{
				setState(66);
				statement();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(T__12);
			setState(73);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MyLangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MyLangParser.IDENTIFIER, i);
		}
		public List<TypeRefContext> typeRef() {
			return getRuleContexts(TypeRefContext.class);
		}
		public TypeRefContext typeRef(int i) {
			return getRuleContext(TypeRefContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(75);
				match(T__13);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIER) {
						{
						setState(76);
						match(IDENTIFIER);
						setState(81);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__14) {
							{
							{
							setState(77);
							match(T__14);
							setState(78);
							match(IDENTIFIER);
							}
							}
							setState(83);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(86);
						match(T__0);
						setState(87);
						typeRef();
						}
					}

					setState(90);
					match(T__10);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncSignatureContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MyLangParser.IDENTIFIER, 0); }
		public List<ArgDefContext> argDef() {
			return getRuleContexts(ArgDefContext.class);
		}
		public ArgDefContext argDef(int i) {
			return getRuleContext(ArgDefContext.class,i);
		}
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public FuncSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterFuncSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitFuncSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitFuncSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncSignatureContext funcSignature() throws RecognitionException {
		FuncSignatureContext _localctx = new FuncSignatureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(IDENTIFIER);
			setState(99);
			match(T__15);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(100);
				argDef();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(101);
					match(T__14);
					setState(102);
					argDef();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(110);
			match(T__16);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(111);
				match(T__0);
				setState(112);
				typeRef();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeRefContext extends ParserRuleContext {
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
	 
		public TypeRefContext() { }
		public void copyFrom(TypeRefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayContext extends TypeRefContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public ArrayContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BuiltinContext extends TypeRefContext {
		public BuiltContext built() {
			return getRuleContext(BuiltContext.class,0);
		}
		public BuiltinContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBuiltin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBuiltin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitBuiltin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CustomContext extends TypeRefContext {
		public TerminalNode IDENTIFIER() { return getToken(MyLangParser.IDENTIFIER, 0); }
		public CustomContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCustom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCustom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitCustom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeRef);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				_localctx = new BuiltinContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				built();
				}
				break;
			case IDENTIFIER:
				_localctx = new CustomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(IDENTIFIER);
				}
				break;
			case T__17:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(T__17);
				setState(118);
				match(T__18);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(119);
					match(T__14);
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(T__19);
				setState(126);
				match(T__20);
				setState(127);
				typeRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatmentBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatmentBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterStatmentBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitStatmentBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitStatmentBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDoContext extends StatementContext {
		public DoStatementsContext doStatements() {
			return getRuleContext(DoStatementsContext.class,0);
		}
		public DoConditionContext doCondition() {
			return getRuleContext(DoConditionContext.class,0);
		}
		public StatementDoContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterStatementDo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitStatementDo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitStatementDo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementBreakContext extends StatementContext {
		public StatementBreakContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterStatementBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitStatementBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitStatementBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExprContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementExprContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterStatementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitStatementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitStatementExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementWhileContext extends StatementContext {
		public WhileConditionContext whileCondition() {
			return getRuleContext(WhileConditionContext.class,0);
		}
		public WhileStatementsContext whileStatements() {
			return getRuleContext(WhileStatementsContext.class,0);
		}
		public StatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterStatementWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitStatementWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementIfContext extends StatementContext {
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public ThenStatementsContext thenStatements() {
			return getRuleContext(ThenStatementsContext.class,0);
		}
		public ElseStatementsContext elseStatements() {
			return getRuleContext(ElseStatementsContext.class,0);
		}
		public StatementIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterStatementIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitStatementIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitStatementIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new StatmentBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				block();
				}
				break;
			case T__21:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__21);
				setState(132);
				ifCondition();
				setState(133);
				thenStatements();
				setState(135);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(134);
					elseStatements();
					}
					break;
				}
				}
				break;
			case T__22:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T__22);
				setState(138);
				whileCondition();
				setState(139);
				match(T__23);
				setState(140);
				whileStatements();
				}
				break;
			case T__24:
				_localctx = new StatementDoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				match(T__24);
				setState(143);
				doStatements();
				setState(144);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(145);
				doCondition();
				setState(146);
				match(T__10);
				}
				break;
			case T__26:
				_localctx = new StatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(148);
				match(T__26);
				setState(149);
				match(T__10);
				}
				break;
			case T__15:
			case CHAR:
			case HEX:
			case BITS:
			case BOOL:
			case DEC:
			case IDENTIFIER:
			case STR:
			case UNOP:
				_localctx = new StatementExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				expr(0);
				setState(151);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitIfCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenStatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ThenStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterThenStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitThenStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitThenStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenStatementsContext thenStatements() throws RecognitionException {
		ThenStatementsContext _localctx = new ThenStatementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_thenStatements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__27);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(158);
					statement();
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterElseStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitElseStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitElseStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementsContext elseStatements() throws RecognitionException {
		ElseStatementsContext _localctx = new ElseStatementsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elseStatements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__28);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165);
					statement();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhileConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterWhileCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitWhileCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitWhileCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileConditionContext whileCondition() throws RecognitionException {
		WhileConditionContext _localctx = new WhileConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterWhileStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitWhileStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitWhileStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementsContext whileStatements() throws RecognitionException {
		WhileStatementsContext _localctx = new WhileStatementsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileStatements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173);
					statement();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterDoCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitDoCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitDoCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoConditionContext doCondition() throws RecognitionException {
		DoConditionContext _localctx = new DoConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_doCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DoStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterDoStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitDoStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitDoStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoStatementsContext doStatements() throws RecognitionException {
		DoStatementsContext _localctx = new DoStatementsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_doStatements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181);
					statement();
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BINOP() { return getToken(MyLangParser.BINOP, 0); }
		public BinaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnariContext extends ExprContext {
		public TerminalNode UNOP() { return getToken(MyLangParser.UNOP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnariContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterUnari(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitUnari(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitUnari(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlaceContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(MyLangParser.IDENTIFIER, 0); }
		public PlaceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitPlace(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexerContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndexerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterIndexer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitIndexer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitIndexer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitBraces(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralContext extends ExprContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public LiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLangVisitor ) return ((MyLangVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNOP:
				{
				_localctx = new UnariContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(188);
				match(UNOP);
				setState(189);
				expr(6);
				}
				break;
			case T__15:
				{
				_localctx = new BracesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(T__15);
				setState(191);
				expr(0);
				setState(192);
				match(T__16);
				}
				break;
			case CHAR:
			case HEX:
			case BITS:
			case BOOL:
			case DEC:
			case STR:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				lit();
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new PlaceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(199);
						match(BINOP);
						setState(200);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new CallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(202);
						match(T__15);
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << CHAR) | (1L << HEX) | (1L << BITS) | (1L << BOOL) | (1L << DEC) | (1L << IDENTIFIER) | (1L << STR) | (1L << UNOP))) != 0)) {
							{
							setState(203);
							expr(0);
							setState(208);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__14) {
								{
								{
								setState(204);
								match(T__14);
								setState(205);
								expr(0);
								}
								}
								setState(210);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(213);
						match(T__16);
						}
						break;
					case 3:
						{
						_localctx = new IndexerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(215);
						match(T__18);
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << CHAR) | (1L << HEX) | (1L << BITS) | (1L << BOOL) | (1L << DEC) | (1L << IDENTIFIER) | (1L << STR) | (1L << UNOP))) != 0)) {
							{
							setState(216);
							expr(0);
							setState(221);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__14) {
								{
								{
								setState(217);
								match(T__14);
								setState(218);
								expr(0);
								}
								}
								setState(223);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(226);
						match(T__19);
						}
						break;
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\5\2,\n\2\3\3\3\3\3\4\3\4\3\5\7\5\63\n"+
		"\5\f\5\16\5\66\13\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7@\n\7\3\7\3\7\3"+
		"\b\3\b\7\bF\n\b\f\b\16\bI\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\tR\n\t\f"+
		"\t\16\tU\13\t\5\tW\n\t\3\t\3\t\5\t[\n\t\3\t\7\t^\n\t\f\t\16\ta\13\t\5"+
		"\tc\n\t\3\n\3\n\3\n\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\5\no\n\n\3\n\3\n\3"+
		"\n\5\nt\n\n\3\13\3\13\3\13\3\13\3\13\7\13{\n\13\f\13\16\13~\13\13\3\13"+
		"\3\13\3\13\5\13\u0083\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u008a\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009c\n\f\3"+
		"\r\3\r\3\16\3\16\7\16\u00a2\n\16\f\16\16\16\u00a5\13\16\3\17\3\17\7\17"+
		"\u00a9\n\17\f\17\16\17\u00ac\13\17\3\20\3\20\3\21\7\21\u00b1\n\21\f\21"+
		"\16\21\u00b4\13\21\3\22\3\22\3\23\7\23\u00b9\n\23\f\23\16\23\u00bc\13"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00c7\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d1\n\24\f\24\16\24\u00d4\13"+
		"\24\5\24\u00d6\n\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00de\n\24\f\24"+
		"\16\24\u00e1\13\24\5\24\u00e3\n\24\3\24\7\24\u00e6\n\24\f\24\16\24\u00e9"+
		"\13\24\3\24\2\3&\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\3"+
		"\2\4\13\4\2 $&&\4\2\31\31\34\34\2\u00fa\2(\3\2\2\2\4-\3\2\2\2\6/\3\2\2"+
		"\2\b\64\3\2\2\2\n9\3\2\2\2\f;\3\2\2\2\16C\3\2\2\2\20b\3\2\2\2\22d\3\2"+
		"\2\2\24\u0082\3\2\2\2\26\u009b\3\2\2\2\30\u009d\3\2\2\2\32\u009f\3\2\2"+
		"\2\34\u00a6\3\2\2\2\36\u00ad\3\2\2\2 \u00b2\3\2\2\2\"\u00b5\3\2\2\2$\u00ba"+
		"\3\2\2\2&\u00c6\3\2\2\2(+\7%\2\2)*\7\3\2\2*,\5\24\13\2+)\3\2\2\2+,\3\2"+
		"\2\2,\3\3\2\2\2-.\t\2\2\2.\5\3\2\2\2/\60\t\3\2\2\60\7\3\2\2\2\61\63\5"+
		"\n\6\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3"+
		"\2\2\2\66\64\3\2\2\2\678\7\2\2\38\t\3\2\2\29:\5\f\7\2:\13\3\2\2\2;<\7"+
		"\f\2\2<?\5\22\n\2=@\5\20\t\2>@\7\r\2\2?=\3\2\2\2?>\3\2\2\2@A\3\2\2\2A"+
		"B\5\16\b\2B\r\3\2\2\2CG\7\16\2\2DF\5\26\f\2ED\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\17\2\2KL\7\r\2\2L\17\3\2\2\2M_"+
		"\7\20\2\2NS\7%\2\2OP\7\21\2\2PR\7%\2\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2S"+
		"T\3\2\2\2TW\3\2\2\2US\3\2\2\2VN\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XY\7\3\2\2"+
		"Y[\5\24\13\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\^\7\r\2\2]V\3\2\2\2^a\3\2"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bM\3\2\2\2bc\3\2\2\2c\21\3"+
		"\2\2\2de\7%\2\2en\7\22\2\2fk\5\2\2\2gh\7\21\2\2hj\5\2\2\2ig\3\2\2\2jm"+
		"\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2\2\2nf\3\2\2\2no\3\2\2\2o"+
		"p\3\2\2\2ps\7\23\2\2qr\7\3\2\2rt\5\24\13\2sq\3\2\2\2st\3\2\2\2t\23\3\2"+
		"\2\2u\u0083\5\4\3\2v\u0083\7%\2\2wx\7\24\2\2x|\7\25\2\2y{\7\21\2\2zy\3"+
		"\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080"+
		"\7\26\2\2\u0080\u0081\7\27\2\2\u0081\u0083\5\24\13\2\u0082u\3\2\2\2\u0082"+
		"v\3\2\2\2\u0082w\3\2\2\2\u0083\25\3\2\2\2\u0084\u009c\5\16\b\2\u0085\u0086"+
		"\7\30\2\2\u0086\u0087\5\30\r\2\u0087\u0089\5\32\16\2\u0088\u008a\5\34"+
		"\17\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u009c\3\2\2\2\u008b"+
		"\u008c\7\31\2\2\u008c\u008d\5\36\20\2\u008d\u008e\7\32\2\2\u008e\u008f"+
		"\5 \21\2\u008f\u009c\3\2\2\2\u0090\u0091\7\33\2\2\u0091\u0092\5$\23\2"+
		"\u0092\u0093\t\4\2\2\u0093\u0094\5\"\22\2\u0094\u0095\7\r\2\2\u0095\u009c"+
		"\3\2\2\2\u0096\u0097\7\35\2\2\u0097\u009c\7\r\2\2\u0098\u0099\5&\24\2"+
		"\u0099\u009a\7\r\2\2\u009a\u009c\3\2\2\2\u009b\u0084\3\2\2\2\u009b\u0085"+
		"\3\2\2\2\u009b\u008b\3\2\2\2\u009b\u0090\3\2\2\2\u009b\u0096\3\2\2\2\u009b"+
		"\u0098\3\2\2\2\u009c\27\3\2\2\2\u009d\u009e\5&\24\2\u009e\31\3\2\2\2\u009f"+
		"\u00a3\7\36\2\2\u00a0\u00a2\5\26\f\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\33\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00aa\7\37\2\2\u00a7\u00a9\5\26\f\2\u00a8\u00a7\3"+
		"\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\35\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\5&\24\2\u00ae\37\3\2\2\2\u00af"+
		"\u00b1\5\26\f\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3!\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6"+
		"\5&\24\2\u00b6#\3\2\2\2\u00b7\u00b9\5\26\f\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb%\3\2\2\2"+
		"\u00bc\u00ba\3\2\2\2\u00bd\u00be\b\24\1\2\u00be\u00bf\7(\2\2\u00bf\u00c7"+
		"\5&\24\b\u00c0\u00c1\7\22\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c3\7\23\2\2"+
		"\u00c3\u00c7\3\2\2\2\u00c4\u00c7\5\6\4\2\u00c5\u00c7\7%\2\2\u00c6\u00bd"+
		"\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00e7\3\2\2\2\u00c8\u00c9\f\t\2\2\u00c9\u00ca\7\'\2\2\u00ca\u00e6\5&"+
		"\24\n\u00cb\u00cc\f\6\2\2\u00cc\u00d5\7\22\2\2\u00cd\u00d2\5&\24\2\u00ce"+
		"\u00cf\7\21\2\2\u00cf\u00d1\5&\24\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3"+
		"\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00cd\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00e6\7\23\2\2\u00d8\u00d9\f\5\2\2\u00d9\u00e2\7\25\2\2\u00da"+
		"\u00df\5&\24\2\u00db\u00dc\7\21\2\2\u00dc\u00de\5&\24\2\u00dd\u00db\3"+
		"\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\7\26\2\2\u00e5\u00c8\3\2\2\2\u00e5"+
		"\u00cb\3\2\2\2\u00e5\u00d8\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e7\u00e8\3\2\2\2\u00e8\'\3\2\2\2\u00e9\u00e7\3\2\2\2\35+\64?G"+
		"SVZ_bkns|\u0082\u0089\u009b\u00a3\u00aa\u00b2\u00ba\u00c6\u00d2\u00d5"+
		"\u00df\u00e2\u00e5\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}