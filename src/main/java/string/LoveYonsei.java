/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25915
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoveYonsei {

    private static final char[] TYPE_STRING = "ILOVEYONSEI".toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine().charAt(0)));
    }

    private static int solution(char startChar) {
        int length = 0;
        char currentChar = startChar;

        for (char c : TYPE_STRING) {
            length += Math.abs(currentChar - c);
            currentChar = c;
        }

        return length;
    }
}
