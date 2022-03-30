
public class Triangle {
    private static double a;
    private static double b;
    private static double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static double getA() {
        return a;
    }

    public static double getB() {
        return b;
    }

    public static double getC() {
        return c;
    }

     static double square() {
        double p=((getA()+getB()+getC())/2);
        double square=Math.sqrt(p*(p-getB())*(p-getC())*(p-getA()));
        return square;
    }

}
