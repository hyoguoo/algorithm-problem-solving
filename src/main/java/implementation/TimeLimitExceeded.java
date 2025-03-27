/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11332
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class TimeLimitExceeded {

    private static final int SYSTEM_SPEED = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCase-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            TimeComplexity timeComplexity = TimeComplexity.fromString(input[0]);
            BigInteger n = new BigInteger(input[1]);
            BigInteger testCaseCount = new BigInteger(input[2]);
            BigInteger timeLimitSec = new BigInteger(input[3]);
            stringBuilder
                    .append(solution(timeComplexity, n, testCaseCount, timeLimitSec) ? "May Pass." : "TLE!")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(TimeComplexity timeComplexity,
            BigInteger n,
            BigInteger testCaseCount,
            BigInteger timeLimitSec) {
        if (timeComplexity == TimeComplexity.O_N_FACTORIAL && n.compareTo(BigInteger.valueOf(20)) > 0) {
            return false;
        }
        return timeComplexity.calculate(n)
                .multiply(testCaseCount)
                .compareTo(timeLimitSec.multiply(BigInteger.valueOf(SYSTEM_SPEED))) <= 0;
    }

    private static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    enum TimeComplexity {
        O_N("O(N)", n -> n),
        O_N_SQUARE("O(N^2)", n -> n.pow(2)),
        O_N_CUBE("O(N^3)", n -> n.pow(3)),
        O_2_N("O(2^N)", n -> BigInteger.TWO.pow(n.intValue())),
        O_N_FACTORIAL("O(N!)", TimeLimitExceeded::factorial);

        private final String value;
        private final TimeComplexityFunction timeComplexityFunction;

        TimeComplexity(String value, TimeComplexityFunction timeComplexityFunction) {
            this.value = value;
            this.timeComplexityFunction = timeComplexityFunction;
        }

        public static TimeComplexity fromString(String value) {
            return Arrays.stream(values())
                    .filter(v -> v.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }

        public BigInteger calculate(BigInteger n) {
            return timeComplexityFunction.calculate(n);
        }
    }

    @FunctionalInterface
    interface TimeComplexityFunction {

        BigInteger calculate(BigInteger n);
    }
}
