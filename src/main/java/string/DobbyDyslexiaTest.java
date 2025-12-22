/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2204
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DobbyDyslexiaTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            int wordCount = Integer.parseInt(bufferedReader.readLine());
            if (wordCount == 0) {
                break;
            }
            String[] words = new String[wordCount];
            for (int i = 0; i < wordCount; i++) {
                words[i] = bufferedReader.readLine();
            }

            stringBuilder
                    .append(solution(words))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String[] words) {
        return Arrays.stream(words)
                .min((word1, word2) -> {
                    String lowerWord1 = word1.toLowerCase();
                    String lowerWord2 = word2.toLowerCase();
                    int compareResult = lowerWord1.compareTo(lowerWord2);
                    if (compareResult == 0) {
                        return Integer.compare(word1.charAt(0), word2.charAt(0));
                    }
                    return compareResult;
                })
                .orElse("");
    }
}
