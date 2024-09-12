/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14627
 * Cheat Level: 2
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreenOnionChicken {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int greenOnionCount = info[0];
        int chickenCount = info[1];
        int[] greenOnionLengths = new int[greenOnionCount];

        for (int i = 0; i < greenOnionCount; i++) {
            greenOnionLengths[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(greenOnionLengths, chickenCount));
    }

    private static long solution(int[] greenOnionLengths, int chickenCount) {
        int left = 1;
        int right = Arrays.stream(greenOnionLengths).max().orElseThrow();

        while (left <= right) {
            int length = (left + right) / 2;
            int greenOnionCount = getGreenOnionCount(greenOnionLengths, length);
            if (greenOnionCount >= chickenCount) {
                left = length + 1;
            } else {
                right = length - 1;
            }
        }

        return calculateRemainOnion(greenOnionLengths, right, chickenCount);
    }

    private static long calculateRemainOnion(
            int[] greenOnionLengths,
            int length,
            int targetChickenCount
    ) {
        long allGreenOnionLength = 0;

        for (int greenOnionLength : greenOnionLengths) {
            allGreenOnionLength += greenOnionLength;
        }

        return allGreenOnionLength - (long) length * targetChickenCount;
    }

    private static int getGreenOnionCount(int[] greenOnionLengths, int length) {
        return Arrays.stream(greenOnionLengths)
                .map(greenOnionLength -> greenOnionLength / length)
                .sum();
    }
}
