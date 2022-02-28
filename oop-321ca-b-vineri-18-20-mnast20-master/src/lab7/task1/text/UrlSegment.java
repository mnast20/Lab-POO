package lab7.task1.text;

import lab7.task1.visitor.DocumentVisitor;

public class UrlSegment extends TextSegment {
    private final String url;
    private final String description;

    public UrlSegment(String url, String description) {
        super(null);
        this.url = url;
        this.description = description;
    }

    // for part 1 of task 1
    public StringBuilder accept(DocumentVisitor document) {
        return document.visit(this);
    }

    public StringBuilder DokuWikiFormat() {
        StringBuilder result = new StringBuilder();
        result.append("[[");
        result.append(url);
        result.append("|");
        result.append(description);
        result.append("]]");
        return result;
    }

    public StringBuilder MarkDownFormat() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(description);
        result.append("](");
        result.append(url);
        result.append(")");
        return result;
    }
}
