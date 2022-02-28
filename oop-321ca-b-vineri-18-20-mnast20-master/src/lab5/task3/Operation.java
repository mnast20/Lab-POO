package lab5.task3;

public class Operation implements Minus, Plus, Div, Mult {
    private float operand;

    public Operation(float operand) {
        this.operand = operand;
    }

    public float getNumber() {
        return operand;
    }

    public void minus(double operand2) {
        operand -= operand2;
    }

    public void plus(double operand2) {
        operand += operand2;
    }

    public void div(double operand2) {
        if (operand2 != 0) {
            operand /= operand2;
        }
    }

    public void mult(double operand2) {
        operand *= operand2;
    }
}
