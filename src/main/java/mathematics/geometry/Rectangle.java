/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1485
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rectangle {

    final static int POINT_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int caseCount = Integer.parseInt(bufferedReader.readLine());
        for (int count = 0; count < caseCount; count++) {
            Point[] points = new Point[POINT_COUNT];
            for (int point = 0; point < POINT_COUNT; point++) {
                int[] pointInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                points[point] = new Point(pointInfo[0], pointInfo[1]);
            }
            stringBuilder.append(solution(points) ? 1 : 0).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static boolean solution(Point[] points) {
        Arrays.sort(points);
        double sideLength = getDistance(points[0], points[1]);
        double diagonalLength = getDistance(points[0], points[3]);
        return getDistance(points[0], points[1]) == sideLength
                && getDistance(points[2], points[3]) == sideLength
                && getDistance(points[0], points[2]) == sideLength
                && getDistance(points[1], points[3]) == sideLength
                && getDistance(points[1], points[2]) == diagonalLength
                && getDistance(points[3], points[0]) == diagonalLength;
    }

    private static double getDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.x == point.x) return this.y - point.y;
            return this.x - point.x;
        }
    }
}
