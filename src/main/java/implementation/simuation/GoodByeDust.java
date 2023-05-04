/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17144
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simuation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodByeDust {

    final static List<Dust> dustList = new ArrayList<>();
    final static int AIR_CLEANER = -1;
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int AIR_CLEANER_TOP;
    static int AIR_CLEANER_BOTTOM;
    static int N, M, TIME;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        System.out.println(getTotalAmount());
    }

    private static void simulation() {
        for (int time = 0; time < TIME; time++) {
            spread();
            clean();
            mapRelocation();
        }
    }

    private static void spread() {
        List<Dust> spreadDustList = new ArrayList<>();

        for (Dust dust : dustList) {
            int x = dust.x;
            int y = dust.y;
            int amount = dust.amount;
            int spreadAmount = amount / 5;

            int spreadCount = 0;
            for (int[] direction : DIRECTIONS) {
                int spreadX = x + direction[0];
                int spreadY = y + direction[1];
                if (spreadX < 0 || spreadX >= N || spreadY < 0 || spreadY >= M) continue;
                if (map[spreadX][spreadY] == AIR_CLEANER) continue;
                spreadDustList.add(new Dust(spreadX, spreadY, spreadAmount));
                spreadCount++;
            }

            map[x][y] -= spreadAmount * spreadCount;
            dust.amount = map[x][y];
        }

        addSpreadDustToMap(spreadDustList);
        regenerateDustListFromMap();
    }

    private static void regenerateDustListFromMap() {
        dustList.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) dustList.add(new Dust(i, j, map[i][j]));
            }
        }
    }

    private static void addSpreadDustToMap(List<Dust> spreadDustList) {
        for (Dust dust : spreadDustList) {
            map[dust.x][dust.y] += dust.amount;
        }
    }

    private static void clean() {
        for (int index = dustList.size() - 1; index >= 0; index--) {
            Dust dust = dustList.get(index);

            if ((dust.x == AIR_CLEANER_TOP - 1 || dust.x == AIR_CLEANER_BOTTOM + 1) && dust.y == 0) {
                dustList.remove(index);
            } else if (dust.x == AIR_CLEANER_TOP && dust.y > 0) {
                if (dust.y == M - 1) dust.x--;
                else dust.y++;
            } else if (dust.x == AIR_CLEANER_BOTTOM && dust.y > 0) {
                if (dust.y == M - 1) dust.x++;
                else dust.y++;
            } else if ((dust.x == 0 && dust.y > 0) || (dust.x == N - 1 && dust.y > 0)) {
                dust.y--;
            } else if (dust.y == M - 1) {
                if (dust.x < AIR_CLEANER_TOP) dust.x--;
                else if (dust.x > AIR_CLEANER_BOTTOM) dust.x++;
            } else if (dust.y == 0) {
                if (dust.x < AIR_CLEANER_TOP) dust.x++;
                else dust.x--;
            }
        }
    }

    private static void mapRelocation() {
        map = new int[N][M];
        for (Dust dust : dustList) {
            map[dust.x][dust.y] = dust.amount;
        }
        map[AIR_CLEANER_TOP][0] = AIR_CLEANER;
        map[AIR_CLEANER_BOTTOM][0] = AIR_CLEANER;
    }

    private static int getTotalAmount() {
        int totalAmount = 0;
        for (Dust dust : dustList) {
            totalAmount += dust.amount;
        }
        return totalAmount;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        TIME = info[2];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
                if (map[i][j] > 0) dustList.add(new Dust(i, j, map[i][j]));
                if (map[i][j] == AIR_CLEANER) {
                    if (AIR_CLEANER_TOP == 0) AIR_CLEANER_TOP = i;
                    else AIR_CLEANER_BOTTOM = i;
                }
            }
        }
    }

    static class Dust {
        int x;
        int y;
        int amount;

        public Dust(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }
}
