/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1004
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LittlePrince {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < caseCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Coordinate start = new Coordinate(info[0], info[1]);
            Coordinate end = new Coordinate(info[2], info[3]);
            int planetCount = Integer.parseInt(bufferedReader.readLine());
            List<Planet> planetList = new ArrayList<>();
            for (int j = 0; j < planetCount; j++) {
                int[] planetInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                planetList.add(new Planet(new Coordinate(planetInfo[0], planetInfo[1]), planetInfo[2]));
            }
            System.out.println(solution(start, end, planetList));
        }
    }

    private static int solution(Coordinate start, Coordinate end, List<Planet> planetList) {
        int count = 0;

        for (Planet planet : planetList) {
            boolean startInPlanet = isInPlanet(start, planet);
            boolean endInPlanet = isInPlanet(end, planet);
            if ((startInPlanet && !endInPlanet) || (!startInPlanet && endInPlanet)) count++;
        }

        return count;
    }

    private static boolean isInPlanet(Coordinate start, Planet planet) {
        return Math.pow(start.x - planet.center.x, 2) + Math.pow(start.y - planet.center.y, 2) < Math.pow(planet.radius, 2);
    }

    static class Planet {
        Coordinate center;
        int radius;

        public Planet(Coordinate center, int radius) {
            this.center = center;
            this.radius = radius;
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
