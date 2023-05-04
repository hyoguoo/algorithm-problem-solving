/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13277
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class MultiplicationLargeNumbers {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BigInteger number1 = scanner.nextBigInteger();
        BigInteger number2 = scanner.nextBigInteger();

        System.out.println(number1.multiply(number2));
    }
}
