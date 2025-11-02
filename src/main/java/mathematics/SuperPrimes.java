/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31216
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperPrimes {

    private static final int PRIME_COUNT = 3_000;
    private static final int SIEVE_LIMIT = 400_000;
    private static final int[] SUPER_PRIMES = precomputeSuperPrimes();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCaseCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());

            stringBuilder
                    .append(solution(n))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int n) {
        return SUPER_PRIMES[n - 1];
    }

    private static int[] precomputeSuperPrimes() {
        boolean[] isPrime = sieve(SIEVE_LIMIT);
        int[] result = new int[PRIME_COUNT];
        int primeCount = 0;
        int superCount = 0;

        for (int i = 2; i <= SIEVE_LIMIT && superCount < PRIME_COUNT; i++) {
            if (isPrime[i]) {
                primeCount++;
                if (primeCount < isPrime.length && isPrime[primeCount]) {
                    result[superCount++] = i;
                }
            }
        }

        return result;
    }

    private static boolean[] sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];

        if (limit >= 2) {
            for (int i = 2; i <= limit; i++) {
                isPrime[i] = true;
            }
            for (int p = 2; (long) p * p <= limit; p++) {
                if (isPrime[p]) {
                    for (int multiple = p * p; multiple <= limit; multiple += p) {
                        isPrime[multiple] = false;
                    }
                }
            }
        }

        return isPrime;
    }
}
