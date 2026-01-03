/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1996
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minesweeper1996 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sizeN = Integer.parseInt(bufferedReader.readLine());
        int[][] minefield = new int[sizeN][sizeN];
        for (int i = 0; i < sizeN; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < sizeN; j++) {
                if (line.charAt(j) == '.') {
                    minefield[i][j] = 0;
                } else {
                    minefield[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }
        }

        System.out.print(solution(minefield));
    }

    private static Field solution(int[][] minefield) {
        return new Field(minefield);
    }

    enum Direction {
        UP(-1, 0),
        UP_RIGHT(-1, 1),
        RIGHT(0, 1),
        DOWN_RIGHT(1, 1),
        DOWN(1, 0),
        DOWN_LEFT(1, -1),
        LEFT(0, -1),
        UP_LEFT(-1, -1);

        private final int deltaX;
        private final int deltaY;

        Direction(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
    }

    static class Field {

        private static final int MINE = -1;
        private static final String MINE_SIGN = "*";
        private static final String MANY_MINES_SIGN = "M";
        private static final int MANY_MINES_THRESHOLD = 10;
        private final int[][] minefield;
        private final int[][] adjacentMineCounts;

        public Field(int[][] minefield) {
            this.minefield = minefield;
            this.adjacentMineCounts = calculateAdjacentMineCounts();
        }

        private int[][] calculateAdjacentMineCounts() {
            int[][] counts = new int[minefield.length][minefield.length];

            for (int i = 0; i < minefield.length; i++) {
                for (int j = 0; j < minefield.length; j++) {
                    if (minefield[i][j] > 0) {
                        counts[i][j] = MINE;
                        continue;
                    }
                    counts[i][j] = countAdjacentMines(i, j);
                }
            }

            return counts;
        }

        private int countAdjacentMines(int x, int y) {
            int sum = 0;
            for (Direction direction : Direction.values()) {
                int nx = x + direction.deltaX;
                int ny = y + direction.deltaY;
                if (!isInBounds(new Coordinate(nx, ny))) {
                    continue;
                }
                sum += minefield[nx][ny];
            }
            return sum;
        }

        private boolean isInBounds(Coordinate coordinate) {
            return 0 <= coordinate.x && coordinate.x < minefield.length &&
                    0 <= coordinate.y && coordinate.y < minefield.length;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < adjacentMineCounts.length; i++) {
                for (int j = 0; j < adjacentMineCounts.length; j++) {
                    if (adjacentMineCounts[i][j] == MINE) {
                        builder.append(MINE_SIGN);
                    } else if (adjacentMineCounts[i][j] >= MANY_MINES_THRESHOLD) {
                        builder.append(MANY_MINES_SIGN);
                    } else {
                        builder.append(adjacentMineCounts[i][j]);
                    }
                }
                builder.append(System.lineSeparator());
            }
            return builder.toString();
        }
    }

    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate move(Direction direction) {
            return new Coordinate(this.x + direction.deltaX, this.y + direction.deltaY);
        }
    }
}
