/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1475
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(bufferedReader.readLine().toCharArray()));
    }

    private static int solution(char[] charNumberArray) {
        int[] count = getNumberCount(charNumberArray);

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, count[i]);
        }

        return Math.max(max, (count[6] + count[9] + 1) / 2);
    }

    private static int[] getNumberCount(char[] charNumberArray) {
        int[] count = new int[10];
        for (char c : charNumberArray) count[c - '0']++;
        return count;
    }
}
