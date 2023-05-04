/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1316
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWordChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = bufferedReader.readLine();
            if (isGroupWord(word)) count++;
        }
        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char previous = word.charAt(0);
        visited[previous - 'a'] = true;
        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            if (previous != current && visited[current - 'a']) return false;
            visited[current - 'a'] = true;
            previous = current;
        }
        return true;
    }
}
