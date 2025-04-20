package itma;

import itma.logari.Ln;
import itma.logari.Log;
import itma.trigon.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BigRussianFunTest {
    private static final double DELTA = 0.05;

    private static Stream<Arguments> dataVerch() {
        return Stream.of(
                Arguments.of(-5.83, 2.796473),
                Arguments.of(-5.82153, 2.692847),
                Arguments.of(-5.81, 2.87352),
                Arguments.of(-3.91936, 7.50131),
                Arguments.of(-3.9, 7.11106),
                Arguments.of(-3.93, 7.40293),
                Arguments.of(-3.84936, 3.17231),
                Arguments.of(-3.856, 3.40686),
                Arguments.of(-3.848, 3.18313),
                Arguments.of(-3.83947, 3.52517),
                Arguments.of(-3.84, 3.52006),
                Arguments.of(-3.839, 3.52056),
                Arguments.of(-2.07218, -1.86934),
                Arguments.of(-2.28184, 0),
                Arguments.of(-2, -1.78838),
                Arguments.of(-1.5708, -1),
                Arguments.of(-1, -1.70069),
                Arguments.of(-0.44865, -5.03692),
                Arguments.of(-0.33146, 0),


                Arguments.of(0.8, -0.23926),
                Arguments.of(1, 0),
                Arguments.of(1.1, 0.018644)

        );
    }


    @ParameterizedTest
    @MethodSource("dataVerch")
    @DisplayName("Интеграционный тест: уровень 1 (всё мокано)")
    void test1l(double x, double expected) {
        Cos cos = mock(Cos.class);
        Sin sin = mock(Sin.class);
        Sec sec = mock(Sec.class);
        Cot cot = mock(Cot.class);
        Csc csc = mock(Csc.class);
        Tan tan = mock(Tan.class);

        Ln ln = mock(Ln.class);
        Log log2 = mock(Log.class);
        Log log5 = mock(Log.class);

        Map<String, Map<Double, Double>> functionValues = Map.of(
                "sin", FunctionCsvLoader.loadFunctionValues("sin")
        );

        if (x <= 0) {
            FunctionMocker.mockUnaryFunction(sin, functionValues.get("sin"), Sin::sin);
            when(cos.cos(x)).thenReturn(0.866);
            when(sec.sec(x)).thenReturn(1 / 0.866);
            when(cot.cot(x)).thenReturn(1.732);
            when(csc.csc(x)).thenReturn(1 / 0.5);
            when(tan.tan(x)).thenReturn(0.577);
        } else {
            when(log2.log(x)).thenReturn(Math.log(x) / Math.log(2));
            when(log5.log(x)).thenReturn(Math.log(x) / Math.log(5));
            when(ln.ln(x)).thenReturn(Math.log(x));
        }

        BigRussianFun func = new BigRussianFun(sin, cos, sec, cot, csc, tan, ln, log2, log5);
        double result = func.calculate(x);

        System.out.println("x = " + x + ", result = " + result + ", expected = " + expected);

        assertEquals(expected, result, 1e-4);
    }

}
