/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1747
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PrimeAndPalindrome {


    public static void main(String[] args) throws IOException {
        System.out.println(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int n) {
        BigInteger bigInteger = BigInteger.valueOf(n);

        while (true) {
            if (bigInteger.isProbablePrime(10) && isPalindrome(bigInteger.toString())) return bigInteger.intValue();
            bigInteger = bigInteger.add(BigInteger.ONE);
        }
    }

    private static boolean isPalindrome(String string) {
        return string.contentEquals(new StringBuilder(string).reverse());
    }
}
