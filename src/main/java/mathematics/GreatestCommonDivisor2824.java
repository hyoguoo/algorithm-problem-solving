/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2824
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class GreatestCommonDivisor2824 {

    private static final int DIVIDE_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers1 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        bufferedReader.readLine();
        int[] numbers2 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        BigInteger result = solution(numbers1, numbers2);
        if (result.compareTo(BigInteger.valueOf(DIVIDE_VALUE)) >= 0) {
            System.out.printf("%09d", result.remainder(BigInteger.valueOf(DIVIDE_VALUE)));

        } else {
            System.out.print(result);
        }
    }

    private static BigInteger solution(int[] numbers1, int[] numbers2) {
        BigInteger multiply1 = multiplyNumbers(numbers1);
        BigInteger multiply2 = multiplyNumbers(numbers2);

        return multiply1.gcd(multiply2);
    }

    private static BigInteger multiplyNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
