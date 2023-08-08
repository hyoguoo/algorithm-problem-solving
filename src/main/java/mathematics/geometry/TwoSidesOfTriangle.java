/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6322
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSidesOfTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int caseCount = 1;

        while (true) {
            int[] triangleInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (triangleInfo[0] == 0) break;
            int a = triangleInfo[0];
            int b = triangleInfo[1];
            int c = triangleInfo[2];

            stringBuilder.append("Triangle #").append(caseCount).append("\n");
            if (a == -1) {
                if (c * c - b * b <= 0) stringBuilder.append("Impossible.\n");
                else stringBuilder.append("a = ").append(String.format("%.3f", Math.sqrt(c * c - b * b))).append("\n");
            } else if (b == -1) {
                if (c * c - a * a <= 0) stringBuilder.append("Impossible.\n");
                else stringBuilder.append("b = ").append(String.format("%.3f", Math.sqrt(c * c - a * a))).append("\n");
            } else {
                stringBuilder.append("c = ").append(String.format("%.3f", Math.sqrt(a * a + b * b))).append("\n");
            }
            stringBuilder.append("\n");
            caseCount++;
        }

        System.out.println(stringBuilder);
    }
}
