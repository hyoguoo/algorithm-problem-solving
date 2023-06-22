/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3053
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxiGeometry {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(bufferedReader.readLine());

        Circle circle = new Circle(R);
        System.out.printf("%.6f\n", circle.getEuclidean());
        System.out.printf("%.6f\n", circle.getTaxi());
    }

    static class Circle {
        double r;

        public Circle(int r) {
            this.r = r;
        }

        public double getEuclidean() {
            return Math.PI * Math.pow(r, 2);
        }

        public double getTaxi() {
            return 2 * Math.pow(r, 2);
        }
    }
}
