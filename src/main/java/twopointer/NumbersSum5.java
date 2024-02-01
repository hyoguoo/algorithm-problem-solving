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
        System.out.print(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int n) {
        int left = 1;
        int right = 1;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= n) {
                sum -= left;
                left++;
            } else if (right <= n) {
                sum += right;
                right++;
            } else {
                break;
            }

            if (sum == n) count++;
        }

        return count;
    }
}
