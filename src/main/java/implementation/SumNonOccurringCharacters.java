/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3059
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class SumNonOccurringCharacters {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String input = bufferedReader.readLine();
            stringBuilder
                    .append(solution(input))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String input) {
        Set<Character> characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        input.chars()
                .mapToObj(c -> (char) c)
                .forEach(characters::remove);

        return characters.stream()
                .mapToInt(c -> c)
                .sum();
    }
}
