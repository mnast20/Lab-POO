package lab7.task1;

import lab7.task1.text.TextSegment;
import lab7.task1.visitor.DokuWikiVisitor;
import lab7.task1.visitor.MarkDownVisitor;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        return new DokuWikiVisitor().getDocument(textSegments);
    }

    public StringBuilder getMarkdownDocument() {
        return new MarkDownVisitor().getDocument(textSegments);
    }
}
