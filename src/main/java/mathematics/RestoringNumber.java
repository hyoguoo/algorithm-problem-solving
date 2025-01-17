/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2312
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoringNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int n) {
        List<Factor> factors = new ArrayList<>();
        int factor = 2;

        while (n > 1) {
            int count = 0;
            while (n % factor == 0) {
                n /= factor;
                count++;
            }
            if (count > 0) {
                factors.add(new Factor(factor, count));
            }
            factor++;
        }

        return factors.stream()
                .map(Factor::toString)
                .collect(Collectors.joining("\n"));
    }

    static class Factor {

        private final int factorValue;
        private final int count;

        public Factor(int factorValue, int count) {
            this.factorValue = factorValue;
            this.count = count;
        }

        @Override
        public String toString() {
            return factorValue + " " + count;
        }
    }
}
