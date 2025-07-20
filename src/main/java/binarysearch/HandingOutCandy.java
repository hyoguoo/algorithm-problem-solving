/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28357
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HandingOutCandy {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long totalCandyCount = info[1];
        long[] scores = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(scores, totalCandyCount));
    }

    private static long solution(long[] scores, long totalCandyCount) {
        long[] sortedScores = Arrays.stream(scores)
                .sorted()
                .toArray();

        long left = 0;
        long right = Arrays.stream(scores).max().orElseThrow();

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canDistribute(sortedScores, totalCandyCount, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canDistribute(long[] scores, long totalCandyCount, long candyPerStudent) {
        long totalCandiesNeeded = 0;

        for (long score : scores) {
            if (score > candyPerStudent) {
                totalCandiesNeeded += score - candyPerStudent;
            }
        }

        return totalCandiesNeeded <= totalCandyCount;
    }
}
