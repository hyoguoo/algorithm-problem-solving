/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29719
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteSilNightWatch {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long totalDays = inputs[0];
        long totalSoldiers = inputs[1];

        System.out.print(solution(totalDays, totalSoldiers));
    }

    private static long solution(long totalDays, long totalSoldiers) {
        long totalWays = power(totalSoldiers, totalDays, MOD);
        long waysWithoutBruteSil = power(totalSoldiers - 1, totalDays, MOD);

        return (totalWays - waysWithoutBruteSil + MOD) % MOD;
    }

    public static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
