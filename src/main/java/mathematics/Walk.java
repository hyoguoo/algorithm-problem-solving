/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1459
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Walk {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Coordinate target = new Coordinate(info[0], info[1]);
        int blockTime = info[2];
        int diagonalTime = info[3];

        System.out.print(solution(target, blockTime, diagonalTime));
    }

    private static long solution(Coordinate target, int blockTime, int diagonalTime) {
        Coordinate start = new Coordinate(START_X, START_Y);

        return Stream.of(
                        calculateUsingOnlyBlocks(start, target, blockTime),
                        calculateUsingOnlyDiagonals(start, target, diagonalTime, blockTime),
                        calculateUsingBoth(start, target, blockTime, diagonalTime)
                )
                .min(Long::compareTo)
                .orElseThrow();
    }

    private static long calculateUsingOnlyBlocks(Coordinate start, Coordinate target, int blockTime) {
        return start.getManhattanDistance(target) * blockTime;
    }

    private static long calculateUsingOnlyDiagonals(Coordinate start, Coordinate target, int diagonalTime, int blockTime) {
        long digonalDistance = Math.max(Math.abs(target.x - start.x), Math.abs(target.y - start.y));
        if (Math.abs((target.x - start.x) + (target.y - start.y)) % 2 == 0) {
            return digonalDistance * diagonalTime;
        }
        return (digonalDistance - 1) * diagonalTime + blockTime;
    }

    private static long calculateUsingBoth(Coordinate start, Coordinate target, int blockTime, int diagonalTime) {
        long diff = Math.abs((target.x - start.x) - (target.y - start.y));

        long min = Math.min(Math.abs(target.x - start.x), Math.abs(target.y - start.y));
        return min * diagonalTime + diff * blockTime;
    }

    static class Coordinate {

        private final long x;
        private final long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getManhattanDistance(Coordinate target) {
            return Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
        }
    }
}
