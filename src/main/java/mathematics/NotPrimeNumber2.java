/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29196
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotPrimeNumber2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.print(solution(input));
    }

    private static String solution(String k) {
        if (!k.contains(".")) {
            return "YES\n" + k + " 1";
        }

        String[] parts = k.split("\\.");
        String decimalPart = parts[1];

        long denominator = 1;
        for (int i = 0; i < decimalPart.length(); i++) {
            denominator *= 10;
        }

        long numerator = Long.parseLong(decimalPart);

        long g = gcd(numerator, denominator);
        numerator /= g;
        denominator /= g;

        return "YES\n" + numerator + " " + denominator;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
