package itma.trigon;


public class Cos {
    private final static double EPSILON = 1e-6;

    public double cos(double x) {
        if (Math.abs(x) < EPSILON) throw new IllegalArgumentException("x must be greater than epsilon");

        if (Double.isNaN(x) || Double.isInfinite(x)) return Double.NaN;


        x = Math.abs(x % Math.PI);
        double res = 1;
        int n = 1;
        double term = 1;

        do {
            term *= -x * x / ((n * 2) * (2 * n - 1));
            res += term;
            n++;
        } while (Math.abs(term) >= EPSILON );

        return res;
    }
}
