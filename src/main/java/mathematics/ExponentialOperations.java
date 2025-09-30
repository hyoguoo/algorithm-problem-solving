/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2052
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExponentialOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        return BigDecimal.ONE
                .divide(BigDecimal.valueOf(2).pow(n), n, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toPlainString();
    }
}
