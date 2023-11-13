/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1062
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teaching {

    static final char A = 'a';
    static final int MIN = 5;
    static final int MAX = 26;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int k = info[1];

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(bufferedReader.readLine());
        }

        solution(k, n, words);
    }

    private static void solution(int k, int n, List<String> words) {
        if (k < MIN) {
            System.out.println(0);
            return;
        }
        if (k == MAX) {
            System.out.println(n);
            return;
        }

        boolean[] isLearned = new boolean[26];
        isLearned['a' - A] = true;
        isLearned['c' - A] = true;
        isLearned['i' - A] = true;
        isLearned['n' - A] = true;
        isLearned['t' - A] = true;

        backtracking(k, 0, isLearned, words, 0);
        System.out.println(answer);
    }

    private static void backtracking(int k, int count, boolean[] isLearned, List<String> words,  int index) {
        if (count == k - MIN) {
            answer = Math.max(answer, getLearnedWordCount(isLearned, words));
            return;
        }

        for (int i = index; i < MAX; i++) {
            if (isLearned[i]) continue;
            isLearned[i] = true;
            backtracking(k, count + 1, isLearned, words, i);
            isLearned[i] = false;
        }
    }

    private static int getLearnedWordCount(boolean[] isLearned, List<String> words) {
        int count = 0;

        for (String word : words) {
            boolean isLearnedWord = true;
            for (int i = 4; i < word.length() - 4; i++) {
                if (!isLearned[word.charAt(i) - A]) {
                    isLearnedWord = false;
                    break;
                }
            }
            if (isLearnedWord) count++;
        }

        return count;
    }
}
