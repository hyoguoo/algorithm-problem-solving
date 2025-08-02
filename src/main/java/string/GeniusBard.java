/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19948
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GeniusBard {

    private static final String INVALID_RESULT = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Map<Character, Integer> charCountMap = new HashMap<>();
        charCountMap.put(' ', Integer.parseInt(bufferedReader.readLine()));
        int[] alphabetCountInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < alphabetCountInfo.length; i++) {
            char character = (char) ('a' + i);
            charCountMap.put(character, alphabetCountInfo[i]);
        }

        System.out.print(solution(input, charCountMap));
    }

    private static String solution(String input, Map<Character, Integer> charCountMap) {
        String compressedInput = compress(input);
        if (!isAvailable(compressedInput, charCountMap)) {
            return INVALID_RESULT;
        }

        String title = buildTitle(compressedInput);
        String compressedTitle = compress(title);
        return isAvailable(compressedTitle, charCountMap)
                ? title
                : INVALID_RESULT;
    }

    private static String compress(String s) {
        return s.replaceAll("(.)\\1+", "$1");
    }

    private static boolean isAvailable(String s, Map<Character, Integer> charCountMap) {
        return s.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .noneMatch(c -> isNotConsumable(c, charCountMap));
    }

    private static String buildTitle(String input) {
        StringBuilder titleBuilder = new StringBuilder();
        char prevChar = ' ';

        for (char c : input.toLowerCase().toCharArray()) {
            if (prevChar == ' ') {
                titleBuilder.append(Character.toUpperCase(c));
            }
            prevChar = c;
        }

        return titleBuilder.toString().trim();
    }

    private static boolean isNotConsumable(char c, Map<Character, Integer> charCountMap) {
        int count = charCountMap.getOrDefault(c, 0);
        if (count > 0) {
            charCountMap.put(c, count - 1);
            return false;
        }
        return true;
    }
}
