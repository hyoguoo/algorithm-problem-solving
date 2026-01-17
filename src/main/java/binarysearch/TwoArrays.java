/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17124
 * Cheat Level: 0
 * Algorithm: Sort / Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoArrays {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        while (testCaseCount-- > 0) {
            bufferedReader.readLine();

            int[] sourceValues = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] candidateValues = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            long totalClosestSum = findClosestSum(sourceValues, candidateValues);

            stringBuilder
                    .append(totalClosestSum)
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int findClosest(int target, int[] candidateValues) {
        int index = Arrays.binarySearch(candidateValues, target);

        if (index >= 0) {
            return candidateValues[index];
        }

        int insertionPoint = -index - 1;

        if (insertionPoint == 0) {
            return candidateValues[0];
        }
        if (insertionPoint == candidateValues.length) {
            return candidateValues[candidateValues.length - 1];
        }

        int left = candidateValues[insertionPoint - 1];
        int right = candidateValues[insertionPoint];

        return Math.abs(target - left) <= Math.abs(target - right)
                ? left
                : right;
    }


    private static long findClosestSum(int[] sourceValues, int[] candidateValues) {
        Arrays.sort(candidateValues);

        long sum = 0;

        for (int value : sourceValues) {
            sum += findClosest(value, candidateValues);
        }

        return sum;
    }
}
