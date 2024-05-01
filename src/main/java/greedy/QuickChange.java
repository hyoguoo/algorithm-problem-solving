/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2720
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickChange {

    private static final int[] COINS = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int cents = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(cents)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int cents) {
        int[] counts = new int[COINS.length];

        for (int i = 0; i < COINS.length; i++) {
            counts[i] = cents / COINS[i];
            cents %= COINS[i];
        }

        return counts[0] + " " + counts[1] + " " + counts[2] + " " + counts[3];
    }
}
