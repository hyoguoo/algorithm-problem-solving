/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1654
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LanCableCut {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cables = new int[info[0]];
        int targetCount = info[1];

        for (int i = 0; i < cables.length; i++) {
            cables[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(solution(cables, targetCount));
    }

    private static long solution(int[] cables, int targetCount) {
        long left = 1;
        long right = Arrays.stream(cables).max().orElse(0);

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(cables, mid);

            if (count >= targetCount) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }

    private static long getCount(int[] cables, long mid) {
        return Arrays.stream(cables).mapToLong(cable -> cable / mid).sum();
    }
}
