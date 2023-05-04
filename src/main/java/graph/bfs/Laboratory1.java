/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14502
 * Cheat Level: 0
 * Algorithm: Graph / Backtracking / Brute Force / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Laboratory1 {

    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int VIRUS = 2;
    final static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static List<Position> virusList = new ArrayList<>();
    final static List<Position> emptyList = new ArrayList<>();
    final static List<Integer> result = new ArrayList<>();
    static int M;
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = info[0];
        N = info[1];
        graph = new int[M][N];

        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length; j++) {
                int value = input[j];
                if (value == VIRUS) virusList.add(new Position(i, j));
                if (value == EMPTY) emptyList.add(new Position(i, j));
                graph[i][j] = value;
            }
        }

        recursion(0, 0);
        System.out.println(result.stream().mapToInt(Integer::intValue).max().getAsInt());
    }

    private static void recursion(int index, int count) {
        if (count == 3) {
            int[][] copyGraph = copyGraph();
            spreadVirus(copyGraph);
            countSafeArea(copyGraph);
            return;
        }

        for (int i = index; i < emptyList.size(); i++) {
            Position position = emptyList.get(i);
            graph[position.x][position.y] = WALL;
            recursion(i + 1, count + 1);
            graph[position.x][position.y] = EMPTY;
        }
    }

    private static void countSafeArea(int[][] copyGraph) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (copyGraph[i][j] == EMPTY) count++;
            }
        }
        result.add(count);
    }

    private static void spreadVirus(int[][] copyGraph) {
        List<Position> copyVirusList = new ArrayList<>();
        for (Position position : virusList) copyVirusList.add(new Position(position.x, position.y));

        while (!copyVirusList.isEmpty()) {
            Position position = copyVirusList.remove(0);
            for (int[] direction : DIRECTION) {
                int x = position.x + direction[0];
                int y = position.y + direction[1];
                if (x < 0 || x >= M || y < 0 || y >= N) continue;
                if (copyGraph[x][y] == EMPTY) {
                    copyGraph[x][y] = VIRUS;
                    copyVirusList.add(new Position(x, y));
                }
            }
        }
    }

    private static int[][] copyGraph() {
        int[][] copyGraph = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
        return copyGraph;
    }
}

class Position {

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
