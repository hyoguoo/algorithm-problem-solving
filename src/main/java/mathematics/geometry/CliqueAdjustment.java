/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33884
 * Cheat Level: 0
 * Algorithm: Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CliqueAdjustment {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int bulletCount = Integer.parseInt(bufferedReader.readLine());
        Coordinate[] round1 = new Coordinate[bulletCount];
        Coordinate[] round2 = new Coordinate[bulletCount];

        for (int i = 0; i < bulletCount; i++) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            round1[i] = new Coordinate(coordinateInfo[0], coordinateInfo[1]);
        }

        for (int i = 0; i < bulletCount; i++) {
            int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            round2[i] = new Coordinate(coordinateInfo[0], coordinateInfo[1]);
        }

        System.out.print(solution(round1, round2));
    }

    private static Coordinate solution(Coordinate[] round1, Coordinate[] round2) {
        Coordinate round1Center = calculateCenter(round1);
        Coordinate round2Center = calculateCenter(round2);
        return new Coordinate(
                round1Center.x + round2Center.x - round1Center.x,
                round1Center.y + round2Center.y - round1Center.y
        );
    }

    private static Coordinate calculateCenter(Coordinate[] coordinates) {
        return new Coordinate(
                (int) Arrays.stream(coordinates).mapToLong(coordinate -> coordinate.x).average().orElse(0),
                (int) Arrays.stream(coordinates).mapToLong(coordinate -> coordinate.y).average().orElse(0)
        );
    }


    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
