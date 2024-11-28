/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2153
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimeWord {

    private static final int MAX_LENGTH = 20;
    private static final int ALPHABET_VALUE = 52;
    private static final int MAX = MAX_LENGTH * ALPHABET_VALUE;
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];

    static {
        Arrays.fill(IS_PRIME, true);
        IS_PRIME[0] = false;

        for (int i = 2; i <= MAX; i++) {
            if (IS_PRIME[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    IS_PRIME[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        System.out.print(
                solution(word)
                        ? "It is a prime word."
                        : "It is not a prime word."
        );
    }

    private static boolean solution(String word) {
        return IS_PRIME[
                IntStream.range(0, word.length())
                        .map(i -> charToAlphabetOrder(word.charAt(i)))
                        .sum()
                ];
    }

    private static int charToAlphabetOrder(int c) {
        return c <= 'Z' ? c - 'A' + 27 : c - 'a' + 1;
    }
}
