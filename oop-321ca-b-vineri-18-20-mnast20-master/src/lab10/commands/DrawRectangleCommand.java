package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class DrawRectangleCommand implements DrawCommand {
    private DiagramCanvas canvas;
    private DiagramComponent diagram;

    public DrawRectangleCommand(DiagramCanvas canvas) {
        this.canvas = canvas;
    }

    public void execute() {
        diagram = new DiagramComponent();
        canvas.addComponent(diagram);
    }
    public void undo() {
        canvas.removeComponent(diagram);
    }

    public void redo() {
        execute();
    }

    @Override
    public String toString() {
        return "DrawRectangleCommand{" +
                "canvas=" + canvas +
                ", diagram=" + diagram +
                '}';
    }
}
