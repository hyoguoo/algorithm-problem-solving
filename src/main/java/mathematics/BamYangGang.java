/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31926
 * Cheat Level: 0
 * Algorithm: Mathematics / Greedy
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BamYangGang {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(solution(n));
    }

    private static int solution(int n) {
        int firstDALDIALGOCount = 8;
        int twoExponent = calculateExponent(n);
        int lastDALDIDANCount = calculateDALDIDANTime(n, twoExponent);
        return firstDALDIALGOCount + twoExponent + lastDALDIDANCount;
    }

    public static int calculateExponent(int number) {
        int exponent = 0;
        int powerOfTwo = 1;

        while (powerOfTwo < number) {
            powerOfTwo *= 2;
            exponent++;
        }

        return exponent;
    }

    public static int calculateDALDIDANTime(int n, int exponent) {
        return n - Math.pow(2, exponent) == 0
                ? 2
                : 1;
    }
}
