/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2146
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

public class CreateBridge {

    static final int LAND = 1;
    static final int SEA = 0;
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solution(map);
    }

    private static void solution(int[][] map) {
        spreadIslands(map);

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map.length; m++) {
                if (map[n][m] == SEA) continue;
                findBridge(copyMap(map), n, m);
            }
        }

        System.out.print(minDistance);
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[map.length][map.length];

        for (int n = 0; n < map.length; n++) {
            System.arraycopy(map[n], 0, copiedMap[n], 0, map.length);
        }

        return copiedMap;
    }

    private static void findBridge(int[][] map, int startN, int startM) {
        int reference = map[startN][startM];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM, 0));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isOutBound(map, nextN, nextM) ||
                    map[nextN][nextM] == reference) continue;
                if (map[nextN][nextM] != SEA) {
                    minDistance = Math.min(minDistance, current.distance);
                    return;
                }
                map[nextN][nextM] = reference;
                queue.add(new Coordinate(nextN, nextM, current.distance + 1));
            }
        }
    }

    private static void spreadIslands(int[][] map) {
        int islandId = 2;

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map.length; m++) {
                if (map[n][m] == LAND) {
                    spread(map, n, m, islandId);
                    islandId++;
                }
            }
        }
    }

    private static void spread(int[][] map, int startN, int startM, int islandId) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(startN, startM, 0));
        map[startN][startM] = islandId;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isOutBound(map, nextN, nextM) ||
                    map[nextN][nextM] != LAND) continue;
                map[nextN][nextM] = islandId;
                queue.add(new Coordinate(nextN, nextM, 0));
            }
        }
    }

    private static boolean isOutBound(int[][] map, int n, int m) {
        return 0 > n || n >= map.length || 0 > m || m >= map.length;
    }

    static class Coordinate {
        int n;
        int m;
        int distance;

        public Coordinate(int n, int m, int distance) {
            this.n = n;
            this.m = m;
            this.distance = distance;
        }
    }
}


/*
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

2
1 1
1 1

2
1 0
0 1
 */