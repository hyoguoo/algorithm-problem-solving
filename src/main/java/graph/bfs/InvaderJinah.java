/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15812
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InvaderJinah {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeY = info[0];
        int sizeX = info[1];

        Symbol[][] map = new Symbol[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            map[y] = Arrays.stream(bufferedReader.readLine().split(""))
                    .map(Symbol::from)
                    .toArray(Symbol[]::new);
        }

        System.out.print(solution(map));
    }

    private static int solution(Symbol[][] map) {
        List<Coordinate> emptyList =
                IntStream.range(0, map.length)
                        .boxed()
                        .flatMap(y -> IntStream.range(0, map[0].length)
                                .filter(x -> map[y][x] == Symbol.EMPTY)
                                .mapToObj(x -> new Coordinate(x, y)))
                        .collect(Collectors.toList());

        return IntStream.range(0, emptyList.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, emptyList.size())
                        .mapToObj(j -> {
                            Queue<Coordinate> bombs = new LinkedList<>();
                            bombs.add(emptyList.get(i));
                            bombs.add(emptyList.get(j));
                            return bfs(map, bombs);
                        }))
                .min(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
    }

    private static int bfs(Symbol[][] map, Queue<Coordinate> bombCoordinateList) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int time = 0;

        bombCoordinateList.forEach(coordinate -> visited[coordinate.y][coordinate.x] = true);

        while (!bombCoordinateList.isEmpty()) {
            int size = bombCoordinateList.size();
            if (isAllBombedVillage(map, visited)) {
                return time;
            }
            IntStream.range(0, size)
                    .forEach(i -> expandBombs(map, bombCoordinateList, visited));
            time++;
        }

        return time;
    }

    private static void expandBombs(Symbol[][] map, Queue<Coordinate> bombCoordinateList, boolean[][] visited) {
        Coordinate current = bombCoordinateList.poll();
        if (current == null) {
            throw new IllegalArgumentException();
        }
        for (Direction direction : Direction.values()) {
            Coordinate next = current.move(direction);
            if (isInBound(map, next) && !visited[next.y][next.x]) {
                visited[next.y][next.x] = true;
                bombCoordinateList.add(next);
            }
        }
    }

    private static boolean isAllBombedVillage(Symbol[][] map, boolean[][] visited) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == Symbol.VILLAGE && !visited[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isInBound(Symbol[][] map, Coordinate coordinate) {
        return coordinate.x >= 0 && coordinate.x < map[0].length &&
                coordinate.y >= 0 && coordinate.y < map.length;
    }

    enum Symbol {
        EMPTY("0"),
        VILLAGE("1");

        private final String value;

        Symbol(String value) {
            this.value = value;
        }

        public static Symbol from(String symbol) {
            return Arrays.stream(Symbol.values())
                    .filter(s -> s.value.equals(symbol))
                    .findFirst()
                    .orElseThrow();
        }
    }

    enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate move(Direction direction) {
            return new Coordinate(this.x + direction.dx, this.y + direction.dy);
        }
    }
}
