package lab10.main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests

        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
        System.out.println();
    }

    private static void testTextAndColor(Client client) {
        if (client.getDiagramCanvas().getSize() == 0) {
            testDraw(client);
        }
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");

        client.showDiagram();
        System.out.println();
    }

    private static void testConnect(Client client) {
        if (client.getDiagramCanvas().getSize() == 0) {
            testDraw(client);
        }
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "2", "5");
        client.executeAction("draw rectangle");
        client.executeAction("connect", "3", "6");
        client.executeAction("connect", "4", "5");
        client.showDiagram();
        System.out.println();
    }

    private static void testResize(Client client) {
        if (client.getDiagramCanvas().getSize() == 0) {
            testDraw(client);
        }
        client.executeAction("resize", "0", "60");
        client.executeAction("resize", "1", "40");
        client.executeAction("resize", "2", "20");
        client.executeAction("resize", "4", "50");

        client.showDiagram();
        System.out.println();
    }

    private static void testAllCommands(Client client) {
        System.out.println("Test Draw Rectangle Command");
        testDraw(client);

        System.out.println("Test Change Text and Color Command");
        testTextAndColor(client);

        System.out.println("Test Connect Components Command");
        testConnect(client);

        System.out.println("Test Resize Command");
        testResize(client);
        System.out.println();
    }

    private static void testSimpleUndoRedo(Client client) {
        System.out.println("Test Simple Undo and Redo");
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        System.out.println("Test Undo of Draw Rectangle");
        client.undo();
        client.showDiagram();

        System.out.println("Test Redo of Draw Rectangle");
        client.redo();
        client.showDiagram();
        System.out.println();
    }

    private static void testComplexUndoRedo(Client client) {
        System.out.println("Test Complex Undo and Redo");
        System.out.println("Create multiple Rectangles:");
        client.newDiagram();
        testDraw(client);

        System.out.println("Change color and text");
        testTextAndColor(client);

        System.out.println("Test Redo for Nothing");
        client.redo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Undo of the Command 'Change text for Rectangle nr 5 to MyClass2'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Redo of the Command 'Change text for Rectangle nr 5 to MyClass2'");
        client.redo();
        client.showDiagram();
        System.out.println();

        System.out.println("Connect Components");
        testConnect(client);

        System.out.println("Test Undo of the Command 'Connect Rectangles 4 and 5'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Undo of the Command 'Connect Rectangles 3 and 6'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Redo of the Command 'Connect Rectangles 3 and 6'");
        client.redo();
        client.showDiagram();
        System.out.println();

        System.out.println("Resize rectangles");
        testResize(client);

        System.out.println("Test Undo of the Command 'Resize Rectangle 4 with a 50%'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Undo of the Command 'Resize Rectangle 2 with a 20%'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Redo of the Command 'Resize Rectangle 2 with a 20%'");
        client.redo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Undo of the Command 'Resize Rectangle 2 with a 20%'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Undo of the Command 'Resize Rectangle 1 with a 40%'");
        client.undo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Redo of the Command 'Resize Rectangle 1 with a 40%'");
        client.redo();
        client.showDiagram();
        System.out.println();

        System.out.println("Test Redo of the Command 'Resize Rectangle 2 with a 20%'");
        client.redo();
        client.showDiagram();
        System.out.println();
    }
}