/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2547
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class AnotherCandies {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            bufferedReader.readLine();
            int studentCount = Integer.parseInt(bufferedReader.readLine());
            BigInteger[] candies = new BigInteger[studentCount];
            for (int i = 0; i < studentCount; i++) {
                candies[i] = new BigInteger(bufferedReader.readLine());
            }
            stringBuilder
                    .append(
                            solution(candies)
                                    ? "YES"
                                    : "NO"
                    )
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(BigInteger[] candies) {
        return Arrays.stream(candies)
                .reduce(BigInteger.ZERO, BigInteger::add)
                .mod(BigInteger.valueOf(candies.length))
                .equals(BigInteger.ZERO);
    }
}
