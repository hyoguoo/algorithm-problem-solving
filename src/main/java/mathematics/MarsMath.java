/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5355
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class MarsMath {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            String[] info = bufferedReader.readLine().split(" ");
            double n = Double.parseDouble(info[0]);
            Operator[] operators = IntStream.range(1, info.length)
                    .mapToObj(i -> Operator.of(info[i]))
                    .toArray(Operator[]::new);

            stringBuilder
                    .append(String.format("%.2f", solution(n, operators)))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static double solution(double n, Operator[] operators) {
        return Arrays.stream(operators)
                .reduce(n, (result, operator) -> (Double) operator.apply(result), (a, b) -> b);
    }

    enum Operator {
        AT("@", value -> value * 3),
        PERCENT("%", value -> value + 5),
        HASH("#", value -> value - 7);

        private final String operatorString;
        private final UnaryOperator<Double> operation;

        Operator(String operatorString, UnaryOperator<Double> operation) {
            this.operatorString = operatorString;
            this.operation = operation;
        }

        public static Operator of(String operator) {
            return Arrays.stream(values())
                    .filter(value -> value.operatorString.equals(operator))
                    .findFirst()
                    .orElseThrow();
        }

        public Object apply(double n) {
            return operation.apply(n);
        }
    }
}
