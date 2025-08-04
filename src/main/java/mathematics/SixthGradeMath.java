/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2702
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SixthGradeMath {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(numbers[0], numbers[1]))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(int a, int b) {
        int gcd = gcd(a, b);
        int lcm = (a * b) / gcd;

        return new Result(lcm, gcd);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static class Result {

        private final int lcm;
        private final int gcd;

        public Result(int lcm, int gcd) {
            this.lcm = lcm;
            this.gcd = gcd;
        }

        @Override
        public String toString() {
            return lcm + " " + gcd;
        }
    }
}
