/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19539
 * Cheat Level: 2
 * Algorithm: Greedy
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppleTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers) ? "YES" : "NO");
    }

    private static boolean solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();

        if (sum % 3 != 0) return false;

        int count = sum / 3;
        int twoCount = 0;
        int oneCount = 0;
        for (int number : numbers) {
            twoCount += number / 2;
            oneCount += number % 2;
        }
        if (twoCount > count) oneCount += (twoCount - count) * 2;

        return oneCount == count;
    }
}
