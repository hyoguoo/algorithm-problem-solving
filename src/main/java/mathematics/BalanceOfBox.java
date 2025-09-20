/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20116
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

public class BalanceOfBox {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int boxSize = info[1];
        int[] boxPositions = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(boxPositions, boxSize) ? "stable" : "unstable");
    }

    private static boolean solution(int[] boxPositions, int boxSize) {
        if (boxPositions.length == 1) {
            return true;
        }
        BigDecimal currentSum = BigDecimal.valueOf(boxPositions[boxPositions.length - 1]);
        int boxCount = 1;

        for (int i = boxPositions.length - 2; i >= 0; i--) {
            BigDecimal boxesCenterPosition = currentSum.divide(BigDecimal.valueOf(boxCount), 10, RoundingMode.HALF_UP);
            if (!isInRange(boxesCenterPosition, BigDecimal.valueOf(boxSize), BigDecimal.valueOf(boxPositions[i]))) {
                return false;
            }
            currentSum = currentSum.add(BigDecimal.valueOf(boxPositions[i]));
            boxCount++;
        }

        return true;
    }

    private static boolean isInRange(BigDecimal boxPosition, BigDecimal boxSize, BigDecimal targetPosition) {
        return targetPosition.compareTo(boxPosition.subtract(boxSize)) > 0
                && targetPosition.compareTo(boxPosition.add(boxSize)) < 0;
    }
}
