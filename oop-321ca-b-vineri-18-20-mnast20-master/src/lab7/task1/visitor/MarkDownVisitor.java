package lab7.task1.visitor;

import lab7.task1.text.*;

import java.util.List;

public class MarkDownVisitor implements DocumentVisitor {
    public StringBuilder visit(ItalicTextSegment italic) {
        return italic.MarkDownFormat();
    }

    public StringBuilder visit(BoldTextSegment bold) {
        return bold.MarkDownFormat();
    }

    public StringBuilder visit(UrlSegment url) {
        return url.MarkDownFormat();
    }

    public StringBuilder visit(PlainTextSegment plain) {
        return plain.MarkDownFormat();
    }

    // for part 2 of task 1
    public StringBuilder visit(TextSegment text) {
        if (text instanceof BoldTextSegment) {
            return ((BoldTextSegment) text).MarkDownFormat();
        } else if (text instanceof ItalicTextSegment) {
            return ((ItalicTextSegment) text).MarkDownFormat();
        } else if (text instanceof UrlSegment) {
            return ((UrlSegment) text).MarkDownFormat();
        } else if (text instanceof PlainTextSegment) {
            return ((PlainTextSegment) text).MarkDownFormat();
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
