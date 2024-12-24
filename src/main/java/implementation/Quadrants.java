/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9610
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;

public class Quadrants {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int pointCount = Integer.parseInt(bufferedReader.readLine());

        Point[] points = new Point[pointCount];

        for (int i = 0; i < pointCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            points[i] = new Point(info[0], info[1]);
        }

        System.out.print(solution(points));
    }

    private static String solution(Point[] points) {
        EnumMap<Quadrant, Integer> quadrantCount = new EnumMap<>(Quadrant.class);

        Arrays.stream(points)
                .map(Point::getQuadrant)
                .forEach(quadrant -> quadrantCount.put(quadrant, quadrantCount.getOrDefault(quadrant, 0) + 1));

        return getFormattedResult(quadrantCount);
    }

    private static String getFormattedResult(EnumMap<Quadrant, Integer> quadrantCount) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Quadrant quadrant : Quadrant.values()) {
            stringBuilder.append(quadrant.name)
                    .append(": ")
                    .append(quadrantCount.getOrDefault(quadrant, 0))
                    .append("\n");
        }

        return stringBuilder.toString().trim();
    }

    enum Quadrant {
        FIRST("Q1"),
        SECOND("Q2"),
        THIRD("Q3"),
        FOURTH("Q4"),
        AXIS("AXIS");

        private final String name;

        Quadrant(String name) {
            this.name = name;
        }
    }

    static class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Quadrant getQuadrant() {
            if (x > 0 && y > 0) {
                return Quadrant.FIRST;
            } else if (x < 0 && y > 0) {
                return Quadrant.SECOND;
            } else if (x < 0 && y < 0) {
                return Quadrant.THIRD;
            } else if (x > 0 && y < 0) {
                return Quadrant.FOURTH;
            } else {
                return Quadrant.AXIS;
            }
        }
    }
}
