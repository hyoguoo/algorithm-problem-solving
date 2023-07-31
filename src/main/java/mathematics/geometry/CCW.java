/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11758
 * Cheat Level: 3
 * Algorithm: Mathematics / Geometry / Counterclockwise
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CCW {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            int[] pointInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            points[i] = new Point(pointInfo[0], pointInfo[1]);
        }

        System.out.println(getCCW(points[0], points[1], points[2]));
    }

    private static int getCCW(Point A, Point B, Point C) {
        int result = (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);

        return Integer.compare(result, 0);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
