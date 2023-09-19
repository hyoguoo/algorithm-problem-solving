/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30036
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class INK {

    final static String UP = "U";
    final static String DOWN = "D";
    final static String LEFT = "L";
    final static String RIGHT = "R";
    final static String INK_CHARGE = "j";
    final static String JUMP = "J";
    final static String SQUARE = "@";
    final static String EMPTY = ".";
    final static String WALL = "#";
    static String[][] grid;
    static String[] inkStrings, commands;
    static int inkStringLength, N, commandCount;
    static int inkAmount = 0;
    static int jumpCount = 0;
    static Coordinate squareCoordinate;

    public static void main(String[] args) throws IOException {
        init();

        solution();
        print();
    }

    private static void solution() {
        for (String command : commands) {
            switch (command) {
                case INK_CHARGE:
                    charge();
                    break;
                case JUMP:
                    jump();
                    break;
                default:
                    move(command);
            }
        }
        grid[squareCoordinate.n][squareCoordinate.m] = SQUARE;
    }

    private static void move(String direction) {
        int nextN = squareCoordinate.n;
        int nextM = squareCoordinate.m;
        switch (direction) {
            case UP:
                nextN--;
                break;
            case DOWN:
                nextN++;
                break;
            case LEFT:
                nextM--;
                break;
            case RIGHT:
                nextM++;
                break;
        }

        if (isOutGrid(nextN, nextM)) return;
        if (!grid[nextN][nextM].equals(EMPTY)) return;

        squareCoordinate.n = nextN;
        squareCoordinate.m = nextM;
    }

    private static void charge() {
        inkAmount++;
    }

    private static void jump() {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                if (isOutGrid(n, m)) continue;
                if (!isReachable(n, m)) continue;
                if (grid[n][m].equals(EMPTY)) continue;
                grid[n][m] = getInkString();
            }
        }
        inkAmount = 0;
        jumpCount++;
    }

    private static String getInkString() {
        return inkStrings[jumpCount % inkStringLength];
    }

    private static boolean isReachable(int n, int m) {
        return getManhattanDistance(n, m) <= inkAmount;
    }

    private static int getManhattanDistance(int n, int m) {
        return Math.abs(squareCoordinate.n - n) + Math.abs(squareCoordinate.m - m);
    }

    private static boolean isOutGrid(int n, int m) {
        return 0 > n || n >= N || 0 > m || m >= N;
    }

    private static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] strings : grid) {
            for (String string : strings) stringBuilder.append(string);
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        inkStringLength = info[0];
        N = info[1];
        commandCount = info[2];
        inkStrings = bufferedReader.readLine().split("");
        grid = new String[N][N];
        for (int n = 0; n < N; n++) {
            String[] split = bufferedReader.readLine().split("");
            for (int m = 0; m < N; m++) {
                String value = split[m];
                if (value.equals(SQUARE)) {
                    squareCoordinate = new Coordinate(n, m);
                    grid[n][m] = EMPTY;
                } else grid[n][m] = value;
            }
        }
        commands = bufferedReader.readLine().split("");
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
