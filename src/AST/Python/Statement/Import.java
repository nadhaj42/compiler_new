package AST.Python.Statement;

import java.util.List;

public class Import extends Statement {
    public List<Path> imports;
    public Path forpath = null;

    public Import(Path forpath, List<Path> imports, int line) {
        super("Import", line);
        this.forpath = forpath;
        this.imports = imports;
    }
    public String toString() {
        String message = super.toString() + "{\nstart Import\n";
        if (forpath != null)
            message += forpath.toString() + "\n;";
        if (imports != null) {
            for (Path element : imports) {
                if (element != null)  // ← هون الإضافة
                    message += element.toString() + "\n";
            }
        }
        message += "}\nend"+super.toString()+"\n";
        return message;
    }
}
