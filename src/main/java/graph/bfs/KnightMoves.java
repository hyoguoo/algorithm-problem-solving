/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7562
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

public class KnightMoves {

    final static int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    final static int NOT_VISITED = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCount = Integer.parseInt(bufferedReader.readLine());

        while (testCount-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] startInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] endInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stringBuilder.append(solution(N, new Coordinate(startInfo[0], startInfo[1]), new Coordinate(endInfo[0], endInfo[1]))).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int solution(int N, Coordinate start, Coordinate end) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        int[][] distance = new int[N][N];

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.n == end.n && current.m == end.m) return distance[current.n][current.m];

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isInBound(N, nextN, nextM) && distance[nextN][nextM] == NOT_VISITED) {
                    distance[nextN][nextM] = distance[current.n][current.m] + 1;
                    queue.add(new Coordinate(nextN, nextM));
                }
            }
        }

        throw new IllegalArgumentException();
    }

    private static boolean isInBound(int N, int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
