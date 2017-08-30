package com.antlrengine.treewalker;

import antlrengine.ExampleListener;
import antlrengine.ExampleParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author qplc
 */
public class AntlrExampleListener implements ExampleListener {

    @Override
    public void enterEval(ExampleParser.EvalContext ctx) {
        System.out.println("Listener Listener called enterEval(): " + ctx.value);
    }

    @Override
    public void exitEval(ExampleParser.EvalContext ctx) {
        System.out.println("Listener called exitEval(): " + ctx.value);
    }

    @Override
    public void enterParamexpr(ExampleParser.ParamexprContext ctx) {
        System.out.println("Listener called enterInnerexpr(): " + ctx.getText());
    }

    @Override
    public void exitParamexpr(ExampleParser.ParamexprContext ctx) {
        System.out.println("Listener called exitInnerexpr(): " + ctx.getText());
    }

    @Override
    public void enterFuncsign(ExampleParser.FuncsignContext ctx) {
        System.out.println("Listener called enterFuncsign(): " + ctx.getText());
    }

    @Override
    public void exitFuncsign(ExampleParser.FuncsignContext ctx) {
        System.out.println("Listener called exitFuncsign(): " + ctx.getText());
        AntlrExampleVisitor visitor = new AntlrExampleVisitor();
        ctx.accept(visitor);
    }

    @Override
    public void visitTerminal(TerminalNode tn) {
        System.out.println("Listener called visitTerminal(): " + tn.getText());
    }

    @Override
    public void visitErrorNode(ErrorNode en) {
        System.out.println("Listener called visitErrorNode(): " + en.getText());
    }

    @Override
    public void enterEveryRule(ParserRuleContext prc) {
        System.out.println("Listener called enterEveryRule(): " + prc.getText());
    }

    @Override
    public void exitEveryRule(ParserRuleContext prc) {
        System.out.println("Listener called exitEveryRule(): " + prc.getText());
    }

    @Override
    public void enterFexpr(ExampleParser.FexprContext ctx) {
        System.out.println("Listener called enterFexpr(): " + ctx.getText());
    }

    @Override
    public void exitFexpr(ExampleParser.FexprContext ctx) {
        System.out.println("Listener called exitFexpr(): " + ctx.getText());
    }

    @Override
    public void enterAllfunc(ExampleParser.AllfuncContext ctx) {
        System.out.println("Listener called enterAllfunc(): " + ctx.getText());
    }

    @Override
    public void exitAllfunc(ExampleParser.AllfuncContext ctx) {
        System.out.println("Listener called exitAllfunc(): " + ctx.getText());
    }
}
