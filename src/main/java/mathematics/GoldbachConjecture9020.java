/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9020
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachConjecture9020 {

    final static int MAX = 10000;
    final static boolean[] IS_PRIME = new boolean[MAX + 1];

    static {
        for (int i = 2; i <= MAX; i++) IS_PRIME[i] = true;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (IS_PRIME[i]) {
                for (int j = i * 2; j <= MAX; j += i) {
                    IS_PRIME[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- >0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static String solution(int n) {
        int n1 = n / 2;
        int n2 = n / 2;

        while (true) {
            if (IS_PRIME[n1] && IS_PRIME[n2]) return n1 + " " + n2;
            n1--;
            n2++;
        }
    }
}
