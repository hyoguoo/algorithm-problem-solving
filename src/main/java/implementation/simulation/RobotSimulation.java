/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2174
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotSimulation {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final String CRASH_WALL_FORMAT = "Robot %d crashes into the wall";
    static final String CRASH_ROBOT_FORMAT = "Robot %d crashes into robot %d";
    static final String NO_CRASH = "OK";
    static final int NOT_EXIST = 0;

    public static void main(String[] args) throws IOException {
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = sizeInfo[1];
        int m = sizeInfo[0];
        int[][] map = new int[n][m];

        int[] robotInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Robot> robotList = initializeRobotList(robotInfo[0], n, map);
        List<CommandInfo> commandInfoList = initializeCommandLIst(robotInfo[1]);

        System.out.println(solution(map, robotList, commandInfoList));
    }

    private static String solution(int[][] map, List<Robot> robotList, List<CommandInfo> commandInfoList) {
        for (CommandInfo commandInfo : commandInfoList) {
            Robot robot = robotList.get(commandInfo.robotNumber - 1);

            for (int i = 0; i < commandInfo.repeatCount; i++) {
                if (commandInfo.commandString.equals("L")) {
                    robot.direction = robot.direction.turnLeft();
                } else if (commandInfo.commandString.equals("R")) {
                    robot.direction = robot.direction.turnRight();
                } else {
                    if (!robot.move(map.length, map[0].length)) {
                        return String.format(CRASH_WALL_FORMAT, commandInfo.robotNumber);
                    }

                    int nextN = robot.n + robot.direction.n;
                    int nextM = robot.m + robot.direction.m;

                    if (map[nextN][nextM] != NOT_EXIST) {
                        return String.format(CRASH_ROBOT_FORMAT, commandInfo.robotNumber, map[nextN][nextM]);
                    }

                    updateRobotPosition(map, commandInfo.robotNumber, robot, nextN, nextM);
                }
            }
        }

        return NO_CRASH;
    }

    private static void updateRobotPosition(int[][] map, int robotNumber, Robot robot, int nextN, int nextM) {
        map[robot.n][robot.m] = NOT_EXIST;
        map[nextN][nextM] = robotNumber;
        robot.n = nextN;
        robot.m = nextM;
    }

    private static List<CommandInfo> initializeCommandLIst(int commandCount) throws IOException {
        List<CommandInfo> commandInfoList = new ArrayList<>();

        for (int i = 0; i < commandCount; i++) {
            String[] commandInfo = bufferedReader.readLine().split(" ");
            int robotNumber = Integer.parseInt(commandInfo[0]);
            String commandString = commandInfo[1];
            int repeatCount = Integer.parseInt(commandInfo[2]);
            commandInfoList.add(new CommandInfo(robotNumber, commandString, repeatCount));
        }

        return commandInfoList;
    }

    private static List<Robot> initializeRobotList(int robotCount, int n, int[][] map) throws IOException {
        List<Robot> robotList = new ArrayList<>();

        for (int i = 0; i < robotCount; i++) {
            String[] robotPositionInfo = bufferedReader.readLine().split(" ");
            int robotN = n - Integer.parseInt(robotPositionInfo[1]);
            int robotM = Integer.parseInt(robotPositionInfo[0]) - 1;
            robotList.add(new Robot(robotN, robotM, robotPositionInfo[2]));
            map[robotN][robotM] = i + 1;
        }

        return robotList;
    }

    enum Direction {
        NORTH("N", -1, 0),
        SOUTH("S", 1, 0),
        EAST("E", 0, 1),
        WEST("W", 0, -1);

        private final String stringValue;
        private final int n;
        private final int m;

        Direction(String stringValue, int n, int m) {
            this.stringValue = stringValue;
            this.n = n;
            this.m = m;
        }

        public static Direction of(String stringValue) {
            return Arrays.stream(values())
                    .filter(direction -> direction.stringValue.equals(stringValue))
                    .findFirst()
                    .orElseThrow();
        }

        public Direction turnLeft() {
            return Arrays.stream(values())
                    .filter(direction -> direction.n == -this.m && direction.m == this.n)
                    .findFirst()
                    .orElseThrow();
        }

        public Direction turnRight() {
            return Arrays.stream(values())
                    .filter(direction -> direction.n == this.m && direction.m == -this.n)
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Robot {
        int n;
        int m;
        Direction direction;

        public Robot(int n, int m, String direction) {
            this.n = n;
            this.m = m;
            this.direction = Direction.of(direction);
        }

        public boolean move(int limitN, int limitM) {
            int nextN = this.n + this.direction.n;
            int nextM = this.m + this.direction.m;

            return isInBound(nextN, nextM, limitN, limitM);
        }

        private boolean isInBound(int n, int m, int limitN, int limitM) {
            return 0 <= n && n < limitN && 0 <= m && m < limitM;
        }
    }

    static class CommandInfo {
        int robotNumber;
        String commandString;
        int repeatCount;

        public CommandInfo(int robotNumber, String commandString, int repeatCount) {
            this.robotNumber = robotNumber;
            this.commandString = commandString;
            this.repeatCount = repeatCount;
        }
    }
}
