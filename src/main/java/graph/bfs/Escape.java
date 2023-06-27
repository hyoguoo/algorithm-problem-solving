/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3055
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Escape {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>();
    final static int EMPTY = 0;
    final static int WATER = -1;
    final static int WALL = -2;
    static int N, M, TARGET_N, TARGET_M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution() == -1 ? "KAKTUS" : solution());
    }

    private static int solution() {
        while (!priorityQueue.isEmpty()) {
            Coordinate current = priorityQueue.poll();
            int isWater = current.isWater;

            if (isWater == 0) {
                if (current.n == TARGET_N && current.m == TARGET_M) return current.distance;
                for (int[] DIRECTION : DIRECTIONS) {
                    int nextN = current.n + DIRECTION[0];
                    int nextM = current.m + DIRECTION[1];
                    if (nextN < 0 || nextM < 0 || nextN >= N || nextM >= M) continue;
                    if (graph[nextN][nextM] == EMPTY) {
                        graph[nextN][nextM] = current.distance + 1;
                        priorityQueue.add(new Coordinate(nextN, nextM, current.distance + 1, 0));
                    }
                }
            } else {
                for (int[] DIRECTION : DIRECTIONS) {
                    int nextN = current.n + DIRECTION[0];
                    int nextM = current.m + DIRECTION[1];
                    if (nextN == TARGET_N && nextM == TARGET_M) continue;
                    if (nextN < 0 || nextM < 0 || nextN >= N || nextM >= M) continue;
                    if (graph[nextN][nextM] == WALL || graph[nextN][nextM] == WATER) continue;
                    graph[nextN][nextM] = WATER;
                    priorityQueue.add(new Coordinate(nextN, nextM, current.distance + 1, 1));
                }
            }
        }

        return graph[TARGET_N][TARGET_M] == EMPTY ? -1 : graph[TARGET_N][TARGET_M];
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        graph = new int[N][M];
        for (int n = 0; n < N; n++) {
            char[] charArray = bufferedReader.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                char value = charArray[m];
                if (value == '.') graph[n][m] = EMPTY;
                else if (value == 'X') graph[n][m] = WALL;
                else if (value == '*') {
                    graph[n][m] = WATER;
                    priorityQueue.add(new Coordinate(n, m, 0, 1));
                } else if (value == 'S') {
                    priorityQueue.add(new Coordinate(n, m, 0, 0));
                } else if (value == 'D') {
                    TARGET_N = n;
                    TARGET_M = m;
                }
            }
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        int n;
        int m;
        int distance;
        int isWater;

        public Coordinate(int n, int m, int distance, int isWater) {
            this.n = n;
            this.m = m;
            this.distance = distance;
            this.isWater = isWater;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.distance == o.distance) return o.isWater - this.isWater;
            return this.distance - o.distance;
        }
    }
}
