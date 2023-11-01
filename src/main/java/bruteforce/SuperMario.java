/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2851
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperMario {

    static final int COUNT = 10;
    static final int TARGET = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int sum = 0;
        int previous = 0;

        for (int number : numbers) {
            sum += number;
            if (sum >= TARGET) {
                int diff1 = Math.abs(sum - TARGET);
                int diff2 = Math.abs(previous - TARGET);

                if (diff1 <= diff2) return sum;
                return previous;
            }
            previous = sum;
        }

        return sum;
    }
}
