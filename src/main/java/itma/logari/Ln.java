package itma.logari;

public class Ln {
    private final static double EPSILON = 1e-6;

    public double ln(double x) {
        if (x <= 0.0 || Double.isNaN(x)) return Double.NaN;

        if (Double.isInfinite(x)) return Double.POSITIVE_INFINITY;

        if (x == 1) return 0;


        double t = (x - 1) / (x + 1);
        double tSquared = t * t;
        double factor = 1 - tSquared;
        double term = t;
        double sum = term;
        int n = 1;

        while (true) {
            term *= tSquared * (2 * n - 1) / (2 * n + 1);
            if (Math.abs(term) < EPSILON * factor) {
                break;
            }
            sum += term;
            n++;
        }

        return 2 * sum;
    }
}
