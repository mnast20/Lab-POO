package lab10.commands;

import lab10.diagram.DiagramComponent;

public class ChangeTextCommand implements DrawCommand {
    private final DiagramComponent diagram;
    private String previousText;
    private String newText;

    public ChangeTextCommand(DiagramComponent diagram, String newText) {
        this.diagram = diagram;
        this.newText = newText;
    }

    public void execute() {
        previousText = diagram.getText();

        diagram.setText(newText);
    }
    public void undo() {
        newText = previousText;
        execute();
    }

    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "ChangeTextCommand{" +
                "diagram=" + diagram +
                ", previousText='" + previousText + '\'' +
                ", newText='" + newText + '\'' +
                '}';
    }
}
