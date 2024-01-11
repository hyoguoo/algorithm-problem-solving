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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Bingo {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final int BOARD_SIZE = 5;

    public static void main(String[] args) throws IOException {
        int[][] board = getBoard();
        List<Integer> numbers = getNumbers();

        System.out.print(solution(board, numbers));
    }

    private static int solution(int[][] board, List<Integer> numbers) {
        boolean[][] isMarked = new boolean[BOARD_SIZE][BOARD_SIZE];
        int count = 0;

        for (Integer number : numbers) {
            count++;
            findNumberCoordinate(board, number)
                    .ifPresent(value -> isMarked[value.n][value.m] = true);

            int bingoCount = getBingoCount(isMarked);
            if (bingoCount >= 3) return count;
        }

        return -1;
    }

    private static Optional<Coordinate> findNumberCoordinate(int[][] board, Integer number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == number) return Optional.of(new Coordinate(i, j));
            }
        }

        return Optional.empty();
    }

    private static int getBingoCount(boolean[][] isMarked) {
        int bingoCount = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (isBingo(isMarked[i])) bingoCount++;
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean[] column = new boolean[BOARD_SIZE];
            for (int j = 0; j < BOARD_SIZE; j++) {
                column[j] = isMarked[j][i];
            }
            if (isBingo(column)) bingoCount++;
        }

        boolean[] diagonal = new boolean[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            diagonal[i] = isMarked[i][i];
        }
        if (isBingo(diagonal)) bingoCount++;

        boolean[] reverseDiagonal = new boolean[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            reverseDiagonal[i] = isMarked[i][BOARD_SIZE - i - 1];
        }
        if (isBingo(reverseDiagonal)) bingoCount++;

        return bingoCount;
    }

    private static boolean isBingo(boolean[] column) {
        for (boolean isMarked : column) {
            if (!isMarked) return false;
        }

        return true;
    }

    private static int[][] getBoard() throws IOException {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return board;
    }

    private static List<Integer> getNumbers() throws IOException {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int number : line) numbers.add(number);
        }

        return numbers;
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
