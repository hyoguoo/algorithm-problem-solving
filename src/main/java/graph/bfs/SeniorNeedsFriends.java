/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21736
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

public class SeniorNeedsFriends {

    final static char WALL = 'X';
    final static char ME = 'I';
    final static char PERSON = 'P';
    final static char VISITED = 'V';
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M, startX, startY;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        init();
        int count = solution();
        System.out.println(count == 0 ? "TT" : count);
    }

    private static int solution() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startX, startY));

        int count = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (graph[current.x][current.y] == VISITED) continue;
            if (graph[current.x][current.y] == PERSON) count++;
            graph[current.x][current.y] = VISITED;

            for (int[] direction : DIRECTIONS) {
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];
                if (!isInBound(nextX, nextY) || graph[nextX][nextY] == WALL) continue;
                queue.add(new Coordinate(nextX, nextY));
            }
        }

        return count;
    }

    private static boolean isInBound(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char c = input[j];
                if (c == ME) {
                    startX = i;
                    startY = j;
                }
                graph[i][j] = c;
            }
        }
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
