/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1919
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class CreateAnagram {

    private static final int ALPHABET_COUNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word1 = bufferedReader.readLine();
        String word2 = bufferedReader.readLine();

        System.out.print(solution(word1, word2));
    }

    private static int solution(String word1, String word2) {
        int[] alphabetCount1 = countAlphabet(word1);
        int[] alphabetCount2 = countAlphabet(word2);

        return IntStream.range(0, ALPHABET_COUNT)
                .map(i -> Math.abs(alphabetCount1[i] - alphabetCount2[i]))
                .sum();
    }

    private static int[] countAlphabet(String word) {
        int[] alphabetCount = new int[ALPHABET_COUNT];
        word.chars()
                .forEach(c -> alphabetCount[c - 'a']++);
        return alphabetCount;
    }
}
