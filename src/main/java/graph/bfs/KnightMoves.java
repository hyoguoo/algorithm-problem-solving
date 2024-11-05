/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7562
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.IntStream;

public class KnightMoves {

    private static final int NOT_VISITED = -1;
    private static final int NOT_REACHABLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int sizeN = Integer.parseInt(bufferedReader.readLine());
            int[] startInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] endInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder
                    .append(
                            solution(
                                    new Coordinate(startInfo[0], startInfo[1]),
                                    new Coordinate(endInfo[0], endInfo[1]),
                                    sizeN
                            )
                    )
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(Coordinate startCoordinate, Coordinate endCoordinate, int sizeN) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(startCoordinate);

        int[][] distance = initDistance(sizeN);
        distance[startCoordinate.n][startCoordinate.m] = 0;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            int currentDistance = distance[currentCoordinate.n][currentCoordinate.m];

            if (currentCoordinate.equals(endCoordinate)) {
                return currentDistance;
            }

            Arrays.stream(Direction.values())
                    .map(currentCoordinate::nextCoordinate)
                    .filter(coordinate -> isInBound(coordinate, sizeN))
                    .filter(coordinate -> distance[coordinate.n][coordinate.m] == NOT_VISITED)
                    .forEach(coordinate -> {
                        distance[coordinate.n][coordinate.m] = currentDistance + 1;
                        queue.add(coordinate);
                    });
        }

        return NOT_REACHABLE;
    }

    private static int[][] initDistance(int sizeN) {
        return IntStream.range(0, sizeN)
                .mapToObj(i -> IntStream.range(0, sizeN)
                        .map(j -> NOT_VISITED)
                        .toArray())
                .toArray(int[][]::new);
    }

    private static boolean isInBound(Coordinate coordinate, int sizeN) {
        return 0 <= coordinate.n && coordinate.n < sizeN &&
                0 <= coordinate.m && coordinate.m < sizeN;
    }

    enum Direction {
        UP_LEFT(-2, -1),
        UP_RIGHT(-2, 1),
        RIGHT_UP(-1, 2),
        RIGHT_DOWN(1, 2),
        DOWN_RIGHT(2, 1),
        DOWN_LEFT(2, -1),
        LEFT_DOWN(1, -2),
        LEFT_UP(-1, -2);

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

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate nextCoordinate(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            return n == that.n && m == that.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }
    }
}
