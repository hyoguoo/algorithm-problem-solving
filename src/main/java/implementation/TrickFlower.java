/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30648
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TrickFlower {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int initialX = info[0];
        int initialY = info[1];
        int gardenSize = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(new InputData(initialX, initialY, gardenSize)));
    }

    private static int solution(InputData inputData) {
        Set<Coordinate> bloomedCoordinates = new HashSet<>();
        Coordinate currentCoordinate = new Coordinate(inputData.getInitialX(), inputData.getInitialY());
        bloomedCoordinates.add(currentCoordinate);

        int time = 0;
        while (true) {
            time++;
            currentCoordinate = currentCoordinate.calculateNext(inputData.getGardenSize());
            if (bloomedCoordinates.contains(currentCoordinate)) {
                return time;
            }
            bloomedCoordinates.add(currentCoordinate);
        }
    }

    enum BloomingRule {
        GROW, RESET;

        public static BloomingRule getRule(Coordinate current, int gardenSize) {
            if ((current.getX() + 1) + (current.getY() + 1) < gardenSize) {
                return GROW;
            }
            return RESET;
        }
    }

    static class InputData {

        private final int initialX;
        private final int initialY;
        private final int gardenSize;

        public InputData(int initialX, int initialY, int gardenSize) {
            this.initialX = initialX;
            this.initialY = initialY;
            this.gardenSize = gardenSize;
        }

        public int getInitialX() {
            return initialX;
        }

        public int getInitialY() {
            return initialY;
        }

        public int getGardenSize() {
            return gardenSize;
        }
    }

    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Coordinate calculateNext(int gardenSize) {
            BloomingRule rule = BloomingRule.getRule(this, gardenSize);

            if (rule == BloomingRule.GROW) {
                return new Coordinate(x + 1, y + 1);
            } else {
                return new Coordinate(x / 2, y / 2);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
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
