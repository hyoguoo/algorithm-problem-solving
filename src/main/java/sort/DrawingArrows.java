/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15970
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawingArrows {

    private static final int NOT_EXIST = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int pointCount = Integer.parseInt(bufferedReader.readLine());

        Point[] points = new Point[pointCount];

        for (int i = 0; i < pointCount; i++) {
            int[] pointInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            points[i] = new Point(pointInfo[0], pointInfo[1]);
        }

        System.out.print(solution(points));
    }

    private static int solution(Point[] points) {
        Arrays.sort(points, (a, b) -> {
            if (a.x == b.x) {
                return a.color - b.color;
            }
            return a.x - b.x;
        });

        Map<Integer, List<Integer>> colorIndexMap = populateColorIndexMap(points);

        int totalDistanceSum = 0;
        for (List<Integer> indexList : colorIndexMap.values()) {
            totalDistanceSum += calculateDistanceSum(indexList);
        }

        return totalDistanceSum;
    }

    private static Map<Integer, List<Integer>> populateColorIndexMap(
            Point[] points
    ) {
        Map<Integer, List<Integer>> colorIndexMap = new HashMap<>();

        for (Point point : points) {
            colorIndexMap.computeIfAbsent(point.color, k -> new ArrayList<>()).add(point.x);
        }

        return colorIndexMap;
    }

    private static int calculateDistanceSum(List<Integer> indexList) {
        int sum = 0;

        for (int i = 0; i < indexList.size(); i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;

            int leftDistance = NOT_EXIST;
            int rightDistance = NOT_EXIST;

            if (leftIndex >= 0) {
                leftDistance = Math.abs(indexList.get(i) - indexList.get(leftIndex));
            }

            if (rightIndex < indexList.size()) {
                rightDistance = Math.abs(indexList.get(i) - indexList.get(rightIndex));
            }

            if (leftDistance != NOT_EXIST && rightDistance != NOT_EXIST) {
                sum += Math.min(leftDistance, rightDistance);
            } else if (leftDistance != NOT_EXIST) {
                sum += leftDistance;
            } else if (rightDistance != NOT_EXIST) {
                sum += rightDistance;
            }
        }

        return sum;
    }

    static class Point {

        private final int x;
        private final int color;

        public Point(int x, int color) {
            this.x = x;
            this.color = color;
        }
    }
}
