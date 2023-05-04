/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2667
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Numbering {

    static final List<Integer> resultList = new ArrayList<>();
    static int N;
    static boolean[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < N; j++) map[i][j] = input[j].equals("1");
        }

        counting();
        Collections.sort(resultList);
        System.out.println(resultList.size());
        resultList.stream().sorted().forEach(System.out::println);
    }

    private static void counting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) travel(i, j);
            }
        }
    }

    private static void travel(int i, int j) {
        int count = 0;
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(i, j));

        while (!queue.isEmpty()) {
            Location removed = queue.remove();
            int x = removed.x;
            int y = removed.y;
            if (map[x][y]) {
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny]) queue.add(new Location(nx, ny));
                }
                count++;
                map[x][y] = false;
            }
        }

        resultList.add(count);
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
