/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5212
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GlobalWarming {

    private static final int SEA_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = sizeInfo[0];
        int sizeM = sizeInfo[1];
        Symbol[][] symbols = new Symbol[sizeN][sizeM];

        for (int i = 0; i < sizeN; i++) {
            symbols[i] = Arrays.stream(bufferedReader.readLine().split(""))
                    .map(Symbol::of)
                    .toArray(Symbol[]::new);
        }

        System.out.print(solution(symbols));
    }

    private static String solution(Symbol[][] symbols) {
        Symbol[][] afterMap = getAfterMap(symbols);
        Symbol[][] refinedMap = getRefinedMap(symbols, afterMap);

        return Arrays.stream(refinedMap)
                .map(row -> Arrays.stream(row)
                        .map(Symbol::toString)
                        .collect(Collectors.joining("")))
                .collect(Collectors.joining("\n"));
    }

    private static Symbol[][] getAfterMap(Symbol[][] symbols) {
        int sizeN = symbols.length;
        int sizeM = symbols[0].length;
        Symbol[][] afterMap = new Symbol[sizeN][sizeM];

        for (int n = 0; n < sizeN; n++) {
            for (int m = 0; m < sizeM; m++) {
                switch (symbols[n][m]) {
                    case SEA:
                        afterMap[n][m] = Symbol.SEA;
                        break;
                    case LAND:
                        Coordinate currentCoordinate = new Coordinate(n, m);
                        afterMap[n][m] = getSymbolBySeaCount(symbols, currentCoordinate);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }

        return afterMap;
    }

    private static Symbol[][] getRefinedMap(Symbol[][] symbols, Symbol[][] afterMap) {
        int firstLandN = Integer.MAX_VALUE;
        int firstLandM = Integer.MAX_VALUE;
        int lastLandN = Integer.MIN_VALUE;
        int lastLandM = Integer.MIN_VALUE;

        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < symbols[i].length; j++) {
                if (afterMap[i][j] == Symbol.LAND) {
                    firstLandN = Math.min(firstLandN, i);
                    firstLandM = Math.min(firstLandM, j);
                    lastLandN = Math.max(lastLandN, i);
                    lastLandM = Math.max(lastLandM, j);
                }
            }
        }

        Symbol[][] refinedMap = new Symbol[lastLandN - firstLandN + 1][lastLandM - firstLandM + 1];

        for (int n = firstLandN; n <= lastLandN; n++) {
            if (lastLandM + 1 - firstLandM >= 0) {
                System.arraycopy(afterMap[n], firstLandM, refinedMap[n - firstLandN], 0, lastLandM + 1 - firstLandM);
            }
        }

        return refinedMap;
    }

    private static Symbol getSymbolBySeaCount(Symbol[][] symbols, Coordinate coordinate) {
        int seaCount = 0;

        for (Direction direction : Direction.values()) {
            Coordinate nextCoordinate = coordinate.next(direction);
            if (isSeaOrOutOfBound(symbols, nextCoordinate)) {
                seaCount++;
            }
        }

        return seaCount >= SEA_COUNT ? Symbol.SEA : Symbol.LAND;
    }

    private static boolean isSeaOrOutOfBound(Symbol[][] symbols, Coordinate nextCoordinate) {
        return !isInBound(nextCoordinate, symbols) ||
                symbols[nextCoordinate.n][nextCoordinate.m] == Symbol.SEA;
    }

    private static boolean isInBound(Coordinate coordinate, Symbol[][] symbols) {
        int sizeN = symbols.length;
        int sizeM = symbols[0].length;

        return 0 <= coordinate.n && coordinate.n < sizeN &&
                0 <= coordinate.m && coordinate.m < sizeM;
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    enum Symbol {
        LAND("X"),
        SEA(".");

        private final String value;

        Symbol(String value) {
            this.value = value;
        }

        public static Symbol of(String value) {
            return Arrays.stream(Symbol.values())
                    .filter(s -> s.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate next(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }

    }
}
