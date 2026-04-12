/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6376
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalculatingE {

    public static void main(String[] args) {
        String header = "n e" + System.lineSeparator() + "- -----------";
        String body = solution().stream()
                .map(EValue::getFormattedOutput)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(header + System.lineSeparator() + body);
    }

    private static List<EValue> solution() {
        return IntStream.rangeClosed(0, 9)
                .mapToObj(n -> new EValue(n, calculateEValue(n)))
                .collect(Collectors.toList());
    }

    private static double calculateEValue(int n) {
        return IntStream.rangeClosed(0, n)
                .mapToDouble(i -> 1.0 / factorial(i))
                .sum();
    }

    private static double factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .asDoubleStream()
                .reduce(1.0, (a, b) -> a * b);
    }

    enum EFormatting {
        INTEGER {
            @Override
            String format(double value) {
                return String.format("%.0f", value);
            }
        },
        ONE_DECIMAL {
            @Override
            String format(double value) {
                return String.format("%.1f", value);
            }
        },
        NINE_DECIMAL {
            @Override
            String format(double value) {
                return String.format("%.9f", value);
            }
        };

        public static String getFormattedValue(int n, double value) {
            if (n <= 1) {
                return INTEGER.format(value);
            }
            if (n == 2) {
                return ONE_DECIMAL.format(value);
            }
            return NINE_DECIMAL.format(value);
        }

        abstract String format(double value);
    }

    static class EValue {

        private final int n;
        private final double value;

        public EValue(int n, double value) {
            this.n = n;
            this.value = value;
        }

        public String getFormattedOutput() {
            return String.format("%d %s", n, EFormatting.getFormattedValue(n, value));
        }
    }
}
