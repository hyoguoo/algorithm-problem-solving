/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14732
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class EventVenueRentalSmall {

    private static final int MAX_COORDINATE = 500;
    private static final int GRID_SIZE = MAX_COORDINATE + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rectangleCount = Integer.parseInt(bufferedReader.readLine());
        Rectangle[] rectangles = new Rectangle[rectangleCount];

        for (int i = 0; i < rectangleCount; i++) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Coordinate bottomLeft = new Coordinate(coordinateInfo[0], coordinateInfo[1]);
            Coordinate topRight = new Coordinate(coordinateInfo[2], coordinateInfo[3]);
            rectangles[i] = new Rectangle(bottomLeft, topRight);
        }

        System.out.print(solution(rectangles));
    }

    private static long solution(Rectangle[] rectangles) {
        boolean[][] area = new boolean[GRID_SIZE][GRID_SIZE];

        Arrays.stream(rectangles)
                .forEach(rectangle -> rectangle.fill(area));

        return IntStream.rangeClosed(0, MAX_COORDINATE)
                .mapToLong(x -> IntStream.rangeClosed(0, MAX_COORDINATE)
                        .filter(y -> area[x][y])
                        .count())
                .sum();
    }

    static class Rectangle {

        private final Coordinate bottomLeft;
        private final Coordinate topRight;

        public Rectangle(Coordinate bottomLeft, Coordinate topRight) {
            this.bottomLeft = bottomLeft;
            this.topRight = topRight;
        }

        public void fill(boolean[][] area) {
            for (int x = bottomLeft.x; x < topRight.x; x++) {
                for (int y = bottomLeft.y; y < topRight.y; y++) {
                    area[x][y] = true;
                }
            }
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
