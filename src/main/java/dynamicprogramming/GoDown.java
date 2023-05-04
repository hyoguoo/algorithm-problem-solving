/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2096
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoDown {

    final static int LINE = 3;
    final static int[] maxDp = new int[LINE];
    final static int[] minDp = new int[LINE];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        int[] firstLine = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        initDp(firstLine);

        for (int i = 0; i < length - 1; i++) {
            int[] values = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            solution(values);
        }

        printMaxMinValue();
    }

    private static void printMaxMinValue() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < LINE; i++) {
            max = Math.max(max, maxDp[i]);
            min = Math.min(min, minDp[i]);
        }
        System.out.println(max + " " + min);
        System.exit(0);
    }

    private static void initDp(int[] values) {
        maxDp[0] = minDp[0] = values[0];
        maxDp[1] = minDp[1] = values[1];
        maxDp[2] = minDp[2] = values[2];
    }

    private static void solution(int[] values) {
        int maxDp0 = maxDp[0];
        int maxDp1 = maxDp[1];
        int maxDp2 = maxDp[2];
        int minDp0 = minDp[0];
        int minDp1 = minDp[1];
        int minDp2 = minDp[2];
        maxDp[0] = Math.max(maxDp0, maxDp1) + values[0];
        maxDp[1] = Math.max(maxDp0, Math.max(maxDp1, maxDp2)) + values[1];
        maxDp[2] = Math.max(maxDp1, maxDp2) + values[2];
        minDp[0] = Math.min(minDp0, minDp1) + values[0];
        minDp[1] = Math.min(minDp0, Math.min(minDp1, minDp2)) + values[1];
        minDp[2] = Math.min(minDp1, minDp2) + values[2];
    }
}
