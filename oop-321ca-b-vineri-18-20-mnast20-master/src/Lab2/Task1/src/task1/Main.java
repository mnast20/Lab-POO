package task1;

public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex();

        Complex c2 = new Complex(2, 3);

        Complex c3 = new Complex();
        c3.setReal(1);
        c3.setImaginary(2);

        Complex c4 = new Complex(c2);

        // metode diferite de a printa numerele complexe
        c1.showNumber();

        // alt mod de a printa numarul complex prin intermediul unui getter
        if (c2.getImaginary() >= 0) {
            System.out.printf("Numar complex: %d + %di\n", c2.getReal(), c2.getImaginary());
        } else {
            System.out.printf("Numar Complex: %d + (%d)i\n", c2.getReal(), c2.getImaginary());
        }

        System.out.println(c3);

        c4.addWithComplex(c3);
        System.out.println(c4);
    }
}
