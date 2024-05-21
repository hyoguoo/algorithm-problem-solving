/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17129
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WhyOnInformationIsland {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseMap()));
    }

    private static String solution(Map map) {
        return map.simulation();
    }

    private static Map parseMap() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        char[][] mapValues = new char[sizeN][sizeM];

        for (int n = 0; n < sizeN; n++) {
            mapValues[n] = bufferedReader.readLine().toCharArray();
        }

        return new Map(mapValues);
    }

    enum MapObject {
        EMPTY('0'),
        WALL('1'),
        FAMILY('2'),
        FOOD('3');

        private final int value;

        MapObject(int value) {
            this.value = value;
        }

        public static MapObject valueOf(int value) {
            return Arrays.stream(values())
                    .filter(mapObject -> mapObject.value == value)
                    .findFirst()
                    .orElse(FOOD);
        }
    }

    enum Direction {
        UP(-1, 0),
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }


    static class Map {

        private static final int NOT_FOUND = -1;
        private final MapObject[][] mapObjects;
        private final int[][] distances;
        private final Deque<Coordinate> deque;

        public Map(char[][] mapValues) {
            this.deque = new ArrayDeque<>();
            this.mapObjects = new MapObject[mapValues.length][mapValues[0].length];
            this.distances = new int[mapValues.length][mapValues[0].length];

            for (int n = 0; n < mapValues.length; n++) {
                for (int m = 0; m < mapValues[n].length; m++) {
                    this.mapObjects[n][m] = MapObject.valueOf(mapValues[n][m]);
                    this.distances[n][m] = Integer.MAX_VALUE;
                    if (this.mapObjects[n][m] == MapObject.FAMILY) {
                        this.deque.add(new Coordinate(n, m));
                        this.distances[n][m] = 0;
                    }
                }
            }
        }

        public String simulation() {
            int result = findClosestObject();

            return result == NOT_FOUND
                    ? "NIE"
                    : "TAK\n" + result;
        }

        private int findClosestObject() {
            while (!deque.isEmpty()) {
                Coordinate current = deque.poll();

                if (this.getMapObject(current) == MapObject.FOOD) {
                    return distances[current.n][current.m];
                }

                for (Direction direction : Direction.values()) {
                    Coordinate next = current.getNext(direction);
                    if (isAvailable(next)) {
                        distances[next.n][next.m] = distances[current.n][current.m] + 1;
                        deque.add(next);
                    }
                }
            }

            return NOT_FOUND;
        }

        private boolean isAvailable(Coordinate next) {
            return this.isInBound(next.n, next.m) &&
                    mapObjects[next.n][next.m] != MapObject.WALL &&
                    distances[next.n][next.m] == Integer.MAX_VALUE;
        }

        private MapObject getMapObject(Coordinate coordinate) {
            return this.mapObjects[coordinate.n][coordinate.m];
        }

        private boolean isInBound(int n, int m) {
            return 0 <= n && n < this.mapObjects.length &&
                    0 <= m && m < this.mapObjects[0].length;
        }
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Coordinate getNext(Direction direction) {
            return new Coordinate(n + direction.n, m + direction.m);
        }
    }
}
