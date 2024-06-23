/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12847
 * Cheat Level: 0
 * Algorithm: Implementation / Sliding Window
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HoneyPartTimeJob {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int limit = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, limit));
    }

    private static long solution(int[] numbers, int limit) {
        long sum = 0;

        for (int i = 0; i < limit; i++) {
            sum += numbers[i];
        }

        long max = sum;

        for (int i = limit; i < numbers.length; i++) {
            sum += numbers[i] - numbers[i - limit];
            max = Math.max(max, sum);
        }

        return max;
    }
}
