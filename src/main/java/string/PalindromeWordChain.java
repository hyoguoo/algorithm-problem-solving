/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20528
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromeWordChain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] words = bufferedReader.readLine().split(" ");

        System.out.print(solution(words) ? 1 : 0);
    }

    private static boolean solution(String[] words) {
        return Arrays.stream(words)
                .allMatch(word -> word.charAt(0) == words[0].charAt(0));
    }
}
