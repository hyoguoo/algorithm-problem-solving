/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3187
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

public class ShepherdKung {

    public static void main(String[] args) throws IOException {
        Symbol[][] graph = parseGraph();
        System.out.print(solution(graph));
    }

    private static Symbol[][] parseGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int n = info[0];
        int m = info[1];
        Symbol[][] graph = new Symbol[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(""))
                    .map(s -> Symbol.fromChar(s.charAt(0)))
                    .toArray(Symbol[]::new);
        }

        return graph;
    }

    private static String solution(Symbol[][] graph) {
        Count count = new Count();

        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] != Symbol.WALL &&
                        graph[n][m] != Symbol.VISITED) {
                    bfs(graph, new Coordinate(n, m), count);
                }
            }
        }

        return count.toString();
    }

    private static void bfs(Symbol[][] graph, Coordinate start, Count count) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        int sheepCount = 0;
        int wolfCount = 0;

        if (graph[start.n][start.m] == Symbol.SHEEP) {
            sheepCount++;
        }
        if (graph[start.n][start.m] == Symbol.WOLF) {
            wolfCount++;
        }
        graph[start.n][start.m] = Symbol.VISITED;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            for (Direction direction : Direction.values()) {
                Coordinate nextCoordinate = coordinate.move(direction);

                if (!isInBound(graph, nextCoordinate) ||
                        graph[nextCoordinate.n][nextCoordinate.m] == Symbol.WALL ||
                        graph[nextCoordinate.n][nextCoordinate.m] == Symbol.VISITED) {
                    continue;
                }

                if (graph[nextCoordinate.n][nextCoordinate.m] == Symbol.SHEEP) {
                    sheepCount++;
                }
                if (graph[nextCoordinate.n][nextCoordinate.m] == Symbol.WOLF) {
                    wolfCount++;
                }
                graph[nextCoordinate.n][nextCoordinate.m] = Symbol.VISITED;
                queue.add(nextCoordinate);
            }
        }

        count.updateCount(sheepCount, wolfCount);
    }

    private static boolean isInBound(Symbol[][] graph, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < graph.length &&
                0 <= coordinate.m && coordinate.m < graph[coordinate.n].length;
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
        WALL('#'),
        SHEEP('k'),
        WOLF('v'),
        VISITED('x'),
        EMPTY('.');

        private final char value;

        Symbol(char value) {
            this.value = value;
        }

        public static Symbol fromChar(char ch) {
            return Arrays.stream(Symbol.values())
                    .filter(symbol -> symbol.value == ch)
                    .findAny()
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

        public Coordinate move(Direction direction) {
            return new Coordinate(this.n + direction.n, this.m + direction.m);
        }
    }

    static class Count {

        private int sheepCount;
        private int wolfCount;

        public Count() {
            this.sheepCount = 0;
            this.wolfCount = 0;
        }

        public void updateCount(int sheepCount, int wolfCount) {
            if (sheepCount > wolfCount) {
                this.sheepCount += sheepCount;
            } else {
                this.wolfCount += wolfCount;
            }
        }

        @Override
        public String toString() {
            return this.sheepCount + " " + this.wolfCount;
        }
    }
}
