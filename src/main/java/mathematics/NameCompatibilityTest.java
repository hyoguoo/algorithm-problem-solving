/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17269
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class NameCompatibilityTest {

    private static final int[] ALPHABET_VALUES = {
            3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3,
            2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] input = bufferedReader.readLine().split(" ");

        System.out.print(solution(input[0], input[1]) + "%");
    }

    private static int solution(String s1, String s2) {
        String combined = combineNames(s1, s2);
        String valueString = combined.chars()
                .map(c -> ALPHABET_VALUES[c - 'A'])
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return Integer.parseInt(reduceValueString(valueString));
    }

    private static String reduceValueString(String valueString) {
        while (valueString.length() > 2) {
            StringBuilder nextValueString = new StringBuilder();
            for (int i = 0; i < valueString.length() - 1; i++) {
                int sum = Character.getNumericValue(valueString.charAt(i)) +
                        Character.getNumericValue(valueString.charAt(i + 1));
                nextValueString.append(sum % 10);
            }
            valueString = nextValueString.toString();
        }

        return valueString;
    }

    private static String combineNames(String s1, String s2) {
        StringBuilder combined = new StringBuilder();
        int length = Math.max(s1.length(), s2.length());

        for (int i = 0; i < length; i++) {
            if (i < s1.length()) {
                combined.append(s1.charAt(i));
            }
            if (i < s2.length()) {
                combined.append(s2.charAt(i));
            }
        }

        return combined.toString();
    }
}
