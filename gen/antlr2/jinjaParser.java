// Generated from E:/compiler_new/src/antlr2/jinjaParser.g4 by ANTLR 4.13.2
package antlr2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class jinjaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STYLE_TAG_START=1, WS=2, HTML_LT=3, HTML_CLOSE_LT=4, HTML_COMMENT=5, HTML_TEXT=6, 
		JINJA2_COMMENT=7, JINJA2_OPEN_EXPR=8, JINJA2_OPEN_STMT=9, TAG_HTML=10, 
		TAG_HEAD=11, TAG_BODY=12, TAG_DIV=13, TAG_SPAN=14, TAG_P=15, TAG_A=16, 
		TAG_H1_6=17, TAG_UL=18, TAG_OL=19, TAG_LI=20, TAG_TABLE=21, TAG_TR=22, 
		TAG_TD=23, TAG_FORM=24, TAG_BUTTON=25, TAG_SCRIPT=26, TAG_HEADER=27, TAG_FOOTER=28, 
		TAG_SECTION=29, TAG_BR=30, TAG_HR=31, TAG_IMG=32, TAG_INPUT=33, TAG_META=34, 
		TAG_LINK=35, HTML_TAG_NAME=36, HTML_TAG_WS=37, HTML_EQUALS=38, HTML_ATTR_VALUE_START_DOUBLE=39, 
		HTML_ATTR_VALUE_START_SINGLE=40, HTML_ATTRIBUTE_VALUE_UNQUOTED=41, JINJA2_OPEN_EXPR_IN_TAG=42, 
		JINJA2_OPEN_STMT_IN_TAG=43, HTML_TAG_SELF_CLOSE=44, HTML_TAG_END=45, HTML_ATTRIBUTE_NAME=46, 
		HTML_CLOSE_TAG_NAME=47, HTML_CLOSE_TAG_WS=48, HTML_CLOSE_TAG_END=49, JINJA2_OPEN_EXPR_IN_ATTR=50, 
		JINJA2_OPEN_STMT_IN_ATTR=51, ATTR_VALUE_TEXT_DOUBLE=52, ATTR_VALUE_END_DOUBLE=53, 
		JINJA2_OPEN_EXPR_IN_ATTR_S=54, JINJA2_OPEN_STMT_IN_ATTR_S=55, ATTR_VALUE_TEXT_SINGLE=56, 
		ATTR_VALUE_END_SINGLE=57, CSS_STYLE_END=58, CSS_COLON=59, CSS_SEMICOLON=60, 
		CSS_BRACE_OPEN=61, CSS_BRACE_CLOSE=62, CSS_COMMA=63, JINJA2_OPEN_EXPR_IN_CSS=64, 
		JINJA2_OPEN_STMT_IN_CSS=65, CSS_COMMENT=66, CSS_WS=67, CSS_AT_RULE=68, 
		CSS_UNIVERSAL=69, CSS_CLASS_SELECTOR=70, CSS_ID_SELECTOR=71, CSS_PSEUDO_ELEMENT=72, 
		CSS_PSEUDO_CLASS=73, CSS_PROPERTY=74, CSS_VALUE=75, CSS_TYPE_SELECTOR=76, 
		CSS_COMBINATOR=77, JINJA2_CLOSE_EXPR=78, JINJA_WS=79, JINJA_IDENT=80, 
		JINJA_DOT=81, JINJA_NUMBER=82, JINJA_STRING=83, JINJA_COMMA=84, JINJA_COLON=85, 
		JINJA_LPAREN=86, JINJA_RPAREN=87, JINJA_LBRACK=88, JINJA_RBRACK=89, JINJA_PIPE=90, 
		JINJA_OP=91, JINJA_TILDE=92, JINJA_ASSIGN=93, JINJA_OTHER=94, JINJA2_CLOSE_STMT=95, 
		JINJA_STMT_WS=96, JINJA_KW_FOR=97, JINJA_KW_ENDFOR=98, JINJA_KW_IF=99, 
		JINJA_KW_ENDIF=100, JINJA_KW_ELSE=101, JINJA_KW_ELIF=102, JINJA_KW_IN=103, 
		JINJA_STMT_ANY=104;
	public static final int
		RULE_prog = 0, RULE_content = 1, RULE_htmlText = 2, RULE_jinjaExpression = 3, 
		RULE_expr = 4, RULE_primaryExpr = 5, RULE_jinjaStatement = 6, RULE_ifStatement = 7, 
		RULE_elifStatement = 8, RULE_elseStatement = 9, RULE_endifStatement = 10, 
		RULE_forStatement = 11, RULE_endforStatement = 12, RULE_forControl = 13, 
		RULE_htmlElement = 14, RULE_voidTagName = 15, RULE_tagName = 16, RULE_closeTagName = 17, 
		RULE_attribute = 18, RULE_attrValue = 19, RULE_styleBlock = 20, RULE_cssContent = 21, 
		RULE_cssRule = 22, RULE_cssSelectorList = 23, RULE_cssSelector = 24, RULE_cssDeclarationList = 25, 
		RULE_declaration = 26, RULE_cssValue = 27, RULE_cssValueList = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "content", "htmlText", "jinjaExpression", "expr", "primaryExpr", 
			"jinjaStatement", "ifStatement", "elifStatement", "elseStatement", "endifStatement", 
			"forStatement", "endforStatement", "forControl", "htmlElement", "voidTagName", 
			"tagName", "closeTagName", "attribute", "attrValue", "styleBlock", "cssContent", 
			"cssRule", "cssSelectorList", "cssSelector", "cssDeclarationList", "declaration", 
			"cssValue", "cssValueList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<'", "'</'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "';'", "'{'", "'}'", null, null, null, null, null, null, "'*'", 
			null, null, null, null, null, null, null, null, "'}}'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'~'", null, 
			null, "'%}'", null, "'for'", "'endfor'", "'if'", "'endif'", "'else'", 
			"'elif'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STYLE_TAG_START", "WS", "HTML_LT", "HTML_CLOSE_LT", "HTML_COMMENT", 
			"HTML_TEXT", "JINJA2_COMMENT", "JINJA2_OPEN_EXPR", "JINJA2_OPEN_STMT", 
			"TAG_HTML", "TAG_HEAD", "TAG_BODY", "TAG_DIV", "TAG_SPAN", "TAG_P", "TAG_A", 
			"TAG_H1_6", "TAG_UL", "TAG_OL", "TAG_LI", "TAG_TABLE", "TAG_TR", "TAG_TD", 
			"TAG_FORM", "TAG_BUTTON", "TAG_SCRIPT", "TAG_HEADER", "TAG_FOOTER", "TAG_SECTION", 
			"TAG_BR", "TAG_HR", "TAG_IMG", "TAG_INPUT", "TAG_META", "TAG_LINK", "HTML_TAG_NAME", 
			"HTML_TAG_WS", "HTML_EQUALS", "HTML_ATTR_VALUE_START_DOUBLE", "HTML_ATTR_VALUE_START_SINGLE", 
			"HTML_ATTRIBUTE_VALUE_UNQUOTED", "JINJA2_OPEN_EXPR_IN_TAG", "JINJA2_OPEN_STMT_IN_TAG", 
			"HTML_TAG_SELF_CLOSE", "HTML_TAG_END", "HTML_ATTRIBUTE_NAME", "HTML_CLOSE_TAG_NAME", 
			"HTML_CLOSE_TAG_WS", "HTML_CLOSE_TAG_END", "JINJA2_OPEN_EXPR_IN_ATTR", 
			"JINJA2_OPEN_STMT_IN_ATTR", "ATTR_VALUE_TEXT_DOUBLE", "ATTR_VALUE_END_DOUBLE", 
			"JINJA2_OPEN_EXPR_IN_ATTR_S", "JINJA2_OPEN_STMT_IN_ATTR_S", "ATTR_VALUE_TEXT_SINGLE", 
			"ATTR_VALUE_END_SINGLE", "CSS_STYLE_END", "CSS_COLON", "CSS_SEMICOLON", 
			"CSS_BRACE_OPEN", "CSS_BRACE_CLOSE", "CSS_COMMA", "JINJA2_OPEN_EXPR_IN_CSS", 
			"JINJA2_OPEN_STMT_IN_CSS", "CSS_COMMENT", "CSS_WS", "CSS_AT_RULE", "CSS_UNIVERSAL", 
			"CSS_CLASS_SELECTOR", "CSS_ID_SELECTOR", "CSS_PSEUDO_ELEMENT", "CSS_PSEUDO_CLASS", 
			"CSS_PROPERTY", "CSS_VALUE", "CSS_TYPE_SELECTOR", "CSS_COMBINATOR", "JINJA2_CLOSE_EXPR", 
			"JINJA_WS", "JINJA_IDENT", "JINJA_DOT", "JINJA_NUMBER", "JINJA_STRING", 
			"JINJA_COMMA", "JINJA_COLON", "JINJA_LPAREN", "JINJA_RPAREN", "JINJA_LBRACK", 
			"JINJA_RBRACK", "JINJA_PIPE", "JINJA_OP", "JINJA_TILDE", "JINJA_ASSIGN", 
			"JINJA_OTHER", "JINJA2_CLOSE_STMT", "JINJA_STMT_WS", "JINJA_KW_FOR", 
			"JINJA_KW_ENDFOR", "JINJA_KW_IF", "JINJA_KW_ENDIF", "JINJA_KW_ELSE", 
			"JINJA_KW_ELIF", "JINJA_KW_IN", "JINJA_STMT_ANY"
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
	public String getGrammarFileName() { return "jinjaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public jinjaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ProgContext {
		public TerminalNode EOF() { return getToken(jinjaParser.EOF, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public List<TerminalNode> JINJA_STMT_WS() { return getTokens(jinjaParser.JINJA_STMT_WS); }
		public TerminalNode JINJA_STMT_WS(int i) {
			return getToken(jinjaParser.JINJA_STMT_WS, i);
		}
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 19153492555858762L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4294967299L) != 0)) {
				{
				setState(60);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STYLE_TAG_START:
				case HTML_LT:
				case HTML_TEXT:
				case JINJA2_OPEN_EXPR:
				case JINJA2_OPEN_STMT:
				case JINJA2_OPEN_EXPR_IN_TAG:
				case JINJA2_OPEN_STMT_IN_TAG:
				case JINJA2_OPEN_EXPR_IN_ATTR:
				case JINJA2_OPEN_EXPR_IN_ATTR_S:
				case JINJA2_OPEN_EXPR_IN_CSS:
				case JINJA2_OPEN_STMT_IN_CSS:
					{
					setState(58);
					content();
					}
					break;
				case JINJA_STMT_WS:
					{
					setState(59);
					match(JINJA_STMT_WS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContentContext extends ParserRuleContext {
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
	 
		public ContentContext() { }
		public void copyFrom(ContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementContentContext extends ContentContext {
		public JinjaStatementContext jinjaStatement() {
			return getRuleContext(JinjaStatementContext.class,0);
		}
		public JinjaStatementContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterJinjaStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitJinjaStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitJinjaStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContentContext extends ContentContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlElementContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterHtmlElementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitHtmlElementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitHtmlElementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StyleBlockContentContext extends ContentContext {
		public StyleBlockContext styleBlock() {
			return getRuleContext(StyleBlockContext.class,0);
		}
		public StyleBlockContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterStyleBlockContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitStyleBlockContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitStyleBlockContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextContentContext extends ContentContext {
		public HtmlTextContext htmlText() {
			return getRuleContext(HtmlTextContext.class,0);
		}
		public TextContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTextContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTextContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContentContext extends ContentContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public JinjaExpressionContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterJinjaExpressionContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitJinjaExpressionContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitJinjaExpressionContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_content);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_LT:
				_localctx = new HtmlElementContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				htmlElement();
				}
				break;
			case JINJA2_OPEN_STMT:
			case JINJA2_OPEN_STMT_IN_TAG:
			case JINJA2_OPEN_STMT_IN_CSS:
				_localctx = new JinjaStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				jinjaStatement();
				}
				break;
			case JINJA2_OPEN_EXPR:
			case JINJA2_OPEN_EXPR_IN_TAG:
			case JINJA2_OPEN_EXPR_IN_ATTR:
			case JINJA2_OPEN_EXPR_IN_ATTR_S:
			case JINJA2_OPEN_EXPR_IN_CSS:
				_localctx = new JinjaExpressionContentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				jinjaExpression();
				}
				break;
			case STYLE_TAG_START:
				_localctx = new StyleBlockContentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				styleBlock();
				}
				break;
			case HTML_TEXT:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				htmlText();
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

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContext extends ParserRuleContext {
		public HtmlTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlText; }
	 
		public HtmlTextContext() { }
		public void copyFrom(HtmlTextContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContentContext extends HtmlTextContext {
		public TerminalNode HTML_TEXT() { return getToken(jinjaParser.HTML_TEXT, 0); }
		public HtmlTextContentContext(HtmlTextContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterHtmlTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitHtmlTextContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitHtmlTextContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlTextContext htmlText() throws RecognitionException {
		HtmlTextContext _localctx = new HtmlTextContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlText);
		try {
			_localctx = new HtmlTextContentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(HTML_TEXT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
	 
		public JinjaExpressionContext() { }
		public void copyFrom(JinjaExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionWrapperContext extends JinjaExpressionContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA2_CLOSE_EXPR() { return getToken(jinjaParser.JINJA2_CLOSE_EXPR, 0); }
		public TerminalNode JINJA2_OPEN_EXPR() { return getToken(jinjaParser.JINJA2_OPEN_EXPR, 0); }
		public TerminalNode JINJA2_OPEN_EXPR_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_EXPR_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_EXPR_IN_ATTR() { return getToken(jinjaParser.JINJA2_OPEN_EXPR_IN_ATTR, 0); }
		public TerminalNode JINJA2_OPEN_EXPR_IN_ATTR_S() { return getToken(jinjaParser.JINJA2_OPEN_EXPR_IN_ATTR_S, 0); }
		public TerminalNode JINJA2_OPEN_EXPR_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_EXPR_IN_CSS, 0); }
		public JinjaExpressionWrapperContext(JinjaExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterJinjaExpressionWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitJinjaExpressionWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitJinjaExpressionWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_jinjaExpression);
		int _la;
		try {
			_localctx = new JinjaExpressionWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !(((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 72132378008485889L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(77);
			expr(0);
			setState(78);
			match(JINJA2_CLOSE_EXPR);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExpressionContext extends ExprContext {
		public Token ifToken;
		public ExprContext condition;
		public Token elseToken;
		public ExprContext elseExpr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> JINJA_IDENT() { return getTokens(jinjaParser.JINJA_IDENT); }
		public TerminalNode JINJA_IDENT(int i) {
			return getToken(jinjaParser.JINJA_IDENT, i);
		}
		public TernaryExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessExpressionContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA_DOT() { return getToken(jinjaParser.JINJA_DOT, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode JINJA_IDENT() { return getToken(jinjaParser.JINJA_IDENT, 0); }
		public MemberAccessExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterMemberAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitMemberAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitMemberAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpExpressionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JINJA_OP() { return getToken(jinjaParser.JINJA_OP, 0); }
		public BinaryOpExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterBinaryOpExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitBinaryOpExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitBinaryOpExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ExprContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public PrimaryExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexAccessExpressionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JINJA_LBRACK() { return getToken(jinjaParser.JINJA_LBRACK, 0); }
		public TerminalNode JINJA_RBRACK() { return getToken(jinjaParser.JINJA_RBRACK, 0); }
		public IndexAccessExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterIndexAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitIndexAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitIndexAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterExpressionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JINJA_PIPE() { return getToken(jinjaParser.JINJA_PIPE, 0); }
		public TerminalNode JINJA_IDENT() { return getToken(jinjaParser.JINJA_IDENT, 0); }
		public TerminalNode JINJA_LPAREN() { return getToken(jinjaParser.JINJA_LPAREN, 0); }
		public TerminalNode JINJA_RPAREN() { return getToken(jinjaParser.JINJA_RPAREN, 0); }
		public List<TerminalNode> JINJA_COMMA() { return getTokens(jinjaParser.JINJA_COMMA); }
		public TerminalNode JINJA_COMMA(int i) {
			return getToken(jinjaParser.JINJA_COMMA, i);
		}
		public FilterExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterFilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitFilterExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitFilterExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExpressionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JINJA_LPAREN() { return getToken(jinjaParser.JINJA_LPAREN, 0); }
		public TerminalNode JINJA_RPAREN() { return getToken(jinjaParser.JINJA_RPAREN, 0); }
		public List<TerminalNode> JINJA_COMMA() { return getTokens(jinjaParser.JINJA_COMMA); }
		public TerminalNode JINJA_COMMA(int i) {
			return getToken(jinjaParser.JINJA_COMMA, i);
		}
		public FunctionCallExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryExpressionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(81);
			primaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpExpressionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(84);
						match(JINJA_OP);
						setState(85);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new TernaryExpressionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(87);
						((TernaryExpressionContext)_localctx).ifToken = match(JINJA_IDENT);
						setState(88);
						((TernaryExpressionContext)_localctx).condition = expr(0);
						setState(89);
						((TernaryExpressionContext)_localctx).elseToken = match(JINJA_IDENT);
						setState(90);
						((TernaryExpressionContext)_localctx).elseExpr = expr(2);
						}
						break;
					case 3:
						{
						_localctx = new FunctionCallExpressionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(93);
						match(JINJA_LPAREN);
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 2621453L) != 0)) {
							{
							setState(94);
							expr(0);
							setState(99);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==JINJA_COMMA) {
								{
								{
								setState(95);
								match(JINJA_COMMA);
								setState(96);
								expr(0);
								}
								}
								setState(101);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(104);
						match(JINJA_RPAREN);
						}
						break;
					case 4:
						{
						_localctx = new MemberAccessExpressionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(106);
						match(JINJA_DOT);
						setState(109);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
						case 1:
							{
							setState(107);
							primaryExpr();
							}
							break;
						case 2:
							{
							setState(108);
							match(JINJA_IDENT);
							}
							break;
						}
						}
						break;
					case 5:
						{
						_localctx = new IndexAccessExpressionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(112);
						match(JINJA_LBRACK);
						setState(113);
						expr(0);
						setState(114);
						match(JINJA_RBRACK);
						}
						break;
					case 6:
						{
						_localctx = new FilterExpressionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(117);
						match(JINJA_PIPE);
						setState(118);
						match(JINJA_IDENT);
						setState(131);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
						case 1:
							{
							setState(119);
							match(JINJA_LPAREN);
							setState(128);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 2621453L) != 0)) {
								{
								setState(120);
								expr(0);
								setState(125);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==JINJA_COMMA) {
									{
									{
									setState(121);
									match(JINJA_COMMA);
									setState(122);
									expr(0);
									}
									}
									setState(127);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
							}

							setState(130);
							match(JINJA_RPAREN);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	 
		public PrimaryExprContext() { }
		public void copyFrom(PrimaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseKeywordPrimaryContext extends PrimaryExprContext {
		public TerminalNode JINJA_KW_ELSE() { return getToken(jinjaParser.JINJA_KW_ELSE, 0); }
		public ElseKeywordPrimaryContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterElseKeywordPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitElseKeywordPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitElseKeywordPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfKeywordPrimaryContext extends PrimaryExprContext {
		public TerminalNode JINJA_KW_IF() { return getToken(jinjaParser.JINJA_KW_IF, 0); }
		public IfKeywordPrimaryContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterIfKeywordPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitIfKeywordPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitIfKeywordPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringPrimaryContext extends PrimaryExprContext {
		public TerminalNode JINJA_STRING() { return getToken(jinjaParser.JINJA_STRING, 0); }
		public StringPrimaryContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterStringPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitStringPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitStringPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierPrimaryContext extends PrimaryExprContext {
		public TerminalNode JINJA_IDENT() { return getToken(jinjaParser.JINJA_IDENT, 0); }
		public IdentifierPrimaryContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterIdentifierPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitIdentifierPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitIdentifierPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberPrimaryContext extends PrimaryExprContext {
		public TerminalNode JINJA_NUMBER() { return getToken(jinjaParser.JINJA_NUMBER, 0); }
		public NumberPrimaryContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterNumberPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitNumberPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitNumberPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primaryExpr);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_IDENT:
				_localctx = new IdentifierPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(JINJA_IDENT);
				}
				break;
			case JINJA_NUMBER:
				_localctx = new NumberPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(JINJA_NUMBER);
				}
				break;
			case JINJA_STRING:
				_localctx = new StringPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(JINJA_STRING);
				}
				break;
			case JINJA_KW_IF:
				_localctx = new IfKeywordPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(JINJA_KW_IF);
				}
				break;
			case JINJA_KW_ELSE:
				_localctx = new ElseKeywordPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				match(JINJA_KW_ELSE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementContext extends ParserRuleContext {
		public JinjaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStatement; }
	 
		public JinjaStatementContext() { }
		public void copyFrom(JinjaStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContentContext extends JinjaStatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfStatementContentContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterIfStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitIfStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitIfStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndifStatementContentContext extends JinjaStatementContext {
		public EndifStatementContext endifStatement() {
			return getRuleContext(EndifStatementContext.class,0);
		}
		public EndifStatementContentContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterEndifStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitEndifStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitEndifStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContentContext extends JinjaStatementContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForStatementContentContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterForStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitForStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitForStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndforStatementContentContext extends JinjaStatementContext {
		public EndforStatementContext endforStatement() {
			return getRuleContext(EndforStatementContext.class,0);
		}
		public EndforStatementContentContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterEndforStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitEndforStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitEndforStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElifStatementContentContext extends JinjaStatementContext {
		public ElifStatementContext elifStatement() {
			return getRuleContext(ElifStatementContext.class,0);
		}
		public ElifStatementContentContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterElifStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitElifStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitElifStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContentContext extends JinjaStatementContext {
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public ElseStatementContentContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterElseStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitElseStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitElseStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStatementContext jinjaStatement() throws RecognitionException {
		JinjaStatementContext _localctx = new JinjaStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_jinjaStatement);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new IfStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				ifStatement();
				}
				break;
			case 2:
				_localctx = new ForStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				forStatement();
				}
				break;
			case 3:
				_localctx = new ElifStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				elifStatement();
				}
				break;
			case 4:
				_localctx = new ElseStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				elseStatement();
				}
				break;
			case 5:
				_localctx = new EndifStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				endifStatement();
				}
				break;
			case 6:
				_localctx = new EndforStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				endforStatement();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	 
		public IfStatementContext() { }
		public void copyFrom(IfStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementWrapperContext extends IfStatementContext {
		public TerminalNode JINJA_KW_IF() { return getToken(jinjaParser.JINJA_KW_IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA2_CLOSE_STMT() { return getToken(jinjaParser.JINJA2_CLOSE_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT() { return getToken(jinjaParser.JINJA2_OPEN_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_CSS, 0); }
		public IfStatementWrapperContext(IfStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterIfStatementWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitIfStatementWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitIfStatementWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			_localctx = new IfStatementWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057611217797121L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(154);
			match(JINJA_KW_IF);
			setState(155);
			expr(0);
			setState(156);
			match(JINJA2_CLOSE_STMT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElifStatementContext extends ParserRuleContext {
		public ElifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifStatement; }
	 
		public ElifStatementContext() { }
		public void copyFrom(ElifStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElifStatementWrapperContext extends ElifStatementContext {
		public TerminalNode JINJA_KW_ELIF() { return getToken(jinjaParser.JINJA_KW_ELIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA2_CLOSE_STMT() { return getToken(jinjaParser.JINJA2_CLOSE_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT() { return getToken(jinjaParser.JINJA2_OPEN_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_CSS, 0); }
		public ElifStatementWrapperContext(ElifStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterElifStatementWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitElifStatementWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitElifStatementWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifStatementContext elifStatement() throws RecognitionException {
		ElifStatementContext _localctx = new ElifStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elifStatement);
		int _la;
		try {
			_localctx = new ElifStatementWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057611217797121L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(159);
			match(JINJA_KW_ELIF);
			setState(160);
			expr(0);
			setState(161);
			match(JINJA2_CLOSE_STMT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContext extends ParserRuleContext {
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
	 
		public ElseStatementContext() { }
		public void copyFrom(ElseStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementWrapperContext extends ElseStatementContext {
		public TerminalNode JINJA_KW_ELSE() { return getToken(jinjaParser.JINJA_KW_ELSE, 0); }
		public TerminalNode JINJA2_CLOSE_STMT() { return getToken(jinjaParser.JINJA2_CLOSE_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT() { return getToken(jinjaParser.JINJA2_OPEN_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_CSS, 0); }
		public ElseStatementWrapperContext(ElseStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterElseStatementWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitElseStatementWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitElseStatementWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseStatement);
		int _la;
		try {
			_localctx = new ElseStatementWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057611217797121L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(164);
			match(JINJA_KW_ELSE);
			setState(165);
			match(JINJA2_CLOSE_STMT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EndifStatementContext extends ParserRuleContext {
		public EndifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endifStatement; }
	 
		public EndifStatementContext() { }
		public void copyFrom(EndifStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndifStatementWrapperContext extends EndifStatementContext {
		public TerminalNode JINJA_KW_ENDIF() { return getToken(jinjaParser.JINJA_KW_ENDIF, 0); }
		public TerminalNode JINJA2_CLOSE_STMT() { return getToken(jinjaParser.JINJA2_CLOSE_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT() { return getToken(jinjaParser.JINJA2_OPEN_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_CSS, 0); }
		public EndifStatementWrapperContext(EndifStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterEndifStatementWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitEndifStatementWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitEndifStatementWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndifStatementContext endifStatement() throws RecognitionException {
		EndifStatementContext _localctx = new EndifStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_endifStatement);
		int _la;
		try {
			_localctx = new EndifStatementWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057611217797121L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(168);
			match(JINJA_KW_ENDIF);
			setState(169);
			match(JINJA2_CLOSE_STMT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	 
		public ForStatementContext() { }
		public void copyFrom(ForStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementWrapperContext extends ForStatementContext {
		public TerminalNode JINJA_KW_FOR() { return getToken(jinjaParser.JINJA_KW_FOR, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode JINJA2_CLOSE_STMT() { return getToken(jinjaParser.JINJA2_CLOSE_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT() { return getToken(jinjaParser.JINJA2_OPEN_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_CSS, 0); }
		public ForStatementWrapperContext(ForStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterForStatementWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitForStatementWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitForStatementWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forStatement);
		int _la;
		try {
			_localctx = new ForStatementWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057611217797121L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(172);
			match(JINJA_KW_FOR);
			setState(173);
			forControl();
			setState(174);
			match(JINJA2_CLOSE_STMT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EndforStatementContext extends ParserRuleContext {
		public EndforStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endforStatement; }
	 
		public EndforStatementContext() { }
		public void copyFrom(EndforStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndforStatementWrapperContext extends EndforStatementContext {
		public TerminalNode JINJA_KW_ENDFOR() { return getToken(jinjaParser.JINJA_KW_ENDFOR, 0); }
		public TerminalNode JINJA2_CLOSE_STMT() { return getToken(jinjaParser.JINJA2_CLOSE_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT() { return getToken(jinjaParser.JINJA2_OPEN_STMT, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_TAG() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_TAG, 0); }
		public TerminalNode JINJA2_OPEN_STMT_IN_CSS() { return getToken(jinjaParser.JINJA2_OPEN_STMT_IN_CSS, 0); }
		public EndforStatementWrapperContext(EndforStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterEndforStatementWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitEndforStatementWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitEndforStatementWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndforStatementContext endforStatement() throws RecognitionException {
		EndforStatementContext _localctx = new EndforStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_endforStatement);
		int _la;
		try {
			_localctx = new EndforStatementWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057611217797121L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(177);
			match(JINJA_KW_ENDFOR);
			setState(178);
			match(JINJA2_CLOSE_STMT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForControlContext extends ParserRuleContext {
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
	 
		public ForControlContext() { }
		public void copyFrom(ForControlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForControlContentContext extends ForControlContext {
		public ExprContext expr;
		public List<ExprContext> iterVars = new ArrayList<ExprContext>();
		public ExprContext iterable;
		public TerminalNode JINJA_KW_IN() { return getToken(jinjaParser.JINJA_KW_IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> JINJA_COMMA() { return getTokens(jinjaParser.JINJA_COMMA); }
		public TerminalNode JINJA_COMMA(int i) {
			return getToken(jinjaParser.JINJA_COMMA, i);
		}
		public ForControlContentContext(ForControlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterForControlContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitForControlContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitForControlContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forControl);
		int _la;
		try {
			_localctx = new ForControlContentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((ForControlContentContext)_localctx).expr = expr(0);
			((ForControlContentContext)_localctx).iterVars.add(((ForControlContentContext)_localctx).expr);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==JINJA_COMMA) {
				{
				{
				setState(181);
				match(JINJA_COMMA);
				setState(182);
				((ForControlContentContext)_localctx).expr = expr(0);
				((ForControlContentContext)_localctx).iterVars.add(((ForControlContentContext)_localctx).expr);
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(JINJA_KW_IN);
			setState(189);
			((ForControlContentContext)_localctx).iterable = expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementSpecialContext extends HtmlElementContext {
		public TerminalNode HTML_LT() { return getToken(jinjaParser.HTML_LT, 0); }
		public VoidTagNameContext voidTagName() {
			return getRuleContext(VoidTagNameContext.class,0);
		}
		public TerminalNode HTML_TAG_END() { return getToken(jinjaParser.HTML_TAG_END, 0); }
		public TerminalNode HTML_TAG_SELF_CLOSE() { return getToken(jinjaParser.HTML_TAG_SELF_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidElementSpecialContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterVoidElementSpecial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitVoidElementSpecial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitVoidElementSpecial(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PairedElementContext extends HtmlElementContext {
		public TagNameContext open;
		public CloseTagNameContext close;
		public TerminalNode HTML_LT() { return getToken(jinjaParser.HTML_LT, 0); }
		public TerminalNode HTML_TAG_END() { return getToken(jinjaParser.HTML_TAG_END, 0); }
		public TerminalNode HTML_CLOSE_LT() { return getToken(jinjaParser.HTML_CLOSE_LT, 0); }
		public TerminalNode HTML_CLOSE_TAG_END() { return getToken(jinjaParser.HTML_CLOSE_TAG_END, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public CloseTagNameContext closeTagName() {
			return getRuleContext(CloseTagNameContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public List<TerminalNode> JINJA_STMT_WS() { return getTokens(jinjaParser.JINJA_STMT_WS); }
		public TerminalNode JINJA_STMT_WS(int i) {
			return getToken(jinjaParser.JINJA_STMT_WS, i);
		}
		public PairedElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterPairedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitPairedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitPairedElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingElementContext extends HtmlElementContext {
		public TerminalNode HTML_LT() { return getToken(jinjaParser.HTML_LT, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode HTML_TAG_SELF_CLOSE() { return getToken(jinjaParser.HTML_TAG_SELF_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitSelfClosingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitSelfClosingElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_htmlElement);
		int _la;
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new VoidElementSpecialContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(HTML_LT);
				setState(192);
				voidTagName();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 72132653159022589L) != 0)) {
					{
					{
					setState(193);
					attribute();
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==HTML_TAG_SELF_CLOSE || _la==HTML_TAG_END) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new PairedElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(HTML_LT);
				setState(202);
				((PairedElementContext)_localctx).open = tagName();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 72132653159022589L) != 0)) {
					{
					{
					setState(203);
					attribute();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(HTML_TAG_END);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 19153492555858762L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4294967299L) != 0)) {
					{
					setState(212);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STYLE_TAG_START:
					case HTML_LT:
					case HTML_TEXT:
					case JINJA2_OPEN_EXPR:
					case JINJA2_OPEN_STMT:
					case JINJA2_OPEN_EXPR_IN_TAG:
					case JINJA2_OPEN_STMT_IN_TAG:
					case JINJA2_OPEN_EXPR_IN_ATTR:
					case JINJA2_OPEN_EXPR_IN_ATTR_S:
					case JINJA2_OPEN_EXPR_IN_CSS:
					case JINJA2_OPEN_STMT_IN_CSS:
						{
						setState(210);
						content();
						}
						break;
					case JINJA_STMT_WS:
						{
						setState(211);
						match(JINJA_STMT_WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(HTML_CLOSE_LT);
				setState(218);
				((PairedElementContext)_localctx).close = closeTagName();
				setState(219);
				match(HTML_CLOSE_TAG_END);
				}
				break;
			case 3:
				_localctx = new SelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				match(HTML_LT);
				setState(222);
				tagName();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 72132653159022589L) != 0)) {
					{
					{
					setState(223);
					attribute();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
				match(HTML_TAG_SELF_CLOSE);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class VoidTagNameContext extends ParserRuleContext {
		public VoidTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidTagName; }
	 
		public VoidTagNameContext() { }
		public void copyFrom(VoidTagNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagImgContext extends VoidTagNameContext {
		public TerminalNode TAG_IMG() { return getToken(jinjaParser.TAG_IMG, 0); }
		public TagImgContext(VoidTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagImg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagImg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagImg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagLinkContext extends VoidTagNameContext {
		public TerminalNode TAG_LINK() { return getToken(jinjaParser.TAG_LINK, 0); }
		public TagLinkContext(VoidTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagLink(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagBrContext extends VoidTagNameContext {
		public TerminalNode TAG_BR() { return getToken(jinjaParser.TAG_BR, 0); }
		public TagBrContext(VoidTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagBr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagHrContext extends VoidTagNameContext {
		public TerminalNode TAG_HR() { return getToken(jinjaParser.TAG_HR, 0); }
		public TagHrContext(VoidTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagHr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagHr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagHr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagInputContext extends VoidTagNameContext {
		public TerminalNode TAG_INPUT() { return getToken(jinjaParser.TAG_INPUT, 0); }
		public TagInputContext(VoidTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagInput(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagMetaContext extends VoidTagNameContext {
		public TerminalNode TAG_META() { return getToken(jinjaParser.TAG_META, 0); }
		public TagMetaContext(VoidTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagMeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagMeta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagMeta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidTagNameContext voidTagName() throws RecognitionException {
		VoidTagNameContext _localctx = new VoidTagNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_voidTagName);
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_BR:
				_localctx = new TagBrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(TAG_BR);
				}
				break;
			case TAG_HR:
				_localctx = new TagHrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(TAG_HR);
				}
				break;
			case TAG_IMG:
				_localctx = new TagImgContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(TAG_IMG);
				}
				break;
			case TAG_INPUT:
				_localctx = new TagInputContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
				match(TAG_INPUT);
				}
				break;
			case TAG_META:
				_localctx = new TagMetaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				match(TAG_META);
				}
				break;
			case TAG_LINK:
				_localctx = new TagLinkContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(238);
				match(TAG_LINK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
	 
		public TagNameContext() { }
		public void copyFrom(TagNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagBodyContext extends TagNameContext {
		public TerminalNode TAG_BODY() { return getToken(jinjaParser.TAG_BODY, 0); }
		public TagBodyContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagBody(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagSpanContext extends TagNameContext {
		public TerminalNode TAG_SPAN() { return getToken(jinjaParser.TAG_SPAN, 0); }
		public TagSpanContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagSpan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagSpan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagSpan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagAContext extends TagNameContext {
		public TerminalNode TAG_A() { return getToken(jinjaParser.TAG_A, 0); }
		public TagAContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagA(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagFormContext extends TagNameContext {
		public TerminalNode TAG_FORM() { return getToken(jinjaParser.TAG_FORM, 0); }
		public TagFormContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagForm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagButtonContext extends TagNameContext {
		public TerminalNode TAG_BUTTON() { return getToken(jinjaParser.TAG_BUTTON, 0); }
		public TagButtonContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagButton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagButton(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagButton(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagSectionContext extends TagNameContext {
		public TerminalNode TAG_SECTION() { return getToken(jinjaParser.TAG_SECTION, 0); }
		public TagSectionContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagSection(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagHeadContext extends TagNameContext {
		public TerminalNode TAG_HEAD() { return getToken(jinjaParser.TAG_HEAD, 0); }
		public TagHeadContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagHead(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagHeaderContext extends TagNameContext {
		public TerminalNode TAG_HEADER() { return getToken(jinjaParser.TAG_HEADER, 0); }
		public TagHeaderContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagHeader(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagTdContext extends TagNameContext {
		public TerminalNode TAG_TD() { return getToken(jinjaParser.TAG_TD, 0); }
		public TagTdContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagTd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagTd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagTd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagHContext extends TagNameContext {
		public TerminalNode TAG_H1_6() { return getToken(jinjaParser.TAG_H1_6, 0); }
		public TagHContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagH(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagH(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagDivContext extends TagNameContext {
		public TerminalNode TAG_DIV() { return getToken(jinjaParser.TAG_DIV, 0); }
		public TagDivContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GenericTagContext extends TagNameContext {
		public TerminalNode HTML_TAG_NAME() { return getToken(jinjaParser.HTML_TAG_NAME, 0); }
		public GenericTagContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterGenericTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitGenericTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitGenericTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagPContext extends TagNameContext {
		public TerminalNode TAG_P() { return getToken(jinjaParser.TAG_P, 0); }
		public TagPContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagTrContext extends TagNameContext {
		public TerminalNode TAG_TR() { return getToken(jinjaParser.TAG_TR, 0); }
		public TagTrContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagTr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagTr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagTr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagScriptContext extends TagNameContext {
		public TerminalNode TAG_SCRIPT() { return getToken(jinjaParser.TAG_SCRIPT, 0); }
		public TagScriptContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagScript(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagHtmlContext extends TagNameContext {
		public TerminalNode TAG_HTML() { return getToken(jinjaParser.TAG_HTML, 0); }
		public TagHtmlContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagHtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagHtml(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagOlContext extends TagNameContext {
		public TerminalNode TAG_OL() { return getToken(jinjaParser.TAG_OL, 0); }
		public TagOlContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagOl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagOl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagOl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagLiContext extends TagNameContext {
		public TerminalNode TAG_LI() { return getToken(jinjaParser.TAG_LI, 0); }
		public TagLiContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagLi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagLi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagLi(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagTableContext extends TagNameContext {
		public TerminalNode TAG_TABLE() { return getToken(jinjaParser.TAG_TABLE, 0); }
		public TagTableContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagTable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagUlContext extends TagNameContext {
		public TerminalNode TAG_UL() { return getToken(jinjaParser.TAG_UL, 0); }
		public TagUlContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagUl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagUl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagUl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagFooterContext extends TagNameContext {
		public TerminalNode TAG_FOOTER() { return getToken(jinjaParser.TAG_FOOTER, 0); }
		public TagFooterContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterTagFooter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitTagFooter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitTagFooter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tagName);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_HTML:
				_localctx = new TagHtmlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(TAG_HTML);
				}
				break;
			case TAG_HEAD:
				_localctx = new TagHeadContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(TAG_HEAD);
				}
				break;
			case TAG_BODY:
				_localctx = new TagBodyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				match(TAG_BODY);
				}
				break;
			case TAG_DIV:
				_localctx = new TagDivContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(TAG_DIV);
				}
				break;
			case TAG_SPAN:
				_localctx = new TagSpanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(245);
				match(TAG_SPAN);
				}
				break;
			case TAG_P:
				_localctx = new TagPContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(246);
				match(TAG_P);
				}
				break;
			case TAG_A:
				_localctx = new TagAContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(247);
				match(TAG_A);
				}
				break;
			case TAG_H1_6:
				_localctx = new TagHContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(248);
				match(TAG_H1_6);
				}
				break;
			case TAG_UL:
				_localctx = new TagUlContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(249);
				match(TAG_UL);
				}
				break;
			case TAG_OL:
				_localctx = new TagOlContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(250);
				match(TAG_OL);
				}
				break;
			case TAG_LI:
				_localctx = new TagLiContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(251);
				match(TAG_LI);
				}
				break;
			case TAG_TABLE:
				_localctx = new TagTableContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(252);
				match(TAG_TABLE);
				}
				break;
			case TAG_TR:
				_localctx = new TagTrContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(253);
				match(TAG_TR);
				}
				break;
			case TAG_TD:
				_localctx = new TagTdContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(254);
				match(TAG_TD);
				}
				break;
			case TAG_FORM:
				_localctx = new TagFormContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(255);
				match(TAG_FORM);
				}
				break;
			case TAG_BUTTON:
				_localctx = new TagButtonContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(256);
				match(TAG_BUTTON);
				}
				break;
			case TAG_SCRIPT:
				_localctx = new TagScriptContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(257);
				match(TAG_SCRIPT);
				}
				break;
			case TAG_HEADER:
				_localctx = new TagHeaderContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(258);
				match(TAG_HEADER);
				}
				break;
			case TAG_FOOTER:
				_localctx = new TagFooterContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(259);
				match(TAG_FOOTER);
				}
				break;
			case TAG_SECTION:
				_localctx = new TagSectionContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(260);
				match(TAG_SECTION);
				}
				break;
			case HTML_TAG_NAME:
				_localctx = new GenericTagContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(261);
				match(HTML_TAG_NAME);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CloseTagNameContext extends ParserRuleContext {
		public CloseTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closeTagName; }
	 
		public CloseTagNameContext() { }
		public void copyFrom(CloseTagNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CloseTagLiteralContext extends CloseTagNameContext {
		public TerminalNode HTML_CLOSE_TAG_NAME() { return getToken(jinjaParser.HTML_CLOSE_TAG_NAME, 0); }
		public CloseTagLiteralContext(CloseTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCloseTagLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCloseTagLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCloseTagLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CloseTagFromOpenContext extends CloseTagNameContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public CloseTagFromOpenContext(CloseTagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCloseTagFromOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCloseTagFromOpen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCloseTagFromOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CloseTagNameContext closeTagName() throws RecognitionException {
		CloseTagNameContext _localctx = new CloseTagNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_closeTagName);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_CLOSE_TAG_NAME:
				_localctx = new CloseTagLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(HTML_CLOSE_TAG_NAME);
				}
				break;
			case TAG_HTML:
			case TAG_HEAD:
			case TAG_BODY:
			case TAG_DIV:
			case TAG_SPAN:
			case TAG_P:
			case TAG_A:
			case TAG_H1_6:
			case TAG_UL:
			case TAG_OL:
			case TAG_LI:
			case TAG_TABLE:
			case TAG_TR:
			case TAG_TD:
			case TAG_FORM:
			case TAG_BUTTON:
			case TAG_SCRIPT:
			case TAG_HEADER:
			case TAG_FOOTER:
			case TAG_SECTION:
			case HTML_TAG_NAME:
				_localctx = new CloseTagFromOpenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				tagName();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DynamicAttributeContext extends AttributeContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public DynamicAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterDynamicAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitDynamicAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitDynamicAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RegularAttributeContext extends AttributeContext {
		public TerminalNode HTML_ATTRIBUTE_NAME() { return getToken(jinjaParser.HTML_ATTRIBUTE_NAME, 0); }
		public TerminalNode HTML_TAG_NAME() { return getToken(jinjaParser.HTML_TAG_NAME, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode HTML_EQUALS() { return getToken(jinjaParser.HTML_EQUALS, 0); }
		public AttrValueContext attrValue() {
			return getRuleContext(AttrValueContext.class,0);
		}
		public RegularAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterRegularAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitRegularAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitRegularAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_attribute);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_HTML:
			case TAG_HEAD:
			case TAG_BODY:
			case TAG_DIV:
			case TAG_SPAN:
			case TAG_P:
			case TAG_A:
			case TAG_H1_6:
			case TAG_UL:
			case TAG_OL:
			case TAG_LI:
			case TAG_TABLE:
			case TAG_TR:
			case TAG_TD:
			case TAG_FORM:
			case TAG_BUTTON:
			case TAG_SCRIPT:
			case TAG_HEADER:
			case TAG_FOOTER:
			case TAG_SECTION:
			case HTML_TAG_NAME:
			case HTML_ATTRIBUTE_NAME:
				_localctx = new RegularAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(268);
					match(HTML_ATTRIBUTE_NAME);
					}
					break;
				case 2:
					{
					setState(269);
					match(HTML_TAG_NAME);
					}
					break;
				case 3:
					{
					setState(270);
					tagName();
					}
					break;
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HTML_EQUALS) {
					{
					setState(273);
					match(HTML_EQUALS);
					setState(274);
					attrValue();
					}
				}

				}
				break;
			case JINJA2_OPEN_EXPR:
			case JINJA2_OPEN_EXPR_IN_TAG:
			case JINJA2_OPEN_EXPR_IN_ATTR:
			case JINJA2_OPEN_EXPR_IN_ATTR_S:
			case JINJA2_OPEN_EXPR_IN_CSS:
				_localctx = new DynamicAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				jinjaExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueContext extends ParserRuleContext {
		public AttrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValue; }
	 
		public AttrValueContext() { }
		public void copyFrom(AttrValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnquotedValueContext extends AttrValueContext {
		public TerminalNode HTML_ATTRIBUTE_VALUE_UNQUOTED() { return getToken(jinjaParser.HTML_ATTRIBUTE_VALUE_UNQUOTED, 0); }
		public UnquotedValueContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterUnquotedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitUnquotedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitUnquotedValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleQuotedValueContext extends AttrValueContext {
		public TerminalNode HTML_ATTR_VALUE_START_DOUBLE() { return getToken(jinjaParser.HTML_ATTR_VALUE_START_DOUBLE, 0); }
		public TerminalNode ATTR_VALUE_END_DOUBLE() { return getToken(jinjaParser.ATTR_VALUE_END_DOUBLE, 0); }
		public List<TerminalNode> ATTR_VALUE_TEXT_DOUBLE() { return getTokens(jinjaParser.ATTR_VALUE_TEXT_DOUBLE); }
		public TerminalNode ATTR_VALUE_TEXT_DOUBLE(int i) {
			return getToken(jinjaParser.ATTR_VALUE_TEXT_DOUBLE, i);
		}
		public List<JinjaExpressionContext> jinjaExpression() {
			return getRuleContexts(JinjaExpressionContext.class);
		}
		public JinjaExpressionContext jinjaExpression(int i) {
			return getRuleContext(JinjaExpressionContext.class,i);
		}
		public DoubleQuotedValueContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterDoubleQuotedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitDoubleQuotedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitDoubleQuotedValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleQuotedValueContext extends AttrValueContext {
		public TerminalNode HTML_ATTR_VALUE_START_SINGLE() { return getToken(jinjaParser.HTML_ATTR_VALUE_START_SINGLE, 0); }
		public TerminalNode ATTR_VALUE_END_SINGLE() { return getToken(jinjaParser.ATTR_VALUE_END_SINGLE, 0); }
		public List<TerminalNode> ATTR_VALUE_TEXT_SINGLE() { return getTokens(jinjaParser.ATTR_VALUE_TEXT_SINGLE); }
		public TerminalNode ATTR_VALUE_TEXT_SINGLE(int i) {
			return getToken(jinjaParser.ATTR_VALUE_TEXT_SINGLE, i);
		}
		public List<JinjaExpressionContext> jinjaExpression() {
			return getRuleContexts(JinjaExpressionContext.class);
		}
		public JinjaExpressionContext jinjaExpression(int i) {
			return getRuleContext(JinjaExpressionContext.class,i);
		}
		public SingleQuotedValueContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterSingleQuotedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitSingleQuotedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitSingleQuotedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValueContext attrValue() throws RecognitionException {
		AttrValueContext _localctx = new AttrValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_attrValue);
		int _la;
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_ATTR_VALUE_START_DOUBLE:
				_localctx = new DoubleQuotedValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(HTML_ATTR_VALUE_START_DOUBLE);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 72149970194530305L) != 0)) {
					{
					setState(283);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ATTR_VALUE_TEXT_DOUBLE:
						{
						setState(281);
						match(ATTR_VALUE_TEXT_DOUBLE);
						}
						break;
					case JINJA2_OPEN_EXPR:
					case JINJA2_OPEN_EXPR_IN_TAG:
					case JINJA2_OPEN_EXPR_IN_ATTR:
					case JINJA2_OPEN_EXPR_IN_ATTR_S:
					case JINJA2_OPEN_EXPR_IN_CSS:
						{
						setState(282);
						jinjaExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(288);
				match(ATTR_VALUE_END_DOUBLE);
				}
				break;
			case HTML_ATTR_VALUE_START_SINGLE:
				_localctx = new SingleQuotedValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(HTML_ATTR_VALUE_START_SINGLE);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 72413852985196545L) != 0)) {
					{
					setState(292);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ATTR_VALUE_TEXT_SINGLE:
						{
						setState(290);
						match(ATTR_VALUE_TEXT_SINGLE);
						}
						break;
					case JINJA2_OPEN_EXPR:
					case JINJA2_OPEN_EXPR_IN_TAG:
					case JINJA2_OPEN_EXPR_IN_ATTR:
					case JINJA2_OPEN_EXPR_IN_ATTR_S:
					case JINJA2_OPEN_EXPR_IN_CSS:
						{
						setState(291);
						jinjaExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(297);
				match(ATTR_VALUE_END_SINGLE);
				}
				break;
			case HTML_ATTRIBUTE_VALUE_UNQUOTED:
				_localctx = new UnquotedValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(HTML_ATTRIBUTE_VALUE_UNQUOTED);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StyleBlockContext extends ParserRuleContext {
		public StyleBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleBlock; }
	 
		public StyleBlockContext() { }
		public void copyFrom(StyleBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StyleBlockWrapperContext extends StyleBlockContext {
		public TerminalNode STYLE_TAG_START() { return getToken(jinjaParser.STYLE_TAG_START, 0); }
		public TerminalNode CSS_STYLE_END() { return getToken(jinjaParser.CSS_STYLE_END, 0); }
		public List<CssContentContext> cssContent() {
			return getRuleContexts(CssContentContext.class);
		}
		public CssContentContext cssContent(int i) {
			return getRuleContext(CssContentContext.class,i);
		}
		public StyleBlockWrapperContext(StyleBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterStyleBlockWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitStyleBlockWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitStyleBlockWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleBlockContext styleBlock() throws RecognitionException {
		StyleBlockContext _localctx = new StyleBlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_styleBlock);
		int _la;
		try {
			_localctx = new StyleBlockWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(STYLE_TAG_START);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1172074997162705664L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 6115L) != 0)) {
				{
				{
				setState(302);
				cssContent();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			match(CSS_STYLE_END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssContentContext extends ParserRuleContext {
		public CssContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssContent; }
	 
		public CssContentContext() { }
		public void copyFrom(CssContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSemicolonContext extends CssContentContext {
		public TerminalNode CSS_SEMICOLON() { return getToken(jinjaParser.CSS_SEMICOLON, 0); }
		public CssSemicolonContext(CssContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssSemicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssSemicolon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssSemicolon(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContentContext extends CssContentContext {
		public CssRuleContext cssRule() {
			return getRuleContext(CssRuleContext.class,0);
		}
		public CssRuleContentContext(CssContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssRuleContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssRuleContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssRuleContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssJinjaStatementContentContext extends CssContentContext {
		public JinjaStatementContext jinjaStatement() {
			return getRuleContext(JinjaStatementContext.class,0);
		}
		public CssJinjaStatementContentContext(CssContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssJinjaStatementContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssJinjaStatementContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssJinjaStatementContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssJinjaExpressionContentContext extends CssContentContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public CssJinjaExpressionContentContext(CssContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssJinjaExpressionContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssJinjaExpressionContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssJinjaExpressionContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssContentContext cssContent() throws RecognitionException {
		CssContentContext _localctx = new CssContentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cssContent);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_UNIVERSAL:
			case CSS_CLASS_SELECTOR:
			case CSS_ID_SELECTOR:
			case CSS_PSEUDO_ELEMENT:
			case CSS_PSEUDO_CLASS:
			case CSS_PROPERTY:
			case CSS_TYPE_SELECTOR:
				_localctx = new CssRuleContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				cssRule();
				}
				break;
			case JINJA2_OPEN_STMT:
			case JINJA2_OPEN_STMT_IN_TAG:
			case JINJA2_OPEN_STMT_IN_CSS:
				_localctx = new CssJinjaStatementContentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				jinjaStatement();
				}
				break;
			case JINJA2_OPEN_EXPR:
			case JINJA2_OPEN_EXPR_IN_TAG:
			case JINJA2_OPEN_EXPR_IN_ATTR:
			case JINJA2_OPEN_EXPR_IN_ATTR_S:
			case JINJA2_OPEN_EXPR_IN_CSS:
				_localctx = new CssJinjaExpressionContentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(312);
				jinjaExpression();
				}
				break;
			case CSS_SEMICOLON:
				_localctx = new CssSemicolonContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				match(CSS_SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
	 
		public CssRuleContext() { }
		public void copyFrom(CssRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StandardCssRuleContext extends CssRuleContext {
		public CssSelectorListContext cssSelectorList() {
			return getRuleContext(CssSelectorListContext.class,0);
		}
		public TerminalNode CSS_BRACE_OPEN() { return getToken(jinjaParser.CSS_BRACE_OPEN, 0); }
		public CssDeclarationListContext cssDeclarationList() {
			return getRuleContext(CssDeclarationListContext.class,0);
		}
		public TerminalNode CSS_BRACE_CLOSE() { return getToken(jinjaParser.CSS_BRACE_CLOSE, 0); }
		public StandardCssRuleContext(CssRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterStandardCssRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitStandardCssRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitStandardCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cssRule);
		try {
			_localctx = new StandardCssRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			cssSelectorList();
			setState(317);
			match(CSS_BRACE_OPEN);
			setState(318);
			cssDeclarationList();
			setState(319);
			match(CSS_BRACE_CLOSE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorListContext extends ParserRuleContext {
		public CssSelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelectorList; }
	 
		public CssSelectorListContext() { }
		public void copyFrom(CssSelectorListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorListRuleContext extends CssSelectorListContext {
		public List<CssSelectorContext> cssSelector() {
			return getRuleContexts(CssSelectorContext.class);
		}
		public CssSelectorContext cssSelector(int i) {
			return getRuleContext(CssSelectorContext.class,i);
		}
		public List<TerminalNode> CSS_COMMA() { return getTokens(jinjaParser.CSS_COMMA); }
		public TerminalNode CSS_COMMA(int i) {
			return getToken(jinjaParser.CSS_COMMA, i);
		}
		public CssSelectorListRuleContext(CssSelectorListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssSelectorListRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssSelectorListRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssSelectorListRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorListContext cssSelectorList() throws RecognitionException {
		CssSelectorListContext _localctx = new CssSelectorListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cssSelectorList);
		int _la;
		try {
			_localctx = new CssSelectorListRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			cssSelector();
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_COMMA) {
				{
				{
				setState(322);
				match(CSS_COMMA);
				setState(323);
				cssSelector();
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
	 
		public CssSelectorContext() { }
		public void copyFrom(CssSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorWrapperContext extends CssSelectorContext {
		public List<TerminalNode> CSS_TYPE_SELECTOR() { return getTokens(jinjaParser.CSS_TYPE_SELECTOR); }
		public TerminalNode CSS_TYPE_SELECTOR(int i) {
			return getToken(jinjaParser.CSS_TYPE_SELECTOR, i);
		}
		public List<TerminalNode> CSS_CLASS_SELECTOR() { return getTokens(jinjaParser.CSS_CLASS_SELECTOR); }
		public TerminalNode CSS_CLASS_SELECTOR(int i) {
			return getToken(jinjaParser.CSS_CLASS_SELECTOR, i);
		}
		public List<TerminalNode> CSS_ID_SELECTOR() { return getTokens(jinjaParser.CSS_ID_SELECTOR); }
		public TerminalNode CSS_ID_SELECTOR(int i) {
			return getToken(jinjaParser.CSS_ID_SELECTOR, i);
		}
		public List<TerminalNode> CSS_UNIVERSAL() { return getTokens(jinjaParser.CSS_UNIVERSAL); }
		public TerminalNode CSS_UNIVERSAL(int i) {
			return getToken(jinjaParser.CSS_UNIVERSAL, i);
		}
		public List<TerminalNode> CSS_PSEUDO_CLASS() { return getTokens(jinjaParser.CSS_PSEUDO_CLASS); }
		public TerminalNode CSS_PSEUDO_CLASS(int i) {
			return getToken(jinjaParser.CSS_PSEUDO_CLASS, i);
		}
		public List<TerminalNode> CSS_PSEUDO_ELEMENT() { return getTokens(jinjaParser.CSS_PSEUDO_ELEMENT); }
		public TerminalNode CSS_PSEUDO_ELEMENT(int i) {
			return getToken(jinjaParser.CSS_PSEUDO_ELEMENT, i);
		}
		public List<TerminalNode> CSS_PROPERTY() { return getTokens(jinjaParser.CSS_PROPERTY); }
		public TerminalNode CSS_PROPERTY(int i) {
			return getToken(jinjaParser.CSS_PROPERTY, i);
		}
		public List<TerminalNode> CSS_COMBINATOR() { return getTokens(jinjaParser.CSS_COMBINATOR); }
		public TerminalNode CSS_COMBINATOR(int i) {
			return getToken(jinjaParser.CSS_COMBINATOR, i);
		}
		public CssSelectorWrapperContext(CssSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssSelectorWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssSelectorWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssSelectorWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cssSelector);
		int _la;
		try {
			_localctx = new CssSelectorWrapperContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 191L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 447L) != 0)) {
				{
				{
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CSS_COMBINATOR) {
					{
					setState(330);
					match(CSS_COMBINATOR);
					}
				}

				setState(333);
				_la = _input.LA(1);
				if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 191L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationListContext extends ParserRuleContext {
		public CssDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclarationList; }
	 
		public CssDeclarationListContext() { }
		public void copyFrom(CssDeclarationListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationListRuleContext extends CssDeclarationListContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<JinjaStatementContext> jinjaStatement() {
			return getRuleContexts(JinjaStatementContext.class);
		}
		public JinjaStatementContext jinjaStatement(int i) {
			return getRuleContext(JinjaStatementContext.class,i);
		}
		public List<JinjaExpressionContext> jinjaExpression() {
			return getRuleContexts(JinjaExpressionContext.class);
		}
		public JinjaExpressionContext jinjaExpression(int i) {
			return getRuleContext(JinjaExpressionContext.class,i);
		}
		public List<TerminalNode> CSS_SEMICOLON() { return getTokens(jinjaParser.CSS_SEMICOLON); }
		public TerminalNode CSS_SEMICOLON(int i) {
			return getToken(jinjaParser.CSS_SEMICOLON, i);
		}
		public List<TerminalNode> JINJA_STMT_WS() { return getTokens(jinjaParser.JINJA_STMT_WS); }
		public TerminalNode JINJA_STMT_WS(int i) {
			return getToken(jinjaParser.JINJA_STMT_WS, i);
		}
		public CssDeclarationListRuleContext(CssDeclarationListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssDeclarationListRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssDeclarationListRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssDeclarationListRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationListContext cssDeclarationList() throws RecognitionException {
		CssDeclarationListContext _localctx = new CssDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cssDeclarationList);
		int _la;
		try {
			_localctx = new CssDeclarationListRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1172145365906883328L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4294972419L) != 0)) {
				{
				setState(344);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HTML_ATTRIBUTE_NAME:
				case CSS_PROPERTY:
				case CSS_TYPE_SELECTOR:
					{
					setState(339);
					declaration();
					}
					break;
				case JINJA2_OPEN_STMT:
				case JINJA2_OPEN_STMT_IN_TAG:
				case JINJA2_OPEN_STMT_IN_CSS:
					{
					setState(340);
					jinjaStatement();
					}
					break;
				case JINJA2_OPEN_EXPR:
				case JINJA2_OPEN_EXPR_IN_TAG:
				case JINJA2_OPEN_EXPR_IN_ATTR:
				case JINJA2_OPEN_EXPR_IN_ATTR_S:
				case JINJA2_OPEN_EXPR_IN_CSS:
					{
					setState(341);
					jinjaExpression();
					}
					break;
				case CSS_SEMICOLON:
					{
					setState(342);
					match(CSS_SEMICOLON);
					}
					break;
				case JINJA_STMT_WS:
					{
					setState(343);
					match(JINJA_STMT_WS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends DeclarationContext {
		public CssValueListContext cssValueList() {
			return getRuleContext(CssValueListContext.class,0);
		}
		public TerminalNode CSS_SEMICOLON() { return getToken(jinjaParser.CSS_SEMICOLON, 0); }
		public TerminalNode CSS_PROPERTY() { return getToken(jinjaParser.CSS_PROPERTY, 0); }
		public TerminalNode CSS_TYPE_SELECTOR() { return getToken(jinjaParser.CSS_TYPE_SELECTOR, 0); }
		public TerminalNode HTML_ATTRIBUTE_NAME() { return getToken(jinjaParser.HTML_ATTRIBUTE_NAME, 0); }
		public TerminalNode CSS_COLON() { return getToken(jinjaParser.CSS_COLON, 0); }
		public CssDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_declaration);
		int _la;
		try {
			_localctx = new CssDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & 1342177281L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_COLON:
				{
				setState(350);
				match(CSS_COLON);
				}
				break;
			case JINJA2_OPEN_EXPR:
			case JINJA2_OPEN_EXPR_IN_TAG:
			case JINJA2_OPEN_EXPR_IN_ATTR:
			case JINJA2_OPEN_EXPR_IN_ATTR_S:
			case JINJA2_OPEN_EXPR_IN_CSS:
			case CSS_ID_SELECTOR:
			case CSS_PSEUDO_CLASS:
			case CSS_PROPERTY:
			case CSS_VALUE:
			case CSS_TYPE_SELECTOR:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(354);
			cssValueList();
			setState(355);
			match(CSS_SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
	 
		public CssValueContext() { }
		public void copyFrom(CssValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueLiteralContext extends CssValueContext {
		public TerminalNode CSS_VALUE() { return getToken(jinjaParser.CSS_VALUE, 0); }
		public CssValueLiteralContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueTypeSelectorContext extends CssValueContext {
		public TerminalNode CSS_TYPE_SELECTOR() { return getToken(jinjaParser.CSS_TYPE_SELECTOR, 0); }
		public CssValueTypeSelectorContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValueTypeSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValueTypeSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValueTypeSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueJinjaExpressionContext extends CssValueContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public CssValueJinjaExpressionContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValueJinjaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValueJinjaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValueJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValuePropertyContext extends CssValueContext {
		public TerminalNode CSS_PROPERTY() { return getToken(jinjaParser.CSS_PROPERTY, 0); }
		public CssValuePropertyContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValueProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValueProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValueProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueIdSelectorContext extends CssValueContext {
		public TerminalNode CSS_ID_SELECTOR() { return getToken(jinjaParser.CSS_ID_SELECTOR, 0); }
		public CssValueIdSelectorContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValueIdSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValueIdSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValueIdSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValuePseudoClassContext extends CssValueContext {
		public TerminalNode CSS_PSEUDO_CLASS() { return getToken(jinjaParser.CSS_PSEUDO_CLASS, 0); }
		public CssValuePseudoClassContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValuePseudoClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValuePseudoClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValuePseudoClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cssValue);
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_VALUE:
				_localctx = new CssValueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				match(CSS_VALUE);
				}
				break;
			case CSS_PROPERTY:
				_localctx = new CssValuePropertyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				match(CSS_PROPERTY);
				}
				break;
			case CSS_TYPE_SELECTOR:
				_localctx = new CssValueTypeSelectorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				match(CSS_TYPE_SELECTOR);
				}
				break;
			case CSS_ID_SELECTOR:
				_localctx = new CssValueIdSelectorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(360);
				match(CSS_ID_SELECTOR);
				}
				break;
			case CSS_PSEUDO_CLASS:
				_localctx = new CssValuePseudoClassContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(361);
				match(CSS_PSEUDO_CLASS);
				}
				break;
			case JINJA2_OPEN_EXPR:
			case JINJA2_OPEN_EXPR_IN_TAG:
			case JINJA2_OPEN_EXPR_IN_ATTR:
			case JINJA2_OPEN_EXPR_IN_ATTR_S:
			case JINJA2_OPEN_EXPR_IN_CSS:
				_localctx = new CssValueJinjaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(362);
				jinjaExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueListContext extends ParserRuleContext {
		public CssValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueList; }
	 
		public CssValueListContext() { }
		public void copyFrom(CssValueListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueListRuleContext extends CssValueListContext {
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public List<TerminalNode> CSS_COMMA() { return getTokens(jinjaParser.CSS_COMMA); }
		public TerminalNode CSS_COMMA(int i) {
			return getToken(jinjaParser.CSS_COMMA, i);
		}
		public CssValueListRuleContext(CssValueListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).enterCssValueListRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jinjaParserListener ) ((jinjaParserListener)listener).exitCssValueListRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jinjaParserVisitor ) return ((jinjaParserVisitor<? extends T>)visitor).visitCssValueListRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueListContext cssValueList() throws RecognitionException {
		CssValueListContext _localctx = new CssValueListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cssValueList);
		int _la;
		try {
			_localctx = new CssValueListRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			cssValue();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9204227340391939840L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7809L) != 0)) {
				{
				{
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CSS_COMMA) {
					{
					setState(366);
					match(CSS_COMMA);
					}
				}

				setState(369);
				cssValue();
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001h\u0178\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0005\u0000=\b\u0000"+
		"\n\u0000\f\u0000@\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001I\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004b\b\u0004"+
		"\n\u0004\f\u0004e\t\u0004\u0003\u0004g\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004n\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"|\b\u0004\n\u0004\f\u0004\u007f\t\u0004\u0003\u0004\u0081\b\u0004\u0001"+
		"\u0004\u0003\u0004\u0084\b\u0004\u0005\u0004\u0086\b\u0004\n\u0004\f\u0004"+
		"\u0089\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0090\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0098\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u00b8\b\r\n\r\f\r\u00bb"+
		"\t\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00c3\b\u000e\n\u000e\f\u000e\u00c6\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00cd\b\u000e\n\u000e"+
		"\f\u000e\u00d0\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00d5\b\u000e\n\u000e\f\u000e\u00d8\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00e1"+
		"\b\u000e\n\u000e\f\u000e\u00e4\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00e8\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00f0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u0107\b\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u010b\b"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0110\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0114\b\u0012\u0001\u0012\u0003\u0012\u0117"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u011c\b\u0013"+
		"\n\u0013\f\u0013\u011f\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u0125\b\u0013\n\u0013\f\u0013\u0128\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u012c\b\u0013\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0130\b\u0014\n\u0014\f\u0014\u0133\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u013b\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u0145\b\u0017\n\u0017\f\u0017\u0148\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u014c\b\u0018\u0001\u0018\u0005\u0018"+
		"\u014f\b\u0018\n\u0018\f\u0018\u0152\t\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0159\b\u0019\n\u0019\f\u0019"+
		"\u015c\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0161\b"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u016c\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0170\b\u001c\u0001\u001c\u0005\u001c\u0173"+
		"\b\u001c\n\u001c\f\u001c\u0176\t\u001c\u0001\u001c\u0000\u0001\b\u001d"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468\u0000\u0005\u0005\u0000\b\b**2266@@\u0003\u0000"+
		"\t\t++AA\u0001\u0000,-\u0002\u0000EJLL\u0003\u0000..JJLL\u01b5\u0000>"+
		"\u0001\u0000\u0000\u0000\u0002H\u0001\u0000\u0000\u0000\u0004J\u0001\u0000"+
		"\u0000\u0000\u0006L\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000"+
		"\n\u008f\u0001\u0000\u0000\u0000\f\u0097\u0001\u0000\u0000\u0000\u000e"+
		"\u0099\u0001\u0000\u0000\u0000\u0010\u009e\u0001\u0000\u0000\u0000\u0012"+
		"\u00a3\u0001\u0000\u0000\u0000\u0014\u00a7\u0001\u0000\u0000\u0000\u0016"+
		"\u00ab\u0001\u0000\u0000\u0000\u0018\u00b0\u0001\u0000\u0000\u0000\u001a"+
		"\u00b4\u0001\u0000\u0000\u0000\u001c\u00e7\u0001\u0000\u0000\u0000\u001e"+
		"\u00ef\u0001\u0000\u0000\u0000 \u0106\u0001\u0000\u0000\u0000\"\u010a"+
		"\u0001\u0000\u0000\u0000$\u0116\u0001\u0000\u0000\u0000&\u012b\u0001\u0000"+
		"\u0000\u0000(\u012d\u0001\u0000\u0000\u0000*\u013a\u0001\u0000\u0000\u0000"+
		",\u013c\u0001\u0000\u0000\u0000.\u0141\u0001\u0000\u0000\u00000\u0149"+
		"\u0001\u0000\u0000\u00002\u015a\u0001\u0000\u0000\u00004\u015d\u0001\u0000"+
		"\u0000\u00006\u016b\u0001\u0000\u0000\u00008\u016d\u0001\u0000\u0000\u0000"+
		":=\u0003\u0002\u0001\u0000;=\u0005`\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000AB\u0005\u0000\u0000\u0001B\u0001\u0001\u0000\u0000\u0000"+
		"CI\u0003\u001c\u000e\u0000DI\u0003\f\u0006\u0000EI\u0003\u0006\u0003\u0000"+
		"FI\u0003(\u0014\u0000GI\u0003\u0004\u0002\u0000HC\u0001\u0000\u0000\u0000"+
		"HD\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000I\u0003\u0001\u0000\u0000\u0000JK\u0005"+
		"\u0006\u0000\u0000K\u0005\u0001\u0000\u0000\u0000LM\u0007\u0000\u0000"+
		"\u0000MN\u0003\b\u0004\u0000NO\u0005N\u0000\u0000O\u0007\u0001\u0000\u0000"+
		"\u0000PQ\u0006\u0004\uffff\uffff\u0000QR\u0003\n\u0005\u0000R\u0087\u0001"+
		"\u0000\u0000\u0000ST\n\u0002\u0000\u0000TU\u0005[\u0000\u0000U\u0086\u0003"+
		"\b\u0004\u0003VW\n\u0001\u0000\u0000WX\u0005P\u0000\u0000XY\u0003\b\u0004"+
		"\u0000YZ\u0005P\u0000\u0000Z[\u0003\b\u0004\u0002[\u0086\u0001\u0000\u0000"+
		"\u0000\\]\n\u0006\u0000\u0000]f\u0005V\u0000\u0000^c\u0003\b\u0004\u0000"+
		"_`\u0005T\u0000\u0000`b\u0003\b\u0004\u0000a_\u0001\u0000\u0000\u0000"+
		"be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000f^\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0086"+
		"\u0005W\u0000\u0000ij\n\u0005\u0000\u0000jm\u0005Q\u0000\u0000kn\u0003"+
		"\n\u0005\u0000ln\u0005P\u0000\u0000mk\u0001\u0000\u0000\u0000ml\u0001"+
		"\u0000\u0000\u0000n\u0086\u0001\u0000\u0000\u0000op\n\u0004\u0000\u0000"+
		"pq\u0005X\u0000\u0000qr\u0003\b\u0004\u0000rs\u0005Y\u0000\u0000s\u0086"+
		"\u0001\u0000\u0000\u0000tu\n\u0003\u0000\u0000uv\u0005Z\u0000\u0000v\u0083"+
		"\u0005P\u0000\u0000w\u0080\u0005V\u0000\u0000x}\u0003\b\u0004\u0000yz"+
		"\u0005T\u0000\u0000z|\u0003\b\u0004\u0000{y\u0001\u0000\u0000\u0000|\u007f"+
		"\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"x\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0005W\u0000\u0000\u0083w\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000"+
		"\u0000\u0000\u0085S\u0001\u0000\u0000\u0000\u0085V\u0001\u0000\u0000\u0000"+
		"\u0085\\\u0001\u0000\u0000\u0000\u0085i\u0001\u0000\u0000\u0000\u0085"+
		"o\u0001\u0000\u0000\u0000\u0085t\u0001\u0000\u0000\u0000\u0086\u0089\u0001"+
		"\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\t\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u008a\u0090\u0005P\u0000\u0000\u008b\u0090\u0005R\u0000\u0000"+
		"\u008c\u0090\u0005S\u0000\u0000\u008d\u0090\u0005c\u0000\u0000\u008e\u0090"+
		"\u0005e\u0000\u0000\u008f\u008a\u0001\u0000\u0000\u0000\u008f\u008b\u0001"+
		"\u0000\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u000b\u0001"+
		"\u0000\u0000\u0000\u0091\u0098\u0003\u000e\u0007\u0000\u0092\u0098\u0003"+
		"\u0016\u000b\u0000\u0093\u0098\u0003\u0010\b\u0000\u0094\u0098\u0003\u0012"+
		"\t\u0000\u0095\u0098\u0003\u0014\n\u0000\u0096\u0098\u0003\u0018\f\u0000"+
		"\u0097\u0091\u0001\u0000\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000"+
		"\u0097\u0093\u0001\u0000\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000"+
		"\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\r\u0001\u0000\u0000\u0000\u0099\u009a\u0007\u0001\u0000\u0000\u009a"+
		"\u009b\u0005c\u0000\u0000\u009b\u009c\u0003\b\u0004\u0000\u009c\u009d"+
		"\u0005_\u0000\u0000\u009d\u000f\u0001\u0000\u0000\u0000\u009e\u009f\u0007"+
		"\u0001\u0000\u0000\u009f\u00a0\u0005f\u0000\u0000\u00a0\u00a1\u0003\b"+
		"\u0004\u0000\u00a1\u00a2\u0005_\u0000\u0000\u00a2\u0011\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0007\u0001\u0000\u0000\u00a4\u00a5\u0005e\u0000\u0000"+
		"\u00a5\u00a6\u0005_\u0000\u0000\u00a6\u0013\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0007\u0001\u0000\u0000\u00a8\u00a9\u0005d\u0000\u0000\u00a9\u00aa"+
		"\u0005_\u0000\u0000\u00aa\u0015\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007"+
		"\u0001\u0000\u0000\u00ac\u00ad\u0005a\u0000\u0000\u00ad\u00ae\u0003\u001a"+
		"\r\u0000\u00ae\u00af\u0005_\u0000\u0000\u00af\u0017\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0007\u0001\u0000\u0000\u00b1\u00b2\u0005b\u0000\u0000"+
		"\u00b2\u00b3\u0005_\u0000\u0000\u00b3\u0019\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b9\u0003\b\u0004\u0000\u00b5\u00b6\u0005T\u0000\u0000\u00b6\u00b8"+
		"\u0003\b\u0004\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0005g\u0000\u0000\u00bd\u00be\u0003\b"+
		"\u0004\u0000\u00be\u001b\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0003"+
		"\u0000\u0000\u00c0\u00c4\u0003\u001e\u000f\u0000\u00c1\u00c3\u0003$\u0012"+
		"\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0007\u0002\u0000\u0000\u00c8\u00e8\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0005\u0003\u0000\u0000\u00ca\u00ce\u0003 \u0010\u0000"+
		"\u00cb\u00cd\u0003$\u0012\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd"+
		"\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d6\u0005-\u0000\u0000\u00d2\u00d5"+
		"\u0003\u0002\u0001\u0000\u00d3\u00d5\u0005`\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0005\u0004\u0000\u0000\u00da\u00db\u0003"+
		"\"\u0011\u0000\u00db\u00dc\u00051\u0000\u0000\u00dc\u00e8\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0005\u0003\u0000\u0000\u00de\u00e2\u0003 \u0010"+
		"\u0000\u00df\u00e1\u0003$\u0012\u0000\u00e0\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005,\u0000\u0000\u00e6"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e7\u00bf\u0001\u0000\u0000\u0000\u00e7"+
		"\u00c9\u0001\u0000\u0000\u0000\u00e7\u00dd\u0001\u0000\u0000\u0000\u00e8"+
		"\u001d\u0001\u0000\u0000\u0000\u00e9\u00f0\u0005\u001e\u0000\u0000\u00ea"+
		"\u00f0\u0005\u001f\u0000\u0000\u00eb\u00f0\u0005 \u0000\u0000\u00ec\u00f0"+
		"\u0005!\u0000\u0000\u00ed\u00f0\u0005\"\u0000\u0000\u00ee\u00f0\u0005"+
		"#\u0000\u0000\u00ef\u00e9\u0001\u0000\u0000\u0000\u00ef\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ef\u00eb\u0001\u0000\u0000\u0000\u00ef\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f0\u001f\u0001\u0000\u0000\u0000\u00f1\u0107\u0005\n\u0000"+
		"\u0000\u00f2\u0107\u0005\u000b\u0000\u0000\u00f3\u0107\u0005\f\u0000\u0000"+
		"\u00f4\u0107\u0005\r\u0000\u0000\u00f5\u0107\u0005\u000e\u0000\u0000\u00f6"+
		"\u0107\u0005\u000f\u0000\u0000\u00f7\u0107\u0005\u0010\u0000\u0000\u00f8"+
		"\u0107\u0005\u0011\u0000\u0000\u00f9\u0107\u0005\u0012\u0000\u0000\u00fa"+
		"\u0107\u0005\u0013\u0000\u0000\u00fb\u0107\u0005\u0014\u0000\u0000\u00fc"+
		"\u0107\u0005\u0015\u0000\u0000\u00fd\u0107\u0005\u0016\u0000\u0000\u00fe"+
		"\u0107\u0005\u0017\u0000\u0000\u00ff\u0107\u0005\u0018\u0000\u0000\u0100"+
		"\u0107\u0005\u0019\u0000\u0000\u0101\u0107\u0005\u001a\u0000\u0000\u0102"+
		"\u0107\u0005\u001b\u0000\u0000\u0103\u0107\u0005\u001c\u0000\u0000\u0104"+
		"\u0107\u0005\u001d\u0000\u0000\u0105\u0107\u0005$\u0000\u0000\u0106\u00f1"+
		"\u0001\u0000\u0000\u0000\u0106\u00f2\u0001\u0000\u0000\u0000\u0106\u00f3"+
		"\u0001\u0000\u0000\u0000\u0106\u00f4\u0001\u0000\u0000\u0000\u0106\u00f5"+
		"\u0001\u0000\u0000\u0000\u0106\u00f6\u0001\u0000\u0000\u0000\u0106\u00f7"+
		"\u0001\u0000\u0000\u0000\u0106\u00f8\u0001\u0000\u0000\u0000\u0106\u00f9"+
		"\u0001\u0000\u0000\u0000\u0106\u00fa\u0001\u0000\u0000\u0000\u0106\u00fb"+
		"\u0001\u0000\u0000\u0000\u0106\u00fc\u0001\u0000\u0000\u0000\u0106\u00fd"+
		"\u0001\u0000\u0000\u0000\u0106\u00fe\u0001\u0000\u0000\u0000\u0106\u00ff"+
		"\u0001\u0000\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000\u0106\u0101"+
		"\u0001\u0000\u0000\u0000\u0106\u0102\u0001\u0000\u0000\u0000\u0106\u0103"+
		"\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0105"+
		"\u0001\u0000\u0000\u0000\u0107!\u0001\u0000\u0000\u0000\u0108\u010b\u0005"+
		"/\u0000\u0000\u0109\u010b\u0003 \u0010\u0000\u010a\u0108\u0001\u0000\u0000"+
		"\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b#\u0001\u0000\u0000\u0000"+
		"\u010c\u0110\u0005.\u0000\u0000\u010d\u0110\u0005$\u0000\u0000\u010e\u0110"+
		"\u0003 \u0010\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u010f\u010d\u0001"+
		"\u0000\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u0110\u0113\u0001"+
		"\u0000\u0000\u0000\u0111\u0112\u0005&\u0000\u0000\u0112\u0114\u0003&\u0013"+
		"\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000"+
		"\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0117\u0003\u0006\u0003"+
		"\u0000\u0116\u010f\u0001\u0000\u0000\u0000\u0116\u0115\u0001\u0000\u0000"+
		"\u0000\u0117%\u0001\u0000\u0000\u0000\u0118\u011d\u0005\'\u0000\u0000"+
		"\u0119\u011c\u00054\u0000\u0000\u011a\u011c\u0003\u0006\u0003\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c"+
		"\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0001\u0000\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f"+
		"\u011d\u0001\u0000\u0000\u0000\u0120\u012c\u00055\u0000\u0000\u0121\u0126"+
		"\u0005(\u0000\u0000\u0122\u0125\u00058\u0000\u0000\u0123\u0125\u0003\u0006"+
		"\u0003\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0123\u0001\u0000"+
		"\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0129\u0001\u0000"+
		"\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012c\u00059\u0000"+
		"\u0000\u012a\u012c\u0005)\u0000\u0000\u012b\u0118\u0001\u0000\u0000\u0000"+
		"\u012b\u0121\u0001\u0000\u0000\u0000\u012b\u012a\u0001\u0000\u0000\u0000"+
		"\u012c\'\u0001\u0000\u0000\u0000\u012d\u0131\u0005\u0001\u0000\u0000\u012e"+
		"\u0130\u0003*\u0015\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u0130\u0133"+
		"\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0132"+
		"\u0001\u0000\u0000\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u0131"+
		"\u0001\u0000\u0000\u0000\u0134\u0135\u0005:\u0000\u0000\u0135)\u0001\u0000"+
		"\u0000\u0000\u0136\u013b\u0003,\u0016\u0000\u0137\u013b\u0003\f\u0006"+
		"\u0000\u0138\u013b\u0003\u0006\u0003\u0000\u0139\u013b\u0005<\u0000\u0000"+
		"\u013a\u0136\u0001\u0000\u0000\u0000\u013a\u0137\u0001\u0000\u0000\u0000"+
		"\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u0139\u0001\u0000\u0000\u0000"+
		"\u013b+\u0001\u0000\u0000\u0000\u013c\u013d\u0003.\u0017\u0000\u013d\u013e"+
		"\u0005=\u0000\u0000\u013e\u013f\u00032\u0019\u0000\u013f\u0140\u0005>"+
		"\u0000\u0000\u0140-\u0001\u0000\u0000\u0000\u0141\u0146\u00030\u0018\u0000"+
		"\u0142\u0143\u0005?\u0000\u0000\u0143\u0145\u00030\u0018\u0000\u0144\u0142"+
		"\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144"+
		"\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147/\u0001"+
		"\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u0150\u0007"+
		"\u0003\u0000\u0000\u014a\u014c\u0005M\u0000\u0000\u014b\u014a\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000"+
		"\u0000\u0000\u014d\u014f\u0007\u0003\u0000\u0000\u014e\u014b\u0001\u0000"+
		"\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u01511\u0001\u0000\u0000"+
		"\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0159\u00034\u001a\u0000"+
		"\u0154\u0159\u0003\f\u0006\u0000\u0155\u0159\u0003\u0006\u0003\u0000\u0156"+
		"\u0159\u0005<\u0000\u0000\u0157\u0159\u0005`\u0000\u0000\u0158\u0153\u0001"+
		"\u0000\u0000\u0000\u0158\u0154\u0001\u0000\u0000\u0000\u0158\u0155\u0001"+
		"\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0157\u0001"+
		"\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b3\u0001\u0000"+
		"\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015d\u0160\u0007\u0004"+
		"\u0000\u0000\u015e\u0161\u0005;\u0000\u0000\u015f\u0161\u0001\u0000\u0000"+
		"\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u015f\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u00038\u001c\u0000"+
		"\u0163\u0164\u0005<\u0000\u0000\u01645\u0001\u0000\u0000\u0000\u0165\u016c"+
		"\u0005K\u0000\u0000\u0166\u016c\u0005J\u0000\u0000\u0167\u016c\u0005L"+
		"\u0000\u0000\u0168\u016c\u0005G\u0000\u0000\u0169\u016c\u0005I\u0000\u0000"+
		"\u016a\u016c\u0003\u0006\u0003\u0000\u016b\u0165\u0001\u0000\u0000\u0000"+
		"\u016b\u0166\u0001\u0000\u0000\u0000\u016b\u0167\u0001\u0000\u0000\u0000"+
		"\u016b\u0168\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016b\u016a\u0001\u0000\u0000\u0000\u016c7\u0001\u0000\u0000\u0000\u016d"+
		"\u0174\u00036\u001b\u0000\u016e\u0170\u0005?\u0000\u0000\u016f\u016e\u0001"+
		"\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0001"+
		"\u0000\u0000\u0000\u0171\u0173\u00036\u001b\u0000\u0172\u016f\u0001\u0000"+
		"\u0000\u0000\u0173\u0176\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000"+
		"\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u01759\u0001\u0000\u0000"+
		"\u0000\u0176\u0174\u0001\u0000\u0000\u0000*<>Hcfm}\u0080\u0083\u0085\u0087"+
		"\u008f\u0097\u00b9\u00c4\u00ce\u00d4\u00d6\u00e2\u00e7\u00ef\u0106\u010a"+
		"\u010f\u0113\u0116\u011b\u011d\u0124\u0126\u012b\u0131\u013a\u0146\u014b"+
		"\u0150\u0158\u015a\u0160\u016b\u016f\u0174";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}