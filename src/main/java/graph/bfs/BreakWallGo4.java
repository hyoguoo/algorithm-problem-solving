/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16946
 * Cheat Level: 2
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BreakWallGo4 {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static int WALL = -1;
    final static int EMPTY = 0;
    final static int VISITED = 1;
    static int N_LENGTH, M_LENGTH;
    static Area[][] graph;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        int index = 1;
        for (int n = 0; n < N_LENGTH; n++) {
            for (int m = 0; m < M_LENGTH; m++) {
                if (graph[n][m].value != EMPTY) continue;
                setAreaSize(n, m, index++);
            }
        }

        printResult();
    }

    private static void setAreaSize(int n, int m, int index) {
        Queue<Coordinate> queue = new LinkedList<>();
        List<Coordinate> visited = new ArrayList<>();

        queue.add(new Coordinate(n, m));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (graph[current.n][current.m].value == VISITED) continue;
            graph[current.n][current.m].value = VISITED;
            visited.add(current);

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (isOutBound(nextN, nextM) || graph[nextN][nextM].value == WALL) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        int count = visited.size();
        for (Coordinate coordinate : visited) {
            graph[coordinate.n][coordinate.m].value = count;
            graph[coordinate.n][coordinate.m].index = index;
        }
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n = 0; n < N_LENGTH; n++) {
            for (int m = 0; m < M_LENGTH; m++) {
                if (graph[n][m].value == WALL) stringBuilder.append(getSurroundingAreaSize(n, m) % 10);
                else stringBuilder.append(0);
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int getSurroundingAreaSize(int n, int m) {
        int count = 1;
        List<Integer> visitedIndexList = new ArrayList<>();

        for (int[] direction : DIRECTIONS) {
            int nextN = n + direction[0];
            int nextM = m + direction[1];

            if (isOutBound(n, m) || graph[n][m].value == WALL) continue;
            if (visitedIndexList.contains(graph[nextN][nextM].index)) continue;
            visitedIndexList.add(graph[nextN][nextM].index);

            count += graph[nextN][nextM].value;
        }

        return count;
    }

    private static boolean isOutBound(int n, int m) {
        return 0 > n || n >= N_LENGTH || 0 > m || m >= M_LENGTH;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N_LENGTH = sizeInfo[0];
        M_LENGTH = sizeInfo[1];

        graph = new Area[N_LENGTH][M_LENGTH];
        for (int n = 0; n < N_LENGTH; n++) {
            char[] charArray = bufferedReader.readLine().toCharArray();
            for (int m = 0; m < M_LENGTH; m++) {
                boolean isWall = charArray[m] == '1';
                graph[n][m] = new Area(0, isWall ? WALL : EMPTY);
            }
        }
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Area {
        int index;
        int value;

        public Area(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
