/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25643
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StringTowerBuilding {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wordCount = info[0];
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.print(solution(words) ? 1 : 0);
    }

    private static boolean solution(String[] words) {
        return IntStream.range(0, words.length - 1)
                .allMatch(i -> wordsStackable(words[i], words[i + 1]));
    }

    private static boolean wordsStackable(String word1, String word2) {
        int wordLength = word1.length();
        for (int length = 1; length <= wordLength; length++) {
            String suffix1 = word1.substring(wordLength - length);
            String suffix2 = word2.substring(wordLength - length);
            String prefix1 = word1.substring(0, length);
            String prefix2 = word2.substring(0, length);

            if (suffix1.equals(prefix2) || suffix2.equals(prefix1)) {
                return true;
            }
        }
        return false;
    }
}
