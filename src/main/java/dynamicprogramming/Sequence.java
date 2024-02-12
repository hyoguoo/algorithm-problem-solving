/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2491
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.println(solution(Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()));
    }

    private static int solution(int[] numbers) {
        int[] increaseDp = new int[numbers.length];
        int[] decreaseDp = new int[numbers.length];
        increaseDp[0] = 1;
        decreaseDp[0] = 1;
        int max = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] <= numbers[i]) {
                increaseDp[i] = increaseDp[i - 1] + 1;
                max = Math.max(max, increaseDp[i]);
            } else {
                increaseDp[i] = 1;
            }

            if (numbers[i - 1] >= numbers[i]) {
                decreaseDp[i] = decreaseDp[i - 1] + 1;
                max = Math.max(max, decreaseDp[i]);
            } else {
                decreaseDp[i] = 1;
            }
        }

        return max;
    }
}
