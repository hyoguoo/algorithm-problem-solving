/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1789
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();

        System.out.println(solution(input));
    }

    private static long solution(long input) {
        long sum = 0;
        long number = 0;
        while (sum <= input) {
            number++;
            sum += number;
        }
        number--;

        return number;
    }
}
