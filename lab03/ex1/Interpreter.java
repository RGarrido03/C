import org.antlr.v4.runtime.tree.TerminalNode;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

// Generated from CSV.g4 by ANTLR 4.13.1
@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CSVBaseVisitor<ST> {
    private final STGroup templates = new STGroupFile("CSV.stg");

    @Override
    public ST visitProgram(CSVParser.ProgramContext ctx) {
        ST res = templates.getInstanceOf("table");

        CSVParser.HeaderContext header = ctx.header();
        res.add("header", visit(header).render());

        for (CSVParser.RowContext rowContext : ctx.row()) {
            res.add("row", visit(rowContext).render());
        }
        return res;
    }

    @Override
    public ST visitHeader(CSVParser.HeaderContext ctx) {
        return visit(ctx.row());
    }

    @Override
    public ST visitRow(CSVParser.RowContext ctx) {
        ST res = templates.getInstanceOf("rows");

        for (TerminalNode node : ctx.Value()) {
            ST col = templates.getInstanceOf("cols");
            col.add("info", node.getText());

            res.add("cols", col.render());
        }

        return res;
    }
}
