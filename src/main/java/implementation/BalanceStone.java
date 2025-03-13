/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15788
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BalanceStone {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sizeN = Integer.parseInt(bufferedReader.readLine());
        long[][] stones = new long[sizeN][sizeN];

        Coordinate targetCoordinate = null;
        for (int i = 0; i < sizeN; i++) {
            long[] line = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            for (int j = 0; j < sizeN; j++) {
                stones[i][j] = line[j];
                if (line[j] == 0) {
                    targetCoordinate = new Coordinate(i, j);
                }
            }
        }

        System.out.print(solution(stones, targetCoordinate));
    }

    private static long solution(long[][] stones, Coordinate targetCoordinate) {
        long referenceSum = getReferenceSum(stones, targetCoordinate);
        long targetValue = getTargetValue(stones, targetCoordinate, referenceSum);
        stones[targetCoordinate.n][targetCoordinate.m] = targetValue;

        return validate(stones, referenceSum) && targetValue > 0
                ? targetValue
                : NOT_FOUND;
    }

    private static boolean validate(long[][] stones, long referenceSum) {
        for (int n = 0; n < stones.length; n++) {
            long rowSum = Arrays.stream(stones[n]).sum();
            if (rowSum != referenceSum) {
                return false;
            }
        }

        for (int m = 0; m < stones.length; m++) {
            final int mCopy = m;
            long colSum = Arrays.stream(stones)
                    .mapToLong(row -> row[mCopy])
                    .sum();
            if (colSum != referenceSum) {
                return false;
            }
        }

        long mainDiagonalSum = IntStream.range(0, stones.length)
                .mapToLong(i -> stones[i][i])
                .sum();

        long antiDiagonalSum = IntStream.range(0, stones.length)
                .mapToLong(i -> stones[i][stones.length - 1 - i])
                .sum();

        return mainDiagonalSum == referenceSum && antiDiagonalSum == referenceSum;
    }

    private static long getTargetValue(long[][] stones, Coordinate targetCoordinate, long referenceSum) {
        long horizontalSum = Arrays.stream(stones[targetCoordinate.n]).sum();

        return referenceSum - horizontalSum;
    }

    private static long getReferenceSum(long[][] stones, Coordinate targetCoordinate) {
        for (int n = 0; n < stones.length; n++) {
            if (n != targetCoordinate.n) {
                return Arrays.stream(stones[n]).sum();
            }
        }

        throw new IllegalArgumentException();
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
