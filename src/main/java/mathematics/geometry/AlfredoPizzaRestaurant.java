/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6502
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlfredoPizzaRestaurant {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int caseCount = 1;

        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (info[0] == 0) break;
            int radius = info[0];
            int width = info[1];
            int height = info[2];
            stringBuilder.append("Pizza ").append(caseCount).append(" ");
            if (isFit(radius, width, height)) stringBuilder.append("fits on the table.\n");
            else stringBuilder.append("does not fit on the table.\n");
            caseCount++;
        }

        System.out.println(stringBuilder);
    }

    private static boolean isFit(int radius, int width, int height) {
        return getDiagonal(width, height) <= radius * 2;
    }

    private static double getDiagonal(int width, int height) {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
