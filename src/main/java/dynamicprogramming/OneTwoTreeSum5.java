/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15990
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OneTwoTreeSum5 {

    private static final int MOD = 1_000_000_009;
    private static final int MAX = 100_000;
    private static final long[][] DP = new long[MAX + 1][3 + 1];

    static {
        DP[1][1] = 1;
        DP[2][2] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;

        for (int i = 4; i <= MAX; i++) {
            DP[i][1] = (DP[i - 1][2] + DP[i - 1][3]) % MOD;
            DP[i][2] = (DP[i - 2][1] + DP[i - 2][3]) % MOD;
            DP[i][3] = (DP[i - 3][1] + DP[i - 3][2]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(Arrays.stream(DP[n]).sum() % MOD).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }
}
