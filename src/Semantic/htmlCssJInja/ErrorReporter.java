package Semantic.htmlCssJInja;

import java.util.ArrayList;
import java.util.List;

public class ErrorReporter {
    public List<SemanticError> errors = new ArrayList<>();

    public void report(SemanticErrorType type, String message, int line) {
        errors.add(new SemanticError(type, message, line));
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String printErrors() {
        StringBuilder sb = new StringBuilder();
        sb.append("==== Semantic Errors ====\n");
        if (errors.isEmpty()) {
            sb.append("No semantic errors found.\n");
        } else {
            for (SemanticError e : errors) sb.append(e.toString()).append("\n");
        }
        sb.append("==========================\n");
        return sb.toString();
    }
}