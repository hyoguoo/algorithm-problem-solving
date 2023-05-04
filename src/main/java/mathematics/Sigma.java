/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13172
 * Cheat Level: 4
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sigma {

    final static long MOD = 1000000007;
    static long N = 1;
    static long S = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int diceCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < diceCount; i++) {
            long[] diceInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            calculateFraction(diceInfo);
        }

        if (S % N == 0) System.out.println(S / N);
        else System.out.println(fermatTheorem(N, S));
    }

    private static void calculateFraction(long[] diceInfo) {
        long n = diceInfo[0];
        long s = diceInfo[1];
        S = s * N + S * n;
        N *= n;
        S %= MOD;
        N %= MOD;
    }

    public static long fermatTheorem(long n, long s) {
        long result = 1;
        long p = MOD - 2;
        while (p > 0) {
            if (p % 2 == 1) {
                result *= n;
                result %= MOD;
            }
            n *= n;
            n %= MOD;
            p /= 2;
        }
        return (result * s) % MOD;
    }
}
