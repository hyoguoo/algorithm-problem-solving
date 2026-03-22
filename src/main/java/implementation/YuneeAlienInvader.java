/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26123
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YuneeAlienInvader {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int day = info[1];
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(heights, day));
    }

    private static long solution(int[] heights, int day) {
        Arrays.sort(heights);
        long totalShots = 0;
        int daysRemaining = day;

        for (int d = heights.length - 1; d >= 0 && daysRemaining > 0; d--) {
            int nextHeight = (d > 0) ? heights[d - 1] : 0;
            int daysInPhase = heights[d] - nextHeight;
            int buildingCount = heights.length - d;

            if (daysInPhase > 0) {
                int used = Math.min(daysRemaining, daysInPhase);
                totalShots += (long) buildingCount * used;
                daysRemaining -= used;
            }
        }

        return totalShots;
    }
}
