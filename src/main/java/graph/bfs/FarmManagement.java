/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1245
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

public class FarmManagement {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = sizeInfo[0];
        int sizeM = sizeInfo[1];
        int[][] farm = new int[sizeN][sizeM];

        for (int i = 0; i < sizeN; i++) {
            farm[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(farm));
    }

    private static int solution(int[][] farm) {
        boolean[][] visited = new boolean[farm.length][farm[0].length];
        int count = 0;

        for (int n = 0; n < farm.length; n++) {
            for (int m = 0; m < farm[n].length; m++) {
                if (!visited[n][m] && bfs(farm, visited, new Coordinate(n, m))) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean bfs(int[][] farm, boolean[][] visited, Coordinate start) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean isPeak = true;
        int height = farm[start.n][start.m];
        queue.add(start);
        visited[start.n][start.m] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (Direction direction : Direction.values()) {
                Coordinate next = current.next(direction);
                if (!isInBounds(farm, next)) {
                    continue;
                }
                if (farm[next.n][next.m] > height) {
                    isPeak = false;
                }
                if (!visited[next.n][next.m] && farm[next.n][next.m] == height) {
                    queue.add(next);
                    visited[next.n][next.m] = true;
                }
            }
        }

        return isPeak;
    }

    private static boolean isInBounds(int[][] farm, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < farm.length &&
                0 <= coordinate.m && coordinate.m < farm[coordinate.n].length;
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1),
        UP_LEFT(-1, -1),
        UP_RIGHT(-1, 1),
        DOWN_LEFT(1, -1),
        DOWN_RIGHT(1, 1);

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

        public Coordinate next(Direction direction) {
            return new Coordinate(
                    n + direction.n,
                    m + direction.m
            );
        }
    }
}
