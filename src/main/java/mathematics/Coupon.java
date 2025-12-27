/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10179
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Coupon {

    private static final long DISCOUNT_RATE = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            BigDecimal price = new BigDecimal(bufferedReader.readLine());
            stringBuilder
                    .append("$")
                    .append(solution(price))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static BigDecimal solution(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(100 - DISCOUNT_RATE))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
