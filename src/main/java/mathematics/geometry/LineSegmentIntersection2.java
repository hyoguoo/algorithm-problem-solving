/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17387
 * Cheat Level: 4
 * Algorithm: Mathematics / Geometry / Counterclockwise
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LineSegmentIntersection2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] lineAInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] lineBInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Point p1 = new Point(lineAInfo[0], lineAInfo[1]);
        Point p2 = new Point(lineAInfo[2], lineAInfo[3]);
        Point p3 = new Point(lineBInfo[0], lineBInfo[1]);
        Point p4 = new Point(lineBInfo[2], lineBInfo[3]);

        System.out.println(isIntersect(p1, p2, p3, p4) ? 1 : 0);
    }

    private static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccwA = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int ccwB = ccw(p3, p4, p1) * ccw(p3, p4, p2);

        if (ccwA == 0 && ccwB == 0) {
            return Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) && Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
                    Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) && Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y);
        }

        return ccwA <= 0 && ccwB <= 0;
    }

    private static int ccw(Point a, Point b, Point c) {
        long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.x * c.y + c.x * b.y + b.x * a.y);

        if (result > 0) return 1;
        else if (result < 0) return -1;
        return 0;
    }

    static class Point {
        private final long x;
        private final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
