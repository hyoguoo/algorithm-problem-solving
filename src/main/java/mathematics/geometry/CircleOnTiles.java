/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1709
 * Cheat Level: 3
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircleOnTiles {

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(solution(N));
    }

    private static long solution(long N) {
        long radius = N / 2;
        long x = 0;
        long y = radius - 1;
        long R = radius * radius;
        long count = 0;

        while (x <= radius && y >= 0) {
            long dist = (x + 1) * (x + 1) + y * y;
            if (dist <= R) x++;
            if (dist >= R) y--;
            count++;
        }

        return count * 4;
    }
}
