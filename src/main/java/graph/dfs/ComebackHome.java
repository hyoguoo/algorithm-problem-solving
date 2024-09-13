/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1189
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class ComebackHome {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeN = info[0];
        int sizeM = info[1];
        int depthLimit = info[2];

        Symbol[][] map = new Symbol[sizeN][sizeM];

        for (int i = 0; i < sizeN; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < sizeM; j++) {
                map[i][j] = Symbol.of(line.charAt(j));
            }
        }

        System.out.print(solution(map, depthLimit));
    }

    private static int solution(Symbol[][] map, int depthLimit) {
        Coordinate start = new Coordinate(map.length - 1, 0);
        Coordinate end = new Coordinate(0, map[0].length - 1);
        boolean[][] visited = new boolean[map.length][map[0].length];

        visited[start.n][start.m] = true;
        dfs(map, visited, start, end, depthLimit, 1);

        return count;
    }

    private static void dfs(
            Symbol[][] map,
            boolean[][] visited,
            Coordinate current,
            Coordinate end,
            int depthLimit,
            int currentDepth
    ) {
        if (currentDepth == depthLimit) {
            if (current.equals(end)) {
                count++;
            }
            return;
        }

        for (Direction direction : Direction.values()) {
            Coordinate next = current.move(direction);
            if (!isInBound(map, next) ||
                    map[next.n][next.m] == Symbol.BLOCK ||
                    visited[next.n][next.m]) {
                continue;
            }
            visited[next.n][next.m] = true;
            dfs(map, visited, next, end, depthLimit, currentDepth + 1);
            visited[next.n][next.m] = false;
        }
    }

    private static boolean isInBound(Symbol[][] map, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < map.length &&
                0 <= coordinate.m && coordinate.m < map[0].length;
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
        EMPTY('.'),
        BLOCK('T');

        private final char value;

        Symbol(char value) {
            this.value = value;
        }

        public static Symbol of(char symbol) {
            return Arrays.stream(values())
                    .filter(value -> value.value == symbol)
                    .findFirst()
                    .orElseThrow();
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
