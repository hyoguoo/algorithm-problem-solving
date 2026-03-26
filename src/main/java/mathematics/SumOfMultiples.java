/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17173
 * Cheat Level: 0
 * Algorithm: Mathematics / Brute Force
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfMultiples {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int limit = info[0];

        int[] divisors = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(new InputData(limit, divisors)));
    }

    private static int solution(InputData inputData) {
        int totalSum = 0;
        int limit = inputData.getLimit();
        int[] divisors = inputData.getDivisors();

        for (int currentNumber = 1; currentNumber <= limit; currentNumber++) {
            if (MultipleStatus.from(currentNumber, divisors).isMultiple()) {
                totalSum += currentNumber;
            }
        }

        return totalSum;
    }

    enum MultipleStatus {
        MULTIPLE,
        NOT_MULTIPLE;

        public static MultipleStatus from(int number, int[] divisors) {
            for (int divisor : divisors) {
                if (number % divisor == 0) {
                    return MULTIPLE;
                }
            }
            return NOT_MULTIPLE;
        }

        public boolean isMultiple() {
            return this == MULTIPLE;
        }
    }

    private static class InputData {

        private final int limit;
        private final int[] divisors;

        public InputData(int limit, int[] divisors) {
            this.limit = limit;
            this.divisors = divisors;
        }

        public int getLimit() {
            return limit;
        }

        public int[] getDivisors() {
            return divisors;
        }
    }
}
