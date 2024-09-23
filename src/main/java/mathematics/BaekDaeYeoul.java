/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14490
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekDaeYeoul {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String input) {
        return new Ratio(input).getReducedRatio().toString();
    }

    static class Ratio {

        private static final String COLON = ":";
        private final int numerator;
        private final int denominator;

        public Ratio(String ratioString) {
            String[] split = ratioString.split(COLON);
            this.numerator = Integer.parseInt(split[0]);
            this.denominator = Integer.parseInt(split[1]);
        }

        public Ratio(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getGcd() {
            int a = numerator;
            int b = denominator;

            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }

            return a;
        }

        public Ratio getReducedRatio() {
            int gcd = getGcd();
            return new Ratio(numerator / gcd, denominator / gcd);
        }

        @Override
        public String toString() {
            return numerator + COLON + denominator;
        }
    }
}
