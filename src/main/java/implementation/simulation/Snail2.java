/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1952
 * Cheat Level: 0
 * Algorithm: Simulation / Implementation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Snail2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(new GameBoard(info[0], info[1]), new Snail()));
    }

    private static int solution(GameBoard gameBoard, Snail snail) {
        while (gameBoard.isAvailable(snail.coordinate)) {
            gameBoard.check(snail.coordinate);
            snail.move(gameBoard);
        }

        return snail.getTurnCount();
    }

    enum Direction {
        RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Direction next() {
            switch (this) {
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case UP:
                    return RIGHT;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    static class GameBoard {

        private final boolean[][] board;

        public GameBoard(int sizeN, int sizeM) {
            this.board = new boolean[sizeN][sizeM];
        }

        public void check(Coordinate coordinate) {
            this.board[coordinate.n][coordinate.m] = true;
        }

        public boolean isAvailable(Coordinate coordinate) {
            return isInBound(coordinate) &&
                    !this.board[coordinate.n][coordinate.m];
        }

        private boolean isInBound(Coordinate coordinate) {
            return 0 <= coordinate.n && coordinate.n < this.board.length &&
                    0 <= coordinate.m && coordinate.m < this.board[0].length;
        }
    }

    static class Snail {

        private Coordinate coordinate;
        private Direction direction;
        private int turnCount;

        public Snail() {
            this.coordinate = new Coordinate(0, 0);
            this.direction = Direction.RIGHT;
            this.turnCount = 0;
        }

        public void move(GameBoard gameBoard) {
            Coordinate nextCoordinate = this.coordinate.next(this.direction);
            if (gameBoard.isAvailable(nextCoordinate)) {
                this.coordinate = nextCoordinate;
            } else {
                this.direction = this.direction.next();
                this.coordinate = this.coordinate.next(this.direction);
                this.turnCount++;
            }
        }

        public int getTurnCount() {
            return this.turnCount;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate next(Direction direction) {
            return new Coordinate(this.n + direction.n, this.m + direction.m);
        }
    }
}
