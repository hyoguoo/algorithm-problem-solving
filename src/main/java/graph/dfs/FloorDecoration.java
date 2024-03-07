/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1388
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class FloorDecoration {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseFloor()));
    }

    private static int solution(Type[][] floor) {
        int count = 0;

        for (int n = 0; n < floor.length; n++) {
            for (int m = 0; m < floor[n].length; m++) {
                if (floor[n][m].isNotVisited()) {
                    dfs(floor, new Coordinate(n, m), floor[n][m]);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(Type[][] floor, Coordinate current, Type type) {
        floor[current.n][current.m] = Type.VISITED;
        type.move(current);

        if (current.isInBound(floor.length, floor[0].length) &&
                floor[current.n][current.m].isMatched(type)) {
            dfs(floor, current, type);
        }
    }

    private static Type[][] parseFloor() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[0];
        int m = info[1];

        Type[][] floor = new Type[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                floor[i][j] = Type.of(line[j]);
            }
        }

        return floor;
    }

    enum Type {
        HORIZONTAL('-', Coordinate::moveRight),
        VERTICAL('|', Coordinate::moveDown),
        VISITED('v', null);

        final char value;
        final Consumer<Coordinate> move;

        Type(char value, Consumer<Coordinate> move) {
            this.value = value;
            this.move = move;
        }

        public static Type of(char value) {
            return Arrays.stream(values())
                    .filter(type -> type.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public void move(Coordinate coordinate) {
            move.accept(coordinate);
        }

        public boolean isNotVisited() {
            return this != VISITED;
        }

        public boolean isMatched(Type type) {
            return this == type;
        }
    }

    static class Coordinate {

        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public void moveRight() {
            m++;
        }

        public void moveDown() {
            n++;
        }

        public boolean isInBound(int limitN, int limitM) {
            return 0 <= n && n < limitN && 0 <= m && m < limitM;
        }
    }
}
