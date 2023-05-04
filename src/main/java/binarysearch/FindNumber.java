/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1920
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] reference = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bufferedReader.readLine();
        int[] targets = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(reference);
        for (int target : targets) System.out.println(binarySearch(reference, target) ? 1 : 0);
    }

    private static boolean binarySearch(int[] reference, int target) {
        int start = 0;
        int end = reference.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (reference[mid] == target) return true;
            else if (reference[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
