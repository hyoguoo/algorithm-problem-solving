/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10157
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AssigningSeat {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = info[1];
        int m = info[0];
        int sequence = Integer.parseInt(bufferedReader.readLine());

        Coordinate result = solution(n, m, sequence);
        System.out.print(result == null ? 0 : result);
    }

    private static Coordinate solution(int sizeN, int sizeM, int sequence) {
        if (sequence > sizeN * sizeM) {
            return null;
        }

        Coordinate coordinate = new Coordinate(0, 0);
        Seat seat = new Seat(sizeN, sizeM);
        int currentSequence = 1;

        seat.assignSeat(coordinate);

        while (currentSequence != sequence) {
            coordinate.getNext(seat);
            currentSequence++;
        }

        return coordinate;
    }

    enum Direction {
        UP(-1, 0),
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Direction getNext() {
            switch (this) {
                case DOWN:
                    return RIGHT;
                case RIGHT:
                    return UP;
                case LEFT:
                    return DOWN;
                case UP:
                    return LEFT;
            }
            throw new IllegalArgumentException();
        }
    }

    static class Coordinate {

        private int n;
        private int m;
        private Direction direction;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
            this.direction = Direction.DOWN;
        }

        public void getNext(Seat seats) {
            this.n += this.direction.n;
            this.m += this.direction.m;

            if (seats.isUnAvailable(this)) {
                this.n -= this.direction.n;
                this.m -= this.direction.m;
                this.direction = this.direction.getNext();
                this.n += this.direction.n;
                this.m += this.direction.m;
            }
            seats.assignSeat(this);
        }

        @Override
        public String toString() {
            return (this.m + 1) + " " + (this.n + 1);
        }
    }

    static class Seat {

        private final boolean[][] seats;

        public Seat(int n, int m) {
            this.seats = new boolean[n][m];
        }

        public void assignSeat(Coordinate coordinate) {
            if (isUnAvailable(coordinate)) {
                throw new IllegalArgumentException();
            }
            seats[coordinate.n][coordinate.m] = true;
        }

        public boolean isUnAvailable(Coordinate coordinate) {
            return !isInBound(coordinate) || seats[coordinate.n][coordinate.m];
        }

        private boolean isInBound(Coordinate coordinate) {
            return 0 <= coordinate.n && coordinate.n < seats.length &&
                    0 <= coordinate.m && coordinate.m < seats[0].length;
        }
    }
}
