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

public class BigRussianFunTest {

    private static Stream<Arguments> dataVerch() {
        return Stream.of(
                Arguments.of(-5.83, 2.796473, 0.001),
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
                Arguments.of(-5.677, 12.6077905614222),
                Arguments.of(-5.68911, 9.47714),
                Arguments.of(-5.7, 10.02264),
                Arguments.of(-5.71376, 10.506940335946569),
                Arguments.of(-5.2,-200.18953417835803 ),
                Arguments.of(-5.1,-206.25203913651316 ),
                Arguments.of(-5.17242, -199.27431027756137),
                Arguments.of(-4.1, -4.1614),
                Arguments.of(-4.0494, 0),
                Arguments.of(-3.83211, -0.005),
                Arguments.of(-3.8294, -7.1617),
                Arguments.of(-2.4,6.1315 ),
                Arguments.of(-0.4, -4.57382),
                Arguments.of(-0.297, 7.23264),

                Arguments.of( -3.70794, 270.07051),
                Arguments.of(-3.73, 281.84591),
                Arguments.of(  -3.68,   282.80652),


                Arguments.of(0.8, -0.23926),
                Arguments.of(1, Double.NaN),
                Arguments.of(1.1, 0.018644)

        );
    }

    @ParameterizedTest
    @MethodSource("dataVerch")
    @DisplayName("Интеграционный тест: уровень 1 (всё мокано)")
    void testAllMock(double x, double expected) {
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
                "sin", FunctionCsvLoader.loadFunctionValues("output_sin"),
                "cos", FunctionCsvLoader.loadFunctionValues("cos"),
                "sec", FunctionCsvLoader.loadFunctionValues("sec"),
                "cot", FunctionCsvLoader.loadFunctionValues("cot"),
                "csc", FunctionCsvLoader.loadFunctionValues("csc"),
                "tan", FunctionCsvLoader.loadFunctionValues("tan"),
                "log2", FunctionCsvLoader.loadFunctionValues("log2"),
                "log5", FunctionCsvLoader.loadFunctionValues("log5"),
                "ln", FunctionCsvLoader.loadFunctionValues("ln")
        );
        if (x <= 0) {
            FunctionMocker.mockUnaryFunction(sin, functionValues.get("sin"), Sin::sin);
            FunctionMocker.mockUnaryFunction(cos, functionValues.get("cos"), Cos::cos);
            FunctionMocker.mockUnaryFunction(sec, functionValues.get("sec"), Sec::sec);
            FunctionMocker.mockUnaryFunction(cot, functionValues.get("cot"), Cot::cot);
            FunctionMocker.mockUnaryFunction(csc, functionValues.get("csc"), Csc::csc);
            FunctionMocker.mockUnaryFunction(tan, functionValues.get("tan"), Tan::tan);
        } else {
            FunctionMocker.mockUnaryFunction(log2, functionValues.get("log2"), Log::log);
            FunctionMocker.mockUnaryFunction(log5, functionValues.get("log5"), Log::log);
            FunctionMocker.mockUnaryFunction(ln, functionValues.get("ln"), Ln::ln);
        }

        BigRussianFun func = new BigRussianFun(sin, cos, sec, cot, csc, tan, ln, log2, log5);
        double result = func.calculate(x);

        assertEquals(expected, result, 1e-1);
    }


    @ParameterizedTest
    @MethodSource("dataVerch")
    @DisplayName("Интеграционный тест: 2 уровень mock / tan, cot, csc ")
    void test2l(double x, double expected) {
        Cos cos = mock(Cos.class);
        Sin sin = mock(Sin.class);
        Sec sec = mock(Sec.class);

        Tan tan = new Tan(cos, sin);
        Cot cot = new Cot(cos, sin);
        Csc csc=new Csc(sin);

        Ln ln = mock(Ln.class);
        Log log2 = mock(Log.class);
        Log log5 = mock(Log.class);

        Map<String, Map<Double, Double>> functionValues = Map.of(
                "sin", FunctionCsvLoader.loadFunctionValues("output_sin"),
                "cos", FunctionCsvLoader.loadFunctionValues("cos"),
                "sec", FunctionCsvLoader.loadFunctionValues("sec"),
                "log2", FunctionCsvLoader.loadFunctionValues("log2"),
                "log5", FunctionCsvLoader.loadFunctionValues("log5"),
                "ln", FunctionCsvLoader.loadFunctionValues("ln")
        );

        if (x <= 0) {
            FunctionMocker.mockUnaryFunction(sin, functionValues.get("sin"), Sin::sin);
            FunctionMocker.mockUnaryFunction(cos, functionValues.get("cos"), Cos::cos);
            FunctionMocker.mockUnaryFunction(sec, functionValues.get("sec"), Sec::sec);
        } else {
            FunctionMocker.mockUnaryFunction(log2, functionValues.get("log2"), Log::log);
            FunctionMocker.mockUnaryFunction(log5, functionValues.get("log5"), Log::log);
            FunctionMocker.mockUnaryFunction(ln, functionValues.get("ln"), Ln::ln);
        }

        BigRussianFun func = new BigRussianFun(sin, cos, sec, cot, csc, tan, ln, log2, log5);
        double result = func.calculate(x);

        assertEquals(expected, result, 1e-2);
    }



    @ParameterizedTest
    @MethodSource("dataVerch")
    @DisplayName("Интеграционный тест: 2 уровень mock / tan, cot, csc + sin, sec, log ")
    void test3l(double x, double expected) {
        Cos cos = mock(Cos.class);

        Sin sin =new Sin(cos);
        Sec sec =new Sec(cos);

        Tan tan = new Tan(cos, sin);
        Cot cot = new Cot(cos, sin);
        Csc csc=new Csc(sin);

        Ln ln = mock(Ln.class);

        Log log2 = new Log(ln, 2);
        Log log5 = new Log(ln, 5);

        Map<String, Map<Double, Double>> functionValues = Map.of(
                "cos", FunctionCsvLoader.loadFunctionValues("cos"),
                "ln", FunctionCsvLoader.loadFunctionValues("ln")
        );

        if (x <= 0) {
            FunctionMocker.mockUnaryFunction(cos, functionValues.get("cos"), Cos::cos);
        } else {
            FunctionMocker.mockUnaryFunction(ln, functionValues.get("ln"), Ln::ln);
        }

        BigRussianFun func = new BigRussianFun(sin, cos, sec, cot, csc, tan, ln, log2, log5);
        double result = func.calculate(x);

        assertEquals(expected, result, 1e-2);
    }


    @ParameterizedTest
    @MethodSource("dataVerch")
    @DisplayName("Интеграционный тест: 2 уровень cos, ln + tan, cot, csc + sin, sec, log ")
    void test4l(double x, double expected) {
        Cos cos = new Cos();

        Sin sin =new Sin(cos);
        Sec sec =new Sec(cos);

        Tan tan = new Tan(cos, sin);
        Cot cot = new Cot(cos, sin);
        Csc csc=new Csc(sin);

        Ln ln = new Ln();

        Log log2 = new Log(ln, 2);
        Log log5 = new Log(ln, 5);


        BigRussianFun func = new BigRussianFun(sin, cos, sec, cot, csc, tan, ln, log2, log5);
        double result = func.calculate(x);

        assertEquals(expected, result, 1e-2);
    }
}
