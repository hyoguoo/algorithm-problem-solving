/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27913
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SciComLove2023 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] settings = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int stringLength = settings[0];
        int queryCount = settings[1];

        int[] queryPositions = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            queryPositions[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(
                Arrays.stream(solution(stringLength, queryPositions))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private static int[] solution(int stringLength, int[] queryPositions) {
        Case[] characterStates = new Case[stringLength];
        int currentUppercaseCount = 0;

        for (int i = 0; i < stringLength; i++) {
            int patternIndex = i % 10;
            if (isInitialUppercase(patternIndex)) {
                characterStates[i] = Case.UPPERCASE;
                currentUppercaseCount++;
            } else {
                characterStates[i] = Case.LOWERCASE;
            }
        }

        int[] results = new int[queryPositions.length];
        for (int i = 0; i < queryPositions.length; i++) {
            int targetIndex = queryPositions[i] - 1;
            if (characterStates[targetIndex] == Case.UPPERCASE) {
                characterStates[targetIndex] = Case.LOWERCASE;
                currentUppercaseCount--;
            } else {
                characterStates[targetIndex] = Case.UPPERCASE;
                currentUppercaseCount++;
            }
            results[i] = currentUppercaseCount;
        }

        return results;
    }

    private static boolean isInitialUppercase(int index) {
        return index == 0 || index == 3 || index == 6;
    }

    enum Case {
        UPPERCASE, LOWERCASE
    }
}
