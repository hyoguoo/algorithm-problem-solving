/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17142
 * Cheat Level: 2
 * Algorithm: Graph / BFS / Brute Force
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Laboratory3 {

    final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    final static List<Virus> viruses = new ArrayList<>();
    static int N, ACTIVE_VIRUS_COUNT;
    static int[][] graph;
    static int EMPTY_SPACE = 0;
    static Virus[] active;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        ACTIVE_VIRUS_COUNT = info[1];

        graph = new int[N][N];
        active = new Virus[ACTIVE_VIRUS_COUNT];

        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < N; m++) {
                graph[n][m] = input[m];
                if (graph[n][m] == 0) EMPTY_SPACE++;
                if (graph[n][m] == 2) viruses.add(new Virus(n, m, 0));
            }
        }

        if (EMPTY_SPACE == 0) {
            System.out.println(0);
        } else {
            selectVirus(0, 0);
            System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
        }
    }

    static void selectVirus(int startIndex, int selectCount) {
        if (selectCount == ACTIVE_VIRUS_COUNT) {
            spreadVirus(EMPTY_SPACE);
            return;
        }

        for (int i = startIndex; i < viruses.size(); i++) {
            active[selectCount] = viruses.get(i);
            selectVirus(i + 1, selectCount + 1);
        }
    }

    static void spreadVirus(int emptySpace) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] infected = new boolean[N][N];

        for (int i = 0; i < ACTIVE_VIRUS_COUNT; i++) {
            Virus virus = active[i];
            infected[virus.n][virus.m] = true;
            queue.add(virus);
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nx = virus.n + direction[0];
                int ny = virus.m + direction[1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (infected[nx][ny] || graph[nx][ny] == 1) continue;

                if (graph[nx][ny] == 0) emptySpace--;
                if (emptySpace == 0) {
                    minTime = Math.min(minTime, virus.time + 1);
                    return;
                }
                infected[nx][ny] = true;
                queue.add(new Virus(nx, ny, virus.time + 1));
            }
        }
    }

    static class Virus {
        int n;
        int m;
        int time;

        Virus(int n, int m, int time) {
            this.n = n;
            this.m = m;
            this.time = time;
        }
    }
}
