/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11328
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Strfry {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String[] words = bufferedReader.readLine().split(" ");
            stringBuilder
                    .append(solution(words[0], words[1]) ? "Possible" : "Impossible")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(String word1, String word2) {
        return countCharacters(word1).equals(countCharacters(word2));
    }

    private static CharacterCount countCharacters(String word) {
        return new CharacterCount(word);
    }

    static class CharacterCount {

        private static final int ALPHABET_SIZE = 26;
        private final int[] counts = new int[ALPHABET_SIZE];

        public CharacterCount(String word) {
            for (char c : word.toCharArray()) {
                add(c);
            }
        }

        public void add(char c) {
            counts[getOrder(c)]++;
        }

        private static int getOrder(char c) {
            return c - 'a';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CharacterCount)) {
                return false;
            }
            CharacterCount other = (CharacterCount) obj;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (this.counts[i] != other.counts[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(counts);
        }
    }
}
