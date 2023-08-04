/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7869
 * Cheat Level: 3
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoCircles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        System.out.printf("%.3f", solution(info[0], info[1], info[2], info[3], info[4], info[5]));
    }

    private static double solution(double x1, double y1, double r1, double x2, double y2, double r2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (distance >= r1 + r2) return 0;
        else if (distance <= Math.abs(r1 - r2)) {
            double min = Math.min(r1, r2);
            return Math.PI * Math.pow(min, 2);
        } else {
            double theta1 = Math.acos((Math.pow(r1, 2) + Math.pow(distance, 2) - Math.pow(r2, 2)) / (2 * r1 * distance));
            double theta2 = Math.acos((Math.pow(r2, 2) + Math.pow(distance, 2) - Math.pow(r1, 2)) / (2 * r2 * distance));
            double area1 = Math.pow(r1, 2) * theta1 - Math.pow(r1, 2) * Math.sin(2 * theta1) / 2;
            double area2 = Math.pow(r2, 2) * theta2 - Math.pow(r2, 2) * Math.sin(2 * theta2) / 2;
            return area1 + area2;
        }
    }
}
