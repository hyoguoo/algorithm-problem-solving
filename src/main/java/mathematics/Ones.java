/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4375
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ones {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.isEmpty()) break;
            stringBuilder.append(solution(Integer.parseInt(input))).append("\n");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    private static int solution(int n) {
        BigInteger bigInteger = BigInteger.ONE;

        while (true) {
            if (isDivisibleBy(n, bigInteger)) return bigInteger.toString().length();
            bigInteger = addOneAfter(bigInteger);
        }
    }

    private static BigInteger addOneAfter(BigInteger bigInteger) {
        return bigInteger.multiply(BigInteger.TEN).add(BigInteger.ONE);
    }

    private static boolean isDivisibleBy(int n, BigInteger bigInteger) {
        return bigInteger.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO);
    }
}
