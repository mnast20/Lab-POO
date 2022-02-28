package task1;

public class Complex {
    private int real, imaginary;

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex c) {
        this.real = c.real;
        this.imaginary = c.imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void addWithComplex(Complex c) {
        this.real += c.real;
        this.imaginary += c.imaginary;
    }

    @Override
    public String toString() {
        return "Numar complex " +
                "cu partea reala = " + real +
                " si cu partea imaginara = " + imaginary;
    }

    public void showNumber() {
        System.out.println(this);
    }
}
