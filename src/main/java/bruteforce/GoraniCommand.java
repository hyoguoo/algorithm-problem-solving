/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27445
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoraniCommand {

    final static List<Point> points = new ArrayList<>();
    final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];

        for (int i = 1; i <= N; i++) {
            if (i != N) {
                int distance = Integer.parseInt(bufferedReader.readLine());
                points.add(new Point(i, 1, distance));
            } else {
                int[] distances = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 1; j <= M; j++) {
                    points.add(new Point(i, j, distances[j - 1]));
                }
            }
        }

        findTarget();
    }

    private static void findTarget() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (isTarget(i, j)) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    private static boolean isTarget(int i, int j) {
        for (Point point : points) {
            int pointDistance = getManhattanDistance(point.i, point.j, i, j);
            if (pointDistance != point.distance) return false;
        }
        return true;
    }

    private static int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Point {
        int i;
        int j;
        int distance;

        public Point(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
}
