/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27466
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhatContestName {

    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private static final char LETTER_A = 'A';
    private static final int REQUIRE_A_COUNT = 2;
    private static final int REQUIRE_NOT_VOWEL_COUNT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetLength = info[1];

        char[] input = bufferedReader.readLine().toCharArray();

        System.out.print(solution(input, targetLength));
    }

    private static String solution(char[] input, int targetLength) {
        List<Integer> letterAIndexList = findLetterAIndexes(input);

        if (letterAIndexList.size() < REQUIRE_A_COUNT) {
            return "NO";
        }
        int remainingLength = targetLength - REQUIRE_A_COUNT - REQUIRE_NOT_VOWEL_COUNT;

        if (letterAIndexList.get(letterAIndexList.size() - REQUIRE_A_COUNT) < remainingLength) {
            return "NO";
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (
                int i = letterAIndexList.get(letterAIndexList.size() - REQUIRE_A_COUNT)
                        - remainingLength;
                i < letterAIndexList.get(letterAIndexList.size() - REQUIRE_A_COUNT);
                i++) {
            stringBuilder.append(input[i]);
        }

        stringBuilder.append(LETTER_A).append(LETTER_A);

        for (
                int i = letterAIndexList.get(letterAIndexList.size() - 1) + REQUIRE_NOT_VOWEL_COUNT;
                i < input.length;
                i++
        ) {
            if (!isVowel(input[i])) {
                stringBuilder.append(input[i]);
                break;
            }
        }

        if (stringBuilder.length() != targetLength) {
            return "NO";
        }

        return "YES\n" + stringBuilder.toString().trim();
    }

    private static boolean isVowel(char letter) {
        for (char vowel : VOWELS) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> findLetterAIndexes(char[] input) {
        List<Integer> letterAIndexList = new ArrayList<>();

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == LETTER_A) {
                letterAIndexList.add(i);
            }
        }
        return letterAIndexList;
    }
}
