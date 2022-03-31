
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

     static double square() throws ObjectIsNotTriangleException, NullPointerException {

        if((a<=0||b<=0||c<=0) || (a+b<=c||a+c<=b||c+b<=a)) {
            throw new ObjectIsNotTriangleException();
        }
        double p=((getA()+getB()+getC())/2);
        double square=Math.sqrt(p*(p-getB())*(p-getC())*(p-getA()));

        return square;
    }

}
