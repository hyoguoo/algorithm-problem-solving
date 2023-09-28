/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2583
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GetArea {

    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        visit = new boolean[N][M];
        int squareCount = info[2];
        while (squareCount-- > 0) {
            int[] squareInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int leftBottomM = squareInfo[0];
            int leftBottomN = squareInfo[1];
            int rightTopM = squareInfo[2];
            int rightTopN = squareInfo[3];
            for (int n = leftBottomN; n < rightTopN; n++) {
                for (int m = leftBottomM; m < rightTopM; m++) {
                    visit[n][m] = true;
                }
            }
        }
        printList(solution());
    }

    private static List<Integer> solution() {
        List<Integer> result = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (!visit[n][m]) result.add(bfs(n, m));
            }
        }

        return result;
    }

    private static int bfs(int n, int m) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));
        int count = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visit[current.n][current.m]) continue;
            visit[current.n][current.m] = true;
            count++;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(nextN, nextM)) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return count;
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    private static void printList(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.size()).append("\n");
        result.stream().sorted().forEach(i -> stringBuilder.append(i).append(" "));
        System.out.println(stringBuilder);
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
