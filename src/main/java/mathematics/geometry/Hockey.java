/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10569
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hockey {

    final static List<Coordinate> COORDINATE_LIST = new ArrayList<>();
    static double WIDTH, HEIGHT, X, Y, RADIUS;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        double leftCircleX = X;
        double leftCircleY = Y + RADIUS;
        double rightCircleX = X + WIDTH;
        double rightCircleY = Y + RADIUS;

        int count = 0;
        for (Coordinate coordinate : COORDINATE_LIST) {
            if (isInside(coordinate, leftCircleX, leftCircleY, rightCircleX, rightCircleY)) count++;
        }

        return count;
    }

    private static boolean isInside(Coordinate coordinate, double leftCircleX, double leftCircleY, double rightCircleX, double rightCircleY) {
        return isInCircle(leftCircleX, leftCircleY, coordinate.x, coordinate.y)
                || isInCircle(rightCircleX, rightCircleY, coordinate.x, coordinate.y)
                || isInRectangle(coordinate.x, coordinate.y);
    }

    private static boolean isInRectangle(double x, double y) {
        return x >= X && x <= X + WIDTH && y >= Y && y <= Y + HEIGHT;
    }

    private static boolean isInCircle(double circleX, double circleY, double x, double y) {
        return Math.pow(x - circleX, 2) + Math.pow(y - circleY, 2) <= Math.pow(RADIUS, 2);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        WIDTH = info[0];
        HEIGHT = info[1];
        RADIUS = HEIGHT / 2;
        X = info[2];
        Y = info[3];
        int coordinateCount = info[4];
        for (int i = 0; i < coordinateCount; i++) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            COORDINATE_LIST.add(new Coordinate(coordinateInfo[0], coordinateInfo[1]));
        }
    }

    static class Coordinate {
        double x;
        double y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
