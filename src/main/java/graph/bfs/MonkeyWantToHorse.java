/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1600
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

public class MonkeyWantToHorse {

    static final int NOT_REACH = -1;
    static final int NOT_VISITED = 0;
    static final int[][] HORSE_DIRECTION = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
    };
    static final int[][] NORMAL_DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int horseMoveCount = Integer.parseInt(bufferedReader.readLine());
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[1];
        int m = info[0];

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int result = bfs(graph, n, m, horseMoveCount);

        System.out.print(
                result == Integer.MAX_VALUE
                        ? NOT_REACH
                        : result
        );
    }

    public static int bfs(int[][] graph, int limitN, int limitM, int horseMoveCount) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 0, horseMoveCount));

        boolean[][][] visited = new boolean[limitN][limitM][horseMoveCount + 1];
        visited[0][0][horseMoveCount] = true;

        while (!queue.isEmpty()) {
            Move current = queue.poll();

            if (current.n == limitN - 1 && current.m == limitM - 1) {
                return current.moveCount;
            }

            for (int[] direction : NORMAL_DIRECTION) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isOutBound(nextN, nextM, limitN, limitM)
                        || visited[nextN][nextM][current.remainHorseMove]
                        || graph[nextN][nextM] != NOT_VISITED) {
                    continue;
                }

                visited[nextN][nextM][current.remainHorseMove] = true;
                queue.add(
                        new Move(
                                nextN,
                                nextM,
                                current.moveCount + 1,
                                current.remainHorseMove
                        )
                );
            }

            if (current.remainHorseMove > 0) {
                for (int[] direction : HORSE_DIRECTION) {
                    int nextN = current.n + direction[0];
                    int nextM = current.m + direction[1];

                    if (isOutBound(nextN, nextM, limitN, limitM)
                            || visited[nextN][nextM][current.remainHorseMove - 1]
                            || graph[nextN][nextM] != NOT_VISITED) {
                        continue;
                    }

                    visited[nextN][nextM][current.remainHorseMove - 1] = true;
                    queue.add(
                            new Move(
                                    nextN,
                                    nextM,
                                    current.moveCount + 1,
                                    current.remainHorseMove - 1
                            )
                    );
                }
            }
        }

        return NOT_REACH;
    }

    private static boolean isOutBound(int n, int m, int limitN, int limitM) {
        return n < 0 || m < 0 || n >= limitN || m >= limitM;
    }

    static class Move {

        int n;
        int m;
        int moveCount;
        int remainHorseMove;

        public Move(int n, int m, int moveCount, int remainHorseMove) {
            this.n = n;
            this.m = m;
            this.moveCount = moveCount;
            this.remainHorseMove = remainHorseMove;
        }
    }
}

