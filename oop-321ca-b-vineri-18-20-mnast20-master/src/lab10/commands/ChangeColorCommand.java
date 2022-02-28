package lab10.commands;

import lab10.diagram.DiagramComponent;

public class ChangeColorCommand implements DrawCommand {
    private final DiagramComponent diagram;
    private String previousColor;
    private String newColor;

    public ChangeColorCommand(DiagramComponent diagram, String newColor) {
        this.diagram = diagram;
        this.newColor = newColor;
    }

    public void execute() {
        previousColor = diagram.getColor();

        diagram.setColor(newColor);
    }
    public void undo() {
        newColor = previousColor;

        execute();
    }

    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "ChangeColorCommand{" +
                "diagram=" + diagram +
                ", previousColor='" + previousColor + '\'' +
                ", newColor='" + newColor + '\'' +
                '}';
    }
}
