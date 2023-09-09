/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10826
 * Cheat Level: 0
 * Algorithm: Mathematics / Dynamic Programming
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciNumber4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(N));
    }

    private static BigInteger solution(int N) {
        if (N == 0) return BigInteger.ZERO;
        else if (N == 1) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[N + 1];

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        return dp[N];
    }
}
