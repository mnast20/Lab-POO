package lab7.task1.text;

import lab7.task1.visitor.DocumentVisitor;

public abstract class TextSegment {
    private final String content;

    public TextSegment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // for part 1 of task 1, this method will be ignored by the second part of the task
    public abstract StringBuilder accept(DocumentVisitor document);
}
