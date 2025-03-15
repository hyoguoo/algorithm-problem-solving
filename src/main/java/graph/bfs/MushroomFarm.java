/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27737
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MushroomFarm {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sporeCount = info[1];
        int spreadCount = info[2];

        Cell[][] farm = new Cell[sizeN][sizeN];

        for (int i = 0; i < sizeN; i++) {
            farm[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(v -> v.equals("0") ? Cell.GROWABLE : Cell.UNGROWABLE)
                    .toArray(Cell[]::new);
        }

        System.out.print(solution(farm, sporeCount, spreadCount));
    }

    private static String solution(Cell[][] farm, int sporeCount, int spreadCount) {
        List<Integer> growableCellSizeList = new ArrayList<>();

        for (int n = 0; n < farm.length; n++) {
            for (int m = 0; m < farm[n].length; m++) {
                if (farm[n][m] == Cell.GROWABLE) {
                    growableCellSizeList.add(bfs(farm, new Coordinate(n, m)));
                }
            }
        }

        int requiredSporeCount = growableCellSizeList.stream()
                .mapToInt(v -> (int) Math.ceil((double) v / spreadCount))
                .sum();

        return sporeCount >= requiredSporeCount && requiredSporeCount > 0
                ? "POSSIBLE" + "\n" + (sporeCount - requiredSporeCount)
                : "IMPOSSIBLE";
    }

    private static int bfs(Cell[][] farm, Coordinate coordinate) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(coordinate);
        farm[coordinate.n][coordinate.m] = Cell.GROWN;
        int count = 1;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (Direction direction : Direction.values()) {
                Coordinate next = current.next(direction);

                if (isInBound(next.n, next.m, farm.length) &&
                        farm[next.n][next.m] == Cell.GROWABLE) {
                    farm[next.n][next.m] = Cell.GROWN;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isInBound(int n, int m, int sizeN) {
        return 0 <= n && n < sizeN &&
                0 <= m && m < sizeN;
    }

    enum Cell {
        GROWABLE,
        UNGROWABLE,
        GROWN
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

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate next(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }
    }
}
