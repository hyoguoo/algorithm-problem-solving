/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26082
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class WARBOY {

    private static final int WARBOY_PRODUCT_PERFORMANCE_MULTIPLIER = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        System.out.print(solution(info[0], info[1], info[2]));
    }

    private static BigDecimal solution(int competitorProductPrice, int competitorProductPerformance, int warboyProductPrice) {
        return BigDecimal.valueOf(WARBOY_PRODUCT_PERFORMANCE_MULTIPLIER)
                .multiply(BigDecimal.valueOf(competitorProductPerformance))
                .multiply(BigDecimal.valueOf(warboyProductPrice))
                .divide(BigDecimal.valueOf(competitorProductPrice), 0, RoundingMode.DOWN);
    }
}
