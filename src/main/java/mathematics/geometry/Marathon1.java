/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10655
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry / Brute Force
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marathon1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] pointInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrayList.add(new Point(pointInfo[0], pointInfo[1]));
        }

        System.out.println(solution(arrayList));
    }

    private static int solution(List<Point> pointList) {
        int maxDiff = 0;
        int maxDiffIndex = 0;

        for (int i = 1; i < pointList.size() - 1; i++) {
            int distance = getManhattanDistance(pointList.get(i - 1), pointList.get(i)) + getManhattanDistance(pointList.get(i), pointList.get(i + 1));
            int skippedDistance = getManhattanDistance(pointList.get(i - 1), pointList.get(i + 1));

            if (maxDiff < distance - skippedDistance) {
                maxDiff = distance - skippedDistance;
                maxDiffIndex = i;
            }
        }

        pointList.remove(maxDiffIndex);

        int totalDistance = 0;
        for (int i = 1; i < pointList.size(); i++) {
            totalDistance += getManhattanDistance(pointList.get(i - 1), pointList.get(i));
        }

        return totalDistance;
    }

    private static int getManhattanDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
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
