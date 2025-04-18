package itma.trigon;

public class Tan {
    private final Cos cos;
    private final Sin sin;

    public Tan(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public double cot(double x) {
        double sin = this.sin.sin(x);
        double cos = this.cos.cos(x);
        if (cos == 0.0) return Double.NaN;
        return sin / cos;
    }
}
