/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1730
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Printmaking {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String s = bufferedReader.readLine();
        Direction[] directions = new Direction[s.length()];
        for (int i = 0; i < s.length(); i++) {
            directions[i] = Direction.of(String.valueOf(s.charAt(i)));
        }
        System.out.print(solution(new Map(n), directions));
    }

    private static String solution(Map map, Direction[] directions) {
        for (Direction direction : directions) {
            map.moveRobot(direction);
        }

        return map.toString();
    }

    enum Direction {
        UP("U", -1, 0),
        DOWN("D", 1, 0),
        LEFT("L", 0, -1),
        RIGHT("R", 0, 1);

        private final String directionValue;
        private final int n;
        private final int m;

        Direction(String directionValue, int n, int m) {
            this.directionValue = directionValue;
            this.n = n;
            this.m = m;
        }

        public static Direction of(String direction) {
            return Arrays.stream(values())
                    .filter(d -> d.directionValue.equals(direction))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum Mark {
        EMPTY("."),
        VERTICAL("|"),
        HORIZONTAL("-"),
        CROSS("+");

        private final String markValue;

        Mark(String markValue) {
            this.markValue = markValue;
        }

        public Mark nextMark(Direction direction) {
            switch (this) {
                case EMPTY:
                    return direction == Direction.UP || direction == Direction.DOWN
                            ? VERTICAL
                            : HORIZONTAL;
                case VERTICAL:
                    return direction == Direction.UP || direction == Direction.DOWN
                            ? VERTICAL
                            : CROSS;
                case HORIZONTAL:
                    return direction == Direction.LEFT || direction == Direction.RIGHT
                            ? HORIZONTAL
                            : CROSS;
                case CROSS:
                    return CROSS;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    static class Map {

        private final Mark[][] marks;
        private Coordinate robotCoordinate;

        public Map(int n) {
            final int START_N = 0;
            final int START_M = 0;

            this.marks = new Mark[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(marks[i], Mark.EMPTY);
            }
            this.robotCoordinate = new Coordinate(START_N, START_M);
        }

        public void moveRobot(Direction direction) {
            Coordinate nextCoordinate = robotCoordinate.nextCoordinate(direction);

            if (isInBound(nextCoordinate)) {
                drawLine(robotCoordinate, direction);
                robotCoordinate = nextCoordinate;
                drawLine(robotCoordinate, direction);
            }
        }

        private void drawLine(Coordinate coordinate, Direction direction) {
            Mark mark = marks[coordinate.n][coordinate.m];
            marks[coordinate.n][coordinate.m] = mark.nextMark(direction);
        }

        private boolean isInBound(Coordinate coordinate) {
            return 0 <= coordinate.n && coordinate.n < marks.length &&
                    0 <= coordinate.m && coordinate.m < marks[0].length;
        }

        private String print() {
            StringBuilder stringBuilder = new StringBuilder();

            for (Mark[] line : marks) {
                for (Mark mark : line) {
                    stringBuilder.append(mark.markValue);
                }
                stringBuilder.append("\n");
            }

            return stringBuilder.toString();
        }

        @Override
        public String toString() {
            return print();
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
            return new Coordinate(n + direction.n, m + direction.m);
        }
    }
}
