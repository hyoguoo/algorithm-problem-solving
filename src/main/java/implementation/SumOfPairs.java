/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5217
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Pair> result = solution(n);
            String resultString = result.stream()
                    .map(Pair::toString)
                    .collect(Collectors.joining(", "))
                    .trim();
            stringBuilder
                    .append(String.format("Pairs for %d: ", n))
                    .append(resultString)
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static List<Pair> solution(int n) {
        List<Pair> result = new ArrayList<>();

        for (int a = 1; a <= n / 2; a++) {
            int b = n - a;
            if (a != b) {
                result.add(new Pair(a, b));
            }
        }

        return result;
    }

    static class Pair {

        private final int a;
        private final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }
}
