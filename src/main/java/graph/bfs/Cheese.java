/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2638
 * Cheat Level: 2
 * Algorithm: Graph / Simulation / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cheese {

    final static int CHEESE = 1;
    final static int AIR = 0;
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static List<CheeseCoordinate> cheeseCoordinateList = new ArrayList<>();
    final static Queue<Coordinate> airCoordinateList = new LinkedList<>();
    static int N;
    static int M;
    static int[][] GRAPH;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        int meltingTime = getMeltingTime();
        System.out.println(meltingTime);
    }

    private static int getMeltingTime() {
        airCoordinateList.add(new Coordinate(0, 0));
        airCoordinateList.add(new Coordinate(0, M - 1));
        airCoordinateList.add(new Coordinate(N - 1, 0));
        airCoordinateList.add(new Coordinate(N - 1, M - 1));
        int time = 0;
        while (!cheeseCoordinateList.isEmpty()) {
            bfs();
            removeCheeseBlock();
            time++;
        }
        return time;
    }

    private static void bfs() {
        while (!airCoordinateList.isEmpty()) {
            Coordinate current = airCoordinateList.poll();

            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;

            for (int[] direction : DIRECTIONS) {
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];

                if (nextX < 0 || N <= nextX || nextY < 0 || M <= nextY) continue;
                if (GRAPH[nextX][nextY] == CHEESE) {
                    cheeseCoordinateList.stream().filter(cheeseCoordinate -> cheeseCoordinate.x == nextX && cheeseCoordinate.y == nextY).forEach(cheeseCoordinate -> cheeseCoordinate.count++);
                } else airCoordinateList.add(new Coordinate(nextX, nextY));
            }
        }
    }

    private static void removeCheeseBlock() {
        for (int i = cheeseCoordinateList.size() - 1; i >= 0; i--) {
            CheeseCoordinate cheeseCoordinate = cheeseCoordinateList.get(i);
            if (cheeseCoordinate.count >= 2) {
                GRAPH[cheeseCoordinate.x][cheeseCoordinate.y] = AIR;
                cheeseCoordinateList.remove(i);
                airCoordinateList.add(new Coordinate(cheeseCoordinate.x, cheeseCoordinate.y));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        GRAPH = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                int value = input[j];
                if (value == CHEESE) cheeseCoordinateList.add(new CheeseCoordinate(i, j, 0));
                GRAPH[i][j] = value;
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

    static class CheeseCoordinate extends Coordinate {
        int count;

        public CheeseCoordinate(int x, int y, int count) {
            super(x, y);
            this.count = count;
        }
    }
}
