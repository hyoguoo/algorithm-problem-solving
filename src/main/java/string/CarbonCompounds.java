/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1907
 * Cheat Level: 0
 * Algorithm: String / Brute Force
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class CarbonCompounds {

    public static final char LAST_ALPHABET = 'Z';
    private static final int ALPHABET_COUNT = 26;
    private static final char FIRST_ALPHABET = 'A';
    private static final char FIRST_NUMBER = '0';
    private static final char LAST_NUMBER = '9';
    private static final int MAX_COEFFICIENT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.print(solution(input));
    }

    private static String solution(String input) {
        String[] compounds = input.split("[+=]");
        int[] leftCount1 = parseCount(compounds[0]);
        int[] leftCount2 = parseCount(compounds[1]);
        int[] rightCount = parseCount(compounds[2]);

        Coefficient coefficient = findCoefficient(leftCount1, leftCount2, rightCount);

        return coefficient.toString();
    }

    private static Coefficient findCoefficient(int[] leftCount1, int[] leftCount2, int[] rightCount) {
        for (int left1 = 1; left1 <= MAX_COEFFICIENT; left1++) {
            for (int left2 = 1; left2 <= MAX_COEFFICIENT; left2++) {
                for (int right = 1; right <= MAX_COEFFICIENT; right++) {
                    if (isCorrect(leftCount1, leftCount2, rightCount, left1, left2, right)) {
                        return new Coefficient(left1, left2, right);
                    }
                }
            }
        }

        throw new IllegalArgumentException();
    }

    private static boolean isCorrect(int[] leftCount1,
            int[] leftCount2,
            int[] rightCount,
            int left1Coefficient,
            int left2Coefficient,
            int rightCoefficient
    ) {
        return IntStream.range(0, ALPHABET_COUNT)
                .allMatch(c ->
                        leftCount1[c] * left1Coefficient + leftCount2[c] * left2Coefficient
                                == rightCount[c] * rightCoefficient);
    }

    private static int[] parseCount(String compound) {
        String reversedCompound = new StringBuilder(compound).reverse().toString();
        int[] alphabetCounts = new int[ALPHABET_COUNT];

        int coefficient = 1;
        for (char c : reversedCompound.toCharArray()) {
            if (FIRST_ALPHABET <= c && c <= LAST_ALPHABET) {
                alphabetCounts[c - FIRST_ALPHABET] += coefficient;
                coefficient = 1;
            } else if (FIRST_NUMBER <= c && c <= LAST_NUMBER) {
                coefficient = c - FIRST_NUMBER;
            }
        }

        return alphabetCounts;
    }

    static class Coefficient {

        private final int left1;
        private final int left2;
        private final int right;

        public Coefficient(int left1, int left2, int right) {
            this.left1 = left1;
            this.left2 = left2;
            this.right = right;
        }

        @Override
        public String toString() {
            return left1 + " " + left2 + " " + right;
        }
    }
}
