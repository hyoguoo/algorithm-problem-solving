/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17247
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaxiDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int M = info[1];
        Coordinate a = null;
        Coordinate b = null;
        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < M; m++) {
                if (input[m] == 1) {
                    if (a == null) a = new Coordinate(n, m);
                    else b = new Coordinate(n, m);
                }
            }
        }

        System.out.println(getTaxiDistance(a, b));
    }

    private static int getTaxiDistance(Coordinate a, Coordinate b) {
        return Math.abs(b.n - a.n) + Math.abs(b.m - a.m);
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
