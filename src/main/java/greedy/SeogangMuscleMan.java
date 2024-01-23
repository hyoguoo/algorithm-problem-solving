/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20300
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeogangMuscleMan {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(solution(numbers));
    }

    private static long solution(long[] numbers) {
        Arrays.sort(numbers);

        long maxValue = Long.MIN_VALUE;

        if (numbers.length == 1) {
            maxValue = numbers[0];
        } else if (numbers.length % 2 == 0) {
            for (int i = 0; i < numbers.length / 2; i++) {
                maxValue = Math.max(maxValue, numbers[i] + numbers[numbers.length - 1 - i]);
            }
        } else {
            for (int i = 0; i < numbers.length / 2; i++) {
                maxValue = Math.max(maxValue, numbers[i] + numbers[numbers.length - 2 - i]);
            }
            maxValue = Math.max(maxValue, numbers[numbers.length - 1]);
        }

        return maxValue;
    }
}
