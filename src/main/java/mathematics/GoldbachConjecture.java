/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6588
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachConjecture {

    static final String WRONG_INPUT = "Goldbach's conjecture is wrong.";
    static final int MAX = 1_000_000;
    static final boolean[] IS_NOT_PRIME = new boolean[MAX + 1];

    static {
        IS_NOT_PRIME[0] = IS_NOT_PRIME[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (!IS_NOT_PRIME[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    IS_NOT_PRIME[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) break;
            stringBuilder.append(solution(n)).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static String solution(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (!IS_NOT_PRIME[i] && !IS_NOT_PRIME[n - i]) {
                return n + " = " + i + " + " + (n - i);
            }
        }

        return WRONG_INPUT;
    }
}
