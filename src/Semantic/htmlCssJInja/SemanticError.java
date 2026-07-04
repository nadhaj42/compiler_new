package Semantic.htmlCssJInja;

public class SemanticError {
    public SemanticErrorType type;
    public String message;
    public int line;

    public SemanticError(SemanticErrorType type, String message, int line) {
        this.type = type;
        this.message = message;
        this.line = line;
    }

    @Override
    public String toString() {
        return "[Line " + line + "] " + type + ": " + message;
    }
}