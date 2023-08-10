/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22938
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Marksman {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] circle1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] circle2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(circle1, circle2) ? "YES" : "NO");
    }

    private static boolean solution(int[] circle1, int[] circle2) {
        int x1 = circle1[0];
        int y1 = circle1[1];
        int r1 = circle1[2];
        int x2 = circle2[0];
        int y2 = circle2[1];
        int r2 = circle2[2];

        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return distance < r1 + r2;
    }
}
