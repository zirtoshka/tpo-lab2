package itma;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

public class FunctionMocker {
    public static <T> void mockUnaryFunction(T mock, Map<Double, Double> values, FunctionCall<T> call) {
        when(call.apply(mock, anyDouble())).thenAnswer(inv -> {
            double x = inv.getArgument(0);
            if (!values.containsKey(x)) {
                throw new IllegalArgumentException("No value for x = " + x);
            }
            return values.get(x);
        });
    }

    @FunctionalInterface
    public interface FunctionCall<T> {
        double apply(T instance, double x);
    }
}
