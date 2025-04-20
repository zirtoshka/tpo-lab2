package itma;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FunctionCsvLoader {
    public static Map<Double, Double> loadFunctionValues(String functionName) {
        Map<Double, Double> map = new HashMap<>();
        Path path = Paths.get("src/test/resources/" + functionName + ".csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.lines().skip(1).forEach(line -> {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double value = Double.parseDouble(parts[1]);
                map.put(x, value);
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to load CSV for " + functionName, e);
        }

        return map;
    }
}
