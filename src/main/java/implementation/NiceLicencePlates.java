/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1871
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NiceLicencePlates {

    private static final int NICE_DIFFERENCE_RANGE = 100;
    private static final int FRONT_LENGTH = 3;
    private static final int BACK_LENGTH = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String licencePlate = bufferedReader.readLine();
            stringBuilder
                    .append(solution(licencePlate) ? "nice" : "not nice")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(String licencePlate) {
        String front = licencePlate.substring(0, FRONT_LENGTH);
        String back = licencePlate.substring(licencePlate.length() - BACK_LENGTH);
        return Math.abs(convertFrontNumber(front) - convertBackNumber(back)) <= NICE_DIFFERENCE_RANGE;
    }

    private static int convertFrontNumber(String front) {
        return Arrays.stream(front.chars().map(c -> c - 'A').toArray())
                .reduce(0, (a, b) -> a * 26 + b);
    }

    private static int convertBackNumber(String back) {
        return Integer.parseInt(back);
    }
}
