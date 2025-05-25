/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6996
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String[] words = bufferedReader.readLine().split(" ");
            stringBuilder
                    .append(String.format("%s & %s are ", words[0], words[1]))
                    .append(solution(words[0], words[1]) ? "anagrams" : "NOT anagrams")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(String word1, String word2) {
        String sortedWord1 = sortString(word1);
        String sortedWord2 = sortString(word2);
        return sortedWord1.equals(sortedWord2);
    }

    private static String sortString(String input) {
        return input.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
