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
import java.util.Queue;

public class KnightMoves {

    private static final int NOT_VISITED = -1;

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
        int[][] distance = initDistance(sizeN);
        queue.add(startCoordinate);
        distance[startCoordinate.n][startCoordinate.m] = 0;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();
            if (currentCoordinate.n == endCoordinate.n && currentCoordinate.m == endCoordinate.m) {
                return distance[currentCoordinate.n][currentCoordinate.m];
            }
            for (Direction direction : Direction.values()) {
                Coordinate nextCoordinate = currentCoordinate.nextCoordinate(direction);
                if (!isInBound(sizeN, nextCoordinate)) {
                    continue;
                }
                if (distance[nextCoordinate.n][nextCoordinate.m] == NOT_VISITED) {
                    distance[nextCoordinate.n][nextCoordinate.m] =
                            distance[currentCoordinate.n][currentCoordinate.m] + 1;
                    queue.add(nextCoordinate);
                }
            }
        }

        return -1;
    }

    private static int[][] initDistance(int sizeN) {
        int[][] distance = new int[sizeN][sizeN];
        Arrays.stream(distance)
                .forEach(row -> Arrays.fill(row, NOT_VISITED));
        return distance;
    }

    private static boolean isInBound(int sizeN, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < sizeN
                && 0 <= coordinate.m && coordinate.m < sizeN;
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
    }
}
