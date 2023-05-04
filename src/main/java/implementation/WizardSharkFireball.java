/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20056
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WizardSharkFireball {

    final static int[][] DIRECTIONS = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    final static int[] EVEN_OR_ODD = {0, 2, 4, 6};
    final static int[] OTHER = {1, 3, 5, 7};
    final static List<Fireball> fireballList = new ArrayList<>();
    static int N;
    static int FIREBALL_COUNT;
    static int MOVE_COUNT;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        FIREBALL_COUNT = info[1];
        MOVE_COUNT = info[2];
        map = new int[N][N];

        for (int i = 0; i < FIREBALL_COUNT; i++) {
            int[] fireballInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[fireballInfo[0] - 1][fireballInfo[1] - 1] = 1;
            fireballList.add(new Fireball(fireballInfo[0] - 1, fireballInfo[1] - 1, fireballInfo[2], fireballInfo[3], fireballInfo[4]));
        }

        System.out.println(solution());
    }

    private static int solution() {
        for (int i = 0; i < MOVE_COUNT; i++) {
            moveFireballList();
            mergeFireballList();
        }
        return getMass();
    }

    private static void mergeFireballList() {
        List<Fireball> newFireballList = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] == 0) continue;
                if (map[x][y] == 1) {
                    for (Fireball fireball : fireballList) {
                        if (fireball.x == x && fireball.y == y) {
                            newFireballList.add(fireball);
                            break;
                        }
                    }
                    continue;
                }
                mergeFireballEachRegion(newFireballList, x, y);
            }
        }
        fireballList.clear();
        fireballList.addAll(newFireballList);
    }

    private static void mergeFireballEachRegion(List<Fireball> newFireballList, int x, int y) {
        int mass = 0;
        int speed = 0;
        int evenCount = 0;
        int oddCount = 0;
        for (Fireball fireball : fireballList) {
            if (fireball.x == x && fireball.y == y) {
                mass += fireball.mass;
                speed += fireball.speed;
                if (fireball.direction % 2 == 0) evenCount++;
                else oddCount++;
            }
        }
        mass /= 5;
        speed /= map[x][y];
        if (mass == 0) {
            map[x][y] = 0;
            return;
        }
        if (evenCount == 0 || oddCount == 0) {
            for (int direction : EVEN_OR_ODD) {
                newFireballList.add(new Fireball(x, y, mass, speed, direction));
            }
            map[x][y] = 4;
        } else {
            for (int direction : OTHER) {
                newFireballList.add(new Fireball(x, y, mass, speed, direction));
            }
            map[x][y] = 4;
        }
    }

    private static void moveFireballList() {
        for (Fireball fireball : fireballList) {
            map[fireball.x][fireball.y] -= 1;
            fireball.move();
            map[fireball.x][fireball.y] += 1;
        }
    }

    private static int getMass() {
        int mass = 0;
        for (Fireball fireball : fireballList) {
            mass += fireball.mass;
        }
        return mass;
    }

    static class Fireball {
        int x;
        int y;
        int mass;
        int speed;
        int direction;

        public Fireball(int x, int y, int mass, int speed, int direction) {
            this.x = x;
            this.y = y;
            this.mass = mass;
            this.direction = direction;
            this.speed = speed;
        }

        public void move() {
            int nx = this.x + DIRECTIONS[direction][0] * speed;
            int ny = this.y + DIRECTIONS[direction][1] * speed;
            while (nx < 0) nx += N;
            while (ny < 0) ny += N;
            this.x = nx % N;
            this.y = ny % N;
        }
    }
}
