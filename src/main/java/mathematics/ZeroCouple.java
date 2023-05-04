/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 3주차 문제 1
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZeroCouple {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = countPrimeNumber(numberArray);
        System.out.println(sum);
    }

    public static int countPrimeNumber(int[] numbers) {
        int sum = 0;
        for (int number : numbers) sum += number;
        return sum;
    }
}