package lab10.main;

import lab10.commands.*;
import lab10.diagram.DiagramCanvas;

/**
 * Receives commands in clear text from the user and transforms them in DrawCommand objects. It uses the Invoker to
 * execute the given commands.
 */
public class Client {

    private Invoker invoker;
    private DiagramCanvas diagramCanvas;

    Client() {
        invoker = new Invoker();
        diagramCanvas = new DiagramCanvas();
    }

    public void showDiagram() {
        diagramCanvas.show();
    }

    public void newDiagram() {
        diagramCanvas = new DiagramCanvas();
    }

    public void executeAction(String commandName, String ...args) {
        DrawCommand command;
        try {
            CommandType commandType = CommandType.fromString(commandName);
            command = getCommand(commandType, args);
            if (command == null) {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException ex) {
            System.out.println("Invalid command: " + commandName);
            System.out.println("Available commands:");
            for (CommandType type : CommandType.values()) {
                System.out.println("\t- " + type.text);
            }
            return;
        }

        invoker.execute(command);
    }

    private DrawCommand getCommand(CommandType type, String ...args) throws IllegalArgumentException {
        // If there is an exception when parsing the string arguments (NumberFormatException) catch it and
        // throw an IllegalArgumentException

        try {
            return switch (type) {
                case DRAW_RECTANGLE -> new DrawRectangleCommand(diagramCanvas);
                case CHANGE_COLOR -> new ChangeColorCommand(diagramCanvas.getComponent(Integer.parseInt(args[0])), args[1]);
                case RESIZE -> new ResizeCommand(diagramCanvas.getComponent(Integer.parseInt(args[0])), Integer.parseInt(args[1]));
                case CONNECT -> new ConnectComponentsCommand(diagramCanvas.getComponent(Integer.parseInt(args[0])), diagramCanvas.getComponent(Integer.parseInt(args[1])), args[0], args[1]);
                case CHANGE_TEXT -> new ChangeTextCommand(diagramCanvas.getComponent(Integer.parseInt(args[0])), args[1]);
            };
        } catch(NumberFormatException ex) {
            System.out.println("Invalid command: " + type.text);
            System.out.println("The conversion from String to Integer is not possible");
            return null;
        }
    }

    public void undo(){
        invoker.undo();
    }

    public void redo() {
        invoker.redo();
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public DiagramCanvas getDiagramCanvas() {
        return diagramCanvas;
    }
}