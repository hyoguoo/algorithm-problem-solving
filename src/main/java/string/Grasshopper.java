/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10545
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Grasshopper {

    private static final char[][] KEYPAD = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    private static final char BREAK_KEY = '#';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] keyMappingNumbers = new int[10];
        int[] inputNumbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.arraycopy(inputNumbers, 0, keyMappingNumbers, 1, inputNumbers.length);

        String message = bufferedReader.readLine();

        System.out.print(solution(message, keyMappingNumbers));
    }

    private static String solution(String message, int[] keyMappingNumbers) {
        String originalInputKey = getOriginalInputKey(message);
        Map<Integer, Integer> keyMapping = createKeyMappingMap(keyMappingNumbers);
        return mappingKey(originalInputKey, keyMapping);
    }

    private static Map<Integer, Integer> createKeyMappingMap(int[] keyMappingNumbers) {
        Map<Integer, Integer> keyMapping = new HashMap<>();
        for (int i = 1; i < keyMappingNumbers.length; i++) {
            keyMapping.put(keyMappingNumbers[i], i);
        }
        return keyMapping;
    }

    private static String mappingKey(String originalInputKey, Map<Integer, Integer> keyMapping) {
        return originalInputKey.chars()
                .mapToObj(
                        c -> c == BREAK_KEY
                                ? String.valueOf(BREAK_KEY)
                                : String.valueOf(keyMapping.get(Character.getNumericValue(c)))
                )
                .reduce("", String::concat);
    }

    private static String getOriginalInputKey(String message) {
        StringBuilder originalInputKey = new StringBuilder();
        int previousNumber = 0;

        for (char c : message.toCharArray()) {
            for (int keyNumber = 1; keyNumber < KEYPAD.length; keyNumber++) {
                for (int pressCount = 0; pressCount < KEYPAD[keyNumber].length; pressCount++) {
                    if (c == KEYPAD[keyNumber][pressCount]) {
                        if (keyNumber == previousNumber) {
                            originalInputKey.append(BREAK_KEY);
                        }
                        previousNumber = keyNumber;
                        originalInputKey.append(String.valueOf(keyNumber).repeat(pressCount + 1));
                        break;
                    }
                }
            }
        }

        return originalInputKey.toString();
    }
}
