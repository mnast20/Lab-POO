package lab10.commands;

import lab10.diagram.DiagramComponent;

public class ConnectComponentsCommand implements DrawCommand {
    DiagramComponent diagram;
    String diagramId;
    DiagramComponent newlyConnectedComponent;
    String newlyConnectedComponentId;

    public ConnectComponentsCommand(DiagramComponent diagram, DiagramComponent newlyConnectedComponent, String diagramId, String newlyConnectedComponentId) {
        this.diagram = diagram;
        this.newlyConnectedComponent = newlyConnectedComponent;
        this.diagramId = diagramId;
        this.newlyConnectedComponentId = newlyConnectedComponentId;
    }

    public void execute() {
        diagram.connectTo(newlyConnectedComponentId);
        newlyConnectedComponent.connectTo(diagramId);
    }
    public void undo() {
        diagram.removeConnection(newlyConnectedComponentId);
        newlyConnectedComponent.removeConnection(diagramId);
    }

    public void redo() {
        execute();
    }

    @Override
    public String toString() {
        return "ConnectComponentsCommand{" +
                "diagram=" + diagram +
                ", diagramId='" + diagramId + '\'' +
                ", newlyConnectedComponent=" + newlyConnectedComponent +
                ", newlyConnectedComponentId='" + newlyConnectedComponentId + '\'' +
                '}';
    }
}
