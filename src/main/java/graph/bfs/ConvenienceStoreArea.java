/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31849
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ConvenienceStoreArea {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeN = info[0];
        int sizeM = info[1];
        int houseCount = info[2];
        int convenienceStoreCount = info[3];

        List<House> houseList = new ArrayList<>();

        MapObject[][] map = new MapObject[sizeN][sizeM];
        for (int n = 0; n < sizeN; n++) {
            for (int m = 0; m < sizeM; m++) {
                map[n][m] = MapObject.EMPTY;
            }
        }

        for (int i = 0; i < houseCount; i++) {
            int[] houseInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = houseInfo[0] - 1;
            int m = houseInfo[1] - 1;
            int rent = houseInfo[2];
            map[n][m] = MapObject.HOUSE;
            houseList.add(new House(new Coordinate(n, m), rent));
        }

        Queue<Coordinate> convenienceStoreQueue = new ArrayDeque<>();
        for (int i = 0; i < convenienceStoreCount; i++) {
            int[] convenienceStoreInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = convenienceStoreInfo[0] - 1;
            int m = convenienceStoreInfo[1] - 1;
            map[n][m] = MapObject.CONVENIENCE_STORE;
            convenienceStoreQueue.add(new Coordinate(n, m));
        }

        System.out.print(solution(convenienceStoreQueue, map, houseList));
    }

    private static int solution(
            Queue<Coordinate> convenienceStoreQueue,
            MapObject[][] map,
            List<House> houseList
    ) {
        int[][] minDistances = bfs(convenienceStoreQueue, map);

        return getMinConvenienceScore(houseList, minDistances);
    }

    private static int[][] bfs(Queue<Coordinate> convenienceStoreQueue, MapObject[][] map) {
        int[][] minDistances = new int[map.length][map[0].length];
        for (int[] row : minDistances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        boolean[][] visited = new boolean[map.length][map[0].length];
        for (Coordinate convenienceStore : convenienceStoreQueue) {
            minDistances[convenienceStore.n][convenienceStore.m] = 0;
            visited[convenienceStore.n][convenienceStore.m] = true;
        }

        while (!convenienceStoreQueue.isEmpty()) {
            Coordinate current = convenienceStoreQueue.poll();

            for (Direction direction : Direction.values()) {
                Coordinate next = current.move(direction);
                if (isInBound(map, next) && !visited[next.n][next.m]) {
                    visited[next.n][next.m] = true;
                    minDistances[next.n][next.m] = minDistances[current.n][current.m] + 1;
                    convenienceStoreQueue.add(next);
                }
            }
        }

        return minDistances;
    }

    private static int getMinConvenienceScore(List<House> houseList, int[][] minDistances) {
        int minConvenienceScore = Integer.MAX_VALUE;

        for (House house : houseList) {
            int distance = minDistances[house.coordinate.n][house.coordinate.m];
            minConvenienceScore = Math.min(
                    minConvenienceScore,
                    house.calculateConvenienceScore(distance)
            );
        }

        return minConvenienceScore;
    }

    private static boolean isInBound(MapObject[][] map, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < map.length &&
                0 <= coordinate.m && coordinate.m < map[0].length;
    }

    enum MapObject {
        HOUSE, CONVENIENCE_STORE, EMPTY
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class House {

        private final Coordinate coordinate;
        private final int rent;

        public House(Coordinate coordinate, int rent) {
            this.coordinate = coordinate;
            this.rent = rent;
        }

        public int calculateConvenienceScore(int distance) {
            return rent * distance;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate move(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }
    }
}
