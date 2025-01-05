/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14581
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HongJoonSurroundedFans {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String input) {
        return ":fan::fan::fan:\n" +
                ":fan::" + input + "::fan:\n" +
                ":fan::fan::fan:";
    }
}
