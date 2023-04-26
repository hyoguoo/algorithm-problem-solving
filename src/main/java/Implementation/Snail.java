/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1913
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {

    static int N, TARGET, targetX, targetY;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        printResult();
    }

    private static void solution() {
        Coordinate coordinate = new Coordinate(-1, 0, 0);
        int value = N * N;

        while (!isCenterCoordinate(coordinate)) {
            coordinate.move();
            graph[coordinate.x][coordinate.y] = value;
            if (value == TARGET) setTargetCoordinate(coordinate);
            value--;
        }
    }

    private static boolean isCenterCoordinate(Coordinate coordinate) {
        return coordinate.x == N / 2 && coordinate.y == N / 2;
    }

    private static void setTargetCoordinate(Coordinate coordinate) {
        targetX = coordinate.x + 1;
        targetY = coordinate.y + 1;
    }

    private static void printResult() {
        printGraph();
        printTarget();
    }

    private static void printGraph() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stringBuilder.append(graph[i][j]).append(" ");
            }
            if (i != N - 1) stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void printTarget() {
        System.out.println(targetX + " " + targetY);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        TARGET = Integer.parseInt(bufferedReader.readLine());
        graph = new int[N][N];
    }

    static class Coordinate {
        int x;
        int y;
        int direction;

        public Coordinate(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        // 0: down, 1: right, 2: up, 3: left
        public void move() {
            switch (this.direction) {
                case 0:
                    this.x++;
                    if (!this.isAvailable()) {
                        this.x--;
                        this.setNextDirection();
                        this.move();
                    }
                    break;
                case 1:
                    this.y++;
                    if (!this.isAvailable()) {
                        this.y--;
                        this.setNextDirection();
                        this.move();
                    }
                    break;
                case 2:
                    this.x--;
                    if (!this.isAvailable()) {
                        this.x++;
                        this.setNextDirection();
                        this.move();
                    }
                    break;
                case 3:
                    this.y--;
                    if (!this.isAvailable()) {
                        this.y++;
                        this.setNextDirection();
                        this.move();
                    }
                    break;
            }
        }

        private boolean isAvailable() {
            return this.isInBound() && this.isNotVisited();
        }

        private boolean isNotVisited() {
            return graph[x][y] == 0;
        }

        private boolean isInBound() {
            return 0 <= this.x && this.x < N && 0 <= this.y && this.y < N;
        }

        private void setNextDirection() {
            this.direction = (this.direction + 1) % 4;
        }
    }
}
