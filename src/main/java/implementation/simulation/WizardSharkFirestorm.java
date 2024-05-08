/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20058
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WizardSharkFirestorm {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int EMPTY = 0;
    private static final int ADJACENT_ICE_LIMIT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = (int) Math.pow(2, info[0]);

        int[][] map = new int[sizeN][sizeN];
        for (int n = 0; n < sizeN; n++) {
            map[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] magics = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(map, magics));
    }

    private static String solution(int[][] map, int[] magics) {
        int sizeN = map.length;

        for (int magic : magics) {
            map = rotateMap(map, magic, sizeN);
            map = melt(map);
        }

        return getSum(map) + "\n" + getMaxIceberg(map);
    }

    private static int getSum(int[][] map) {
        return Arrays.stream(map)
                .mapToInt(row -> Arrays.stream(row).sum())
                .sum();
    }

    private static int getMaxIceberg(int[][] map) {
        int sizeN = map.length;
        boolean[][] visited = new boolean[sizeN][sizeN];
        int max = 0;

        for (int n = 0; n < sizeN; n++) {
            for (int m = 0; m < sizeN; m++) {
                if (map[n][m] == EMPTY || visited[n][m]) {
                    continue;
                }

                max = Math.max(max, bfs(map, visited, n, m));
            }
        }

        return max;
    }

    private static int bfs(int[][] map, boolean[][] visited, int n, int m) {
        Deque<Coordinate> deque = new ArrayDeque<>();
        deque.add(new Coordinate(n, m));

        int sizeN = map.length;
        int count = 1;
        visited[n][m] = true;

        while (!deque.isEmpty()) {
            Coordinate current = deque.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isOutBound(nextN, nextM, sizeN) ||
                        visited[nextN][nextM] ||
                        map[nextN][nextM] == EMPTY) {
                    continue;
                }

                visited[nextN][nextM] = true;
                count++;
                deque.add(new Coordinate(nextN, nextM));
            }
        }

        return count;
    }

    private static int[][] melt(int[][] map) {
        int sizeN = map.length;
        int[][] newMap = copyMap(map, sizeN);

        for (int n = 0; n < sizeN; n++) {
            for (int m = 0; m < sizeN; m++) {
                if (map[n][m] == EMPTY) {
                    continue;
                }

                if (countAdjacentIce(map, n, m, sizeN) < ADJACENT_ICE_LIMIT) {
                    newMap[n][m]--;
                }
            }
        }

        return newMap;
    }

    private static int countAdjacentIce(int[][] map, int n, int m, int sizeN) {
        int count = 0;

        for (int[] direction : DIRECTIONS) {
            int nextN = n + direction[0];
            int nextM = m + direction[1];

            if (!isOutBound(nextN, nextM, sizeN) &&
                    map[nextN][nextM] != EMPTY) {
                count++;
            }
        }

        return count;
    }

    private static boolean isOutBound(int n, int m, int sizeN) {
        return n < 0 || sizeN <= n ||
                m < 0 || sizeN <= m;
    }

    private static int[][] rotateMap(int[][] map, int magic, int sizeN) {
        int[][] newMap = copyMap(map, sizeN);

        int base = (int) Math.pow(2, magic);

        for (int n = 0; n < sizeN; n += base) {
            for (int m = 0; m < sizeN; m += base) {
                rotateBlock(newMap, n, m, base);
            }
        }

        return newMap;
    }

    private static int[][] copyMap(int[][] map, int sizeN) {
        int[][] newMap = new int[sizeN][sizeN];

        for (int n = 0; n < sizeN; n++) {
            newMap[n] = Arrays.copyOf(map[n], sizeN);
        }

        return newMap;
    }

    private static void rotateBlock(int[][] map, int startN, int startM, int base) {
        int[][] temp = getTempMap(map, startN, startM, base);

        for (int n = 0; n < base; n++) {
            for (int m = 0; m < base; m++) {
                map[startN + m][startM + base - 1 - n] = temp[n][m];
            }
        }
    }

    private static int[][] getTempMap(int[][] map, int startN, int startM, int base) {
        int[][] temp = new int[base][base];

        for (int n = 0; n < base; n++) {
            temp[n] = Arrays.copyOfRange(map[startN + n], startM, startM + base);
        }

        return temp;
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
