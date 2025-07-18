/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 224468
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConflictCount {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = info[0];
        int ballCount = info[1];
        int time = info[2];

        Ball[] balls = new Ball[ballCount];

        for (int i = 0; i < ballCount; i++) {
            String[] ballInfo = bufferedReader.readLine().split(" ");

            int position = Integer.parseInt(ballInfo[0]);
            Direction direction = "L".equals(ballInfo[1]) ? Direction.LEFT : Direction.RIGHT;

            balls[i] = new Ball(position, direction);
        }

        System.out.print(solution(balls, length, time));
    }

    private static int solution(Ball[] balls, int length, int time) {
        int conflictCount = 0;

        for (int t = 0; t < time; t++) {
            Map<Integer, List<Ball>> positionMap = new HashMap<>();

            Arrays.stream(balls).forEach(ball -> {
                ball.move(length);
                positionMap.computeIfAbsent(ball.position, k -> new ArrayList<>())
                        .add(ball);
            });

            for (List<Ball> ballList : positionMap.values()) {
                if (ballList.size() >= 2) {
                    conflictCount++;
                    ballList.forEach(Ball::turn);
                }
            }
        }

        return conflictCount;
    }

    enum Direction {
        LEFT(-1),
        RIGHT(1);

        private final int dx;

        Direction(int dx) {
            this.dx = dx;
        }

        public Direction opposite() {
            return this == LEFT ? RIGHT : LEFT;
        }
    }

    static class Ball {

        private int position;
        private Direction direction;

        public Ball(int position, Direction direction) {
            this.position = position;
            this.direction = direction;
        }

        public void move(int length) {
            this.position += direction.dx;

            if (this.position == 0 || this.position == length) {
                this.turn();
            }
        }

        public void turn() {
            direction = direction.opposite();
        }
    }
}
