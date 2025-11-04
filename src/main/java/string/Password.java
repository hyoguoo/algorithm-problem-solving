/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1718
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Password {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String plainText = bufferedReader.readLine();
        String key = bufferedReader.readLine();

        System.out.print(solution(plainText, key));
    }

    private static String solution(String plainText, String key) {
        return IntStream.range(0, plainText.length())
                .mapToObj(i -> decryptChar(plainText, key, i))
                .collect(Collectors.joining());
    }

    private static String decryptChar(String plainText, String key, int i) {
        char c = plainText.charAt(i);
        int shift = (key.charAt(i % key.length()) - 'a') + 1; // advance key even on spaces
        if (c == ' ') {
            return " ";
        }
        int enc = ((c - 'a') - shift + 26) % 26 + 'a';
        return String.valueOf((char) enc);
    }
}
