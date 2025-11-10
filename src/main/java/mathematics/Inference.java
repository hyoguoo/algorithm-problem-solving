/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1731
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Inference {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        return getSequenceType(numbers)
                .next(numbers);
    }

    private static SequenceType getSequenceType(int[] numbers) {
        return IntStream.range(2, numbers.length).allMatch(i -> isArithmeticSequence(numbers, i))
                ? SequenceType.ARITHMETIC
                : SequenceType.GEOMETRIC;
    }

    private static boolean isArithmeticSequence(int[] numbers, int i) {
        return numbers[i] - numbers[i - 1] == numbers[1] - numbers[0];
    }

    enum SequenceType {
        ARITHMETIC(nums -> {
            int diff = nums[1] - nums[0];
            return nums[nums.length - 1] + diff;
        }),
        GEOMETRIC(nums -> {
            int ratio = nums[1] / nums[0];
            return nums[nums.length - 1] * ratio;
        });

        private final NextValueStrategy strategy;

        SequenceType(NextValueStrategy strategy) {
            this.strategy = strategy;
        }

        int next(int[] nums) {
            return strategy.next(nums);
        }
    }

    @FunctionalInterface
    interface NextValueStrategy {

        int next(int[] nums);
    }
}
