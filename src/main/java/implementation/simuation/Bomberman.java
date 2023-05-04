/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16918
 * Cheat Level: 0
 * Algorithm: Simulation
 */

package implementation.simuation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bomberman {

    final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final static char BOMB = 'O';
    final static char EMPTY = '.';
    static int N, M, TARGET_SECOND;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    private static void simulate() {
        for (int currentSecond = 2; currentSecond <= TARGET_SECOND; currentSecond++) {
            if (currentSecond % 2 == 0) installAllBomb();
            else bomb();
        }
        printMap();
    }

    private static void installAllBomb() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) map[i][j] = 1;
                else map[i][j]++;
            }
        }
    }

    private static void bomb() {
        List<Bomb> bombList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    bombList.add(new Bomb(i, j));
                    for (int[] direction : DIRECTIONS) {
                        int nextX = i + direction[0];
                        int nextY = j + direction[1];
                        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                        bombList.add(new Bomb(nextX, nextY));
                    }
                }
            }
        }

        for (Bomb bomb : bombList) map[bomb.x][bomb.y] = -1;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        TARGET_SECOND = info[2];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] readArray = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < readArray.length; j++) {
                char c = readArray[j];
                if (c == BOMB) map[i][j] = 1;
                else map[i][j] = -1;
            }
        }
    }

    private static void printMap() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) stringBuilder.append(EMPTY);
                else stringBuilder.append(BOMB);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    static class Bomb {
        int x;
        int y;

        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
