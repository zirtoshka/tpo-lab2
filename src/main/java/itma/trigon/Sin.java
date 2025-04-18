package itma.trigon;

public class Sin {
    private final Cos cos;

    public Sin(Cos cos) {
        this.cos = cos;
    }

    public double sin(double x) {
        double cos = this.cos.cos(x);
        if (Double.isNaN(cos)) return Double.NaN;

        double sin = Math.sqrt(1 - cos * cos);

        if (sin == 0) return sin;

        x = x % (Math.PI * 2);

        if (-Math.PI <= x && x <= 0 ||
                Math.PI <= x && x <= 2 * Math.PI) {
            sin *= -1;
        }

        return sin;
    }
}
