// Generated from /home/eduardo/Documents/Comp/Bloco2/ex09/Calculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, Fraction=11, ID=12, Integer=13, ENDLINE=14, WS=15, COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "Fraction", "ID", "Integer", "ENDLINE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'->'", "'print'", "'reduce'", "'+'", "'-'", "'*'", "':'", "'%'", 
			"'('", "')'", null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "Fraction", 
			"ID", "Integer", "ENDLINE", "WS", "COMMENT"
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


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0089\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fC\n\f\r\f\16\fD"+
		"\3\f\3\f\6\fI\n\f\r\f\16\fJ\3\f\3\f\6\fO\n\f\r\f\16\fP\3\f\3\f\6\fU\n"+
		"\f\r\f\16\fV\3\f\6\fZ\n\f\r\f\16\f[\3\f\3\f\3\f\6\fa\n\f\r\f\16\fb\3\f"+
		"\6\ff\n\f\r\f\16\fg\5\fj\n\f\3\r\6\rm\n\r\r\r\16\rn\3\16\6\16r\n\16\r"+
		"\16\16\16s\3\17\3\17\3\20\6\20y\n\20\r\20\16\20z\3\20\3\20\3\21\3\21\7"+
		"\21\u0081\n\21\f\21\16\21\u0084\13\21\3\21\3\21\3\21\3\21\3\u0082\2\22"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22\3\2\6\3\2\62;\3\2\63;\5\2C\\aac|\4\2\13\f\"\"\2\u0096\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5"+
		"&\3\2\2\2\7,\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2"+
		"\2\21;\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27i\3\2\2\2\31l\3\2\2\2\33q\3\2"+
		"\2\2\35u\3\2\2\2\37x\3\2\2\2!~\3\2\2\2#$\7/\2\2$%\7@\2\2%\4\3\2\2\2&\'"+
		"\7r\2\2\'(\7t\2\2()\7k\2\2)*\7p\2\2*+\7v\2\2+\6\3\2\2\2,-\7t\2\2-.\7g"+
		"\2\2./\7f\2\2/\60\7w\2\2\60\61\7e\2\2\61\62\7g\2\2\62\b\3\2\2\2\63\64"+
		"\7-\2\2\64\n\3\2\2\2\65\66\7/\2\2\66\f\3\2\2\2\678\7,\2\28\16\3\2\2\2"+
		"9:\7<\2\2:\20\3\2\2\2;<\7\'\2\2<\22\3\2\2\2=>\7*\2\2>\24\3\2\2\2?@\7+"+
		"\2\2@\26\3\2\2\2AC\t\2\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3"+
		"\2\2\2FH\7\61\2\2GI\t\3\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2Kj"+
		"\3\2\2\2LN\7/\2\2MO\t\2\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR"+
		"\3\2\2\2RT\7\61\2\2SU\t\3\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2"+
		"Wj\3\2\2\2XZ\t\2\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2"+
		"\2]^\7\61\2\2^`\7/\2\2_a\t\3\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2"+
		"\2cj\3\2\2\2df\t\2\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2"+
		"\2iB\3\2\2\2iL\3\2\2\2iY\3\2\2\2ie\3\2\2\2j\30\3\2\2\2km\t\4\2\2lk\3\2"+
		"\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\32\3\2\2\2pr\t\2\2\2qp\3\2\2\2rs\3"+
		"\2\2\2sq\3\2\2\2st\3\2\2\2t\34\3\2\2\2uv\7=\2\2v\36\3\2\2\2wy\t\5\2\2"+
		"xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\b\20\2\2} \3\2\2"+
		"\2~\u0082\7%\2\2\177\u0081\13\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2"+
		"\2\2\u0082\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0086\7\f\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\21"+
		"\2\2\u0088\"\3\2\2\2\17\2DJPV[bginsz\u0082\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}