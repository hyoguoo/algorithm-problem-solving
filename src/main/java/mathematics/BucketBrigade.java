/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17198
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class BucketBrigade {

    private static final int GRID_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<Symbol, Coordinate> coordinateMap = new EnumMap<>(Symbol.class);

        for (int i = 0; i < GRID_SIZE; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < s.length(); j++) {
                Symbol symbol = Symbol.of(s.charAt(j));
                if (symbol != Symbol.EMPTY) {
                    coordinateMap.put(symbol, new Coordinate(i, j));
                }
            }
        }

        System.out.print(
                solution(
                        coordinateMap.get(Symbol.LAKE),
                        coordinateMap.get(Symbol.BARN),
                        coordinateMap.get(Symbol.ROCK)
                )
        );
    }


    private static int solution(Coordinate lakeCoordinate, Coordinate barnCoordinate, Coordinate rockCoordinate) {
        int distance = lakeCoordinate.getManhattanDistance(barnCoordinate);

        if (lakeCoordinate.isSameRowOrColumn(barnCoordinate) &&
                rockCoordinate.isBetween(lakeCoordinate, barnCoordinate)) {
            return distance + 1;
        }

        return distance - 1;
    }

    enum Symbol {
        EMPTY('.'),
        ROCK('R'),
        LAKE('L'),
        BARN('B');

        private final char value;

        Symbol(char value) {
            this.value = value;
        }

        public static Symbol of(char symbol) {
            return Arrays.stream(values())
                    .filter(s -> s.value == symbol)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getManhattanDistance(Coordinate coordinate) {
            return Math.abs(n - coordinate.n) + Math.abs(m - coordinate.m);
        }

        public boolean isSameRowOrColumn(Coordinate coordinate) {
            return n == coordinate.n || m == coordinate.m;
        }

        public boolean isBetween(Coordinate start, Coordinate end) {
            if (n == start.n && n == end.n) {
                return (m > Math.min(start.m, end.m) && m < Math.max(start.m, end.m));
            }
            if (m == start.m && m == end.m) {
                return (n > Math.min(start.n, end.n) && n < Math.max(start.n, end.n));
            }
            return false;
        }
    }
}
