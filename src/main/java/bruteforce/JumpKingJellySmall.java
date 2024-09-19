/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16173
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JumpKingJellySmall {

    private static final int START_N = 0;
    private static final int START_M = 0;
    private static final int END_VALUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sizeN = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[sizeN][sizeN];

        for (int n = 0; n < sizeN; n++) {
            map[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(map) ? "HaruHaru" : "Hing");
    }

    private static boolean solution(int[][] map) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(START_N, START_M));
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[START_N][START_M] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (map[current.n][current.m] == END_VALUE) {
                return true;
            }

            for (Direction direction : Direction.values()) {
                int weight = map[current.n][current.m];
                Coordinate next = new Coordinate(
                        current.n + direction.n * weight,
                        current.m + direction.m * weight
                );

                if (isInBound(map, next) && !visited[next.n][next.m]) {
                    visited[next.n][next.m] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    private static boolean isInBound(int[][] map, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < map.length &&
                0 <= coordinate.m && coordinate.m < map[0].length;
    }

    enum Direction {
        DOWN(0, 1),
        RIGHT(1, 0);

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
    }
}
