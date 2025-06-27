/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14233
 * Cheat Level: 0
 * Algorithm: Greedy / Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoguePresident {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        int[] deadlines = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(deadlines));
    }

    private static int solution(int[] deadlines) {
        int[] sortedDeadlines = Arrays.stream(deadlines)
                .sorted()
                .toArray();

        int left = 1;
        int right = sortedDeadlines[sortedDeadlines.length - 1];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAssign(sortedDeadlines, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean canAssign(int[] deadlines, int k) {
        int day = 0;

        for (int deadline : deadlines) {
            day += k;
            if (day > deadline) {
                return false;
            }
        }

        return true;
    }
}
