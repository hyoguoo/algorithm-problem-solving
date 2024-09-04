/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2018
 * Cheat Level: 0
 * Algorithm: Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumbersSum5 {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        Integer.parseInt(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    private static int solution(int n) {
        int count = 0;
        int left = 1;
        int right = 1;
        int sum = 1;

        while (left <= n) {
            if (sum == n) {
                count++;
                sum -= left;
                left++;
            } else if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }

        return count;
    }
}
