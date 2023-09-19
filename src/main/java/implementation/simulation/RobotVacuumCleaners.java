/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14503
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RobotVacuumCleaners {

    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int CLEANED = 2;
    static Robot robot;
    static int N, M;
    static int[][] grid;
    static int cleanedCount = 0;

    public static void main(String[] args) throws IOException {
        init();
        clean();
        System.out.println(cleanedCount);
    }

    private static void clean() {
        if (grid[robot.n][robot.m] == EMPTY) {
            grid[robot.n][robot.m] = CLEANED;
            cleanedCount++;
        }

        for (int i = 0; i < 4; i++) {
            robot.direction = Direction.values()[(robot.direction.ordinal() + 3) % 4];
            int nextN = robot.n + robot.direction.n;
            int nextM = robot.m + robot.direction.m;
            if (grid[nextN][nextM] == EMPTY) {
                robot.n = nextN;
                robot.m = nextM;
                clean();
                return;
            }
        }

        int nextN = robot.n - robot.direction.n;
        int nextM = robot.m - robot.direction.m;
        if (grid[nextN][nextM] == WALL) return;
        robot.n = nextN;
        robot.m = nextM;
        clean();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        grid = new int[N][M];
        int[] robotInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        robot = new Robot(robotInfo[0], robotInfo[1], Direction.values()[robotInfo[2]]);
        for (int n = 0; n < N; n++) {
            grid[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    enum Direction {
        NORTH(-1, 0),
        EAST(0, 1),
        SOUTH(1, 0),
        WEST(0, -1);

        final int n;
        final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Robot {

        int n;
        int m;
        Direction direction;

        public Robot(int n, int m, Direction direction) {
            this.n = n;
            this.m = m;
            this.direction = direction;
        }
    }
}
