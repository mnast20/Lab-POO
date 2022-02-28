package lab7.task1.text;

import lab7.task1.visitor.DocumentVisitor;

public class PlainTextSegment extends TextSegment {
    public PlainTextSegment(String content) {
        super(content);
    }

    public StringBuilder accept(DocumentVisitor document) {
        return document.visit(this);
    }

    public StringBuilder DokuWikiFormat() {
        StringBuilder result = new StringBuilder();
        result.append(this.getContent());
        return result;
    }

    public StringBuilder MarkDownFormat() {
        StringBuilder result = new StringBuilder();
        result.append(this.getContent());
        return result;
    }
}