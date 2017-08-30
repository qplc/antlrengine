package com.antlrengine;

import antlrengine.ExampleLexer;
import antlrengine.ExampleParser;
import antlrengine.ExampleParser.EvalContext;
import com.antlrengine.treewalker.AntlrExampleListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

/**
 *
 * @author qplc
 */
public class AntlrTest {

    @Test
    public void executeReflection() {
        String expr1 = "com.antlrengine . util.Util.factorial  (\"TINT:4\")  ";
        String expr2 = "com.antlrengine.util. Util.add  (\"TINT:5\",\"TINT:10\",\"TINT:15\")  ";
        String expr3 = "com.antlrengine . util.Util.   isPalindrom(\"TSTRING:radar\")  ";
        String expression = expr1 + "," + expr2 + "," + expr3;

        compileExpression(expression);
    }

    EvalContext compileExpression(String expression) {
        try {
            System.out.println("Input = [" + expression + "]");
            ANTLRInputStream ais = new ANTLRInputStream(expression);
            ExampleLexer lexer = new ExampleLexer(ais);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExampleParser parser = new ExampleParser(tokens);
            parser.addParseListener(new AntlrExampleListener());
            EvalContext ctx = parser.eval();
            System.out.println();
            System.out.println("validated output: " + ctx.value);
            System.out.println();
            return ctx;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
