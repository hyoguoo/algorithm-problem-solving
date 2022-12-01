/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2920
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Note {

    static final String ASCENDING = "1 2 3 4 5 6 7 8";
    static final String DESCENDING = "8 7 6 5 4 3 2 1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        if (input.equals(ASCENDING)) return "ascending";
        else if (input.equals(DESCENDING)) return "descending";
        else return "mixed";
    }
}
