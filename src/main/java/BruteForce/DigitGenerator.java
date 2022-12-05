/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15903
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitGenerator {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());
        
        System.out.println(findGeneratorNumber(target));
    }

    private static int findGeneratorNumber(int target) {

        for (int i = 1; i <= target; i++) {
            int sum = i;
            sum += sumEachDigits(i);
            if (sum == target) return i;
        }

        return 0;
    }

    private static int sumEachDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
