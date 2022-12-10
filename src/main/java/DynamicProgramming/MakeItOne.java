/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1463
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeItOne {

    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        System.out.println(makeItOne(x));
    }

    private static int makeItOne(int x) {
        dp[1] = 0;
        dp[2] = dp[3] = 1;
        for (int i = 4; i <= x; i++) {
            int minCount = Integer.MAX_VALUE;
            if (i % 2 == 0) minCount = Math.min(minCount, dp[i / 2]);
            if (i % 3 == 0) minCount = Math.min(minCount, dp[i / 3]);
            minCount = Math.min(minCount, dp[i - 1]);
            dp[i] = minCount + 1;
        }

        return dp[x];
    }
}
