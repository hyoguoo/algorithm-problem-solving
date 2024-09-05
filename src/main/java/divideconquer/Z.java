/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1074
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Z {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point point = new Point(info[1], info[2]);

        System.out.print(solution(point, info[0]));
    }

    private static int solution(Point point, int exponent) {
        int matrixSize = (int) Math.pow(2, exponent);

        return recursive(point, matrixSize, 0);
    }

    private static int recursive(Point currentPoint, int matrixSize, int accumulatedValue) {
        if (matrixSize == 1) {
            return accumulatedValue;
        }

        int halfSize = matrixSize / 2;
        int quadrant = calculateQuadrant(currentPoint, halfSize);

        int cellsInQuadrant = (int) Math.pow(halfSize, 2);
        int quadrantValue = cellsInQuadrant * quadrant;

        return recursive(
                currentPoint.nextPoint(quadrant, halfSize),
                halfSize,
                accumulatedValue + quadrantValue
        );
    }

    private static int calculateQuadrant(Point point, int halfSize) {
        int rowQuadrant = (point.n >= halfSize) ? 2 : 0;
        int colQuadrant = (point.m >= halfSize) ? 1 : 0;

        return rowQuadrant + colQuadrant;
    }

    static class Point {

        private final int n;
        private final int m;

        public Point(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Point nextPoint(int quadrant, int halfSize) {
            switch (quadrant) {
                case 0:
                    return new Point(n, m);
                case 1:
                    return new Point(n, m - halfSize);
                case 2:
                    return new Point(n - halfSize, m);
                case 3:
                    return new Point(n - halfSize, m - halfSize);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
