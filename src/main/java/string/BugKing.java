/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3447
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BugKing {

    private static final String DELETE_STRING = "BUG";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = new ArrayList<>();

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            input.add(line);
        }

        System.out.print(solution(input));
    }


    private static String solution(List<String> input) {
        return input.stream()
                .map(BugKing::removeBug)
                .collect(Collectors.joining("\n"));
    }

    private static String removeBug(String line) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < line.length()) {
            char currentChar = line.charAt(index);
            result.append(currentChar);

            if (result.length() >= DELETE_STRING.length() && result.substring(result.length() - DELETE_STRING.length())
                    .equals(DELETE_STRING)) {
                result.delete(result.length() - DELETE_STRING.length(), result.length());
            }

            index++;
        }

        return result.toString();
    }
}
