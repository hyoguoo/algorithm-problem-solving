/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number:
 * Cheat Level:
 * Algorithm:
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class WiseKnight {

    private static final int NOT_VISITED = -1;
    private static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];

        int[] knightInfo = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Coordinate knight = new Coordinate(knightInfo[0] - 1, knightInfo[1] - 1);

        int enemyCount = info[1];
        boolean[][] enemyMap = new boolean[sizeN][sizeN];
        List<Coordinate> enemies = new ArrayList<>();
        while (enemyCount-- > 0) {
            int[] enemyInfo = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            enemyMap[enemyInfo[0] - 1][enemyInfo[1] - 1] = true;
            enemies.add(new Coordinate(enemyInfo[0] - 1, enemyInfo[1] - 1));
        }

        System.out.print(solution(enemyMap, enemies, knight));
    }

    private static String solution(
            boolean[][] enemyMap,
            List<Coordinate> enemies,
            Coordinate knight
    ) {
        return toStringEnemyDistances(enemies, calculateDistances(enemyMap, knight));
    }

    private static int[][] calculateDistances(boolean[][] enemyMap, Coordinate knight) {
        int[][] distanceMap = initializeVisitedArray(enemyMap);

        Deque<Coordinate> deque = new ArrayDeque<>();

        deque.add(knight);
        distanceMap[knight.getN()][knight.getM()] = 0;

        while (!deque.isEmpty()) {
            Coordinate current = deque.poll();

            for (Direction direction : Direction.values()) {
                Coordinate next = current.getNext(direction);

                if (!isInBound(next, enemyMap.length)
                        || distanceMap[next.getN()][next.getM()] != NOT_VISITED) {
                    continue;
                }

                distanceMap[next.getN()][next.getM()] =
                        distanceMap[current.getN()][current.getM()] + 1;
                deque.add(next);
            }
        }

        return distanceMap;
    }

    private static int[][] initializeVisitedArray(boolean[][] enemyMap) {
        int[][] visited = new int[enemyMap.length][enemyMap.length];

        for (int[] i : visited) {
            Arrays.fill(i, NOT_VISITED);
        }

        return visited;
    }

    private static String toStringEnemyDistances(List<Coordinate> enemies, int[][] distanceMap) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Coordinate enemy : enemies) {
            stringBuilder.append(distanceMap[enemy.getN()][enemy.getM()]).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    private static boolean isInBound(Coordinate coordinate, int size) {
        return 0 <= coordinate.getN() && coordinate.getN() < size &&
                0 <= coordinate.getM() && coordinate.getM() < size;
    }

    enum Direction {
        UP_LEFT(-2, -1),
        UP_RIGHT(-2, 1),
        RIGHT_UP(-1, 2),
        RIGHT_DOWN(1, 2),
        DOWN_LEFT(2, -1),
        DOWN_RIGHT(2, 1),
        LEFT_UP(-1, -2),
        LEFT_DOWN(1, -2);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

        public Coordinate getNext(Direction direction) {
            return new Coordinate(n + direction.getN(), m + direction.getM());
        }
    }
}
