package itma.trigon;


public class Cos {

    public double cos(double x, double epsilon) {
        if (Math.abs(x) < epsilon) throw new IllegalArgumentException("x must be greater than epsilon");

        if (Double.isNaN(x) || Double.isInfinite(x)) return Double.NaN;


        x = Math.abs(x % Math.PI);

        double res = 1;
        int n = 1;
        double term = 1;

        do {
            term *= -x * x / ((n * 2) * (2 * n - 1));
        } while (Math.abs(term) >= epsilon);

        return res;
    }
}
