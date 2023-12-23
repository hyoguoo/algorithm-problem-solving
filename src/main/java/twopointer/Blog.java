/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21921
 * Cheat Level: 0
 * Algorithm: Two Pointer / Sliding Window
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Blog {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = info[1];
        int[] visitors = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(visitors, length);
    }

    private static void solution(int[] visitors, int length) {
        int initialSum = getInitialSum(visitors, length);

        int leftIndex = 0;
        int rightIndex = length - 1;

        int maxSum = initialSum;
        int maxCount = 1;

        while (rightIndex < visitors.length - 1) {
            initialSum -= visitors[leftIndex++];
            initialSum += visitors[++rightIndex];

            if (initialSum > maxSum) {
                maxSum = initialSum;
                maxCount = 1;
            } else if (initialSum == maxSum) {
                maxCount++;
            }
        }

        if (maxSum == 0) System.out.println("SAD");
        else System.out.println(maxSum + "\n" + maxCount);
    }

    private static int getInitialSum(int[] visitors, int length) {
        return Arrays.stream(visitors).limit(length).sum();
    }
}
