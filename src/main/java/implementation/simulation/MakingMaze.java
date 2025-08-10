/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1347
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakingMaze {

    private static final Direction START_DIRECTION = Direction.DOWN;
    private static final int MAX_SIZE = 100;
    private static final int START_X = MAX_SIZE / 2;
    private static final int START_Y = MAX_SIZE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        Action[] actions = Arrays.stream(bufferedReader.readLine().split(""))
                .map(Action::fromString)
                .toArray(Action[]::new);

        System.out.print(solution(actions));
    }

    private static Map solution(Action[] actions) {
        Map maze = Map.initializeMaze();
        Me me = new Me(START_X, START_Y, START_DIRECTION);

        maze.mark(me.position);
        Arrays.stream(actions).forEach(action -> {
            me.action(action);
            maze.mark(new Position(me.position.x, me.position.y));
        });

        return maze;
    }

    enum Symbol {
        WALL("#"),
        PATH(".");

        private final String value;

        Symbol(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    enum Direction {
        UP(0, -1),
        RIGHT(1, 0),
        DOWN(0, 1),
        LEFT(-1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public Direction turn(Action action) {
            switch (action) {
                case FRONT:
                    return this;
                case LEFT:
                    switch (this) {
                        case UP:
                            return LEFT;
                        case RIGHT:
                            return UP;
                        case DOWN:
                            return RIGHT;
                        case LEFT:
                            return DOWN;
                        default:
                            throw new IllegalArgumentException();
                    }
                case RIGHT:
                    switch (this) {
                        case UP:
                            return RIGHT;
                        case RIGHT:
                            return DOWN;
                        case DOWN:
                            return LEFT;
                        case LEFT:
                            return UP;
                        default:
                            throw new IllegalArgumentException();
                    }
                default:
                    throw new IllegalArgumentException();
            }
        }


    }

    enum Action {
        FRONT("F"),
        LEFT("L"),
        RIGHT("R");

        private final String value;

        Action(String value) {
            this.value = value;
        }

        public static Action fromString(String value) {
            return Arrays.stream(values())
                    .filter(action -> action.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Map {

        private final Symbol[][] maze;
        private int minX = MAX_SIZE;
        private int minY = MAX_SIZE;
        private int maxX = 0;
        private int maxY = 0;

        private Map() {
            Symbol[] filled = IntStream.range(0, MAX_SIZE + 1)
                    .mapToObj(i -> Symbol.WALL)
                    .toArray(Symbol[]::new);
            this.maze = IntStream.range(0, MAX_SIZE + 1)
                    .mapToObj(i -> filled.clone())
                    .toArray(Symbol[][]::new);
        }

        public static Map initializeMaze() {
            return new Map();
        }

        public void mark(Position position) {
            maze[position.y][position.x] = Symbol.PATH;
            updateBounds(position);
        }

        private void updateBounds(Position position) {
            minX = Math.min(minX, position.x);
            minY = Math.min(minY, position.y);
            maxX = Math.max(maxX, position.x);
            maxY = Math.max(maxY, position.y);
        }

        @Override
        public String toString() {
            return IntStream.range(minY, maxY + 1)
                    .mapToObj(y -> IntStream.range(minX, maxX + 1)
                            .mapToObj(x -> maze[y][x].toString())
                            .collect(Collectors.joining()))
                    .collect(Collectors.joining("\n"));
        }
    }

    static class Me {

        private final Position position;
        private Direction direction;

        public Me(int x, int y, Direction direction) {
            this.position = new Position(x, y);
            this.direction = direction;
        }

        public void action(Action action) {
            this.direction = this.direction.turn(action);
            if (action == Action.FRONT) {
                this.position.x += this.direction.dx;
                this.position.y += this.direction.dy;
            }
        }
    }

    static class Position {

        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
