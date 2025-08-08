/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4892
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessNumberGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCase = 1;

        while (true) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == 0) {
                break;
            }

            stringBuilder.append(String.format("%d. ", testCase++))
                    .append(solution(number))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(int number) {
        int n1 = 3 * number;
        int n2 = (n1 % 2 == 0) ? (n1 / 2) : ((n1 + 1) / 2);
        int n3 = 3 * n2;
        int n4 = n3 / 9;
        OddEven oddEven = OddEven.from(n1);
        return new Result(oddEven, n4);
    }

    enum OddEven {
        ODD, EVEN;

        public static OddEven from(int number) {
            return (number % 2 == 0) ? EVEN : ODD;
        }
    }

    static class Result {

        private final OddEven oddEven;
        private final int number;

        public Result(OddEven oddEven, int number) {
            this.oddEven = oddEven;
            this.number = number;
        }

        @Override
        public String toString() {
            return String.format("%s %d", oddEven.name().toLowerCase(), number);
        }
    }
}
