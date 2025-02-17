/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number:
 * Cheat Level: 
 * Algorithm: 
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class TicTacToe {

    private static final int ROUND_COUNT = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PlayerNumber playerNumber = PlayerNumber.of(Integer.parseInt(bufferedReader.readLine()));

        Check[] checks = new Check[ROUND_COUNT];

        for (int i = 0; i < ROUND_COUNT; i++) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            checks[i] = new Check(new Coordinate(coordinateInfo[0], coordinateInfo[1]), playerNumber);
            playerNumber = playerNumber.getOppositePlayer();
        }

        System.out.print(solution(checks));
    }

    private static PlayerNumber solution(Check[] checks) {
        Board board = new Board();
        int round = 0;

        while (round < ROUND_COUNT) {
            board.addCheck(checks[round++]);
            Optional<PlayerNumber> winner = board.isGameEnd();
            if (winner.isPresent()) {
                return winner.get();
            }
        }

        return PlayerNumber.DRAW;
    }

    enum PlayerNumber {
        DRAW(0), ONE(1), TWO(2);

        private final int value;

        PlayerNumber(int value) {
            this.value = value;
        }

        public static PlayerNumber of(int value) {
            return Arrays.stream(PlayerNumber.values())
                    .filter(p -> p.value == value)
                    .findFirst()
                    .orElseThrow();
        }

        public PlayerNumber getOppositePlayer() {
            return this == ONE ? TWO : ONE;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    static class Board {

        private static final int BOARD_SIZE = 3;
        private final PlayerNumber[][] boardNumbers;

        public Board() {
            this.boardNumbers = new PlayerNumber[BOARD_SIZE + 1][BOARD_SIZE + 1];
            for (int x = 1; x <= BOARD_SIZE; x++) {
                for (int y = 1; y <= BOARD_SIZE; y++) {
                    this.boardNumbers[x][y] = PlayerNumber.DRAW;
                }
            }
        }

        public void addCheck(Check check) {
            Coordinate coordinate = check.coordinate;
            this.boardNumbers[coordinate.x][coordinate.y] = check.playerNumber;
        }

        public Optional<PlayerNumber> isGameEnd() {
            return checkHorizontal()
                    .or(this::checkVertical)
                    .or(this::checkDiagonal);
        }

        private Optional<PlayerNumber> checkHorizontal() {
            for (int x = 1; x <= BOARD_SIZE; x++) {
                PlayerNumber first = boardNumbers[x][1];
                if (first == PlayerNumber.DRAW) {
                    continue;
                }

                boolean isWinning = true;
                for (int y = 2; y <= BOARD_SIZE; y++) {
                    if (boardNumbers[x][y] != first) {
                        isWinning = false;
                        break;
                    }
                }
                if (isWinning) {
                    return Optional.of(first);
                }
            }
            return Optional.empty();
        }

        private Optional<PlayerNumber> checkVertical() {
            for (int y = 1; y <= BOARD_SIZE; y++) {
                PlayerNumber first = boardNumbers[1][y];
                if (first == PlayerNumber.DRAW) {
                    continue;
                }

                boolean isWinning = true;
                for (int x = 2; x <= BOARD_SIZE; x++) {
                    if (boardNumbers[x][y] != first) {
                        isWinning = false;
                        break;
                    }
                }
                if (isWinning) {
                    return Optional.of(first);
                }
            }
            return Optional.empty();
        }

        private Optional<PlayerNumber> checkDiagonal() {
            PlayerNumber firstMainDiagonal = boardNumbers[1][1];
            boolean isMainDiagonalWin = (firstMainDiagonal != PlayerNumber.DRAW);

            for (int i = 2; i <= BOARD_SIZE; i++) {
                if (boardNumbers[i][i] != firstMainDiagonal) {
                    isMainDiagonalWin = false;
                    break;
                }
            }
            if (isMainDiagonalWin) {
                return Optional.of(firstMainDiagonal);
            }

            PlayerNumber firstAntiDiagonal = boardNumbers[1][BOARD_SIZE];
            boolean isAntiDiagonalWin = (firstAntiDiagonal != PlayerNumber.DRAW);

            for (int i = 2; i <= BOARD_SIZE; i++) {
                if (boardNumbers[i][BOARD_SIZE - i + 1] != firstAntiDiagonal) {
                    isAntiDiagonalWin = false;
                    break;
                }
            }
            if (isAntiDiagonalWin) {
                return Optional.of(firstAntiDiagonal);
            }

            return Optional.empty();
        }
    }

    static class Check {

        private final Coordinate coordinate;
        private final PlayerNumber playerNumber;

        public Check(Coordinate coordinate, PlayerNumber playerNumber) {
            this.coordinate = coordinate;
            this.playerNumber = playerNumber;
        }
    }

    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
