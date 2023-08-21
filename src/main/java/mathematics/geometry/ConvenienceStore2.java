/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14400
 * Cheat Level: 2
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvenienceStore2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int customerCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Coordinate> coordinateList = new ArrayList<>();
        while (customerCount-- > 0) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coordinateList.add(new Coordinate(coordinateInfo[0], coordinateInfo[1]));
        }

        System.out.println(solution(coordinateList));
    }

    private static long solution(List<Coordinate> coordinateList) {
        return getSumDistance(coordinateList,
                getMedian(coordinateList.stream()
                        .mapToInt(coordinate -> coordinate.x)
                        .toArray()),
                getMedian(coordinateList.stream()
                        .mapToInt(coordinate1 -> coordinate1.y)
                        .toArray()));
    }

    private static int getMedian(int[] values) {
        Arrays.sort(values);
        return values[values.length / 2];
    }

    private static long getSumDistance(List<Coordinate> coordinateList, int meanX, int meanY) {
        Coordinate meanCoordinate = new Coordinate(meanX, meanY);
        return coordinateList.stream()
                .mapToLong(coordinate ->
                        getManhattanDistance(meanCoordinate, coordinate))
                .sum();
    }

    private static int getManhattanDistance(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
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
