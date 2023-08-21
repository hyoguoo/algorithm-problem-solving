/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20149
 * Cheat Level: 4
 * Algorithm: Mathematics / Geometry / Counterclockwise
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class LineSegmentIntersection3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] lineAInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] lineBInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Coordinate c1 = new Coordinate(lineAInfo[0], lineAInfo[1]);
        Coordinate c2 = new Coordinate(lineAInfo[2], lineAInfo[3]);
        Coordinate c3 = new Coordinate(lineBInfo[0], lineBInfo[1]);
        Coordinate c4 = new Coordinate(lineBInfo[2], lineBInfo[3]);

        int intersect = isIntersect(c1, c2, c3, c4);
        if (intersect == 1
                || intersect == 2
                || intersect == 3) {
            System.out.println(1);
            printIntersection(c1, c2, c3, c4);
        } else if (intersect == 4) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /**
     * 두 선분이 교차하는지 확인
     *
     * @return 두 선분이 교차하지 않음: -1
     * 두 선분이 교차(한 점에서 만남): 1
     * 세 점이 일직선 상에 있고, 한 점이 다른 선분 위에 있음: 2
     * 두 선분이 일직선 상에 있고, 두 선분이 겹치지 않음: 3
     * 두 선분이 일직선 상에 있고, 두 선분이 겹침: 4
     */
    private static int isIntersect(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4) {
        int ccw123 = ccw(c1, c2, c3);
        int ccw124 = ccw(c1, c2, c4);
        int ccw341 = ccw(c3, c4, c1);
        int ccw342 = ccw(c3, c4, c2);
        int v12 = ccw123 * ccw124;
        int v34 = ccw341 * ccw342;

        if (v12 < 0 && v34 < 0) return 1;
        if ((v12 == 0 && v34 < 0) || (v12 < 0 && v34 == 0)) return 2;
        if (v12 == 0 && v34 == 0) {
            if (ccw123 == 0 && ccw124 == 0 && ccw341 == 0 && ccw342 == 0) {
                int cA, cB, cC, cD;
                if (c1.x == c2.x) {
                    cA = (int) Math.min(c1.y, c2.y);
                    cB = (int) Math.max(c1.y, c2.y);
                } else {
                    cA = (int) Math.min(c1.x, c2.x);
                    cB = (int) Math.max(c1.x, c2.x);
                }
                if (c3.x == c4.x) {
                    cC = (int) Math.min(c3.y, c4.y);
                    cD = (int) Math.max(c3.y, c4.y);
                } else {
                    cC = (int) Math.min(c3.x, c4.x);
                    cD = (int) Math.max(c3.x, c4.x);
                }

                if (cC < cB && cA < cD) return 4;
                if (cC == cB || cA == cD) return 3;
                return -1;
            }
            return 3;
        }

        return -1;
    }

    private static int ccw(Coordinate a, Coordinate b, Coordinate c) {
        double result = (a.x * b.y + b.x * c.y + c.x * a.y)
                - (a.x * c.y + c.x * b.y + b.x * a.y);

        if (result > 0) return 1;
        else if (result < 0) return -1;
        return 0;
    }

    private static void printIntersection(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4) {
        long v = (c1.x - c2.x) * (c3.y - c4.y) - (c1.y - c2.y) * (c3.x - c4.x);
        if (v == 0) {
            if (c1.equals(c3) || c1.equals(c4)) {
                System.out.println(c1.x + " " + c1.y);
                return;
            }
            if (c2.equals(c3) || c2.equals(c4)) {
                System.out.println(c2.x + " " + c2.y);
                return;
            }
        }
        double x = ((c1.x * c2.y - c1.y * c2.x) * (c3.x - c4.x) - (c1.x - c2.x) * (c3.x * c4.y - c3.y * c4.x))
                / (double) v;
        double y = ((c1.x * c2.y - c1.y * c2.x) * (c3.y - c4.y) - (c1.y - c2.y) * (c3.x * c4.y - c3.y * c4.x))
                / (double) v;

        System.out.println(x + " " + y);
    }

    static class Coordinate {
        private final long x;
        private final long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
