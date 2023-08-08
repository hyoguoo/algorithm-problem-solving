/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28432
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class EndNote {

    final static String QUESTION_MARK = "?";
    static String[] words;
    static String[] candidateWords;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static String solution() {
        char startChar = 0;
        char endChar = 0;
        HashSet<String> stringHashSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(QUESTION_MARK)) {
                if (i > 0) startChar = words[i - 1].charAt(words[i - 1].length() - 1);
                if (i < words.length - 1) endChar = words[i + 1].charAt(0);
            } else {
                stringHashSet.add(words[i]);
            }
        }

        for (String candidateWord : candidateWords) {
            if (startChar != 0 && candidateWord.charAt(0) != startChar) continue;
            if (endChar != 0 && candidateWord.charAt(candidateWord.length() - 1) != endChar) continue;
            if (!stringHashSet.contains(candidateWord)) return candidateWord;
        }

        return null;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int recordCount = Integer.parseInt(bufferedReader.readLine());
        words = new String[recordCount];
        for (int i = 0; i < recordCount; i++) words[i] = bufferedReader.readLine();
        int candidateCount = Integer.parseInt(bufferedReader.readLine());
        candidateWords = new String[candidateCount];
        for (int i = 0; i < candidateCount; i++) candidateWords[i] = bufferedReader.readLine();
    }
}
