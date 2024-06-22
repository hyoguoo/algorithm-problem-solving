/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16948
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class DeathKnight {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sizeN = Integer.parseInt(bufferedReader.readLine());
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Coordinate start = new Coordinate(info[0], info[1]);
        Coordinate end = new Coordinate(info[2], info[3]);

        System.out.print(solution(sizeN, start, end));
    }

    private static int solution(int sizeN, Coordinate start, Coordinate end) {
        int[][] distance = new int[sizeN][sizeN];
        Arrays.stream(distance).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        return bfs(start, end, distance);
    }

    private static int bfs(
            Coordinate start,
            Coordinate end,
            int[][] distance
    ) {
        Deque<Coordinate> deque = new ArrayDeque<>();
        deque.add(start);
        distance[start.n][start.m] = 0;

        while (!deque.isEmpty()) {
            Coordinate current = deque.poll();

            if (current.equals(end)) {
                return distance[current.n][current.m];
            }

            for (Direction direction : Direction.values()) {
                Coordinate next = current.move(direction);
                if (isInBound(next, distance.length) &&
                        distance[next.n][next.m] == Integer.MAX_VALUE) {
                    distance[next.n][next.m] = distance[current.n][current.m] + 1;
                    deque.add(next);
                }
            }
        }

        return -1;
    }

    private static boolean isInBound(Coordinate coordinate, int sizeN) {
        return 0 <= coordinate.n && coordinate.n < sizeN &&
                0 <= coordinate.m && coordinate.m < sizeN;
    }

    enum Direction {
        UP_LEFT(-2, -1),
        UP_RIGHT(-2, 1),
        RIGHT(0, 2),
        DOWN_RIGHT(2, 1),
        DOWN_LEFT(2, -1),
        LEFT(0, -2);

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

        public Coordinate move(Direction direction) {
            return new Coordinate(this.n + direction.n, this.m + direction.m);
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
