// Generated from LITTLE.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LITTLEParser}.
 */
public interface LITTLEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LITTLEParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LITTLEParser.ProgramContext ctx);
}