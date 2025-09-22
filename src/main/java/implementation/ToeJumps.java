/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28463
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ToeJumps {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String directionLine = bufferedReader.readLine();
        if (directionLine == null || directionLine.isEmpty()) {
            return;
        }
        Direction direction = Direction.from(directionLine.trim().charAt(0));

        String row0 = bufferedReader.readLine();
        String row1 = bufferedReader.readLine();
        if (row0 == null || row1 == null) {
            return;
        }

        char[][] grid = new char[][]{
                new char[]{row0.charAt(0), row0.charAt(1)},
                new char[]{row1.charAt(0), row1.charAt(1)}
        };

        System.out.print(solution(direction, grid));
    }

    static String solution(Direction direction, char[][] rawGrid) {
        char[][] southAligned = direction.alignToSouth(rawGrid);
        String top = new String(new char[]{southAligned[0][0], southAligned[0][1]});
        String bottom = new String(new char[]{southAligned[1][0], southAligned[1][1]});

        return Arrays.stream(ToePattern.values())
                .filter(pattern -> pattern.matches(top, bottom))
                .map(pattern -> pattern.outputCode)
                .findFirst()
                .orElse("?");
    }

    private static char[][] copy(char[][] g) {
        return new char[][]{
                new char[]{g[0][0], g[0][1]},
                new char[]{g[1][0], g[1][1]}
        };
    }

    private static char[][] rotate90CW(char[][] g) {
        return new char[][]{
                new char[]{g[1][0], g[0][0]},
                new char[]{g[1][1], g[0][1]}
        };
    }

    private static char[][] rotate90CCW(char[][] g) {
        return new char[][]{
                new char[]{g[0][1], g[1][1]},
                new char[]{g[0][0], g[1][0]}
        };
    }

    private static char[][] rotate180(char[][] g) {
        return new char[][]{
                new char[]{g[1][1], g[1][0]},
                new char[]{g[0][1], g[0][0]}
        };
    }

    enum Direction {
        N, E, S, W;

        static Direction from(char c) {
            switch (c) {
                case 'N':
                    return N;
                case 'E':
                    return E;
                case 'S':
                    return S;
                case 'W':
                    return W;
                default:
                    throw new IllegalArgumentException();
            }
        }

        char[][] alignToSouth(char[][] g) {
            switch (this) {
                case S:
                    return copy(g);
                case N:
                    return rotate180(g);
                case E:
                    return rotate90CW(g);
                case W:
                    return rotate90CCW(g);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    enum ToePattern {
        T(".O", "P.", "T"),
        F("I.", ".P", "F"),
        LZ("O.", ".P", "Lz");

        private final String topRow;
        private final String bottomRow;
        private final String outputCode;

        ToePattern(String topRow, String bottomRow, String outputCode) {
            this.topRow = topRow;
            this.bottomRow = bottomRow;
            this.outputCode = outputCode;
        }

        boolean matches(String top, String bottom) {
            return this.topRow.equals(top) && this.bottomRow.equals(bottom);
        }
    }
}
