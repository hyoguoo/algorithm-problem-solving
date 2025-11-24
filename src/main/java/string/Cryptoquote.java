/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2703
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cryptoquote {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String original = bufferedReader.readLine();
            String ciphered = bufferedReader.readLine();

            stringBuilder
                    .append(solution(original, ciphered))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String original, String ciphered) {
        Map<Character, Character> charMapping = IntStream.range(0, ALPHABET.length())
                .boxed()
                .collect(Collectors.toMap(ALPHABET::charAt, ciphered::charAt));

        return original.chars()
                .mapToObj(c -> (char) c)
                .map(c -> charMapping.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
