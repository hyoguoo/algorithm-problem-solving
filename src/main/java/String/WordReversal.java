/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9093
 * Cheat Level: 0
 * Algorithm: String
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordReversal {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            System.out.println(solution(bufferedReader.readLine()));
        }
    }

    public static StringBuilder solution(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : inputString.split(" ")) {
            stringBuilder.append(reverse(s));
            stringBuilder.append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder;
    }

    public static StringBuilder reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) stringBuilder.append(s.charAt(i));

        return stringBuilder;
    }
}
