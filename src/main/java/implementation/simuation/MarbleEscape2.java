/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13460
 * Cheat Level: 0
 * Algorithm: Simulation
 */

package implementation.simuation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MarbleEscape2 {

    final static char WALL = '#';
    final static char HOLE = 'O';
    final static char RED = 'R';
    final static char BLUE = 'B';
    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    final static int LIMIT = 10;
    static int N, M;
    static char[][] graph;
    static Ball blue, red;
    static Coordinate hole;
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        backtracking(red, blue, 0);
        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    private static void backtracking(Ball red, Ball blue, int count) {
        if (count > LIMIT) return;
        if (blue.x == hole.x && blue.y == hole.y) return;
        if (red.x == hole.x && red.y == hole.y) {
            minCount = Math.min(minCount, count);
            return;
        }

        for (int[] direction : DIRECTIONS) {
            Ball nextRed = new Ball(red.x, red.y);
            Ball nextBlue = new Ball(blue.x, blue.y);
            if (isWall(direction, nextRed) && isWall(direction, nextBlue)) continue;
            move(nextRed, nextBlue, direction);
            backtracking(nextRed, nextBlue, count + 1);
        }
    }

    private static boolean isWall(int[] direction, Ball ball) {
        return graph[ball.x + direction[0]][ball.y + direction[1]] == WALL;
    }

    private static void move(Ball ball1, Ball ball2, int[] direction) {
        if (isBall1First(ball1, ball2, direction)) {
            ball1.move(direction);
            ball2.move(direction, ball1);
        } else {
            ball2.move(direction);
            ball1.move(direction, ball2);
        }
    }

    private static boolean isBall1First(Ball ball1, Ball ball2, int[] direction) {
        return (direction[0] == 1 && ball1.x > ball2.x) ||
                (direction[0] == -1 && ball1.x < ball2.x) ||
                (direction[1] == 1 && ball1.y > ball2.y) ||
                (direction[1] == -1 && ball1.y < ball2.y);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                char c = line[j];
                if (c == RED) red = new Ball(i, j);
                else if (c == BLUE) blue = new Ball(i, j);
                else if (c == HOLE) hole = new Coordinate(i, j);
                graph[i][j] = c;
            }
        }
    }

    static class Ball extends Coordinate {
        public Ball(int x, int y) {
            super(x, y);
        }

        public void move(int[] direction) {
            while (canMoveTo(direction)) {
                x += direction[0];
                y += direction[1];
                if (isHole()) break;
            }
        }

        public void move(int[] direction, Ball anotherBall) {
            while (canMoveTo(direction)) {
                x += direction[0];
                y += direction[1];
                if (isHole()) break;
                if (collidesWith(anotherBall)) {
                    x -= direction[0];
                    y -= direction[1];
                    break;
                }
            }
        }

        private boolean canMoveTo(int[] direction) {
            return graph[this.x + direction[0]][this.y + direction[1]] != WALL;
        }

        private boolean isHole() {
            return graph[this.x][this.y] == HOLE;
        }

        private boolean collidesWith(Ball anotherBall) {
            return this.x == anotherBall.x && this.y == anotherBall.y;
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
