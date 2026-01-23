/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1359
 * Cheat Level: 0
 * Algorithm: Mathematics / Combinations
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Lottery {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int k = input[2];

        System.out.printf("%.16f", solution(n, m, k));
    }

    private static BigDecimal solution(int n, int m, int k) {
        BigDecimal totalCases = combinations(n, m);
        BigDecimal winningCases = BigDecimal.ZERO;

        for (int i = k; i <= m; i++) {
            if (m - i > n - m) {
                continue;
            }
            winningCases = winningCases.add(combinations(m, i).multiply(combinations(n - m, m - i)));
        }

        return winningCases.divide(totalCases, 50, RoundingMode.HALF_UP);
    }

    public static BigDecimal combinations(int n, int k) {
        if (k < 0 || k > n) {
            return BigDecimal.ZERO;
        }
        if (k > n / 2) {
            k = n - k;
        }
        if (k == 0) {
            return BigDecimal.ONE;
        }
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < k; i++) {
            result = result
                    .multiply(BigDecimal.valueOf((long) n - i))
                    .divide(BigDecimal.valueOf((long) i + 1), 50, RoundingMode.HALF_UP);
        }
        return result;
    }
}
