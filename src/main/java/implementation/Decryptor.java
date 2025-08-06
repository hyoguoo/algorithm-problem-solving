/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17176
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Decryptor {

    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Map<Character, Integer> charToCodeMap = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length(); i++) {
            charToCodeMap.put(ALPHABET.charAt(i), i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] cipherNumbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String plaintext = bufferedReader.readLine();

        System.out.print(solution(cipherNumbers, plaintext) ? "y" : "n");
    }

    private static boolean solution(int[] cipherNumbers, String plaintext) {
        int[] plaintextCodes = plaintext.chars()
                .map(c -> charToCodeMap.getOrDefault((char) c, -1))
                .filter(code -> code != -1)
                .toArray();

        Arrays.sort(cipherNumbers);
        Arrays.sort(plaintextCodes);

        return Arrays.equals(cipherNumbers, plaintextCodes);
    }
}
