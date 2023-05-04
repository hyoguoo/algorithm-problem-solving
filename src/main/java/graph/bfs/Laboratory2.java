/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17141
 * Cheat Level: 2
 * Algorithm: Graph / Bruteforce / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Laboratory2 {

    final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    final static List<Position> ENABLE_VIRUS_LIST = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int N, VIRUS_COUNT;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        bruteForce(0, new ArrayList<>());
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void bruteForce(int index, List<Position> virusList) {
        if (virusList.size() == VIRUS_COUNT) {
            int distance = spreadVirus(virusList, copyGraph());
            if (distance != -1) result = Math.min(result, distance);
        }

        for (int i = index; i < ENABLE_VIRUS_LIST.size(); i++) {
            virusList.add(ENABLE_VIRUS_LIST.get(i));
            bruteForce(i + 1, virusList);
            virusList.remove(virusList.size() - 1);
        }
    }

    private static int spreadVirus(List<Position> virusList, int[][] copiedGraph) {
        Queue<Position> queue = new LinkedList<>(virusList);
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int distance = copiedGraph[currentX][currentY];

            for (int[] direction : DIRECTIONS) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                int nextDistance = distance + 1;
                if (!isInBound(nextX, nextY)) continue;
                if (copiedGraph[nextX][nextY] != 0) continue;
                if (existVirus(nextX, nextY, virusList)) continue;
                copiedGraph[nextX][nextY] = nextDistance;
                queue.add(new Position(nextX, nextY));
                maxDistance = Math.max(maxDistance, nextDistance);
            }
        }

        return isAllSpread(copiedGraph, virusList) ? maxDistance : -1;
    }

    private static boolean existVirus(int nextX, int nextY, List<Position> virusList) {
        return virusList.stream().anyMatch(virus -> virus.x == nextX && virus.y == nextY);
    }


    private static boolean isAllSpread(int[][] copiedGraph, List<Position> virusList) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copiedGraph[i][j] == 0 && !existVirus(i, j, virusList)) return false;
            }
        }
        return true;
    }

    private static boolean isInBound(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static int[][] copyGraph() {
        int[][] copiedGraph = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(graph[i], 0, copiedGraph[i], 0, N);
        }
        return copiedGraph;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        VIRUS_COUNT = info[1];
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                int value = line[j];
                if (value == 1) {
                    graph[i][j] = -1;
                } else {
                    if (value == 2) ENABLE_VIRUS_LIST.add(new Position(i, j));
                    graph[i][j] = 0;
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*
5 2
1 1 1 1 1
1 1 2 1 1
1 1 2 1 1
1 1 1 1 1
1 1 1 1 1
 */