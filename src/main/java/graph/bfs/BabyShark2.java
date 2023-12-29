/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17086
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

public class BabyShark2 {

    static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static final int SHARK = 1;
    static final int EMPTY = 0;
    static final int VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int[][] map = new int[n][m];
        Queue<Coordinate> sharkQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (line[j] == SHARK) sharkQueue.add(new Coordinate(i, j, 0));
                map[i][j] = line[j];
            }
        }

        System.out.println(solution(map, sharkQueue));
    }

    private static int solution(int[][] map, Queue<Coordinate> sharkQueue) {
        int maxDistance = 0;

        while (!sharkQueue.isEmpty()) {
            Coordinate current = sharkQueue.poll();

            maxDistance = Math.max(maxDistance, current.distance);

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(map, nextN, nextM) ||
                    map[nextN][nextM] != EMPTY) continue;
                map[nextN][nextM] = VISITED;
                sharkQueue.add(new Coordinate(nextN, nextM, current.distance + 1));
            }
        }

        return maxDistance;
    }

    private static boolean isInBound(int[][] map, int n, int m) {
        return 0 <= n && n < map.length && 0 <= m && m < map[0].length;
    }

    static class Coordinate {
        final int n;
        final int m;
        final int distance;

        Coordinate(int n, int m, int distance) {
            this.n = n;
            this.m = m;
            this.distance = distance;
        }
    }
}
