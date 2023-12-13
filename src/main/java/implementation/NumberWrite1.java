/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1748
 * Cheat Level:
 * Algorithm:
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberWrite1 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int n) {
        int number = 1;
        int count = 0;

        while (number <= n) {
            count += (n - number + 1);
            number *= 10;
        }

        return count;
    }
}
