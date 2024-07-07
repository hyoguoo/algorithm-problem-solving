/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2877
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourAndSeven {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        Integer.parseInt(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    private static String solution(int n) {
        return Integer.toBinaryString(n + 1)
                .substring(1)
                .replace('0', '4')
                .replace('1', '7');
    }
}
