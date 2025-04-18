package itma.trigon;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x) {
        double sin = this.sin.sin(x);
        if (sin == 0) return Double.NaN;
        return 1 / sin;
    }
}
