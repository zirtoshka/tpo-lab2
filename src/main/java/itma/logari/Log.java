package itma.logari;

public class Log {
    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double log(double x, double base) {
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
