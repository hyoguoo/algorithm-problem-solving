/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4779
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CantoringAlong {

    private static final char DASH = '-';
    private static final char SPACE = ' ';
    private static final int BASE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null) {
                break;
            }
            int n = Integer.parseInt(input);
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    public static String solution(int exponent) {
        if (exponent == 0) {
            return String.valueOf(DASH);
        }

        int length = (int) Math.pow(BASE, exponent);
        char[] cantor = new char[length];
        Arrays.fill(cantor, DASH);

        createCantorSet(cantor, 0, length, exponent);

        return new String(cantor);
    }

    public static void createCantorSet(
            char[] cantor,
            int currentIndex,
            int sectionLength,
            int exponent
    ) {
        if (exponent == 0) {
            return;
        }

        int divisionLength = sectionLength / BASE;
        int middleSectionStart = currentIndex + divisionLength;
        int middleSectionEnd = currentIndex + (BASE - 1) * divisionLength;

        Arrays.fill(cantor, middleSectionStart, middleSectionEnd, SPACE);

        createCantorSet(cantor, currentIndex, divisionLength, exponent - 1);
        createCantorSet(cantor, middleSectionEnd, divisionLength, exponent - 1);
    }
}
