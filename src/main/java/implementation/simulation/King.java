/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1063
 * Cheat Level:
 * Algorithm:
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class King {

    static final Map<String, Integer> ALPHABET = Map.of(
            "A", 0,
            "B", 1,
            "C", 2,
            "D", 3,
            "E", 4,
            "F", 5,
            "G", 6,
            "H", 7
    );

    static final int BOARD_SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bufferedReader.readLine().split(" ");
        String[] kingInfo = info[0].split("");
        String[] stoneInfo = info[1].split("");
        int commandCount = Integer.parseInt(info[2]);

        List<Direction> commands = new ArrayList<>();
        for (int i = 0; i < commandCount; i++) {
            commands.add(Direction.of(bufferedReader.readLine()));
        }

        solution(
                new Coordinate(BOARD_SIZE - Integer.parseInt(kingInfo[1]), ALPHABET.get(kingInfo[0])),
                new Coordinate(BOARD_SIZE - Integer.parseInt(stoneInfo[1]), ALPHABET.get(stoneInfo[0])),
                commands
        );
    }

    private static void solution(Coordinate king, Coordinate stone, List<Direction> commands) {
        for (Direction command : commands) {
            Coordinate nextKing = new Coordinate(king.n, king.m);
            Coordinate nextStone = new Coordinate(stone.n, stone.m);

            if (!nextKing.move(command) ||
                (nextKing.isSame(nextStone) && !nextStone.move(command))) continue;

            king = nextKing;
            stone = nextStone;
        }

        printResult(king, stone);
    }

    private static void printResult(Coordinate king, Coordinate stone) {
        System.out.printf("%s%s%n", (char) (king.m + 'A'), BOARD_SIZE - king.n);
        System.out.printf("%s%s%n", (char) (stone.m + 'A'), BOARD_SIZE - stone.n);
    }

    enum Direction {
        R(0, 1),
        L(0, -1),
        B(1, 0),
        T(-1, 0),
        RT(-1, 1),
        LT(-1, -1),
        RB(1, 1),
        LB(1, -1);

        final int n;
        final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }

        static Direction of(String str) {
            return Direction.valueOf(str);
        }
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public boolean move(Direction direction) {
            this.n += direction.n;
            this.m += direction.m;

            if (!isInBoard()) {
                this.n -= direction.n;
                this.m -= direction.m;
                return false;
            }

            return true;
        }

        public boolean isSame(Coordinate coordinate) {
            return this.n == coordinate.n && this.m == coordinate.m;
        }

        private boolean isInBoard() {
            return 0 <= n && n < BOARD_SIZE && 0 <= m && m < BOARD_SIZE;
        }
    }
}
