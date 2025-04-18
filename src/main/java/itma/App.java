package itma;

import itma.trigon.Cos;
import itma.trigon.Sin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.function.Function;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println((-Math.PI * 2 + Math.PI / 3) % Math.PI);
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        System.out.println(cos.cos(-2 * Math.PI + Math.PI / 3));
        System.out.println(sin.sin(Math.PI * 2 + Math.PI / 3));
        System.out.println("Hello World!");

//        Cos cos = new Cos();
//        Sin sin = new Sin(cos);

        writeFunctionToCSV("cos.csv", cos::cos, -2 * Math.PI, 2 * Math.PI);

    }

    private static final double X_STEP = 0.01;

//    private static void writeFunctionToCSV(String fileName, Function<Double, Double> function, double start, double end) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//            for (double x = start; x <= end; x += X_STEP) {
//                double y = function.apply(x);
//                writer.write(String.format(Locale.US, "%.5f,%.5f%n", x, y));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


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
