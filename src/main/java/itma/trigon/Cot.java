package itma.trigon;

public class Cot extends Sec {
    private final Cos cos;
    private final Sin sin;

    public Cot(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public double cot(double x) {
        double sin = this.sin.sin(x);
        double cos = this.cos.cos(x);
        if (sin == 0.0) return Double.NaN;
        return cos / sin;
    }
}
