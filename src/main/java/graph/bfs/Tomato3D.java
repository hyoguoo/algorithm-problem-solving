/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7569
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato3D {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeM = info[0];
        int sizeN = info[1];
        int sizeH = info[2];

        Symbol[][][] tomatoes = new Symbol[sizeH][sizeN][sizeM];

        for (int h = 0; h < sizeH; h++) {
            for (int n = 0; n < sizeN; n++) {
                tomatoes[h][n] = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .mapToObj(Symbol::of)
                        .toArray(Symbol[]::new);
            }
        }

        System.out.print(solution(tomatoes));
    }

    private static int solution(Symbol[][][] tomatoes) {
        TomatoBox tomatoBox = new TomatoBox(tomatoes);
        tomatoBox.ripenTomatoes();

        return tomatoBox.getDay();
    }

    enum Symbol {
        EMPTY(-1),
        RIPENED_TOMATO(1),
        UNRIPENED_TOMATO(0);

        private final int value;

        Symbol(int value) {
            this.value = value;
        }

        public static Symbol of(int value) {
            return Arrays.stream(values())
                    .filter(symbol -> symbol.value == value)
                    .findFirst()
                    .orElseThrow();
        }
    }

    enum Direction {
        UP(-1, 0, 0),
        DOWN(1, 0, 0),
        LEFT(0, -1, 0),
        RIGHT(0, 1, 0),
        FRONT(0, 0, 1),
        BACK(0, 0, -1);

        private final int h;
        private final int n;
        private final int m;

        Direction(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }

    static class TomatoBox {

        private static final int NOT_VISITED = -1;
        private static final int NOT_ALL_RIPENED = -1;

        private final Symbol[][][] tomatoes;
        private final int[][][] distance;
        private final Queue<Coordinate> queue;

        public TomatoBox(Symbol[][][] tomatoes) {
            this.tomatoes = tomatoes;
            this.distance = new int[tomatoes.length][tomatoes[0].length][tomatoes[0][0].length];
            this.queue = new LinkedList<>();
            for (int h = 0; h < this.tomatoes.length; h++) {
                for (int n = 0; n < this.tomatoes[0].length; n++) {
                    for (int m = 0; m < this.tomatoes[0][0].length; m++) {
                        if (this.tomatoes[h][n][m] == Symbol.RIPENED_TOMATO) {
                            queue.add(new Coordinate(h, n, m));
                            distance[h][n][m] = 0;
                        } else {
                            distance[h][n][m] = NOT_VISITED;
                        }
                    }
                }
            }
        }

        public void ripenTomatoes() {
            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.poll();
                ripenAdjacentTomatoes(coordinate);
            }
        }

        private void ripenAdjacentTomatoes(Coordinate coordinate) {
            for (Direction direction : Direction.values()) {
                Coordinate nextCoordinate = coordinate.nextCoordinate(direction);
                if (canRipen(nextCoordinate)) {
                    ripenAndEnqueue(coordinate, nextCoordinate);
                }
            }
        }

        private boolean canRipen(Coordinate coordinate) {
            return coordinate.isInBound(tomatoes) &&
                    tomatoes[coordinate.h][coordinate.n][coordinate.m] == Symbol.UNRIPENED_TOMATO;
        }

        private void ripenAndEnqueue(Coordinate coordinate, Coordinate nextCoordinate) {
            tomatoes[nextCoordinate.h][nextCoordinate.n][nextCoordinate.m] = Symbol.RIPENED_TOMATO;
            distance[nextCoordinate.h][nextCoordinate.n][nextCoordinate.m] =
                    distance[coordinate.h][coordinate.n][coordinate.m] + 1;
            queue.add(nextCoordinate);
        }

        public int getDay() {
            return isAllTomatoRipened()
                    ? findMaxDistance()
                    : NOT_ALL_RIPENED;
        }

        private boolean isAllTomatoRipened() {
            return Arrays.stream(tomatoes)
                    .flatMap(Arrays::stream)
                    .flatMap(Arrays::stream)
                    .noneMatch(symbol -> symbol == Symbol.UNRIPENED_TOMATO);
        }

        private int findMaxDistance() {
            return Arrays.stream(distance)
                    .flatMap(Arrays::stream)
                    .flatMapToInt(Arrays::stream)
                    .max()
                    .orElseThrow();
        }
    }

    static class Coordinate {

        private final int h;
        private final int n;
        private final int m;

        public Coordinate(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }

        public Coordinate nextCoordinate(Direction direction) {
            return new Coordinate(h + direction.m, n + direction.h, m + direction.n);
        }

        public <T> boolean isInBound(T[][][] board) {
            return 0 <= h && h < board.length
                    && 0 <= n && n < board[0].length
                    && 0 <= m && m < board[0][0].length;
        }
    }
}
