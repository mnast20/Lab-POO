package lab7.task1.text;

import lab7.task1.visitor.DocumentVisitor;

public class BoldTextSegment extends TextSegment {
    public BoldTextSegment(String content) {
        super(content);
    }

    public StringBuilder accept(DocumentVisitor document) {
        return document.visit(this);
    }

    public StringBuilder DokuWikiFormat() {
        StringBuilder result = new StringBuilder();
        result.append("**");
        result.append(this.getContent());
        result.append("**");
        return result;
    }

    public StringBuilder MarkDownFormat() {
        StringBuilder result = new StringBuilder();
        result.append("__");
        result.append(this.getContent());
        result.append("__");
        return result;
    }
}