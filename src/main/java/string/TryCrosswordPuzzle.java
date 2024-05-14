/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3005
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TryCrosswordPuzzle {

    private static final char BLOCK = '#';
    private static final int MIN_WORD_LENGTH = 2;

    public static void main(String[] args) throws IOException {
        char[][] map = parseMap();
        System.out.print(solution(map));
    }

    private static char[][] parseMap() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];

        char[][] map = new char[sizeN][sizeM];

        for (int n = 0; n < sizeN; n++) {
            map[n] = bufferedReader.readLine().toCharArray();
        }
        return map;
    }

    private static String solution(char[][] map) {
        String result = "z".repeat(20);

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map[n].length; m++) {
                for (Direction direction : Direction.values()) {
                    String word = getWord(map, new Coordinate(n, m), direction);

                    if (word != null && word.compareTo(result) < 0) {
                        result = word;
                    }
                }
            }
        }

        return result;
    }

    private static String getWord(char[][] map, Coordinate coordinate, Direction direction) {
        Coordinate previousCoordinate = coordinate.getPrevious(direction);

        if (
                previousCoordinate.isInBound(map) &&
                        map[previousCoordinate.n][previousCoordinate.m] != BLOCK
        ) {
            return null;
        }

        StringBuilder word = new StringBuilder();

        while (coordinate.isInBound(map) && map[coordinate.n][coordinate.m] != BLOCK) {
            word.append(map[coordinate.n][coordinate.m]);
            coordinate = coordinate.getNext(direction);
        }

        if (word.length() < MIN_WORD_LENGTH) {
            return null;
        }

        return word.toString();
    }

    enum Direction {
        RIGHT(0, 1),
        DOWN(1, 0);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate getPrevious(Direction direction) {
            return new Coordinate(n - direction.n, m - direction.m);
        }

        public Coordinate getNext(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }

        public boolean isInBound(char[][] map) {
            return 0 <= n && n < map.length &&
                    0 <= m && m < map[n].length;
        }
    }
}
