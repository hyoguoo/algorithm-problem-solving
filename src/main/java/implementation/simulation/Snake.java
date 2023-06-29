/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3190
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Snake {

    final static SnakeInfo snake = new SnakeInfo(0, 0, new ArrayDeque<>(), DIRECTIONS.RIGHT);
    final static List<Command> COMMAND_LIST = new ArrayList<>();
    final static int APPLE = 1;
    static int[][] map;
    static int N, APPLE_COUNT, COMMAND_COUNT;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int currentTime = 0;

        for (Command command : COMMAND_LIST) {
            while (currentTime < command.time) {
                currentTime++;
                int nextN = snake.n + snake.direction.n;
                int nextM = snake.m + snake.direction.m;
                if (isDeath(nextN, nextM)) return currentTime;
                snake.eat();
            }
            snake.rotate(command.rotate);
        }

        while (!isDeath(snake.n, snake.m)) {
            currentTime++;
            int nextN = snake.n + snake.direction.n;
            int nextM = snake.m + snake.direction.m;
            if (isDeath(nextN, nextM)) return currentTime;
            snake.eat();
        }

        return currentTime;
    }

    private static boolean isDeath(int n, int m) {
        return isWall(n, m) || isSnakeBody(n, m);
    }

    private static boolean isWall(int n, int m) {
        return n < 0 || m < 0 || n >= N || m >= N;
    }

    private static boolean isSnakeBody(int n, int m) {
        return snake.body.contains(new Coordinate(n, m));
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        APPLE_COUNT = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < APPLE_COUNT; i++) {
            int[] appleInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[appleInfo[0] - 1][appleInfo[1] - 1] = APPLE;
        }
        COMMAND_COUNT = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < COMMAND_COUNT; i++) {
            String[] commandInfo = bufferedReader.readLine().split(" ");
            COMMAND_LIST.add(new Command(Integer.parseInt(commandInfo[0]), commandInfo[1].charAt(0)));
        }
    }

    enum DIRECTIONS {
        RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);

        final int n;
        final int m;

        DIRECTIONS(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }


    static class SnakeInfo {
        int n;
        int m;
        Deque<Coordinate> body;
        DIRECTIONS direction;

        public SnakeInfo(int n, int m, Deque<Coordinate> body, DIRECTIONS direction) {
            this.n = n;
            this.m = m;
            this.body = body;
            this.direction = direction;
        }

        public void eat() {
            if (map[this.n][this.m] == APPLE) {
                this.body.addFirst(new Coordinate(this.n, this.m));
                map[this.n][this.m] = 0;
            } else {
                this.body.addFirst(new Coordinate(this.n, this.m));
                this.body.removeLast();
            }
            this.n += this.direction.n;
            this.m += this.direction.m;
        }

        public void rotate(char rotate) {
            if (rotate == 'L') {
                if (direction == DIRECTIONS.UP) snake.direction = DIRECTIONS.LEFT;
                else if (direction == DIRECTIONS.DOWN) snake.direction = DIRECTIONS.RIGHT;
                else if (direction == DIRECTIONS.LEFT) snake.direction = DIRECTIONS.DOWN;
                else if (direction == DIRECTIONS.RIGHT) snake.direction = DIRECTIONS.UP;
            } else {
                if (direction == DIRECTIONS.UP) snake.direction = DIRECTIONS.RIGHT;
                else if (direction == DIRECTIONS.DOWN) snake.direction = DIRECTIONS.LEFT;
                else if (direction == DIRECTIONS.LEFT) snake.direction = DIRECTIONS.UP;
                else if (direction == DIRECTIONS.RIGHT) snake.direction = DIRECTIONS.DOWN;
            }
        }
    }

    static class Command {
        int time;
        char rotate;

        public Command(int time, char rotate) {
            this.time = time;
            this.rotate = rotate;
        }
    }


    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Coordinate) {
                Coordinate coordinate = (Coordinate) obj;
                return this.n == coordinate.n && this.m == coordinate.m;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }
    }
}
