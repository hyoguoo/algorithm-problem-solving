/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3986
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class GoodWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int wordCount = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.print(solution(words));
    }

    private static long solution(String[] words) {
        return Arrays.stream(words)
                .filter(GoodWord::isGoodWord)
                .count();
    }

    private static boolean isGoodWord(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char current : word.toCharArray()) {
            if (!deque.isEmpty() && deque.peek() == current) {
                deque.pop();
            } else {
                deque.push(current);
            }
        }

        return deque.isEmpty();
    }
}
