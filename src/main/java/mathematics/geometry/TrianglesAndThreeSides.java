/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5073
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrianglesAndThreeSides {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] triangleInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (triangleInfo[0] == 0 && triangleInfo[1] == 0 && triangleInfo[2] == 0) break;
            System.out.println(getTriangleType(triangleInfo[0], triangleInfo[1], triangleInfo[2]));
        }
    }

    private static String getTriangleType(int x, int y, int z) {
        if (x == y && y == z) return "Equilateral";
        else if (x + y <= z || y + z <= x || z + x <= y) return "Invalid";
        else if (x == y || y == z || z == x) return "Isosceles";
        else return "Scalene";
    }
}
