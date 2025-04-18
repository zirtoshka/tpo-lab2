package itma.trigon;

public class Sec {
    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double sec(double x) {
        double cos = this.cos.cos(x);
        if (cos == 0) return Double.NaN;
        return 1 / cos;
    }
}
