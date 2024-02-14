/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17103
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachPartition {

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
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            stringBuilder
                    .append(solution(Integer.parseInt(bufferedReader.readLine())))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int n) {
        int count = 0;
        int half = n / 2;

        for (int number1 = 2; number1 <= half; number1++) {
            int number2 = n - number1;
            if (!IS_NOT_PRIME[number1] && !IS_NOT_PRIME[number2]) {
                count++;
            }
        }

        return count;
    }
}
