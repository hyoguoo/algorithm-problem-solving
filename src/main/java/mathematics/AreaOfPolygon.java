/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2166
 * Cheat Level: 4
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AreaOfPolygon {

    final static List<Coordinate> coordinateList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        init();
        System.out.printf("%.1f%n", getArea());
    }

    private static double getArea() {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            Coordinate current = coordinateList.get(i);
            Coordinate next = coordinateList.get((i + 1) % N);
            sum += ((long) current.x * next.y) - ((long) current.y * next.x);
        }

        return Math.abs(sum) / 2.0;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            coordinateList.add(new Coordinate(x, y));
        }
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
