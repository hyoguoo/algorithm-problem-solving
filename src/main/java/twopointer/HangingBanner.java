/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27527
 * Cheat Level: 0
 * Algorithm: Two Pointer / Sliding Window
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HangingBanner {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int consecutiveCount = info[1];
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(heights, consecutiveCount) ? "YES" : "NO");
    }

    private static boolean solution(int[] heights, int consecutiveCount) {
        int threshold = (9 * consecutiveCount + 9) / 10;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < consecutiveCount; i++) {
            int val = heights[i];
            int newCount = freq.getOrDefault(val, 0) + 1;
            if (newCount >= threshold) {
                return true;
            }
            freq.put(val, newCount);
        }

        for (int i = consecutiveCount; i < heights.length; i++) {
            int out = heights[i - consecutiveCount];
            int outCount = freq.get(out) - 1;
            if (outCount == 0) {
                freq.remove(out);
            } else {
                freq.put(out, outCount);
            }

            int in = heights[i];
            int inCount = freq.getOrDefault(in, 0) + 1;
            if (inCount >= threshold) {
                return true;
            }
            freq.put(in, inCount);
        }

        return false;
    }
}
