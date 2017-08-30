package com.antlrengine.treewalker;

import antlrengine.ExampleParser;
import antlrengine.ExampleVisitor;
import com.antlrengine.util.TypeHandler;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author qplc
 */
public class AntlrExampleVisitor implements ExampleVisitor {

    @Override
    public Object visitEval(ExampleParser.EvalContext ctx) {
        System.out.println("Visitor called visitEval(): " + ctx.value);
        return ctx.value;
    }

    @Override
    public Object visitParamexpr(ExampleParser.ParamexprContext ctx) {
        System.out.println("Visitor called visitInnerexpr(): " + ctx.getText());
        return ctx.getText();
    }

    @Override
    public Object visitFuncsign(ExampleParser.FuncsignContext ctx) {
        System.out.println("Visitor called visitFuncsign(): " + ctx.getText());
        TypeHandler exe = new TypeHandler();
        exe.executeMethod(ctx.getText());
        return ctx.getText();
    }

    @Override
    public Object visit(ParseTree pt) {
        System.out.println("Visitor called visit(): " + pt.getText());
        return pt.getText();
    }

    @Override
    public Object visitChildren(RuleNode rn) {
        System.out.println("Visitor called visitChildren(): " + rn.getText());
        return rn.getText();
    }

    @Override
    public Object visitTerminal(TerminalNode tn) {
        System.out.println("Visitor called visitTerminal(): " + tn.getText());
        return tn.getText();
    }

    @Override
    public Object visitErrorNode(ErrorNode en) {
        System.out.println("Visitor called visitErrorNode(): " + en.getText());
        return en.getText();
    }

    @Override
    public Object visitFexpr(ExampleParser.FexprContext ctx) {
        System.out.println("Visitor called visitFexpr(): " + ctx.getText());
        return ctx.getText();
    }

    @Override
    public Object visitAllfunc(ExampleParser.AllfuncContext ctx) {
        System.out.println("Visitor called visitAllfunc(): " + ctx.getText());
        return ctx.getText();
    }
}
