/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14503
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RobotVacuumCleaners {

    private static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] mapInfo = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Robot robot = parseRobotInfo();
        Grid grid = parseMapInfo(mapInfo[0], mapInfo[1]);

        System.out.print(
                solution(
                        robot,
                        grid
                )
        );
    }

    private static int solution(Robot robot, Grid grid) {
        int count = 0;

        while (true) {
            if (grid.isAvailableClean(robot.coordinate)) {
                robot.clean(grid);
                count++;
            }

            if (!grid.checkAround(robot.coordinate)) {
                if (robot.moveBack(grid)) {
                    continue;
                } else {
                    break;
                }
            }

            robot.turnLeft();
            robot.moveFront(grid);
        }

        return count;
    }

    private static Grid parseMapInfo(int sizeN, int sizeM) throws IOException {
        State[][] map = new State[sizeN][sizeM];

        for (int i = 0; i < sizeN; i++) {
            int[] row = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < sizeM; j++) {
                map[i][j] = State.fromValue(row[j]);
            }
        }

        return new Grid(map);
    }

    private static Robot parseRobotInfo() throws IOException {
        int[] robotInfo = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int robotN = robotInfo[0];
        int robotM = robotInfo[1];
        int robotDirection = robotInfo[2];

        return new Robot(
                new Coordinate(robotN, robotM),
                Direction.fromValue(robotDirection)
        );
    }

    enum Direction {
        NORTH(0, -1, 0),
        EAST(1, 0, 1),
        SOUTH(2, 1, 0),
        WEST(3, 0, -1);

        private final int value;
        private final int n;
        private final int m;

        Direction(int value, int n, int m) {
            this.value = value;
            this.n = n;
            this.m = m;
        }

        public static Direction fromValue(int index) {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.value == index)
                    .findFirst()
                    .orElseThrow();
        }

        public Direction turnLeft() {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.n == -this.m && direction.m == this.n)
                    .findFirst()
                    .orElseThrow();
        }
    }

    enum State {
        CLEANED(2),
        WALL(1),
        EMPTY(0);

        private final int value;

        State(int value) {
            this.value = value;
        }

        public static State fromValue(int value) {
            return Arrays.stream(State.values())
                    .filter(state -> state.value == value)
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Grid {

        private final State[][] states;

        public Grid(State[][] states) {
            this.states = states;
        }

        public boolean isAvailableClean(Coordinate coordinate) {
            return this.isInBound(coordinate) &&
                    this.states[coordinate.n][coordinate.m] == State.EMPTY;
        }

        public boolean isAvailableMove(Coordinate coordinate) {
            return this.isInBound(coordinate) &&
                    this.states[coordinate.n][coordinate.m] != State.WALL;
        }

        public void clean(Coordinate coordinate) {
            this.states[coordinate.n][coordinate.m] = State.CLEANED;
        }

        public boolean checkAround(Coordinate coordinate) {
            for (Direction direction : Direction.values()) {
                Coordinate nextCoordinate = new Coordinate(
                        coordinate.n + direction.n,
                        coordinate.m + direction.m
                );

                if (this.isAvailableClean(nextCoordinate)) {
                    return true;
                }
            }

            return false;
        }

        private boolean isInBound(Coordinate coordinate) {
            return 0 <= coordinate.n && coordinate.n < this.states.length &&
                    0 <= coordinate.m && coordinate.m < this.states[0].length;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Robot {

        private Coordinate coordinate;
        private Direction direction;

        public Robot(Coordinate coordinate, Direction direction) {
            this.coordinate = coordinate;
            this.direction = direction;
        }

        public boolean moveFront(Grid grid) {
            Coordinate nextCoordinate = new Coordinate(
                    this.coordinate.n + this.direction.n,
                    this.coordinate.m + this.direction.m
            );

            if (grid.isAvailableClean(nextCoordinate)) {
                this.coordinate = nextCoordinate;
                return true;
            }

            return false;
        }

        public boolean moveBack(Grid grid) {
            Coordinate nextCoordinate = new Coordinate(
                    this.coordinate.n - this.direction.n,
                    this.coordinate.m - this.direction.m
            );

            if (grid.isAvailableMove(nextCoordinate)) {
                this.coordinate = nextCoordinate;
                return true;
            }

            return false;
        }

        public void clean(Grid grid) {
            grid.clean(this.coordinate);
        }

        public void turnLeft() {
            this.direction = this.direction.turnLeft();
        }
    }
}
