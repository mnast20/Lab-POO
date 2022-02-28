package lab7.task1.visitor;

import lab7.task1.text.*;

import java.util.List;

public class DokuWikiVisitor implements DocumentVisitor {
    public StringBuilder visit(ItalicTextSegment italic) {
        return italic.DokuWikiFormat();
    }

    public StringBuilder visit(BoldTextSegment bold) {
        return bold.DokuWikiFormat();
    }

    public StringBuilder visit(UrlSegment url) {
        return url.DokuWikiFormat();
    }

    public StringBuilder visit(PlainTextSegment plain) {
        return plain.DokuWikiFormat();
    }

    // for part 2 of task 1
    public StringBuilder visit(TextSegment text) {
        if (text instanceof BoldTextSegment) {
            return ((BoldTextSegment) text).DokuWikiFormat();
        } else if (text instanceof ItalicTextSegment) {
            return ((ItalicTextSegment) text).DokuWikiFormat();
        } else if (text instanceof UrlSegment) {
            return ((UrlSegment) text).DokuWikiFormat();
        } else if (text instanceof PlainTextSegment) {
            return ((PlainTextSegment) text).DokuWikiFormat();
        }

        return null;
    }

    public StringBuilder getDocument(List<TextSegment> textSegments) {
        StringBuilder resultedString = new StringBuilder();

        // for part 1 of task 1
        for (TextSegment text: textSegments) {
            resultedString.append(text.accept(this));
        }

        resultedString.append("\nPart 2 of Task 1\n");

        // for part 2 of task 1
        for (TextSegment text: textSegments) {
            resultedString.append(visit(text));
        }

        return resultedString;
    }
}
