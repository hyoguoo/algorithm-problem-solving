/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1544
 * Cheat Level: 0
 * Algorithm: Set / String / Implementation
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CycleWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.print(solution(words));
    }

    private static int solution(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Arrays.stream(words)
                .forEach(word -> addWordIfNotConnected(wordSet, word));
        return wordSet.size();
    }

    private static void addWordIfNotConnected(Set<String> wordSet, String word) {
        if (wordSet.stream().noneMatch(existingWord -> isConnected(existingWord, word))) {
            wordSet.add(word);
        }
    }

    private static boolean isConnected(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        return (word1 + word1).contains(word2);
    }
}
