/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16956
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

public class WolfAndSheep {

    private static final char WOLF = 'W';
    private static final char SHEEP = 'S';
    private static final char FENCE = 'D';


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = mapInfo[0];
        int sizeM = mapInfo[1];

        char[][] map = new char[sizeN][sizeM];
        List<Coordinate> wolves = new ArrayList<>();

        for (int n = 0; n < sizeN; n++) {
            char[] line = bufferedReader.readLine().toCharArray();
            for (int m = 0; m < sizeM; m++) {
                map[n][m] = line[m];
                if (map[n][m] == WOLF) {
                    wolves.add(new Coordinate(n, m));
                }
            }
        }

        System.out.print(solution(map, wolves));
    }

    private static String solution(char[][] map, List<Coordinate> wolves) {
        for (Coordinate wolf : wolves) {
            for (Direction direction : Direction.values()) {
                Coordinate next = wolf.getNext(direction);
                if (!isInBound(map, next) ||
                        map[next.n][next.m] == FENCE ||
                        map[next.n][next.m] == WOLF) {
                    continue;
                }

                if (map[next.n][next.m] == SHEEP) {
                    return "0";
                }
                map[next.n][next.m] = FENCE;
            }
        }

        return "1" + "\n" + toStringMap(map);
    }

    private static boolean isInBound(char[][] map, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < map.length &&
                0 <= coordinate.m && coordinate.m < map[0].length;
    }

    private static String toStringMap(char[][] map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char[] line : map) {
            for (char c : line) {
                stringBuilder.append(c);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString().trim();
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

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
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
            return new Coordinate(n + direction.getN(), m + direction.getM());
        }
    }
}
