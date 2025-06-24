/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9507
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerationsOfTribbles {

    private static final int LIMIT = 67;
    private static final long[] MEMO = new long[LIMIT + 1];

    static {
        MEMO[0] = 1;
        MEMO[1] = 1;
        MEMO[2] = 2;
        MEMO[3] = 4;
        for (int i = 4; i <= LIMIT; i++) {
            MEMO[i] = MEMO[i - 1] + MEMO[i - 2] + MEMO[i - 3] + MEMO[i - 4];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int n) {
        return MEMO[n];
    }
}
