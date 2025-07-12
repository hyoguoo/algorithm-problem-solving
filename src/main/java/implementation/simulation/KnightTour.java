/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1331
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class KnightTour {

    private static final int BOARD_SIZE = 6;
    private static final int MOVE_COUNT = BOARD_SIZE * BOARD_SIZE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] positions = new String[MOVE_COUNT];

        for (int i = 0; i < MOVE_COUNT; i++) {
            positions[i] = bufferedReader.readLine();
        }

        System.out.print(solution(positions) ? "Valid" : "Invalid");
    }

    private static boolean solution(String[] positions) {
        Queue<Coordinate> positionQueue = Arrays.stream(positions)
                .map(KnightTour::convertToCoordinate)
                .collect(Collectors.toCollection(LinkedList::new));

        Set<Coordinate> visited = new HashSet<>();
        Coordinate start = positionQueue.poll();
        Coordinate current = start;

        while (!positionQueue.isEmpty()) {
            Coordinate next = positionQueue.poll();

            if (!isKnightMove(current, next)) {
                return false;
            }

            if (visited.contains(next)) {
                return false;
            }

            visited.add(next);
            current = next;
        }

        return isKnightMove(start, current);
    }

    private static boolean isKnightMove(Coordinate from, Coordinate to) {
        return Arrays.stream(KnightMove.values())
                .anyMatch(move -> from.x + move.dx == to.x && from.y + move.dy == to.y);
    }

    private static Coordinate convertToCoordinate(String position) {
        int x = position.charAt(0) - 'A';
        int y = position.charAt(1) - '1';

        return new Coordinate(x, y);
    }

    enum KnightMove {
        UP_LEFT(-2, -1),
        UP_RIGHT(-2, 1),
        DOWN_LEFT(2, -1),
        DOWN_RIGHT(2, 1),
        LEFT_UP(-1, -2),
        LEFT_DOWN(1, -2),
        RIGHT_UP(-1, 2),
        RIGHT_DOWN(1, 2);

        private final int dx;
        private final int dy;

        KnightMove(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
