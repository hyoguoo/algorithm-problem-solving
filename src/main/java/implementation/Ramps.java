/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14890
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Ramps {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int rampLength = info[1];
        int[][] map = new int[sizeN][sizeN];

        for (int n = 0; n < sizeN; n++) {
            map[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(map, rampLength));
    }

    private static int solution(int[][] map, int rampLength) {
        return countHorizontalLines(map, rampLength) + countVerticalLines(map, rampLength);
    }

    private static int countHorizontalLines(int[][] map, int rampLength) {
        return Arrays.stream(map)
                .mapToInt(line -> check(line, rampLength) ? 1 : 0)
                .sum();
    }

    private static int countVerticalLines(int[][] map, int rampLength) {
        return IntStream.range(0, map.length)
                .map(m -> check(getVerticalLine(map, m), rampLength) ? 1 : 0)
                .sum();
    }

    private static int[] getVerticalLine(int[][] map, int m) {
        return Arrays.stream(map)
                .mapToInt(row -> row[m])
                .toArray();
    }

    private static boolean check(int[] line, int rampLength) {
        int index = 0;
        boolean[] isRamped = new boolean[line.length];

        while (index < line.length - 1) {
            int currentHeight = line[index];
            int nextHeight = line[index + 1];
            Type type = Type.of(nextHeight - currentHeight);

            if (!processLine(type, line, isRamped, index, rampLength, currentHeight, nextHeight)) {
                return false;
            }

            index += offsetIndex(type, rampLength);
        }

        return true;
    }

    private static boolean processLine(Type type,
            int[] line,
            boolean[] isRamped,
            int index,
            int rampLength,
            int currentHeight,
            int nextHeight) {
        switch (type) {
            case FLAT:
                return true;
            case UPHILL:
                return placeRamp(line, isRamped, index, type.direction, currentHeight, rampLength);
            case DOWNHILL:
                return placeRamp(line, isRamped, index + 1, type.direction, nextHeight, rampLength);
            case INVALID:
            default:
                return false;
        }
    }

    private static boolean placeRamp(int[] line,
            boolean[] isRamped,
            int startIndex,
            int direction,
            int targetHeight,
            int rampLength) {
        if (notAvailablePlaceRamp(line, isRamped, startIndex, direction, targetHeight, rampLength)) {
            return false;
        }
        markRamp(isRamped, startIndex, direction, rampLength);
        return true;
    }

    private static int offsetIndex(Type type, int rampLength) {
        switch (type) {
            case FLAT:
            case UPHILL:
                return 1;
            case DOWNHILL:
                return rampLength;
            default:
                return 0;
        }
    }

    private static boolean notAvailablePlaceRamp(int[] line,
            boolean[] isRamped,
            int startIndex,
            int direction,
            int targetHeight,
            int rampLength) {
        for (int r = 0; r < rampLength; r++) {
            int index = startIndex + r * direction;
            if (index < 0 || index >= line.length || line[index] != targetHeight || isRamped[index]) {
                return true;
            }
        }
        return false;
    }

    private static void markRamp(boolean[] isRamped, int startIndex, int direction, int rampLength) {
        for (int r = 0; r < rampLength; r++) {
            int index = startIndex + r * direction;
            isRamped[index] = true;
        }
    }

    enum Type {
        FLAT(0, 0),
        UPHILL(1, -1),
        DOWNHILL(-1, 1),
        INVALID(Integer.MAX_VALUE, 0);

        private final int heightDiff;
        private final int direction;

        Type(int heightDiff, int direction) {
            this.heightDiff = heightDiff;
            this.direction = direction;
        }

        public static Type of(int heightDiff) {
            return Arrays.stream(values())
                    .filter(type -> type.heightDiff == heightDiff)
                    .findFirst()
                    .orElse(INVALID);
        }
    }
}
