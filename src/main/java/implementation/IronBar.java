/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10799
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IronBar {

    final static char OPEN = '(';
    final static char CLOSE = ')';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(bufferedReader.readLine()));
    }

    private static int solution(String input) {
        char[] charArray = input.toCharArray();
        char previous = ' ';
        int openCount = 0;
        int result = 0;

        for (char c : charArray) {
            if (c == OPEN) {
                openCount++;
                previous = OPEN;
            } else if (c == CLOSE) {
                openCount--;
                if (previous == OPEN) result += openCount;
                else result++;
                previous = CLOSE;
            }
        }

        return result;
    }
}
