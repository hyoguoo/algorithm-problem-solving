/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14563
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PerfectNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(numbers)
                .forEach(number ->
                        stringBuilder.append(solution(number)).append("\n")
                );

        System.out.print(stringBuilder.toString().trim());
    }

    private static NumberType solution(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        if (sum == number) {
            return NumberType.PERFECT;
        } else if (sum < number) {
            return NumberType.DEFICIENT;
        } else {
            return NumberType.ABUNDANT;
        }
    }

    enum NumberType {
        PERFECT("Perfect"),
        DEFICIENT("Deficient"),
        ABUNDANT("Abundant");

        private final String value;

        NumberType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}
