/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26162
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArtificialElement {

    private static final int MAX = 118;
    private static final boolean[] IS_PRIME_NUMBERS = new boolean[MAX + 1];
    private static final List<Integer> PRIME_NUMBERS = new ArrayList<>();

    static {
        for (int i = 2; i <= MAX; i++) {
            IS_PRIME_NUMBERS[i] = true;
        }

        for (int i = 2; i <= MAX; i++) {
            if (IS_PRIME_NUMBERS[i]) {
                for (int j = i * 2; j <= MAX; j += i) {
                    IS_PRIME_NUMBERS[j] = false;
                }
            }
        }

        for (int i = 2; i <= MAX; i++) {
            if (IS_PRIME_NUMBERS[i]) {
                PRIME_NUMBERS.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int atomicNumber = Integer.parseInt(bufferedReader.readLine());

            stringBuilder
                    .append(solution(atomicNumber) ? "Yes" : "No")
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int atomicNumber) {
        for (int primeNumber1 : PRIME_NUMBERS) {
            for (int primeNumber2 : PRIME_NUMBERS) {
                if (primeNumber1 + primeNumber2 == atomicNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}
