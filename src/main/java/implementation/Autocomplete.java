/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24883
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Autocomplete {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(
                solution(bufferedReader.readLine())
                ? "Naver D2"
                : "Naver Whale"
        );
    }

    private static boolean solution(String line) {
        return line.equalsIgnoreCase("n");
    }
}
