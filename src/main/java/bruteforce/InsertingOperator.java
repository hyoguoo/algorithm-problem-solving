/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15658
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.BinaryOperator;

public class InsertingOperator {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        EnumMap<Operator, Integer> operatorCount = new EnumMap<>(Operator.class);
        int[] counts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int i = 0;
        for (Operator operator : Operator.values()) {
            operatorCount.put(operator, counts[i++]);
        }

        System.out.print(solution(numbers, operatorCount));
    }

    private static String solution(int[] numbers, EnumMap<Operator, Integer> operatorCount) {
        Result result = new Result();
        dfs(numbers, operatorCount, result, numbers[0], 1);

        return result.max + "\n" + result.min;
    }

    private static void dfs(int[] numbers,
            EnumMap<Operator, Integer> operatorCount,
            Result result,
            int currentValue,
            int idx) {
        if (idx == numbers.length) {
            result.max = Math.max(result.max, currentValue);
            result.min = Math.min(result.min, currentValue);
            return;
        }

        for (Operator operator : Operator.values()) {
            int count = operatorCount.get(operator);
            if (count == 0) {
                continue;
            }
            operatorCount.put(operator, count - 1);
            int nextValue = operator.apply(currentValue, numbers[idx]);
            dfs(numbers, operatorCount, result, nextValue, idx + 1);
            operatorCount.put(operator, count);
        }
    }

    enum Operator {
        ADD(Integer::sum),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b);

        private final BinaryOperator<Integer> operation;

        Operator(BinaryOperator<Integer> operation) {
            this.operation = operation;
        }

        public int apply(int a, int b) {
            return operation.apply(a, b);
        }
    }

    static class Result {

        private int max;
        private int min;

        public Result() {
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
    }
}
