/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17371
 * Cheat Level: 0
 * Algorithm: Greedy / Geometry
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moving {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Coordinate> coordinateList = new ArrayList<>();
        while (n-- > 0) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coordinateList.add(new Coordinate(coordinateInfo[0], coordinateInfo[1]));
        }
        Coordinate result = solution(coordinateList);
        System.out.println(result.x + " " + result.y);
    }

    private static Coordinate solution(List<Coordinate> coordinateList) {
        int index = -1;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < coordinateList.size(); i++) {
            double maxDistance = getMaxDistance(coordinateList, coordinateList.get(i), i);
            if (minDistance > maxDistance) {
                minDistance = maxDistance;
                index = i;
            }
        }

        return coordinateList.get(index);
    }

    private static double getMaxDistance(List<Coordinate> coordinateList, Coordinate coordinate, int skipIndex) {
        double maximumDistance = 0;

        for (int i = 0; i < coordinateList.size(); i++) {
            if (i == skipIndex) continue;
            maximumDistance = Math.max(maximumDistance, getEuclidDistance(coordinate, coordinateList.get(i)));
        }

        return maximumDistance;
    }

    private static double getEuclidDistance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
