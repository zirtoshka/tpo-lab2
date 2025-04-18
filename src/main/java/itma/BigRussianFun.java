package itma;

import itma.logari.Ln;
import itma.logari.Log;
import itma.trigon.*;

public class BigRussianFun {
    private final Sin sin;
    private final Cos cos;
    private final Sec sec;
    private final Cot cot;
    private final Csc csc;
    private final Tan tan;
    private final Ln ln;
    private final Log log;

    public BigRussianFun(Sin sin, Cos cos, Sec sec, Cot cot, Csc csc, Tan tan, Ln ln, Log log) {
        this.sin = sin;
        this.cos = cos;
        this.sec = sec;
        this.cot = cot;
        this.csc = csc;
        this.tan = tan;
        this.ln = ln;
        this.log = log;
    }

    public double calculate(double x) {
        if (x > 0) {
            return (Math.pow(log.log(x, 2) + log.log(x, 2), 3) * log.log(x, 2)
                    / Math.pow(ln.ln(x), 2))
                    * log.log(x, 5);
        } else {
            return
                    Math.pow((((sin.sin(x) + sec.sec(x)) / (cot.cot(x) - sec.sec(x)) - cot.cot(x)) - cos.cos(x)) / csc.csc(x)
                            - ((sec.sec(x) * (csc.csc(x) * sin.sin(x))) + tan.tan(x)), 3)
                            + Math.pow(csc.csc(x), 3);

        }
    }


}
