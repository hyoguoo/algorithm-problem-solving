/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2987
 * Cheat Level: 3
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] coordinateAInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coordinateBInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coordinateCInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Coordinate coordinateA = new Coordinate(coordinateAInfo[0], coordinateAInfo[1]);
        Coordinate coordinateB = new Coordinate(coordinateBInfo[0], coordinateBInfo[1]);
        Coordinate coordinateC = new Coordinate(coordinateCInfo[0], coordinateCInfo[1]);
        Triangle triangle = new Triangle(coordinateA, coordinateB, coordinateC);
        int coordinateCount = Integer.parseInt(bufferedReader.readLine());
        List<Coordinate> coordinateList = new ArrayList<>();
        while (coordinateCount-- > 0) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coordinateList.add(new Coordinate(coordinateInfo[0], coordinateInfo[1]));
        }

        solution(triangle, coordinateList);
    }

    private static void solution(Triangle triangle, List<Coordinate> coordinateList) {
        System.out.println(getTriangleArea(triangle.coordinateA, triangle.coordinateB, triangle.coordinateC));
        System.out.println(getInsideCount(triangle, coordinateList));
    }

    private static long getInsideCount(Triangle triangle, List<Coordinate> coordinateList) {
        return coordinateList.stream()
                .filter(coordinate -> isInside(triangle, coordinate))
                .count();
    }

    /**
     * 주어진 점이 삼각형 내부에 있다면, 그 점을 이용하여 만들어지는 세 개의 부분 삼각형의 넓이의 합이 원래 삼각형의 넓이와 같아야 함
     */
    private static boolean isInside(Triangle triangle, Coordinate coordinate) {
        Coordinate coordinateA = triangle.coordinateA;
        Coordinate coordinateB = triangle.coordinateB;
        Coordinate coordinateC = triangle.coordinateC;

        double triangleArea = getTriangleArea(coordinateA, coordinateB, coordinateC);
        double triangleArea1 = getTriangleArea(coordinateA, coordinateB, coordinate);
        double triangleArea2 = getTriangleArea(coordinateB, coordinateC, coordinate);
        double triangleArea3 = getTriangleArea(coordinateC, coordinateA, coordinate);
        return triangleArea == triangleArea1 + triangleArea2 + triangleArea3;
    }

    private static double getTriangleArea(Coordinate coordinateA, Coordinate coordinateB, Coordinate coordinateC) {
        return Math.abs(
                (coordinateA.x * (coordinateB.y - coordinateC.y)
                        + coordinateB.x * (coordinateC.y - coordinateA.y)
                        + coordinateC.x * (coordinateA.y - coordinateB.y))
                        / 2);
    }

    static class Triangle {
        Coordinate coordinateA;
        Coordinate coordinateB;
        Coordinate coordinateC;

        public Triangle(Coordinate coordinateA, Coordinate coordinateB, Coordinate coordinateC) {
            this.coordinateA = coordinateA;
            this.coordinateB = coordinateB;
            this.coordinateC = coordinateC;
        }
    }

    static class Coordinate {
        double x;
        double y;

        Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
