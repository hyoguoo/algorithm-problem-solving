/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3184
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

public class Sheep {

    static final char WALL = '#';
    static final char WOLF = 'v';
    static final char SHEEP = 'o';
    static final char VISITED = 'x';
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[0];
        int m = info[1];

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }

        System.out.print(solution(map));
    }

    private static String solution(char[][] map) {
        int sheepCount = 0;
        int wolfCount = 0;

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map[n].length; m++) {
                char value = map[n][m];
                if (value != WALL && value != VISITED) {
                    Count count = bfs(map, new Coordinate(n, m));
                    sheepCount += count.sheep;
                    wolfCount += count.wolf;
                }
            }
        }

        return sheepCount + " " + wolfCount;
    }

    private static Count bfs(char[][] map, Coordinate coordinate) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(coordinate);
        int sheepCount = 0;
        int wolfCount = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (map[current.n][current.m] == VISITED) {
                continue;
            }
            if (map[current.n][current.m] == WOLF) {
                wolfCount++;
            }
            if (map[current.n][current.m] == SHEEP) {
                sheepCount++;
            }
            map[current.n][current.m] = VISITED;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(map, new Coordinate(nextN, nextM)) ||
                        map[nextN][nextM] == WALL || map[nextN][nextM] == VISITED
                ) {
                    continue;
                }
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        if (sheepCount > wolfCount) {
            wolfCount = 0;
        } else {
            sheepCount = 0;
        }

        return new Count(sheepCount, wolfCount);
    }

    private static boolean isInBound(char[][] map, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < map.length &&
                0 <= coordinate.m && coordinate.m < map[coordinate.n].length;
    }

    static class Count {

        int sheep;
        int wolf;

        public Count(int sheep, int wolf) {
            this.sheep = sheep;
            this.wolf = wolf;
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
}
