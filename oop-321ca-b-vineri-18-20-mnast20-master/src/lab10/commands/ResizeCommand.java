package lab10.commands;

import lab10.diagram.DiagramComponent;

public class ResizeCommand implements DrawCommand {
    private final DiagramComponent diagram;
    private int previousHeight;
    private int previousWidth;
    private int newHeight;
    private int newWidth;

    public ResizeCommand(DiagramComponent diagram, int newPercent) {
        this.diagram = diagram;
        this.newHeight = diagram.getHeight() - ((newPercent * diagram.getHeight()) / 100);
        this.newWidth = diagram.getWeight() - ((newPercent * diagram.getWeight()) / 100);
    }

    public void execute() {
        previousHeight = diagram.getHeight();
        previousWidth = diagram.getWeight();

        diagram.setHeight(newHeight);
        diagram.setWeight(newWidth);
    }
    public void undo() {
        newWidth = previousWidth;
        newHeight = previousHeight;

        execute();
    }

    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "ResizeCommand{" +
                "diagram=" + diagram +
                ", previousHeight=" + previousHeight +
                ", previousWidth=" + previousWidth +
                ", newHeight=" + newHeight +
                ", newWidth=" + newWidth +
                '}';
    }
}
