/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1816
 * Cheat Level: 0
 * Algorithm: Bruteforce / Mathematics
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptographicKey {

    private static final int BIG_NUMBER_THRESHOLD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            long keyInput = Long.parseLong(bufferedReader.readLine());
            stringBuilder
                    .append(solution(keyInput) ? "YES" : "NO")
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(long n) {
        for (long i = 2; i <= BIG_NUMBER_THRESHOLD; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
