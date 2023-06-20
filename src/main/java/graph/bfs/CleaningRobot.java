/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4991
 * Cheat Level: 0
 * Algorithm: Graph / BFS / Brute Force
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CleaningRobot {

    final static char DIRTY = '*';
    final static char WALL = 'x';
    final static char START = 'o';
    final static int NOT_VISITED = -1;
    final static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = info[0];
            int N = info[1];
            if (M == 0 && N == 0) break;

            char[][] map = new char[N][M];
            Coordinate start = null;
            List<Coordinate> dirtyList = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                char[] line = bufferedReader.readLine().toCharArray();
                for (int m = 0; m < M; m++) {
                    map[n][m] = line[m];
                    if (map[n][m] == DIRTY) dirtyList.add(new Coordinate(n, m));
                    else if (map[n][m] == START) start = new Coordinate(n, m);
                }
            }

            System.out.println(solution(map, start, dirtyList));
        }
    }

    private static int solution(char[][] map, Coordinate start, List<Coordinate> dirtyList) {
        List<int[]> visitOrderList = Permutations.generatePermutations(dirtyList.size());
        int[][][] distanceInfos = getDistanceInfos(map, start, dirtyList);
        int minDistance = Integer.MAX_VALUE;

        for (int[] visitOrder : visitOrderList) {
            int distance = getDistance(dirtyList, distanceInfos, visitOrder);
            if (distance == -1) return -1;
            minDistance = Math.min(minDistance, distance);
        }


        return minDistance;
    }

    private static int getDistance(List<Coordinate> dirtyList, int[][][] distanceInfos, int[] visitOrder) {
        int distance = 0;

        int[][] distanceInfo = distanceInfos[0];
        for (int to : visitOrder) {
            int nextDistance = distanceInfo[dirtyList.get(to - 1).n][dirtyList.get(to - 1).m];
            if (nextDistance == NOT_VISITED) return -1;
            distance += nextDistance;
            distanceInfo = distanceInfos[to];
        }

        return distance;
    }

    private static int[][][] getDistanceInfos(char[][] map, Coordinate start, List<Coordinate> dirtyList) {
        int[][][] distanceInfos = new int[dirtyList.size() + 1][map.length][map[0].length];

        for (int i = 0; i <= dirtyList.size(); i++) {
            distanceInfos[i] = bfs(map, i == 0 ? start : dirtyList.get(i - 1));
        }

        return distanceInfos;
    }

    private static int[][] bfs(char[][] map, Coordinate start) {
        int[][] distanceInfo = new int[map.length][map[0].length];
        for (int[] distance : distanceInfo) Arrays.fill(distance, NOT_VISITED);

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        distanceInfo[start.n][start.m] = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int distance = distanceInfo[current.n][current.m];

            for (int[] direction : DIRECTION) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (nextN < 0 || nextN >= map.length || nextM < 0 || nextM >= map[0].length) continue;
                if (map[nextN][nextM] == WALL) continue;
                if (distanceInfo[nextN][nextM] != NOT_VISITED) continue;

                distanceInfo[nextN][nextM] = distance + 1;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return distanceInfo;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Permutations {

        public static List<int[]> generatePermutations(int n) {
            List<int[]> permutations = new ArrayList<>();
            int[] permutation = new int[n];
            boolean[] used = new boolean[n];

            generate(permutations, permutation, used, 0, n);

            return permutations;
        }

        private static void generate(List<int[]> permutations, int[] permutation, boolean[] used, int index, int n) {
            if (index == n) {
                permutations.add(permutation.clone());
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (!used[i - 1]) {
                    permutation[index] = i;
                    used[i - 1] = true;
                    generate(permutations, permutation, used, index + 1, n);
                    used[i - 1] = false;
                }
            }
        }
    }
}
