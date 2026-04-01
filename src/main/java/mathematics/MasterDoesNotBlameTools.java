/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25905
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class MasterDoesNotBlameTools {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal[] successProbabilities = new BigDecimal[10];

        for (int i = 0; i < 10; i++) {
            String line = bufferedReader.readLine();
            if (line == null || line.isEmpty()) break;
            successProbabilities[i] = new BigDecimal(line);
        }

        System.out.println(solution(successProbabilities).stripTrailingZeros().toPlainString());
    }

    public static BigDecimal solution(BigDecimal[] successProbabilities) {
        Arrays.sort(successProbabilities, (a, b) -> b.compareTo(a));

        BigDecimal probabilityProduct = BigDecimal.ONE;
        for (int i = 0; i < 9; i++) {
            probabilityProduct = probabilityProduct.multiply(successProbabilities[i]);
        }

        BigDecimal denominator = BigDecimal.ONE;
        for (int i = 1; i <= 9; i++) {
            denominator = denominator.multiply(BigDecimal.valueOf(i));
        }

        return probabilityProduct.divide(denominator, MathContext.DECIMAL128)
                .multiply(BigDecimal.valueOf(1_000_000_000));
    }
}
