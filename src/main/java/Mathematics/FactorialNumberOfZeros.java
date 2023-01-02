/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1676
 * Cheat Level: 0
 * Algorithm: Mathematics / Big Integer
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialNumberOfZeros {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());

        BigInteger factorial = getBigInteger(number);
        System.out.println(getCount(factorial));
    }

    private static int getCount(BigInteger factorial) {
        int count = 0;
        while (factorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count++;
            factorial = factorial.divide(BigInteger.TEN);
        }
        return count;
    }

    private static BigInteger getBigInteger(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; i++) factorial = factorial.multiply(BigInteger.valueOf(i));
        return factorial;
    }
}
