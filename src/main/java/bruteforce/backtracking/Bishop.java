/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1799
 * Cheat Level: 0
 * Algorithm: Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop {

    private static final Direction[] DIRECTIONS = Direction.values();
    private static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Cell[][] board = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = Cell.from(line[j]);
            }
        }

        System.out.print(solution(board));
    }

    private static int solution(Cell[][] board) {
        List<Coordinate> blackCandidateList = new ArrayList<>();
        List<Coordinate> whiteCandidateList = new ArrayList<>();
        for (int n = 0; n < board.length; n++) {
            for (int m = 0; m < board.length; m++) {
                if (board[n][m] != Cell.AVAILABLE) {
                    continue;
                }
                if ((n + m) % 2 == 0) {
                    blackCandidateList.add(new Coordinate(n, m));
                } else {
                    whiteCandidateList.add(new Coordinate(n, m));
                }
            }
        }

        maxCount = 0;
        backtrack(blackCandidateList, board, 0, 0);
        int blackMax = maxCount;

        maxCount = 0;
        backtrack(whiteCandidateList, board, 0, 0);
        int whiteMax = maxCount;

        return blackMax + whiteMax;
    }

    private static void backtrack(List<Coordinate> candidateList, Cell[][] board, int index, int count) {
        if (count + (candidateList.size() - index) <= maxCount) {
            return;
        }
        if (index == candidateList.size()) {
            maxCount = count;
            return;
        }
        Coordinate coordinate = candidateList.get(index);

        if (canPlace(coordinate, board)) {
            board[coordinate.n][coordinate.m] = Cell.BISHOP;
            backtrack(candidateList, board, index + 1, count + 1);
            board[coordinate.n][coordinate.m] = Cell.AVAILABLE;
        }
        backtrack(candidateList, board, index + 1, count);
    }

    private static boolean canPlace(Coordinate coordinate, Cell[][] board) {
        int size = board.length;
        for (Direction direction : DIRECTIONS) {
            int nn = coordinate.n + direction.n;
            int mm = coordinate.m + direction.m;
            while (0 <= nn && nn < size && 0 <= mm && mm < size) {
                if (board[nn][mm] == Cell.BISHOP) {
                    return false;
                }
                nn += direction.n;
                mm += direction.m;
            }
        }
        return true;
    }

    enum Cell {
        BLOCKED(0),
        AVAILABLE(1),
        BISHOP(2);

        private final int value;

        Cell(int value) {
            this.value = value;
        }

        public static Cell from(int value) {
            return Arrays.stream(values())
                    .filter(cell -> cell.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum Direction {
        UP_LEFT(-1, -1),
        UP_RIGHT(-1, 1),
        DOWN_LEFT(1, -1),
        DOWN_RIGHT(1, 1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate nextCoordinate(Direction direction) {
            return new Coordinate(this.n + direction.n, this.m + direction.m);
        }
    }
}
