/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30891
 * Cheat Level: 0
 * Algorithm: Bruteforce / Geometry
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ProtectingFriedRice {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int riceCount = info[0];
        int radius = info[1];

        Point[] ricePoints = new Point[riceCount];
        for (int i = 0; i < riceCount; i++) {
            int[] pointInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ricePoints[i] = new Point(pointInfo[0], pointInfo[1]);
        }

        System.out.print(solution(ricePoints, radius));
    }

    private static Point solution(Point[] ricePoints, int radius) {
        return IntStream.rangeClosed(-100, 100)
                .boxed()
                .flatMap(x -> IntStream.rangeClosed(-100, 100).mapToObj(y -> new Point(x, y)))
                .max(
                        (p1, p2) ->
                                Long.compare(
                                        Arrays.stream(ricePoints)
                                                .filter(ricePoint -> isInCircle(ricePoint, p1, radius))
                                                .count(),
                                        Arrays.stream(ricePoints)
                                                .filter(ricePoint -> isInCircle(ricePoint, p2, radius))
                                                .count()
                                )
                )
                .orElseThrow();
    }

    private static boolean isInCircle(Point ricePoint, Point center, int radius) {
        return Math.pow((double) ricePoint.x - center.x, 2) + Math.pow((double) ricePoint.y - center.y, 2) <= Math.pow(radius, 2);
    }

    static class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
