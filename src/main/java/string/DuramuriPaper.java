/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25178
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class DuramuriPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String word1 = bufferedReader.readLine();
        String word2 = bufferedReader.readLine();

        System.out.print(solution(word1, word2) ? "YES" : "NO");
    }

    private static boolean solution(String word1String, String word2String) {
        Word word1 = new Word(word1String);
        Word word2 = new Word(word2String);

        return word1.isDuramuri(word2);
    }

    static class Word {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
        private final String value;
        private final String removedVowelWord;
        private final int length;
        private final int[] alphabetCount;

        public Word(String value) {
            this.value = value;
            this.length = value.length();
            this.alphabetCount = new int[26];
            this.removedVowelWord = removeVowel();
            countAlphabet();
        }

        private void countAlphabet() {
            for (int i = 0; i < length; i++) {
                alphabetCount[value.charAt(i) - 'a']++;
            }
        }

        private String removeVowel() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < length; i++) {
                if (!VOWELS.contains(value.charAt(i))) {
                    stringBuilder.append(value.charAt(i));
                }
            }

            return stringBuilder.toString();
        }

        public boolean isDuramuri(Word word) {
            return isAlphabetCountSame(word) && isSameFirstAndLastCharacter(word) && isSameRemovedVowelWord(word);
        }

        private boolean isAlphabetCountSame(Word word) {
            for (int i = 0; i < 26; i++) {
                if (alphabetCount[i] != word.alphabetCount[i]) {
                    return false;
                }
            }
            return true;
        }

        private boolean isSameFirstAndLastCharacter(Word word) {
            return value.charAt(0) == word.value.charAt(0) &&
                    value.charAt(length - 1) == word.value.charAt(word.length - 1);
        }

        private boolean isSameRemovedVowelWord(Word word) {
            return removedVowelWord.equals(word.removedVowelWord);
        }
    }
}
