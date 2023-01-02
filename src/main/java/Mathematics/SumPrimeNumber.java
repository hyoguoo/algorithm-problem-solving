/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 4
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = sumPrimeNumber(numberArray, length);
        System.out.println(result);
    }

    public static int sumPrimeNumber(int[] numberArray, int length) {
        int sum = 0;
        for (int i = 1; i <= length; i++) {
            if (isPrime(i)) sum += numberArray[i - 1];
        }
        return sum;
    }

    public static boolean isPrime(int number) {
        if (number == 1 || number < 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}