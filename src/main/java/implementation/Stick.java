/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17608
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stick {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int stickCount = Integer.parseInt(bufferedReader.readLine());
        int[] sticks = new int[stickCount];

        for (int i = 0; i < stickCount; i++) {
            sticks[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(sticks));
    }

    private static int solution(int[] sticks) {
        int count = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = sticks.length - 1; i >= 0; i--) {
            if (maxHeight < sticks[i]) {
                maxHeight = sticks[i];
                count++;
            }
        }

        return count;
    }
}
