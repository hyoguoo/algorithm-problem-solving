/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9461
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanSequence {

    private static final int MAX = 100;
    private static final long[] padovan = new long[MAX + 1];

    static {
        solution();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(padovan[number]).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static void solution() {
        padovan[1] = padovan[2] = padovan[3] = 1;
        padovan[4] = padovan[5] = 2;
        for (int i = 6; i <= MAX; i++) {
            padovan[i] = padovan[i - 5] + padovan[i - 1];
        }
    }
}
