/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2942
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FergusonAndApple {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers[0], numbers[1]));
    }

    private static String solution(int a, int b) {
        int gcd = gcd(a, b);

        List<Divisor> divisorList = new ArrayList<>();

        for (int n = 1; n <= Math.sqrt(gcd); n++) {
            if (gcd % n == 0) {
                divisorList.add(new Divisor(n, a / n, b / n));
                if (n != gcd / n) {
                    divisorList.add(new Divisor(gcd / n, a / (gcd / n), b / (gcd / n)));
                }
            }
        }

        return divisorList.stream()
                .map(Divisor::toString)
                .collect(Collectors.joining("\n"));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class Divisor {

        private final int divisorValue;
        private final int quotientA;
        private final int quotientB;

        public Divisor(int divisorValue, int quotientA, int quotientB) {
            this.divisorValue = divisorValue;
            this.quotientA = quotientA;
            this.quotientB = quotientB;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", divisorValue, quotientA, quotientB);
        }
    }
}
