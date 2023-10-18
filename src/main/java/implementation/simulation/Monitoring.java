/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15683
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation / Brute Force / Backtracking
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monitoring {

    static final int VIEW = 9;
    static final int EMPTY = 0;
    static final int WALL = 6;
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        int[][] map = new int[N][M];
        List<CCTV> cctvList = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < M; m++) {
                map[n][m] = input[m];
                if (map[n][m] != EMPTY && map[n][m] != WALL) {
                    cctvList.add(new CCTV(n, m, CCTVType.fromNumber(map[n][m])));
                }
            }
        }

        solution(map, cctvList);
        System.out.println(min);
    }

    private static void solution(int[][] map, List<CCTV> cctvList) {
        dfs(map, cctvList, 0);
    }

    private static void dfs(int[][] map, List<CCTV> cctvList, int index) {
        if (index == cctvList.size()) {
            min = Math.min(min, calculateEmptyCount(map, cctvList));
            return;
        }

        CCTV cctv = cctvList.get(index);
        int[][] directionType = cctv.cctvType.getDirectionType();
        int directionTypeCount = directionType.length;

        for (int i = 0; i < directionTypeCount; i++) {
            cctv.directionIndex = i;
            dfs(map, cctvList, index + 1);
        }
    }

    private static int calculateEmptyCount(int[][] map, List<CCTV> cctvList) {
        int[][] copyMap = copyMap(map);

        for (CCTV cctv : cctvList) {
            int directionIndex = cctv.directionIndex;
            int[][] directions = cctv.cctvType.getDirectionType();
            int[] direction = directions[directionIndex];

            for (int d : direction) {
                int nextN = cctv.n;
                int nextM = cctv.m;
                while (true) {
                    nextN += DIRECTIONS[d][0];
                    nextM += DIRECTIONS[d][1];

                    if (!isInBound(nextN, nextM) || copyMap[nextN][nextM] == WALL) break;
                    copyMap[nextN][nextM] = VIEW;
                }
            }
        }

        return countEmpty(copyMap);
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copyMap = new int[map.length][map[0].length];

        for (int n = 0; n < map.length; n++) {
            System.arraycopy(map[n], 0, copyMap[n], 0, map[n].length);
        }

        return copyMap;
    }

    private static int countEmpty(int[][] map) {
        return (int) Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i == EMPTY)
                .count();
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    enum CCTVType {
        ONE(1, new int[][]{{0}, {1}, {2}, {3}}),
        TWO(2, new int[][]{{0, 2}, {1, 3}}),
        THREE(3, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}}),
        FOUR(4, new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}),
        FIVE(5, new int[][]{{0, 1, 2, 3}});

        private final int number;
        private final int[][] directionType;

        CCTVType(int number, int[][] directionType) {
            this.number = number;
            this.directionType = directionType;
        }

        public static CCTVType fromNumber(int number) {
            return Arrays.stream(CCTVType.values())
                    .filter(cctvType -> cctvType.number == number)
                    .findFirst()
                    .orElse(null);
        }

        public int getNumber() {
            return number;
        }

        public int[][] getDirectionType() {
            return directionType;
        }
    }

    static class CCTV {
        int n;
        int m;
        CCTVType cctvType;
        int directionIndex = -1;

        public CCTV(int n, int m, CCTVType cctvType) {
            this.n = n;
            this.m = m;
            this.cctvType = cctvType;
        }
    }
}
