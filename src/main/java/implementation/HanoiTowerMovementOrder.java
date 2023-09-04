/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11729
 * Cheat Level: 3
 * Algorithm: Recursion
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTowerMovementOrder {

    final static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(bufferedReader.readLine()));
        System.out.println(stringBuilder);
    }

    private static void solution(int n) {
        stringBuilder.append((int) Math.pow(2, n) - 1).append("\n");
        move(n, 1, 2, 3);
    }

    private static void move(int n, int from, int by, int to) {
        if (n == 1) {
            stringBuilder.append(from).append(" ").append(to).append("\n");
            return;
        }

        move(n - 1, from, to, by);
        stringBuilder.append(from).append(" ").append(to).append("\n");
        move(n - 1, by, from, to);
    }
}
