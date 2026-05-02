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
        String message = super.toString() + "{start Import\n";
        if (forpath != null)
            message += forpath.toString() + "\n;";
        if (imports != null){
            for (Path element : imports)
                message += element.toString() + "\n";}
        message += "end Import\n}";
        return message;
    }
}
