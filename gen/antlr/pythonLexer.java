// Generated from E:/compiler_new/src/antlr/pythonLexer.g4 by ANTLR 4.13.2
package antlr;
 package antlr; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class pythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEF=1, IF=2, ELIF=3, ELSE=4, WHILE=5, FOR=6, IN=7, RETURN=8, PRINT=9, 
		FROM=10, IMPORT=11, WITH=12, AS=13, NONE=14, TRUE=15, FALSE=16, AND=17, 
		OR=18, NOT=19, EQUAL_CHECK=20, NOT_EQUAL=21, LESS_EQUAL=22, GREATER_EQUAL=23, 
		ASSIGN=24, PLUS=25, MINUS=26, MUL=27, DIV=28, LESS_THAN=29, GREATER_THAN=30, 
		COLON=31, COMMA=32, DOT=33, AT=34, OPEN_B=35, CLOSE_B=36, LBRACK=37, RBRACK=38, 
		LBRACE=39, RBRACE=40, FLOAT=41, NUMBER=42, STRING=43, VARIABLE=44, COMMENT=45, 
		NEWLINE=46, WS=47, INDENT=48, DEDENT=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DEF", "IF", "ELIF", "ELSE", "WHILE", "FOR", "IN", "RETURN", "PRINT", 
			"FROM", "IMPORT", "WITH", "AS", "NONE", "TRUE", "FALSE", "AND", "OR", 
			"NOT", "EQUAL_CHECK", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "ASSIGN", 
			"PLUS", "MINUS", "MUL", "DIV", "LESS_THAN", "GREATER_THAN", "COLON", 
			"COMMA", "DOT", "AT", "OPEN_B", "CLOSE_B", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "FLOAT", "NUMBER", "STRING", "VARIABLE", "COMMENT", "NEWLINE", 
			"WS", "INDENT", "DEDENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'if'", "'elif'", "'else'", "'while'", "'for'", "'in'", 
			"'return'", "'print'", "'from'", "'import'", "'with'", "'as'", "'None'", 
			"'True'", "'False'", "'and'", "'or'", "'not'", "'=='", "'!='", "'<='", 
			"'>='", "'='", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "':'", "','", 
			"'.'", "'@'", "'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, 
			null, null, null, null, "'INDENT'", "'DEDENT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DEF", "IF", "ELIF", "ELSE", "WHILE", "FOR", "IN", "RETURN", "PRINT", 
			"FROM", "IMPORT", "WITH", "AS", "NONE", "TRUE", "FALSE", "AND", "OR", 
			"NOT", "EQUAL_CHECK", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "ASSIGN", 
			"PLUS", "MINUS", "MUL", "DIV", "LESS_THAN", "GREATER_THAN", "COLON", 
			"COMMA", "DOT", "AT", "OPEN_B", "CLOSE_B", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "FLOAT", "NUMBER", "STRING", "VARIABLE", "COMMENT", "NEWLINE", 
			"WS", "INDENT", "DEDENT"
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


	    private java.util.Stack<Integer> indents = new java.util.Stack<>();
	    private java.util.Queue<Token> tokens = new java.util.LinkedList<>();
	    private int opened = 0;

	    @Override public void emit(Token token) {
	        super.setToken(token);
	        tokens.add(token);
	    }

	    @Override public Token nextToken() {
	        if (!tokens.isEmpty()) return tokens.poll();
	        Token next = super.nextToken();
	        if (next.getType() == NEWLINE) {
	            handleNewline();
	        } else if (next.getType() == EOF) {
	            while (!indents.isEmpty() && indents.peek() > 0) {
	                indents.pop();
	                emit(new CommonToken(DEDENT, "DEDENT"));
	            }
	            emit(next);
	        }
	        return tokens.isEmpty() ? next : tokens.poll();
	    }

	    private void handleNewline() {
	        if (opened > 0) return;
	        int spaces = 0;
	        while (_input.LA(spaces + 1) == ' ') { spaces++; }
	        int currentIndent = indents.isEmpty() ? 0 : indents.peek();
	        if (spaces > currentIndent) {
	            indents.push(spaces);
	            emit(new CommonToken(INDENT, "INDENT"));
	        } else if (spaces < currentIndent) {
	            while (!indents.isEmpty() && spaces < indents.peek()) {
	                indents.pop();
	                emit(new CommonToken(DEDENT, "DEDENT"));
	            }
	        }
	    }


	public pythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "pythonLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 34:
			OPEN_B_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			CLOSE_B_action((RuleContext)_localctx, actionIndex);
			break;
		case 36:
			LBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
			RBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			LBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			RBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void OPEN_B_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 opened++; 
			break;
		}
	}
	private void CLOSE_B_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 opened--; 
			break;
		}
	}
	private void LBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 opened++; 
			break;
		}
	}
	private void RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 opened--; 
			break;
		}
	}
	private void LBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 opened++; 
			break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 opened--; 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u00001\u0141\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001(\u0004"+
		"(\u00f3\b(\u000b(\f(\u00f4\u0001(\u0001(\u0004(\u00f9\b(\u000b(\f(\u00fa"+
		"\u0001)\u0004)\u00fe\b)\u000b)\f)\u00ff\u0001*\u0001*\u0001*\u0001*\u0005"+
		"*\u0106\b*\n*\f*\u0109\t*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u0110"+
		"\b*\n*\f*\u0113\t*\u0001*\u0003*\u0116\b*\u0001+\u0001+\u0005+\u011a\b"+
		"+\n+\f+\u011d\t+\u0001,\u0001,\u0005,\u0121\b,\n,\f,\u0124\t,\u0001,\u0001"+
		",\u0001-\u0003-\u0129\b-\u0001-\u0001-\u0001.\u0004.\u012e\b.\u000b.\f"+
		".\u012f\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u0000\u00001\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K"+
		"&M\'O(Q)S*U+W,Y-[.]/_0a1\u0001\u0000\u0006\u0001\u000009\u0002\u0000\""+
		"\"\\\\\u0002\u0000\'\'\\\\\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002"+
		"\u0000\n\n\r\r\u014c\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000"+
		"\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000"+
		"]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001"+
		"\u0000\u0000\u0000\u0001c\u0001\u0000\u0000\u0000\u0003g\u0001\u0000\u0000"+
		"\u0000\u0005j\u0001\u0000\u0000\u0000\u0007o\u0001\u0000\u0000\u0000\t"+
		"t\u0001\u0000\u0000\u0000\u000bz\u0001\u0000\u0000\u0000\r~\u0001\u0000"+
		"\u0000\u0000\u000f\u0081\u0001\u0000\u0000\u0000\u0011\u0088\u0001\u0000"+
		"\u0000\u0000\u0013\u008e\u0001\u0000\u0000\u0000\u0015\u0093\u0001\u0000"+
		"\u0000\u0000\u0017\u009a\u0001\u0000\u0000\u0000\u0019\u009f\u0001\u0000"+
		"\u0000\u0000\u001b\u00a2\u0001\u0000\u0000\u0000\u001d\u00a7\u0001\u0000"+
		"\u0000\u0000\u001f\u00ac\u0001\u0000\u0000\u0000!\u00b2\u0001\u0000\u0000"+
		"\u0000#\u00b6\u0001\u0000\u0000\u0000%\u00b9\u0001\u0000\u0000\u0000\'"+
		"\u00bd\u0001\u0000\u0000\u0000)\u00c0\u0001\u0000\u0000\u0000+\u00c3\u0001"+
		"\u0000\u0000\u0000-\u00c6\u0001\u0000\u0000\u0000/\u00c9\u0001\u0000\u0000"+
		"\u00001\u00cb\u0001\u0000\u0000\u00003\u00cd\u0001\u0000\u0000\u00005"+
		"\u00cf\u0001\u0000\u0000\u00007\u00d1\u0001\u0000\u0000\u00009\u00d3\u0001"+
		"\u0000\u0000\u0000;\u00d5\u0001\u0000\u0000\u0000=\u00d7\u0001\u0000\u0000"+
		"\u0000?\u00d9\u0001\u0000\u0000\u0000A\u00db\u0001\u0000\u0000\u0000C"+
		"\u00dd\u0001\u0000\u0000\u0000E\u00df\u0001\u0000\u0000\u0000G\u00e2\u0001"+
		"\u0000\u0000\u0000I\u00e5\u0001\u0000\u0000\u0000K\u00e8\u0001\u0000\u0000"+
		"\u0000M\u00eb\u0001\u0000\u0000\u0000O\u00ee\u0001\u0000\u0000\u0000Q"+
		"\u00f2\u0001\u0000\u0000\u0000S\u00fd\u0001\u0000\u0000\u0000U\u0115\u0001"+
		"\u0000\u0000\u0000W\u0117\u0001\u0000\u0000\u0000Y\u011e\u0001\u0000\u0000"+
		"\u0000[\u0128\u0001\u0000\u0000\u0000]\u012d\u0001\u0000\u0000\u0000_"+
		"\u0133\u0001\u0000\u0000\u0000a\u013a\u0001\u0000\u0000\u0000cd\u0005"+
		"d\u0000\u0000de\u0005e\u0000\u0000ef\u0005f\u0000\u0000f\u0002\u0001\u0000"+
		"\u0000\u0000gh\u0005i\u0000\u0000hi\u0005f\u0000\u0000i\u0004\u0001\u0000"+
		"\u0000\u0000jk\u0005e\u0000\u0000kl\u0005l\u0000\u0000lm\u0005i\u0000"+
		"\u0000mn\u0005f\u0000\u0000n\u0006\u0001\u0000\u0000\u0000op\u0005e\u0000"+
		"\u0000pq\u0005l\u0000\u0000qr\u0005s\u0000\u0000rs\u0005e\u0000\u0000"+
		"s\b\u0001\u0000\u0000\u0000tu\u0005w\u0000\u0000uv\u0005h\u0000\u0000"+
		"vw\u0005i\u0000\u0000wx\u0005l\u0000\u0000xy\u0005e\u0000\u0000y\n\u0001"+
		"\u0000\u0000\u0000z{\u0005f\u0000\u0000{|\u0005o\u0000\u0000|}\u0005r"+
		"\u0000\u0000}\f\u0001\u0000\u0000\u0000~\u007f\u0005i\u0000\u0000\u007f"+
		"\u0080\u0005n\u0000\u0000\u0080\u000e\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005r\u0000\u0000\u0082\u0083\u0005e\u0000\u0000\u0083\u0084\u0005t"+
		"\u0000\u0000\u0084\u0085\u0005u\u0000\u0000\u0085\u0086\u0005r\u0000\u0000"+
		"\u0086\u0087\u0005n\u0000\u0000\u0087\u0010\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005p\u0000\u0000\u0089\u008a\u0005r\u0000\u0000\u008a\u008b\u0005"+
		"i\u0000\u0000\u008b\u008c\u0005n\u0000\u0000\u008c\u008d\u0005t\u0000"+
		"\u0000\u008d\u0012\u0001\u0000\u0000\u0000\u008e\u008f\u0005f\u0000\u0000"+
		"\u008f\u0090\u0005r\u0000\u0000\u0090\u0091\u0005o\u0000\u0000\u0091\u0092"+
		"\u0005m\u0000\u0000\u0092\u0014\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"i\u0000\u0000\u0094\u0095\u0005m\u0000\u0000\u0095\u0096\u0005p\u0000"+
		"\u0000\u0096\u0097\u0005o\u0000\u0000\u0097\u0098\u0005r\u0000\u0000\u0098"+
		"\u0099\u0005t\u0000\u0000\u0099\u0016\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005w\u0000\u0000\u009b\u009c\u0005i\u0000\u0000\u009c\u009d\u0005t"+
		"\u0000\u0000\u009d\u009e\u0005h\u0000\u0000\u009e\u0018\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0005a\u0000\u0000\u00a0\u00a1\u0005s\u0000\u0000\u00a1"+
		"\u001a\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005N\u0000\u0000\u00a3\u00a4"+
		"\u0005o\u0000\u0000\u00a4\u00a5\u0005n\u0000\u0000\u00a5\u00a6\u0005e"+
		"\u0000\u0000\u00a6\u001c\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005T\u0000"+
		"\u0000\u00a8\u00a9\u0005r\u0000\u0000\u00a9\u00aa\u0005u\u0000\u0000\u00aa"+
		"\u00ab\u0005e\u0000\u0000\u00ab\u001e\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005F\u0000\u0000\u00ad\u00ae\u0005a\u0000\u0000\u00ae\u00af\u0005l"+
		"\u0000\u0000\u00af\u00b0\u0005s\u0000\u0000\u00b0\u00b1\u0005e\u0000\u0000"+
		"\u00b1 \u0001\u0000\u0000\u0000\u00b2\u00b3\u0005a\u0000\u0000\u00b3\u00b4"+
		"\u0005n\u0000\u0000\u00b4\u00b5\u0005d\u0000\u0000\u00b5\"\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005o\u0000\u0000\u00b7\u00b8\u0005r\u0000\u0000"+
		"\u00b8$\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005n\u0000\u0000\u00ba\u00bb"+
		"\u0005o\u0000\u0000\u00bb\u00bc\u0005t\u0000\u0000\u00bc&\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0005=\u0000\u0000\u00be\u00bf\u0005=\u0000\u0000"+
		"\u00bf(\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005!\u0000\u0000\u00c1\u00c2"+
		"\u0005=\u0000\u0000\u00c2*\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005<"+
		"\u0000\u0000\u00c4\u00c5\u0005=\u0000\u0000\u00c5,\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005>\u0000\u0000\u00c7\u00c8\u0005=\u0000\u0000\u00c8."+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005=\u0000\u0000\u00ca0\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0005+\u0000\u0000\u00cc2\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0005-\u0000\u0000\u00ce4\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0005*\u0000\u0000\u00d06\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005/"+
		"\u0000\u0000\u00d28\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005<\u0000\u0000"+
		"\u00d4:\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005>\u0000\u0000\u00d6<"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005:\u0000\u0000\u00d8>\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005,\u0000\u0000\u00da@\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005.\u0000\u0000\u00dcB\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0005@\u0000\u0000\u00deD\u0001\u0000\u0000\u0000\u00df\u00e0\u0005("+
		"\u0000\u0000\u00e0\u00e1\u0006\"\u0000\u0000\u00e1F\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e3\u0005)\u0000\u0000\u00e3\u00e4\u0006#\u0001\u0000\u00e4"+
		"H\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005[\u0000\u0000\u00e6\u00e7\u0006"+
		"$\u0002\u0000\u00e7J\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005]\u0000"+
		"\u0000\u00e9\u00ea\u0006%\u0003\u0000\u00eaL\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0005{\u0000\u0000\u00ec\u00ed\u0006&\u0004\u0000\u00edN\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ef\u0005}\u0000\u0000\u00ef\u00f0\u0006\'"+
		"\u0005\u0000\u00f0P\u0001\u0000\u0000\u0000\u00f1\u00f3\u0007\u0000\u0000"+
		"\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f8\u0005.\u0000\u0000"+
		"\u00f7\u00f9\u0007\u0000\u0000\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fbR\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fe\u0007\u0000\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0001\u0000\u0000\u0000\u0100T\u0001\u0000\u0000\u0000\u0101\u0107"+
		"\u0005\"\u0000\u0000\u0102\u0106\b\u0001\u0000\u0000\u0103\u0104\u0005"+
		"\\\u0000\u0000\u0104\u0106\t\u0000\u0000\u0000\u0105\u0102\u0001\u0000"+
		"\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000"+
		"\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000"+
		"\u0000\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000"+
		"\u0000\u0000\u010a\u0116\u0005\"\u0000\u0000\u010b\u0111\u0005\'\u0000"+
		"\u0000\u010c\u0110\b\u0002\u0000\u0000\u010d\u010e\u0005\\\u0000\u0000"+
		"\u010e\u0110\t\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u010f"+
		"\u010d\u0001\u0000\u0000\u0000\u0110\u0113\u0001\u0000\u0000\u0000\u0111"+
		"\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112"+
		"\u0114\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0114"+
		"\u0116\u0005\'\u0000\u0000\u0115\u0101\u0001\u0000\u0000\u0000\u0115\u010b"+
		"\u0001\u0000\u0000\u0000\u0116V\u0001\u0000\u0000\u0000\u0117\u011b\u0007"+
		"\u0003\u0000\u0000\u0118\u011a\u0007\u0004\u0000\u0000\u0119\u0118\u0001"+
		"\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b\u0119\u0001"+
		"\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011cX\u0001\u0000"+
		"\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e\u0122\u0005#\u0000"+
		"\u0000\u011f\u0121\b\u0005\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000"+
		"\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0126\u0006,\u0006\u0000\u0126"+
		"Z\u0001\u0000\u0000\u0000\u0127\u0129\u0005\r\u0000\u0000\u0128\u0127"+
		"\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012a"+
		"\u0001\u0000\u0000\u0000\u012a\u012b\u0005\n\u0000\u0000\u012b\\\u0001"+
		"\u0000\u0000\u0000\u012c\u012e\u0005 \u0000\u0000\u012d\u012c\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000"+
		"\u0000\u0000\u0131\u0132\u0006.\u0006\u0000\u0132^\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0005I\u0000\u0000\u0134\u0135\u0005N\u0000\u0000\u0135\u0136"+
		"\u0005D\u0000\u0000\u0136\u0137\u0005E\u0000\u0000\u0137\u0138\u0005N"+
		"\u0000\u0000\u0138\u0139\u0005T\u0000\u0000\u0139`\u0001\u0000\u0000\u0000"+
		"\u013a\u013b\u0005D\u0000\u0000\u013b\u013c\u0005E\u0000\u0000\u013c\u013d"+
		"\u0005D\u0000\u0000\u013d\u013e\u0005E\u0000\u0000\u013e\u013f\u0005N"+
		"\u0000\u0000\u013f\u0140\u0005T\u0000\u0000\u0140b\u0001\u0000\u0000\u0000"+
		"\r\u0000\u00f4\u00fa\u00ff\u0105\u0107\u010f\u0111\u0115\u011b\u0122\u0128"+
		"\u012f\u0007\u0001\"\u0000\u0001#\u0001\u0001$\u0002\u0001%\u0003\u0001"+
		"&\u0004\u0001\'\u0005\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}