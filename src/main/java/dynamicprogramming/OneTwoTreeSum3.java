/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15988
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoTreeSum3 {

    static final int MOD = 1_000_000_009;
    static final int MAX = 1_000_000;
    static final long[] DP = new long[MAX + 1];

    static {
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for (int i = 4; i <= MAX; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(DP[n]).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }
}
