/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25558
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Navigation {

    public static void main(String[] args) throws IOException {
        NavigationSystem[] navigationSystems = parseNavigationSystems();

        System.out.print(solution(navigationSystems));
    }

    private static int solution(NavigationSystem[] navigationSystems) {
        int minimumIndex = -1;
        long minimumDistance = Long.MAX_VALUE;

        for (int i = 0; i < navigationSystems.length; i++) {
            long totalDistance = navigationSystems[i].calculateTotalDistance();
            if (totalDistance < minimumDistance) {
                minimumDistance = totalDistance;
                minimumIndex = i;
            }
        }

        return minimumIndex + 1;
    }

    private static NavigationSystem[] parseNavigationSystems() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int navigationCount = Integer.parseInt(bufferedReader.readLine());
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Coordinate start = new Coordinate(info[0], info[1]);
        Coordinate end = new Coordinate(info[2], info[3]);
        NavigationSystem[] navigationSystems = new NavigationSystem[navigationCount];

        for (int i = 0; i < navigationCount; i++) {
            navigationSystems[i] = new NavigationSystem(start, end);

            int waypointCount = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < waypointCount; j++) {
                int[] waypointInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                navigationSystems[i].addWaypoint(new Coordinate(waypointInfo[0], waypointInfo[1]));
            }
        }

        return navigationSystems;
    }

    static class NavigationSystem {

        private final Coordinate start;
        private final List<Coordinate> waypoints;
        private final Coordinate end;

        public NavigationSystem(Coordinate start, Coordinate end) {
            this.start = start;
            this.end = end;
            this.waypoints = new ArrayList<>();
        }

        public void addWaypoint(Coordinate waypoint) {
            this.waypoints.add(waypoint);
        }

        public long calculateTotalDistance() {
            long totalDistance = 0;
            Coordinate current = this.start;

            for (Coordinate waypoint : this.waypoints) {
                totalDistance += current.calculateManhattanDistance(waypoint);
                current = waypoint;
            }

            totalDistance += current.calculateManhattanDistance(this.end);

            return totalDistance;
        }
    }

    static class Coordinate {

        private final long x;
        private final long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long calculateManhattanDistance(Coordinate coordinate) {
            return Math.abs(this.x - coordinate.x) + Math.abs(this.y - coordinate.y);
        }
    }
}
