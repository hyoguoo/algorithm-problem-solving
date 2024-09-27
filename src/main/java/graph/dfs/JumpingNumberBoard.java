/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2210
 * Cheat Level: 0
 * Algorithm: Graph / DFS / Brute Force
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JumpingNumberBoard {

    static final int SIZE = 5;
    static final int MOVE_LIMIT = 6;

    public static void main(String[] args) throws IOException {
        int[][] board = parseBoard();
        System.out.print(solution(board));
    }

    private static int[][] parseBoard() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[SIZE][SIZE];

        for (int n = 0; n < SIZE; n++) {
            board[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return board;
    }

    private static int solution(int[][] board) {
        Set<String> numberSet = new HashSet<>(); // numberSet을 지역 변수로 사용
        for (int n = 0; n < SIZE; n++) {
            for (int m = 0; m < SIZE; m++) {
                dfs(
                        board,
                        new Coordinate(n, m),
                        new StringBuilder().append(board[n][m]),
                        numberSet
                );
            }
        }
        return numberSet.size();
    }

    private static void dfs(
            int[][] board,
            Coordinate coordinate,
            StringBuilder numberString,
            Set<String> numberSet
    ) {
        if (numberString.length() == MOVE_LIMIT) {
            numberSet.add(numberString.toString());
            return;
        }

        for (Direction direction : Direction.values()) {
            Coordinate nextCoordinate = coordinate.move(direction);

            if (!isInBound(nextCoordinate)) {
                continue;
            }

            dfs(
                    board,
                    nextCoordinate,
                    numberString.append(board[nextCoordinate.n][nextCoordinate.m]),
                    numberSet
            );

            numberString.deleteCharAt(numberString.length() - 1);
        }
    }

    private static boolean isInBound(Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < SIZE &&
                0 <= coordinate.m && coordinate.m < SIZE;
    }

    enum Direction {
        RIGHT(0, 1),
        LEFT(0, -1),
        DOWN(1, 0),
        UP(-1, 0);

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

        public Coordinate move(Direction direction) {
            return new Coordinate(this.n + direction.n, this.m + direction.m);
        }
    }
}
