/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2578
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Bingo {

    private static final int BOARD_SIZE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] calls = new int[BOARD_SIZE * BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.arraycopy(line, 0, calls, i * 5, BOARD_SIZE);
        }

        System.out.print(solution(board, calls));
    }

    private static int solution(int[][] board, int[] calls) {
        Board bingoBoard = new Board(board);
        int count = 0;

        while (true) {
            for (int call : calls) {
                bingoBoard.call(call);
                count++;
                if (bingoBoard.isBingo()) {
                    return count;
                }
            }
        }
    }

    static class Board {

        private static final int BINGO_COUNT = 3;

        private final int[][] values;
        private final boolean[][] marks;

        public Board(int[][] values) {
            this.values = values;
            this.marks = new boolean[BOARD_SIZE][BOARD_SIZE];
        }

        public void call(int call) {
            for (int n = 0; n < BOARD_SIZE; n++) {
                for (int m = 0; m < BOARD_SIZE; m++) {
                    if (values[n][m] == call) {
                        marks[n][m] = true;
                        return;
                    }
                }
            }
        }

        public boolean isBingo() {
            return getBingoCount() >= BINGO_COUNT;
        }

        private int getBingoCount() {
            int count = 0;

            count += countHorizontal();
            count += countVertical();
            count += countDiagonal();

            return count;
        }

        private int countDiagonal() {
            int count = 0;
            if (IntStream.range(0, BOARD_SIZE)
                    .allMatch(n -> marks[n][n])) {
                count++;
            }

            if (IntStream.range(0, BOARD_SIZE)
                    .allMatch(n -> marks[n][BOARD_SIZE - n - 1])) {
                count++;
            }
            return count;
        }

        private int countHorizontal() {
            return (int) IntStream.range(0, values[0].length)
                    .filter(this::isBingoHorizontal)
                    .count();
        }

        private boolean isBingoHorizontal(int n) {
            return IntStream.range(0, BOARD_SIZE)
                    .allMatch(m -> marks[n][m]);
        }

        private int countVertical() {
            return (int) IntStream.range(0, values[0].length)
                    .filter(this::isBingoVertical)
                    .count();
        }

        private boolean isBingoVertical(int m) {
            return IntStream.range(0, BOARD_SIZE)
                    .allMatch(n -> marks[n][m]);
        }
    }
}
