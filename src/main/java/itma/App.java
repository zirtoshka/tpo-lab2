package itma;

import itma.logari.Ln;
import itma.logari.Log;
import itma.trigon.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        Ln ln = new Ln();
        Sec sec = new Sec(cos);
        Csc csc = new Csc(sin);
        Cot cot = new Cot(cos, sin);
        Tan tan = new Tan(cos, sin);
        Log log2 =new Log(ln, 2);
        Log log5 =new Log(ln, 5);

        BigRussianFun systemFunction = new BigRussianFun(sin,cos,sec,cot,csc,tan, ln, log2,log5);

        System.out.println(systemFunction.calculate(-5));
        writeFunctionToCSV("cos.csv", cos::cos, -2 * Math.PI, 2 * Math.PI);
        writeFunctionToCSV("sin.csv", sin::sin, -2 * Math.PI, 2 * Math.PI);
        writeFunctionToCSV("ln.csv", ln::ln, 0.1, 10);
        writeFunctionToCSV("sec.csv", sec::sec, -2 * Math.PI, 2 * Math.PI);
        writeFunctionToCSV("csc.csv", csc::csc, -2 * Math.PI + X_STEP, 2 * Math.PI);
        writeFunctionToCSV("cot.csv", cot::cot, -2 * Math.PI + X_STEP, 2 * Math.PI);
        writeFunctionToCSV("tan.csv", tan::tan, -2 * Math.PI, 2 * Math.PI);
        writeFunctionToCSV("log2.csv", log2::log, 0.1, 10);
        writeFunctionToCSV("log5.csv", log5::log, 0.1, 10);
        writeFunctionToCSV("system_function.csv", systemFunction::calculate, -11 * Math.PI / 4, 10);

    }

    private static final double X_STEP = 0.01;


    private static void writeFunctionToCSV(String fileName, Function<Double, Double> function, double start, double end) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (double x = start; x <= end; x += X_STEP) {
                writer.write(x + "," + function.apply(x) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
