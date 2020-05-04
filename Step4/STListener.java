import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;
import java.util.regex.*;

public class STListener extends LITTLEBaseListener{
	//Stack to keep track of current symbol table for current scope (use PEEK)
	Stack<String> stack_scope = new Stack<String>();

	//integer to keep track of which "BLOCK" scope we're at
	public int code_block = 1;

	//Hashtable of symbol tables, K=scope name, V=Arraylist of SymbolTableItems
	LinkedHashMap<String, ArrayList<SymbolTableItem>> symbolTableCollection = new LinkedHashMap<>();

	//STEP4 AST generation
	ASTNode astRoot;
	Stack<ASTNode> nodeStack = new Stack<ASTNode>();

	boolean write = false;
	boolean read = false;

  @Override public void enterProgram(LITTLEParser.ProgramContext ctx){
		stack_scope.push("GLOBAL");
		symbolTableCollection.put("GLOBAL", new ArrayList<SymbolTableItem>());

	}
	@Override public void exitProgram(LITTLEParser.ProgramContext ctx){
		stack_scope.pop();

	}
	@Override public void enterId(LITTLEParser.IdContext ctx) {
		//TODO:step4
		if(read || write){
			SymbolTableItem scopedVar = varScope(ctx.getText());
			//from scope, we can get variable information for AST
			ASTNode t = new ASTNode(scopedVar.type,"",ctx.getText());
			nodeStack.push(t);
		}
	}
	@Override public void exitId(LITTLEParser.IdContext ctx) {
		//TODO:step4
		//nodeStack.push(ctx.getText());
	}
	@Override public void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx) { }
	@Override public void exitPgm_body(LITTLEParser.Pgm_bodyContext ctx) { }
	@Override public void enterDecl(LITTLEParser.DeclContext ctx) {
	}
	@Override public void exitDecl(LITTLEParser.DeclContext ctx) { }
	@Override public void enterString_decl(LITTLEParser.String_declContext ctx){
		if(ctx.getChildCount() != 5){
			System.out.println("Incorrect String Declaration");
		}else{
			for(int i = 0; i < symbolTableCollection.get(stack_scope.peek()).size(); i++){
				if(symbolTableCollection.get(stack_scope.peek()).get(i).name.equals(ctx.getChild(1).getText())){
					System.out.println("DECLARATION ERROR " + ctx.getChild(1).getText());
					throw new IllegalArgumentException("DECLARATION ERROR " + ctx.getChild(1).getText());
				}else{
					continue;
				}
			}
			symbolTableCollection.get(stack_scope.peek()).add(new SymbolTableItem(ctx.getChild(0).getText(), ctx.getChild(1).getText(), ctx.getChild(3).getText()));
		}
	}
	@Override public void exitString_decl(LITTLEParser.String_declContext ctx) {
		ASTNode t = new ASTNode(":=");
		t.leftRef = new ASTNode("STRING", "", ctx.getChild(1).getText());
		t.rightRef = new ASTNode("STRING", "", ctx.getChild(3).getText());
		nodeStack.push(t);
	}
	@Override public void enterStr(LITTLEParser.StrContext ctx) { }
	@Override public void exitStr(LITTLEParser.StrContext ctx) { }
	@Override public void enterVar_decl(LITTLEParser.Var_declContext ctx){
		String[] variables = ctx.getChild(1).getText().split(",");
		for(int i = 0; i < variables.length; i++){
			for(int j = 0; j < symbolTableCollection.get(stack_scope.peek()).size(); j++){
				if(variables[i].equals(symbolTableCollection.get(stack_scope.peek()).get(j).name)){
					System.out.println("DECLARATION ERROR "+variables[i]);
					throw new IllegalArgumentException("DECLARATION ERROR "+variables[i]);
				}else{
					continue;
				}
			}
			symbolTableCollection.get(stack_scope.peek()).add(new SymbolTableItem(ctx.getChild(0).getText(), variables[i]));
		}
	}
	@Override public void exitVar_decl(LITTLEParser.Var_declContext ctx){
		ASTNode t;
		String[] var_list = ctx.getChild(1).getText().split(",");
		for(int i = 0; i < var_list.length; i++){
			t = new ASTNode("VAR");
			t.leftRef = new ASTNode(ctx.getChild(0).getText(), "", var_list[i]);
			nodeStack.push(t);
		}
	 }
	@Override public void enterVar_type(LITTLEParser.Var_typeContext ctx) { }
	@Override public void exitVar_type(LITTLEParser.Var_typeContext ctx) { }
	@Override public void enterAny_type(LITTLEParser.Any_typeContext ctx) { }
	@Override public void exitAny_type(LITTLEParser.Any_typeContext ctx) { }
	@Override public void enterId_list(LITTLEParser.Id_listContext ctx) { }
	@Override public void exitId_list(LITTLEParser.Id_listContext ctx) { }
	@Override public void enterId_tail(LITTLEParser.Id_tailContext ctx) { }
	@Override public void exitId_tail(LITTLEParser.Id_tailContext ctx) { }
	@Override public void enterParam_decl_list(LITTLEParser.Param_decl_listContext ctx){
	}
	@Override public void exitParam_decl_list(LITTLEParser.Param_decl_listContext ctx){}
	@Override public void enterParam_decl(LITTLEParser.Param_declContext ctx){
		for(int i = 0; i < symbolTableCollection.get(stack_scope.peek()).size(); i++){
                       	if(ctx.getChild(1).getText().equals(symbolTableCollection.get(stack_scope.peek()).get(i).name)){
                        	System.out.println("DECLARATION ERROR "+ctx.getChild(1).getText());
                                throw new IllegalArgumentException("DECLARATION ERROR "+ctx.getChild(1).getText());
                        }else{
                               	continue;
                	}
                }
		symbolTableCollection.get(stack_scope.peek()).add(new SymbolTableItem(ctx.getChild(0).getText(), ctx.getChild(1).getText()));
	}
	@Override public void exitParam_decl(LITTLEParser.Param_declContext ctx){ }
	@Override public void enterParam_decl_tail(LITTLEParser.Param_decl_tailContext ctx) { }
	@Override public void exitParam_decl_tail(LITTLEParser.Param_decl_tailContext ctx) { }
	@Override public void enterFunc_declarations(LITTLEParser.Func_declarationsContext ctx) { }
	@Override public void exitFunc_declarations(LITTLEParser.Func_declarationsContext ctx) { }
	@Override public void enterFunc_decl(LITTLEParser.Func_declContext ctx){
	       	stack_scope.push(ctx.getChild(2).getText());
                symbolTableCollection.put(ctx.getChild(2).getText(), new ArrayList<SymbolTableItem>());
	}
	@Override public void exitFunc_decl(LITTLEParser.Func_declContext ctx) {
		stack_scope.pop();
	}
	@Override public void enterFunc_body(LITTLEParser.Func_bodyContext ctx) { }
	@Override public void exitFunc_body(LITTLEParser.Func_bodyContext ctx) { }
	@Override public void enterStmt_list(LITTLEParser.Stmt_listContext ctx) { }
	@Override public void exitStmt_list(LITTLEParser.Stmt_listContext ctx) { }
	@Override public void enterStmt(LITTLEParser.StmtContext ctx) { }
	@Override public void exitStmt(LITTLEParser.StmtContext ctx) { }
	@Override public void enterBase_stmt(LITTLEParser.Base_stmtContext ctx) {

	}
	@Override public void exitBase_stmt(LITTLEParser.Base_stmtContext ctx) {
		//TODO:step4
		//System.out.println(ctx.getText());
		//nodeStack.push(ctx.getText());
	}
	@Override public void enterAssign_stmt(LITTLEParser.Assign_stmtContext ctx) {}
	@Override public void exitAssign_stmt(LITTLEParser.Assign_stmtContext ctx) {
		ASTNode t = new ASTNode(":=");
		t.leftRef = nodeStack.pop();
		t.rightRef = nodeStack.pop();
		nodeStack.push(t);
	}
	@Override public void enterAssign_expr(LITTLEParser.Assign_exprContext ctx) { }
	@Override public void exitAssign_expr(LITTLEParser.Assign_exprContext ctx) {
		SymbolTableItem scopedVar = varScope(ctx.getChild(0).getText());
		//from scope, we can get variable information for AST
		ASTNode t = new ASTNode(scopedVar.type,"",ctx.getChild(0).getText());
		nodeStack.push(t);
	}
	@Override public void enterRead_stmt(LITTLEParser.Read_stmtContext ctx) {
		nodeStack.push(new ASTNode("readflag"));
		read = true;
	}
	@Override public void exitRead_stmt(LITTLEParser.Read_stmtContext ctx) {
		read = false;
		Stack<ASTNode> tmpNodeStack = new Stack<ASTNode>();
		ASTNode thisNode = nodeStack.pop();
		ASTNode t;

		while(thisNode.temp != "readflag"){
			t = new ASTNode("READ");
			t.leftRef = thisNode;
			tmpNodeStack.push(t);
			thisNode = nodeStack.pop();
		}
		while(!tmpNodeStack.empty()){
			nodeStack.push(tmpNodeStack.pop());
		}
	}
	@Override public void enterWrite_stmt(LITTLEParser.Write_stmtContext ctx) {
		nodeStack.push(new ASTNode("writeflag"));
		write = true;
	}
	@Override public void exitWrite_stmt(LITTLEParser.Write_stmtContext ctx) {
		write = false;
		Stack<ASTNode> tmpNodeStack = new Stack<ASTNode>();
		ASTNode thisNode = nodeStack.pop();
		ASTNode t;

		while(thisNode.temp != "writeflag"){
			t = new ASTNode("WRITE");
			t.leftRef = thisNode;
			tmpNodeStack.push(t);
			thisNode = nodeStack.pop();
		}
		while(!tmpNodeStack.empty()){
			nodeStack.push(tmpNodeStack.pop());
		}
	}
	@Override public void enterReturn_stmt(LITTLEParser.Return_stmtContext ctx) { }
	@Override public void exitReturn_stmt(LITTLEParser.Return_stmtContext ctx) { }
	@Override public void enterExpr(LITTLEParser.ExprContext ctx) {
		//TODO:step4
		//ASTNode t = fromExpression(ctx.getText());
 	}
	@Override public void exitExpr(LITTLEParser.ExprContext ctx) {
		//TODO:step4
		// System.out.println(ctx.getText());
		// if(ctx.getText().substring(0,1).equals("(")){
		//
		// }else{
		// 	ASTNode t = fromExpression(ctx.getText());
		// 	nodeStack.push(t);
		// }
		//System.out.println(ctx.getText());
		int count = getParenLateral(ctx.getText());
		for(int i = 0; i < count; i++){
			nodeStack.pop();
		}
		ASTNode t = fromExpression2(ctx.getText());
		nodeStack.push(t);
	}
	@Override public void enterExpr_prefix(LITTLEParser.Expr_prefixContext ctx) { }
	@Override public void exitExpr_prefix(LITTLEParser.Expr_prefixContext ctx) { }
	@Override public void enterFactor(LITTLEParser.FactorContext ctx) { }
	@Override public void exitFactor(LITTLEParser.FactorContext ctx) { }
	@Override public void enterFactor_prefix(LITTLEParser.Factor_prefixContext ctx) { }
	@Override public void exitFactor_prefix(LITTLEParser.Factor_prefixContext ctx) { }
	@Override public void enterPostfix_expr(LITTLEParser.Postfix_exprContext ctx) { }
	@Override public void exitPostfix_expr(LITTLEParser.Postfix_exprContext ctx) { }
	@Override public void enterCall_expr(LITTLEParser.Call_exprContext ctx) { }
	@Override public void exitCall_expr(LITTLEParser.Call_exprContext ctx) { }
	@Override public void enterExpr_list(LITTLEParser.Expr_listContext ctx) { }
	@Override public void exitExpr_list(LITTLEParser.Expr_listContext ctx) { }
	@Override public void enterExpr_list_tail(LITTLEParser.Expr_list_tailContext ctx) { }
	@Override public void exitExpr_list_tail(LITTLEParser.Expr_list_tailContext ctx) { }
	@Override public void enterPrimary(LITTLEParser.PrimaryContext ctx) { }
	@Override public void exitPrimary(LITTLEParser.PrimaryContext ctx) { }
	@Override public void enterAddop(LITTLEParser.AddopContext ctx) { }
	@Override public void exitAddop(LITTLEParser.AddopContext ctx) { }
	@Override public void enterMulop(LITTLEParser.MulopContext ctx) { }
	@Override public void exitMulop(LITTLEParser.MulopContext ctx) { }
	@Override public void enterIf_stmt(LITTLEParser.If_stmtContext ctx){
		String scope = "BLOCK "+code_block;
		stack_scope.push(scope);
		symbolTableCollection.put(scope, new ArrayList<SymbolTableItem>());
		code_block++;
	}
	@Override public void exitIf_stmt(LITTLEParser.If_stmtContext ctx){
       		stack_scope.pop();
	}
	@Override public void enterElse_part(LITTLEParser.Else_partContext ctx){
		if(ctx.getChildCount() > 1){
			String scope = "BLOCK "+code_block;
			stack_scope.push(scope);
			symbolTableCollection.put(scope, new ArrayList<SymbolTableItem>());
			code_block++;
		}else{}
	}
	@Override public void exitElse_part(LITTLEParser.Else_partContext ctx){
		if (ctx.getChildCount() > 1) {
			stack_scope.pop();
		}
	}
	@Override public void enterCond(LITTLEParser.CondContext ctx) { }
	@Override public void exitCond(LITTLEParser.CondContext ctx) { }
	@Override public void enterCompop(LITTLEParser.CompopContext ctx) { }
	@Override public void exitCompop(LITTLEParser.CompopContext ctx) { }
	@Override public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx){
		String scope = "BLOCK "+code_block;
		stack_scope.push(scope);
		symbolTableCollection.put(scope, new ArrayList<SymbolTableItem>());
		code_block++;
	}
	@Override public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx){
		stack_scope.pop();
	}
	@Override public void enterEmpty(LITTLEParser.EmptyContext ctx) { }
	@Override public void exitEmpty(LITTLEParser.EmptyContext ctx) { }
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }

	//Method for printing out each scopes variables.
	public void prettyPrint(){
		Set<String> keys = symbolTableCollection.keySet();
		for(String key: keys){
            		System.out.println("Symbol table "+key);
			for(int i = 0; i < symbolTableCollection.get(key).size(); i++){
				if(symbolTableCollection.get(key).get(i).value == null){
					System.out.print("name " + symbolTableCollection.get(key).get(i).name + " type " + symbolTableCollection.get(key).get(i).type);
				}else{
					System.out.print("name " + symbolTableCollection.get(key).get(i).name + " type " + symbolTableCollection.get(key).get(i).type + " value " + symbolTableCollection.get(key).get(i).value);
				}
				System.out.println();
			}
			System.out.println();
        	}
	}

	//STEP4 functions

	public String argFirstIndex(String target, String [] strArr){
		int index = target.indexOf(strArr[0]);
		String first = strArr[0];

		for(int i = 1; i < strArr.length; i++){
			if(target.indexOf(strArr[1]) < index && target.indexOf(strArr[1]) != -1){
				index = target.indexOf(strArr[1]);
				first = strArr[1];
			}
		}
		return first;
	}

	public String argLastIndex(String target, String [] strArr){
		int index = target.lastIndexOf(strArr[0]);
		String last = strArr[0];

		for(int i = 1; i < strArr.length; i++){
			if(target.lastIndexOf(strArr[1]) > index && target.lastIndexOf(strArr[1]) != -1){
				index = target.indexOf(strArr[1]);
				last = strArr[1];
			}
		}
		return last;
	}

	//takes an expression and returns a node (root) of expression
	public ASTNode fromExpression(String exp){
		ASTNode thisNode;
		//System.out.println(exp);
		boolean plusAfter,plusBefore,mulAfter,mulBefore;
		if(!exp.contains("(")){
			plusAfter = exp.contains("+") || exp.contains("-");
			plusBefore = exp.contains("+") || exp.contains("-");
			mulAfter = exp.contains("*") || exp.contains("/");
			mulBefore = exp.contains("*") || exp.contains("/");
		}else{
			plusBefore = ((exp.indexOf("+") != -1 && exp.indexOf("+") < exp.indexOf("(")) || (exp.indexOf("-") != -1 && exp.indexOf("-") < exp.indexOf("(")));
			plusAfter = (exp.lastIndexOf("+") > exp.lastIndexOf(")") || exp.lastIndexOf("-") > exp.lastIndexOf(")"));
			mulBefore = ((exp.indexOf("*") != -1 && exp.indexOf("*") < exp.indexOf("(")) || (exp.indexOf("/") != -1 && exp.indexOf("/") < exp.indexOf("(")));
			mulAfter = (exp.lastIndexOf("*") > exp.lastIndexOf(")") || exp.lastIndexOf("/") > exp.lastIndexOf(")"));
		}
		if((exp.contains("+") || exp.contains("-")) && (plusAfter || plusBefore)){
			int div = 0;
			String symbol = "+";
			if(plusBefore){
				symbol = argFirstIndex(exp, new String[]{"+", "-"});
				div = exp.indexOf(symbol);
			}else if(plusAfter){
				symbol = argLastIndex(exp, new String[]{"*", "/"});
				div = exp.lastIndexOf(symbol);
			}
			thisNode = new ASTNode("OP","",symbol);
			thisNode.leftRef = fromExpression(exp.substring(0,div));
			thisNode.rightRef = fromExpression(exp.substring(div+1));
		}else if((exp.contains("*") || exp.contains("/")) && (mulAfter || mulBefore)){
			int div = 0;
			String symbol = "-";
			if(mulBefore){
				symbol = argFirstIndex(exp, new String[]{"*", "/"});
				div = exp.indexOf(symbol);
			}else if(mulAfter){
				symbol = argLastIndex(exp, new String[]{"*", "/"});
				div = exp.lastIndexOf(symbol);
			}
			thisNode = new ASTNode("OP","",symbol);
			thisNode.leftRef = fromExpression(exp.substring(0,div));
			thisNode.rightRef = fromExpression(exp.substring(div+1));
		}else if(exp.contains("(")){
			int firstP = exp.indexOf("(");
			int lastP = exp.lastIndexOf(")");
			thisNode = fromExpression(exp.substring(firstP+1,lastP));
		}else{
			SymbolTableItem scopedVar = varScope(exp);
			if(scopedVar.type==""){
				// if(exp.contains(".")){
				// 	scopedVar.type = "FLOAT";
				// }else{
				// 	scopedVar.type = "INT";
				// }
				thisNode = new ASTNode(scopedVar.type,"LITERAL",exp);
			}else{
				thisNode = new ASTNode(scopedVar.type,"",exp);
			}

			//thisNode = new ASTNode(exp);
		}
		return thisNode;
	}

	//takes an expression and returns a node (root) of expression
	public ASTNode fromExpression2(String exp){
		ASTNode thisNode;
		int addDiv = charNotInParens(exp,'+');
		int subDiv = charNotInParens(exp,'-');
		int mulDiv = charNotInParens(exp,'*');
		int divDiv = charNotInParens(exp,'/');
		if(getParenLateral(exp) == 1 && addDiv == -1 && subDiv == -1 && mulDiv == -1 && divDiv == -1){
			int firstP = exp.indexOf("(");
			int lastP = exp.lastIndexOf(")");
			thisNode = fromExpression2(exp.substring(firstP+1,lastP));
		}else{
			if(addDiv != -1 || subDiv != -1){
				if((subDiv != -1 && subDiv < addDiv) || addDiv == -1){
					addDiv = subDiv;
				}
				String symbol = exp.substring(addDiv, addDiv+1);
				thisNode = new ASTNode("OP","",symbol);
				thisNode.leftRef = fromExpression2(exp.substring(0,addDiv));
				thisNode.rightRef = fromExpression2(exp.substring(addDiv+1));
			}else if(mulDiv != -1 || divDiv != -1){
				if((divDiv != -1 && divDiv < mulDiv) || mulDiv == -1){
					mulDiv = divDiv;
				}
				String symbol = exp.substring(mulDiv, mulDiv+1);
				thisNode = new ASTNode("OP","",symbol);
				thisNode.leftRef = fromExpression2(exp.substring(0,mulDiv));
				thisNode.rightRef = fromExpression2(exp.substring(mulDiv+1));
			}else{
				SymbolTableItem scopedVar = varScope(exp);
				if(scopedVar.type==""){
					if(exp.contains(".")){
						scopedVar.type = "FLOAT";
					}else{
						scopedVar.type = "INT";
					}
					thisNode = new ASTNode(scopedVar.type,"LITERAL",exp);
				}else{
					thisNode = new ASTNode(scopedVar.type,"",exp);
				}
			}
		}

		return thisNode;
	}

	public SymbolTableItem varScope(String desNode){
		//get scope from the symbolTable:
		int i = stack_scope.size();
		String scope;
		ArrayList<SymbolTableItem> check;
		SymbolTableItem scopedVar = new SymbolTableItem("","");
		while (i > 0) {
        scope = stack_scope.get(--i);
				check = symbolTableCollection.get(scope);
				for(int j = 0; j < check.size(); j++){
					if(check.get(j).name.equals(desNode)){
						i = 0;
						scopedVar = check.get(j);
					}
				}
    }
		return scopedVar;
	}

	public int getParenLateral(String str){
		int count = 0;
		int forPar = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '('){
				if(forPar==0){
					count ++;
				}
				forPar ++;
			}
			if(str.charAt(i) == ')'){
				forPar --;
			}
		}

		return count;
	}

	public int charNotInParens(String str, char c){
		int forPar = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '('){
				forPar ++;
			}
			if(str.charAt(i) == ')'){
				forPar --;
			}
			if(str.charAt(i) == c && forPar == 0){
				return i;
			}
		}

		return -1;
	}
}
