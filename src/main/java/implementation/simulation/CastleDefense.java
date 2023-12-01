/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17135
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation / Graph / BFS
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CastleDefense {

    static final int EXIST = 1;
    static final int EMPTY = 0;
    static final int[][] DIRECTIONS = {{0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int distanceLimit = info[2];
        int enemyCount = 0;
        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line[j];
                if (graph[i][j] == EXIST) enemyCount++;
            }
        }

        System.out.println(solution(graph, distanceLimit, enemyCount));
    }

    private static int solution(int[][] graph, int distanceLimit, int enemyCount) {
        List<int[]> archerPositions = getArcherPositions(graph[0].length);
        int maxCount = 0;

        for (int[] archerPosition : archerPositions) {
            int[][] copiedGraph = Arrays.stream(graph).map(int[]::clone).toArray(int[][]::new);
            maxCount = Math.max(maxCount, countDefeatedEnemies(copiedGraph, archerPosition, distanceLimit, enemyCount));
        }

        return maxCount;
    }

    private static List<int[]> getArcherPositions(int m) {
        List<int[]> archerPositions = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    archerPositions.add(new int[]{i, j, k});
                }
            }
        }

        return archerPositions;
    }

    private static int countDefeatedEnemies(int[][] graph, int[] archerPosition, int distanceLimit, int enemyCount) {
        int count = 0;

        for (int round = 0; round < graph.length; round++) {
            count += attackEnemiesEachArcher(graph, archerPosition, distanceLimit);
            if (count == enemyCount) break;
            moveEnemies(graph);
        }

        return count;
    }

    private static void moveEnemies(int[][] graph) {
        for (int n = graph.length - 1; n >= 0; n--) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] == EXIST) {
                    graph[n][m] = EMPTY;
                    if (n + 1 < graph.length) graph[n + 1][m] = EXIST;
                }
            }
        }
    }

    private static int attackEnemiesEachArcher(int[][] graph, int[] archerPosition, int distanceLimit) {
        Set<Coordinate> killedEnemies = new HashSet<>();

        for (int m : archerPosition) {
            Optional<Coordinate> killedEnemy = getKilledEnemy(graph, m, distanceLimit);
            killedEnemy.ifPresent(killedEnemies::add);
        }

        cleanUpKilledEnemies(graph, killedEnemies);

        return killedEnemies.size();
    }

    private static void cleanUpKilledEnemies(int[][] graph, Set<Coordinate> killedEnemies) {
        killedEnemies
                .forEach(killedEnemy ->
                        graph[killedEnemy.n][killedEnemy.m] = EMPTY
                );
    }

    private static Optional<Coordinate> getKilledEnemy(int[][] graph, int startM, int distanceLimit) {
        Queue<Arrow> queue = new LinkedList<>();
        queue.add(new Arrow(graph.length - 1, startM, distanceLimit - 1));

        while (!queue.isEmpty()) {
            Arrow arrow = queue.poll();

            if (graph[arrow.n][arrow.m] == EXIST) return Optional.of(new Coordinate(arrow.n, arrow.m));
            if (arrow.remainingDistance == 0) continue;

            for (int[] direction : DIRECTIONS) {
                int nextN = arrow.n + direction[0];
                int nextM = arrow.m + direction[1];
                if (!isInBound(nextN, nextM, graph)) continue;
                queue.add(new Arrow(nextN, nextM, arrow.remainingDistance - 1));
            }
        }

        return Optional.empty();
    }

    private static boolean isInBound(int n, int m, int[][] graph) {
        return 0 <= n && n < graph.length && 0 <= m && m < graph[n].length;
    }

    static class Arrow extends Coordinate {
        int remainingDistance;

        public Arrow(int n, int m, int remainingDistance) {
            super(n, m);
            this.remainingDistance = remainingDistance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Arrow arrow = (Arrow) o;
            return remainingDistance == arrow.remainingDistance;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), remainingDistance);
        }
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return n == that.n && m == that.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }
    }
}
