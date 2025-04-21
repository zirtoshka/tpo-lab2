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
    private final Log log2;
    private final Log log5;

    public BigRussianFun(Sin sin, Cos cos, Sec sec, Cot cot, Csc csc, Tan tan, Ln ln, Log log2, Log log5) {
        this.sin = sin;
        this.cos = cos;
        this.sec = sec;
        this.cot = cot;
        this.csc = csc;
        this.tan = tan;
        this.ln = ln;
        this.log2 = log2;
        this.log5 = log5;
    }

    public double calculate(double x) {
        if (x > 0) {
            return (Math.pow(log2.log(x) + log2.log(x), 3) * log2.log(x)
                    / Math.pow(ln.ln(x), 2))
                    * log5.log(x);
        } else {
            return

                    ( Math.pow(
                            (
                                    (
                                            (
                                                    (sin.sin(x) + sec.sec(x)) /
                                                            (cot.cot(x) - sec.sec(x))
                                            )
                                                    - cot.cot(x)
                                    )
                                            - cos.cos(x)
                            )
                                    / csc.csc(x)
                                    - (
                                    sec.sec(x) * csc.csc(x) * sin.sin(x) + tan.tan(x)
                            ),
                            3
                    )
                            + Math.pow(csc.csc(x), 3))
                            * (
                            (
                                    (
                                            (
                                                    (csc.csc(x) * (csc.csc(x) - cot.cot(x)))
                                                            / tan.tan(x)
                                            )
                                                    * sin.sin(x)
                                                    - (
                                                    (sin.sin(x) - (sin.sin(x) + csc.csc(x)))
                                                            + (
                                                            (cot.cot(x) / sec.sec(x)) / sec.sec(x)
                                                    )
                                            )
                                    )
                                            / tan.tan(x)
                            )
                    )
                            - (sec.sec(x) / sec.sec(x));

        }
    }


}
