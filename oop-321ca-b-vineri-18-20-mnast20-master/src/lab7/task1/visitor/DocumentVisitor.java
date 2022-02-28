package lab7.task1.visitor;

import lab7.task1.text.*;

import java.util.List;

public interface DocumentVisitor {
    StringBuilder visit(ItalicTextSegment italic);

    StringBuilder visit(BoldTextSegment bold);

    StringBuilder visit(UrlSegment bold);

    StringBuilder visit(PlainTextSegment plain);

    /**
     * I know that using instanceof can be considered bad practice, but I wasn't
     * sure what the second part of the first task was requesting, so this was my approach.
     * The accept methods from the Text Segment subclasses are treated here as nonexistent,
     * they are ignored. In the case of the missing accept commands, the document visitor
     * will try to visit and format the requested Text Segment, but since the two formatting
     * functions in every Text Segment class are not abstract/overridden (they could however be
     * made abstract/overridden but not much would have changed from using accept). In consequence,
     * in order to get the proper formatting, the visitor needs to check the Text Segment instance.
     */
    StringBuilder visit(TextSegment text);

    /**
     * I also changed the getDocument method in order to append both resulted strings from each approach:
     * first, the better one, using the accept methods within the TextSegments, and the second one will
     * correspond to the second part of the first task
     */
    StringBuilder getDocument(List<TextSegment> textSegments);
}
