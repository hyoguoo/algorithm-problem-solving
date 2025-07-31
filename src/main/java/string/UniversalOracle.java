/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7656
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniversalOracle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String input) {
        StringBuilder output = new StringBuilder();
        int searchIndex = -1;

        while ((searchIndex = input.indexOf("What is", searchIndex + 1)) != -1) {
            int questionMarkIndex = input.indexOf("?", searchIndex);
            String candidate = (questionMarkIndex != -1)
                    ? input.substring(searchIndex, questionMarkIndex + 1)
                    : "";

            if (!candidate.isEmpty() && !candidate.contains(".")) {
                output.append(transformQuestion(candidate)).append("\n");
                searchIndex = questionMarkIndex;
            } else {
                searchIndex = (candidate.contains("."))
                        ? input.indexOf(".", searchIndex)
                        : input.length();
            }
        }

        return output.toString().trim();
    }

    private static String transformQuestion(String question) {
        String transformed = question.replaceFirst("What", "Forty-two");
        return transformed.substring(0, transformed.length() - 1) + ".";
    }
}
