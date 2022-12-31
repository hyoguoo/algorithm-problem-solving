/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1065
 * Cheat Level: 0
 * Algorithm: Brute Force / Mathematics
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(number));
    }

    public static int solution(int number) {

        if (number < 100)
            return number;
        int count = 99;
        for (int i = 100; i <= number; i++) {
            int x = i / 100;
            int y = (i / 10) % 10;
            int z = i % 10;

            if ((x - y) == (y - z)) count++;
        }

        return count;
    }
}
