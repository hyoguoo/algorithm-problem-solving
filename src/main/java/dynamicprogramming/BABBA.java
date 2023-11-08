/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9625
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BABBA {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(bufferedReader.readLine()));
    }

    private static void solution(int n) {
        int a = 1;
        int b = 0;

        for (int i = 0; i < n; i++) {
            int tempA = a;
            a = b;
            b = tempA + b;
        }

        System.out.println(a + " " + b);
    }
}
