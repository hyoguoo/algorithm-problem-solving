/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3187
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

public class ShepherdKung {

    static final char WALL = '#';
    static final char SHEEP = 'k';
    static final char WOLF = 'v';
    static final char VISITED = 'x';
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final Count count = new Count();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        char[][] graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = bufferedReader.readLine().toCharArray();
        }

        solution(graph);
    }

    private static void solution(char[][] graph) {
        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] != WALL &&
                    graph[n][m] != VISITED) bfs(graph, n, m);
            }
        }

        System.out.println(count.sheepCount + " " + count.wolfCount);
    }

    private static void bfs(char[][] graph, int startN, int startM) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM));
        int sheepCount = 0;
        int wolfCount = 0;

        if (graph[startN][startM] == SHEEP) sheepCount++;
        if (graph[startN][startM] == WOLF) wolfCount++;
        graph[startN][startM] = VISITED;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(graph, nextN, nextM) ||
                    graph[nextN][nextM] == WALL ||
                    graph[nextN][nextM] == VISITED) continue;

                if (graph[nextN][nextM] == SHEEP) sheepCount++;
                if (graph[nextN][nextM] == WOLF) wolfCount++;
                graph[nextN][nextM] = VISITED;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        count.updateCount(sheepCount, wolfCount);
    }

    private static boolean isInBound(char[][] graph, int nextN, int nextM) {
        return 0 <= nextN && nextN < graph.length &&
               0 <= nextM && nextM < graph[nextN].length;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Count {
        int sheepCount;
        int wolfCount;

        public Count() {
            this.sheepCount = 0;
            this.wolfCount = 0;
        }

        public void updateCount(int sheepCount, int wolfCount) {
            if (sheepCount > wolfCount) this.sheepCount += sheepCount;
            else this.wolfCount += wolfCount;
        }
    }
}
