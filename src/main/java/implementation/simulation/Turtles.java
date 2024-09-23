/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 8911
 * Cheat Level: 0
 * Algorithm: Simulation / Implementation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Turtles {

    private static final int START_X = 0;
    private static final int START_Y = 0;
    private static final Direction START_DIRECTION = Direction.NORTH;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            stringBuilder.append(solution(bufferedReader.readLine())).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String input) {
        Turtle turtle = new Turtle(new Coordinate(START_X, START_Y), START_DIRECTION);
        Rectangle rectangle = new Rectangle();

        for (char c : input.toCharArray()) {
            rectangle.update(turtle.executeCommand(Command.of(c)));
        }

        return rectangle.getArea();
    }

    enum Direction {
        NORTH(0, 1),
        EAST(1, 0),
        SOUTH(0, -1),
        WEST(-1, 0);

        private final int x;
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Direction turnLeft() {
            switch (this) {
                case NORTH:
                    return WEST;
                case EAST:
                    return NORTH;
                case SOUTH:
                    return EAST;
                case WEST:
                    return SOUTH;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public Direction turnRight() {
            switch (this) {
                case NORTH:
                    return EAST;
                case EAST:
                    return SOUTH;
                case SOUTH:
                    return WEST;
                case WEST:
                    return NORTH;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    enum Command {
        FORWARD('F'),
        BACKWARD('B'),
        LEFT('L'),
        RIGHT('R');

        private final char value;

        Command(char value) {
            this.value = value;
        }

        public static Command of(char command) {
            return Arrays.stream(values())
                    .filter(value -> value.value == command)
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Rectangle {

        private int minX;
        private int minY;
        private int maxX;
        private int maxY;

        public Rectangle() {
            this.minX = 0;
            this.minY = 0;
            this.maxX = 0;
            this.maxY = 0;
        }

        public void update(Coordinate coordinate) {
            this.minX = Math.min(this.minX, coordinate.x);
            this.minY = Math.min(this.minY, coordinate.y);
            this.maxX = Math.max(this.maxX, coordinate.x);
            this.maxY = Math.max(this.maxY, coordinate.y);
        }

        public int getArea() {
            return (maxX - minX) * (maxY - minY);
        }
    }

    static class Turtle {

        private Coordinate coordinate;
        private Direction direction;

        public Turtle(Coordinate coordinate, Direction direction) {
            this.coordinate = coordinate;
            this.direction = direction;
        }

        public Coordinate executeCommand(Command command) {
            switch (command) {
                case FORWARD:
                    forward();
                    break;
                case BACKWARD:
                    backward();
                    break;
                case LEFT:
                    direction = direction.turnLeft();
                    break;
                case RIGHT:
                    direction = direction.turnRight();
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            return coordinate;
        }

        private void forward() {
            this.coordinate = new Coordinate(
                    this.coordinate.x + direction.x,
                    this.coordinate.y + direction.y
            );
        }

        private void backward() {
            this.coordinate = new Coordinate(
                    this.coordinate.x - direction.x,
                    this.coordinate.y - direction.y
            );
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
