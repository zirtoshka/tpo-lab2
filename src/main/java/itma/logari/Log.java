package itma.logari;

public class Log {
    private final Ln ln;
    private final double base;

    public Log(Ln ln, double base) {
        this.ln = ln;
        this.base = base;
    }

    public double log(double x) {
        if (base <= 0 || base == 1) return Double.NaN;

        double lnX = ln.ln(x);

        if (lnX == 0.0) {
            return 0;
        }

        if (lnX == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }

        if (Double.isNaN(lnX)) {
            return Double.NaN;
        }

        return lnX / ln.ln(base);


    }
}
