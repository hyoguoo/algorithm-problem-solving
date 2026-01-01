/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15722
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpinningSnail {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int moveCount = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(moveCount));
    }

    static Coordinate solution(int moveCount) {
        if (moveCount == 0) {
            return new Coordinate(0, 0);
        }
        Snail snail = new Snail();
        return snail.move(moveCount);
    }

    enum Direction {
        UP(0, 1),
        RIGHT(1, 0),
        DOWN(0, -1),
        LEFT(-1, 0);

        private final int deltaX;
        private final int deltaY;

        Direction(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public static Direction byOrder(int order) {
            return values()[order % values().length];
        }
    }

    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate move(Direction direction) {
            return new Coordinate(this.x + direction.deltaX, this.y + direction.deltaY);
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    static class Snail {

        private Coordinate position = new Coordinate(0, 0);
        private int directionIndex = 0;
        private int length = 1;
        private int repeat = 0;
        private int moved = 0;

        public Coordinate move(int moveCount) {
            while (moved < moveCount) {
                Direction direction = Direction.byOrder(directionIndex);

                for (int i = 0; i < length && moved < moveCount; i++) {
                    position = position.move(direction);
                    moved++;
                }

                directionIndex++;
                repeat++;

                if (repeat == 2) {
                    repeat = 0;
                    length++;
                }
            }
            return position;
        }
    }
}
