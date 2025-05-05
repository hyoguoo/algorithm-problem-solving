/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1252
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class AddingBinaryNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] binaryNumbers = bufferedReader.readLine().trim().split(" ");

        System.out.print(solution(binaryNumbers[0], binaryNumbers[1]));
    }

    private static String solution(String binaryNumber1, String binaryNumber2) {
        return new BigInteger(binaryNumber1, 2)
                .add(new BigInteger(binaryNumber2, 2))
                .toString(2);
    }
}
