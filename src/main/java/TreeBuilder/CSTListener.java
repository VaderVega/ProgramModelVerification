package TreeBuilder;

import GeneratedFiles.MyLangBaseListener;
import GeneratedFiles.MyLangParser;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.Trees;

import java.util.Arrays;
import java.util.List;

public class CSTListener extends MyLangBaseListener {
    public static final String Eol = System.lineSeparator();

    public static final String Indents = "-";
    private static int level;

    private static String lead(int level) {
        StringBuilder sb = new StringBuilder();
        if (level > 0) {
            sb.append(Eol);
            for (int cnt = 0; cnt < level - 1; cnt++) {
                sb.append("  ");
            }
        }
        return sb.toString();
    }
    private final List<String> ruleNames;
    private final StringBuilder builder = new StringBuilder();

    public CSTListener(Parser parser) {
        level = 0;
        this.ruleNames = Arrays.asList(parser.getRuleNames());
    }

    public CSTListener(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }

    @Override
    public void enterBinary(MyLangParser.BinaryContext ctx) {
        builder.append(' ');
        builder.append(ctx.getClass().getSimpleName());
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if (builder.length() > 0) {
            level++;
            builder.append(lead(level));
        }

        builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
        level--;
    }


    @Override
    public void visitErrorNode(ErrorNode node) {
        if (builder.length() > 0) {
            builder.append(' ');
        }

        builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if (builder.length() > 0) {
//            builder.append(' ');

        }

        if (ctx.getChildCount() > 0) {
            level++;
        }

        int ruleIndex = ctx.getRuleIndex();
        String ruleName;
        if (ruleIndex >= 0 && ruleIndex < ruleNames.size()) {
            ruleName = ruleNames.get(ruleIndex);
        }
        else {
            ruleName = Integer.toString(ruleIndex);
        }

        builder.append(lead(level));
        builder.append(ruleName);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.getChildCount() > 0) {
            Token positionToken = ctx.getStart();
            if (positionToken != null) {
                builder.append(" [line ");
                builder.append(positionToken.getLine());
                builder.append(", offset ");
                builder.append(positionToken.getStartIndex());
                builder.append(':');
                builder.append(positionToken.getStopIndex());
                builder.append("])");
            }
            else {
                builder.append(')');
            }
            level--;
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
