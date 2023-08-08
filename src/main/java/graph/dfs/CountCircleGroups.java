/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10216
 * Cheat Level: 0
 * Algorithm: Graph / DFS / Geometry
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountCircleGroups {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        while (testCount-- > 0) {
            int groupCount = Integer.parseInt(bufferedReader.readLine());

            List<Point> pointList = new ArrayList<>();
            for (int i = 0; i < groupCount; i++) {
                int[] pointInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                pointList.add(new Point(pointInfo[0], pointInfo[1], pointInfo[2]));
            }

            System.out.println(solution(pointList));
        }
    }

    private static int solution(List<Point> pointList) {
        int count = 0;
        boolean[] visited = new boolean[pointList.size()];

        for (int i = 0; i < pointList.size(); i++) {
            if (visited[i]) continue;
            dfs(pointList, visited, i);
            count++;
        }

        return count;
    }

    private static void dfs(List<Point> pointList, boolean[] visited, int index) {
        visited[index] = true;
        Point currentPoint = pointList.get(index);

        for (int i = 0; i < pointList.size(); i++) {
            if (visited[i]) continue;
            Point nextPoint = pointList.get(i);
            if (isConnected(currentPoint, nextPoint)) dfs(pointList, visited, i);
        }
    }

    private static boolean isConnected(Point currentPoint, Point nextPoint) {
        int distance = (int) (Math.pow(currentPoint.x - nextPoint.x, 2) + Math.pow(currentPoint.y - nextPoint.y, 2));
        int radiusSum = (int) Math.pow(currentPoint.r + nextPoint.r, 2);
        return distance <= radiusSum;
    }

    static class Point {
        int x;
        int y;
        int r;

        public Point(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
