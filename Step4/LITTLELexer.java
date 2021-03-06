// Generated from LITTLE.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LITTLELexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, OPERATOR=16, 
		PROGRAM=17, BEGIN=18, END=19, FUNCTION=20, READ=21, WRITE=22, IF=23, ELSE=24, 
		ENDIF=25, WHILE=26, ENDWHILE=27, CONTINUE=28, BREAK=29, RETURN=30, INT=31, 
		VOID=32, STRING=33, FLOAT=34, IDENTIFIER=35, INTLITERAL=36, FLOATLITERAL=37, 
		STRINGLITERAL=38, COMMENT=39, WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "OPERATOR", "PROGRAM", 
			"BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", "ENDIF", "WHILE", 
			"ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", "VOID", "STRING", "FLOAT", 
			"IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "';'", "','", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
			"'<'", "'>'", "'='", "'!='", "'<='", "'>='", null, "'PROGRAM'", "'BEGIN'", 
			"'END'", "'FUNCTION'", "'READ'", "'WRITE'", "'IF'", "'ELSE'", "'ENDIF'", 
			"'WHILE'", "'ENDWHILE'", "'CONTINUE'", "'BREAK'", "'RETURN'", "'INT'", 
			"'VOID'", "'STRING'", "'FLOAT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "OPERATOR", "PROGRAM", "BEGIN", "END", "FUNCTION", 
			"READ", "WRITE", "IF", "ELSE", "ENDIF", "WHILE", "ENDWHILE", "CONTINUE", 
			"BREAK", "RETURN", "INT", "VOID", "STRING", "FLOAT", "IDENTIFIER", "INTLITERAL", 
			"FLOATLITERAL", "STRINGLITERAL", "COMMENT", "WS"
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


	public LITTLELexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LITTLE.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0125\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0080\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3$\3$\7$\u00f3\n$\f$\16$\u00f6\13$\3%\6%\u00f9\n%\r"+
		"%\16%\u00fa\3&\7&\u00fe\n&\f&\16&\u0101\13&\3&\3&\6&\u0105\n&\r&\16&\u0106"+
		"\3\'\3\'\7\'\u010b\n\'\f\'\16\'\u010e\13\'\3\'\3\'\3(\3(\3(\3(\7(\u0116"+
		"\n(\f(\16(\u0119\13(\3(\3(\3(\3(\3)\6)\u0120\n)\r)\16)\u0121\3)\3)\4\u010c"+
		"\u0117\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\t\6\2,-//\61\61??\6\2*+..=>@@"+
		"\3\2C|\4\2\62;C|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0130\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5V\3"+
		"\2\2\2\7X\3\2\2\2\tZ\3\2\2\2\13\\\3\2\2\2\r^\3\2\2\2\17`\3\2\2\2\21b\3"+
		"\2\2\2\23d\3\2\2\2\25f\3\2\2\2\27h\3\2\2\2\31j\3\2\2\2\33l\3\2\2\2\35"+
		"o\3\2\2\2\37r\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0089\3\2\2\2\'\u008f"+
		"\3\2\2\2)\u0093\3\2\2\2+\u009c\3\2\2\2-\u00a1\3\2\2\2/\u00a7\3\2\2\2\61"+
		"\u00aa\3\2\2\2\63\u00af\3\2\2\2\65\u00b5\3\2\2\2\67\u00bb\3\2\2\29\u00c4"+
		"\3\2\2\2;\u00cd\3\2\2\2=\u00d3\3\2\2\2?\u00da\3\2\2\2A\u00de\3\2\2\2C"+
		"\u00e3\3\2\2\2E\u00ea\3\2\2\2G\u00f0\3\2\2\2I\u00f8\3\2\2\2K\u00ff\3\2"+
		"\2\2M\u0108\3\2\2\2O\u0111\3\2\2\2Q\u011f\3\2\2\2ST\7<\2\2TU\7?\2\2U\4"+
		"\3\2\2\2VW\7=\2\2W\6\3\2\2\2XY\7.\2\2Y\b\3\2\2\2Z[\7*\2\2[\n\3\2\2\2\\"+
		"]\7+\2\2]\f\3\2\2\2^_\7-\2\2_\16\3\2\2\2`a\7/\2\2a\20\3\2\2\2bc\7,\2\2"+
		"c\22\3\2\2\2de\7\61\2\2e\24\3\2\2\2fg\7>\2\2g\26\3\2\2\2hi\7@\2\2i\30"+
		"\3\2\2\2jk\7?\2\2k\32\3\2\2\2lm\7#\2\2mn\7?\2\2n\34\3\2\2\2op\7>\2\2p"+
		"q\7?\2\2q\36\3\2\2\2rs\7@\2\2st\7?\2\2t \3\2\2\2uv\7<\2\2v\u0080\7?\2"+
		"\2w\u0080\t\2\2\2xy\7#\2\2y\u0080\7?\2\2z\u0080\t\3\2\2{|\7>\2\2|\u0080"+
		"\7?\2\2}~\7@\2\2~\u0080\7?\2\2\177u\3\2\2\2\177w\3\2\2\2\177x\3\2\2\2"+
		"\177z\3\2\2\2\177{\3\2\2\2\177}\3\2\2\2\u0080\"\3\2\2\2\u0081\u0082\7"+
		"R\2\2\u0082\u0083\7T\2\2\u0083\u0084\7Q\2\2\u0084\u0085\7I\2\2\u0085\u0086"+
		"\7T\2\2\u0086\u0087\7C\2\2\u0087\u0088\7O\2\2\u0088$\3\2\2\2\u0089\u008a"+
		"\7D\2\2\u008a\u008b\7G\2\2\u008b\u008c\7I\2\2\u008c\u008d\7K\2\2\u008d"+
		"\u008e\7P\2\2\u008e&\3\2\2\2\u008f\u0090\7G\2\2\u0090\u0091\7P\2\2\u0091"+
		"\u0092\7F\2\2\u0092(\3\2\2\2\u0093\u0094\7H\2\2\u0094\u0095\7W\2\2\u0095"+
		"\u0096\7P\2\2\u0096\u0097\7E\2\2\u0097\u0098\7V\2\2\u0098\u0099\7K\2\2"+
		"\u0099\u009a\7Q\2\2\u009a\u009b\7P\2\2\u009b*\3\2\2\2\u009c\u009d\7T\2"+
		"\2\u009d\u009e\7G\2\2\u009e\u009f\7C\2\2\u009f\u00a0\7F\2\2\u00a0,\3\2"+
		"\2\2\u00a1\u00a2\7Y\2\2\u00a2\u00a3\7T\2\2\u00a3\u00a4\7K\2\2\u00a4\u00a5"+
		"\7V\2\2\u00a5\u00a6\7G\2\2\u00a6.\3\2\2\2\u00a7\u00a8\7K\2\2\u00a8\u00a9"+
		"\7H\2\2\u00a9\60\3\2\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac\7N\2\2\u00ac\u00ad"+
		"\7U\2\2\u00ad\u00ae\7G\2\2\u00ae\62\3\2\2\2\u00af\u00b0\7G\2\2\u00b0\u00b1"+
		"\7P\2\2\u00b1\u00b2\7F\2\2\u00b2\u00b3\7K\2\2\u00b3\u00b4\7H\2\2\u00b4"+
		"\64\3\2\2\2\u00b5\u00b6\7Y\2\2\u00b6\u00b7\7J\2\2\u00b7\u00b8\7K\2\2\u00b8"+
		"\u00b9\7N\2\2\u00b9\u00ba\7G\2\2\u00ba\66\3\2\2\2\u00bb\u00bc\7G\2\2\u00bc"+
		"\u00bd\7P\2\2\u00bd\u00be\7F\2\2\u00be\u00bf\7Y\2\2\u00bf\u00c0\7J\2\2"+
		"\u00c0\u00c1\7K\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3\7G\2\2\u00c38\3\2\2"+
		"\2\u00c4\u00c5\7E\2\2\u00c5\u00c6\7Q\2\2\u00c6\u00c7\7P\2\2\u00c7\u00c8"+
		"\7V\2\2\u00c8\u00c9\7K\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cb\7W\2\2\u00cb"+
		"\u00cc\7G\2\2\u00cc:\3\2\2\2\u00cd\u00ce\7D\2\2\u00ce\u00cf\7T\2\2\u00cf"+
		"\u00d0\7G\2\2\u00d0\u00d1\7C\2\2\u00d1\u00d2\7M\2\2\u00d2<\3\2\2\2\u00d3"+
		"\u00d4\7T\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6\7V\2\2\u00d6\u00d7\7W\2\2"+
		"\u00d7\u00d8\7T\2\2\u00d8\u00d9\7P\2\2\u00d9>\3\2\2\2\u00da\u00db\7K\2"+
		"\2\u00db\u00dc\7P\2\2\u00dc\u00dd\7V\2\2\u00dd@\3\2\2\2\u00de\u00df\7"+
		"X\2\2\u00df\u00e0\7Q\2\2\u00e0\u00e1\7K\2\2\u00e1\u00e2\7F\2\2\u00e2B"+
		"\3\2\2\2\u00e3\u00e4\7U\2\2\u00e4\u00e5\7V\2\2\u00e5\u00e6\7T\2\2\u00e6"+
		"\u00e7\7K\2\2\u00e7\u00e8\7P\2\2\u00e8\u00e9\7I\2\2\u00e9D\3\2\2\2\u00ea"+
		"\u00eb\7H\2\2\u00eb\u00ec\7N\2\2\u00ec\u00ed\7Q\2\2\u00ed\u00ee\7C\2\2"+
		"\u00ee\u00ef\7V\2\2\u00efF\3\2\2\2\u00f0\u00f4\t\4\2\2\u00f1\u00f3\t\5"+
		"\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5H\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\t\6\2\2"+
		"\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fbJ\3\2\2\2\u00fc\u00fe\t\6\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\7\60\2\2\u0103\u0105\t\6\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107L\3\2\2\2\u0108\u010c\7$\2\2\u0109\u010b\13\2\2\2\u010a\u0109"+
		"\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\7$\2\2\u0110N\3\2\2\2\u0111"+
		"\u0112\7/\2\2\u0112\u0113\7/\2\2\u0113\u0117\3\2\2\2\u0114\u0116\13\2"+
		"\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0118\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\t\7"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\u011d\b(\2\2\u011dP\3\2\2\2\u011e\u0120"+
		"\t\b\2\2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b)\2\2\u0124R\3\2\2\2\f"+
		"\2\177\u00f2\u00f4\u00fa\u00ff\u0106\u010c\u0117\u0121\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}