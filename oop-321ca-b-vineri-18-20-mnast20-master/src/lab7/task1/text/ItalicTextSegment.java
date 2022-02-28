package lab7.task1.text;

import lab7.task1.visitor.DocumentVisitor;

public class ItalicTextSegment extends TextSegment {
    public ItalicTextSegment(String content) {
        super(content);
    }

    public StringBuilder accept(DocumentVisitor document) {
        return document.visit(this);
    }

    public StringBuilder DokuWikiFormat() {
        StringBuilder result = new StringBuilder();
        result.append("//");
        result.append(this.getContent());
        result.append("//");
        return result;
    }

    public StringBuilder MarkDownFormat() {
        StringBuilder result = new StringBuilder();
        result.append("_");
        result.append(this.getContent());
        result.append("_");
        return result;
    }
}
