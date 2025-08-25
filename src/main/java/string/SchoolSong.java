/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21964
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolSong {

    private static final int LENGTH = 5;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String input) {
        return input.length() <= LENGTH
                ? input
                : input.substring(input.length() - LENGTH);
    }
}
