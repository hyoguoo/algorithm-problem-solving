/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1834
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.IntStream;

public class SameQuotientRemainder {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static BigInteger solution(int n) {
        return IntStream.range(1, n)
                .mapToObj(i -> BigInteger.valueOf(i).multiply(BigInteger.valueOf(n)).add(BigInteger.valueOf(i)))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
