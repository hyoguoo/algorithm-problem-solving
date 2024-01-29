/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1735
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FractionalSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] fractionInfo1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] fractionInfo2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(new Fraction(fractionInfo1[0], fractionInfo1[1]), new Fraction(fractionInfo2[0], fractionInfo2[1]));
    }

    private static void solution(Fraction fraction1, Fraction fraction2) {
        int lcm = getLCM(fraction1.denominator, fraction2.denominator);

        int numerator1 = fraction1.numerator * (lcm / fraction1.denominator);
        int numerator2 = fraction2.numerator * (lcm / fraction2.denominator);

        int numerator = numerator1 + numerator2;
        int gcd = getGCD(numerator, lcm);

        System.out.print(numerator / gcd + " " + lcm / gcd);
    }

    private static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    static class Fraction {
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
}
