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
            // Начинаем с вычислений для x <= 0 и добавляем принты
            double sinValue = sin.sin(x);
            System.out.println("sin.sin(x): " + sinValue);

            double secValue = sec.sec(x);
            System.out.println("sec.sec(x): " + secValue);

            double cotValue = cot.cot(x);
            System.out.println("cot.cot(x): " + cotValue);

            double cosValue = cos.cos(x);
            System.out.println("cos.cos(x): " + cosValue);

            double cscValue = csc.csc(x);
            System.out.println("csc.csc(x): " + cscValue);

            double tanValue = tan.tan(x);
            System.out.println("tan.tan(x): " + tanValue);

            // Преобразуем и выводим промежуточные результаты
            double part1 = (sinValue + secValue) / (cotValue - secValue);
            System.out.println("Part1 (sin(x) + sec(x)) / (cot(x) - sec(x)): " + part1);

            double part2 = part1 - cotValue;
            System.out.println("Part2 (Part1 - cot(x)): " + part2);

            double part3 = part2 - cosValue;
            System.out.println("Part3 (Part2 - cos(x)): " + part3);

            double part4 = part3 / cscValue;
            System.out.println("Part4 (Part3 / csc(x)): " + part4);

            double part5 = secValue * cscValue * sinValue + tanValue;
            System.out.println("Part5 (sec(x) * csc(x) * sin(x) + tan(x)): " + part5);

            double part6 = Math.pow(part4 - part5, 3);
            System.out.println("Part6 (Math.pow(Part4 - Part5, 3)): " + part6);

            double part7 = Math.pow(cscValue, 3);
            System.out.println("Part7 (Math.pow(csc(x), 3)): " + part7);

            double part8 = cscValue * (cscValue - cotValue);
            System.out.println("Part8 (csc(x) * (csc(x) - cot(x))): " + part8);

            double part9 = part8 / tanValue;
            System.out.println("Part9 (Part8 / tan(x)): " + part9);

            double part10 = part9 * sinValue;
            System.out.println("Part10 (Part9 * sin(x)): " + part10);

            double part11 = sinValue - (sinValue + cscValue);
            System.out.println("Part11 (sin(x) - (sin(x) + csc(x))): " + part11);

            double part12 = (cotValue / secValue) / secValue;
            System.out.println("Part12 ((cot(x) / sec(x)) / sec(x)): " + part12);

            double part13 = part11 + part12;
            System.out.println("Part13 (Part11 + Part12): " + part13);

            double part14 = (part10 - part13) / tanValue;
            System.out.println("Part14 ((Part10 - Part13) / tan(x)): " + part14);

            double part15 = secValue / secValue;
            System.out.println("Part15 (sec(x) / sec(x)): " + part15);

            // Финальный результат
            double finalResult = part6 + part7 * part14 - part15;
            System.out.println("Final result: " + finalResult);
            return finalResult;
        }
//            return
//
//                    ( Math.pow(
//                            (
//                                    (
//                                            (
//                                                    (sin.sin(x) + sec.sec(x)) /
//                                                            (cot.cot(x) - sec.sec(x))
//                                            )
//                                                    - cot.cot(x)
//                                    )
//                                            - cos.cos(x)
//                            )
//                                    / csc.csc(x)
//                                    - (
//                                    sec.sec(x) * csc.csc(x) * sin.sin(x) + tan.tan(x)
//                            ),
//                            3
//                    )
//                            + Math.pow(csc.csc(x), 3))
//                            * (
//                            (
//                                    (
//                                            (
//                                                    (csc.csc(x) * (csc.csc(x) - cot.cot(x)))
//                                                            / tan.tan(x)
//                                            )
//                                                    * sin.sin(x)
//                                                    - (
//                                                    (sin.sin(x) - (sin.sin(x) + csc.csc(x)))
//                                                            + (
//                                                            (cot.cot(x) / sec.sec(x)) / sec.sec(x)
//                                                    )
//                                            )
//                                    )
//                                            / tan.tan(x)
//                            )
//                    )
//                            - (sec.sec(x) / sec.sec(x));
//
//        }
    }


}
