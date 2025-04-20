package itma;

import itma.logari.Ln;
import itma.trigon.Cos;
import itma.trigon.Csc;
import itma.trigon.Sec;
import itma.trigon.Sin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FunTest {
    private static final double DELTA = 0.05;


    static Stream<Double> dataSinTestCases() {
        return Stream.of(
                0.0,            // sin(0) = 0
                Math.PI / 2,      // sin(π/2) = 1
                -Math.PI / 2,     // sin(-π/2) = -1
                Math.PI / 3,      // 1 четверть
                2 * Math.PI / 3,    // 2 четверть
                4 * Math.PI / 3,    // 3 четверть
                -Math.PI / 3,     // 4 четверть
                Math.PI,        // sin(π) = 0
                -Math.PI        // sin(-π) = 0
        );
    }

    static Stream<Double> dataSecTestCases() {
        return Stream.of(
                0.0,            // cos(x) = 1
                Math.PI,        // cos(x) = -1
                Math.PI / 3,      // 1 четверть
                2 * Math.PI / 3,    // 2 четверть
                -2 * Math.PI / 3,    // 3 четверть
                -Math.PI / 3,     // 4 четверть
                Math.PI / 2 - 0.1, // Близко к точке разрыва справа
                -Math.PI / 2 + 0.1 // Близко к точке разрыва слева
        );
    }


    static Stream<Double> dataCscTestCases() {
        return Stream.of(
                Math.PI/2,      // sin(x) = 1
                -Math.PI/2,     // sin(x) = -1
                Math.PI / 3,      // 1 четверть
                2 * Math.PI / 3,    // 2 четверть
                -2 * Math.PI / 3,    // 3 четверть
                -Math.PI / 3,     // 4 четверть
                Math.PI  - 0.1, // Близко к точке разрыва справа
                -Math.PI  + 0.1 // Близко к точке разрыва слева
        );
    }

    static Stream<Double> dataCotTestCases() {
        return Stream.of(
                Math.PI/2,      // cot(x) = 0
                Math.PI / 3,      // 1 четверть
                2 * Math.PI / 3,    // 2 четверть
                -2 * Math.PI / 3,    // 3 четверть
                -Math.PI / 3,     // 4 четверть
                Math.PI  - 0.1, // Близко к точке разрыва справа
                -Math.PI  + 0.1 // Близко к точке разрыва слева
        );
    }

    static Stream<Double> dataLogTestCases() {
        return Stream.of(
                0.1,            // 0 < x < 1
                0.5,            // 0 < x < 1
                1.0,            // x = 1, log(1) = 0
                2.0,            // x > 1
                10.0,           // x > 1 (далеко от 1)
                0.01,           // Близко к 0
                -1.0,           // Отрицательное число
                0.0             // Точка разрыва
        );
    }

    private double cosStubTableValue(double x) {
        return Math.cos(x);
    }

    private double sinStubTableValue(double x) {
        return Math.sin(x);
    }

    @ParameterizedTest
    @MethodSource("dataSinTestCases")
    @DisplayName("Тестирование cos(x)")
    void testCos(double x) {

        Cos cos = new Cos();
        double result = cos.cos(x);
        double expected = Math.cos(x);

        assertEquals(expected, result, DELTA);
    }


    @ParameterizedTest
    @MethodSource("dataLogTestCases")
    @DisplayName("Тестирование ln(x)")
    void testLn(double x) {

        Ln ln = new Ln();
        double result = ln.ln(x);
        double expected = Math.log(x);

        assertEquals(expected, result, DELTA);
    }


    @ParameterizedTest
    @MethodSource("dataSinTestCases")
    @DisplayName("Тестирование sin(x)")
    void testSin(double x) {
        Cos cos = mock(Cos.class);
        when(cos.cos(x)).thenReturn(cosStubTableValue(x));

        Sin sin = new Sin(cos);
        double result = sin.sin(x);
        double expected = Math.sin(x);

        assertEquals(expected, result, DELTA);
    }


    @ParameterizedTest
    @MethodSource("dataSecTestCases")
    @DisplayName("Тестирование sec(x)")
    void testSec(double x) {
        Cos cos = mock(Cos.class);
        when(cos.cos(x)).thenReturn(cosStubTableValue(x));

        Sec sec = new Sec(cos);
        double result = sec.sec(x);
        double expected = 1 / Math.cos(x);

        assertEquals(expected, result, DELTA);
    }


    @ParameterizedTest
    @MethodSource("dataCscTestCases")
    @DisplayName("Тестирование csc(x)")
    void testCsc(double x) {
        Sin sin = mock(Sin.class);
        when(sin.sin(x)).thenReturn(sinStubTableValue(x));

        Csc csc = new Csc(sin);
        double result = csc.csc(x);
        double expected = 1 / Math.sin(x);

        assertEquals(expected, result, DELTA);
    }



}
