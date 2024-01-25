/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14499
 * Cheat Level: 0
 * Algorithm: Simulation / Implementation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RollDice {

    static final int EMPTY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int diceN = info[2];
        int diceM = info[3];
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] commands = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(map, new Dice(diceN, diceM), commands);
    }

    private static void solution(int[][] map, Dice dice, int[] commands) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int command : commands) {
            if (!dice.move(command, map.length, map[0].length)) continue;
            if (map[dice.n][dice.m] == EMPTY) {
                map[dice.n][dice.m] = dice.getBottom();
            } else {
                dice.setBottom(map[dice.n][dice.m]);
                map[dice.n][dice.m] = EMPTY;
            }
            stringBuilder.append(dice.getTop()).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static class Dice {

        static final int[][] DIRECTIONS = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int n;
        int m;
        int top;
        int bottom;
        int left;
        int right;
        int front;
        int back;

        public Dice(int n, int m) {
            this.n = n;
            this.m = m;
            this.top = EMPTY;
            this.bottom = EMPTY;
            this.left = EMPTY;
            this.right = EMPTY;
            this.front = EMPTY;
            this.back = EMPTY;
        }

        public int getTop() {
            return top;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int value) {
            this.bottom = value;
        }

        public boolean move(int direction, int limitN, int limitM) {
            int nextN = n + DIRECTIONS[direction][0];
            int nextM = m + DIRECTIONS[direction][1];
            if (!isInBound(nextN, nextM, limitN, limitM)) return false;

            movePosition(nextN, nextM);

            switch (direction) {
                case 1:
                    moveRight();
                    break;
                case 2:
                    moveLeft();
                    break;
                case 3:
                    moveUp();
                    break;
                case 4:
                    moveDown();
                    break;
                default:
                    break;
            }

            return true;
        }

        private void movePosition(int nextN, int nextM) {
            this.n = nextN;
            this.m = nextM;
        }

        private boolean isInBound(int nextN, int nextM, int limitN, int limitM) {
            return 0 <= nextN && nextN < limitN && 0 <= nextM && nextM < limitM;
        }

        private void moveRight() {
            int temp = right;
            right = top;
            top = left;
            left = bottom;
            bottom = temp;
        }

        private void moveLeft() {
            int temp = left;
            left = top;
            top = right;
            right = bottom;
            bottom = temp;
        }

        private void moveUp() {
            int temp = top;
            top = front;
            front = bottom;
            bottom = back;
            back = temp;
        }

        private void moveDown() {
            int temp = bottom;
            bottom = front;
            front = top;
            top = back;
            back = temp;
        }
    }
}
