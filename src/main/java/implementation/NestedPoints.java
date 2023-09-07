/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 18일차
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NestedPoints {

    final static List<Line> horizontalLineList = new ArrayList<>();
    final static List<Line> verticalLineList = new ArrayList<>();
    final static Map<String, int[]> DIRECTION_MAP = new HashMap<>() {
        {
            put("U", new int[]{-1, 0});
            put("D", new int[]{1, 0});
            put("L", new int[]{0, -1});
            put("R", new int[]{0, 1});
        }
    };
    static int N;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solution());
    }

    private static long solution() {
        for (Line line : verticalLineList) {
            int n = line.n;
            int m = line.m;
            int[] direction = line.direction;
            while (isInBound(n, m)) {
                board[n][m]++;
                n += direction[0];
                m += direction[1];
            }
        }

        long count = 0;

        for (Line line : horizontalLineList) {
            int n = line.n;
            int m = line.m;
            int[] direction = line.direction;
            while (isInBound(n, m)) {
                count += board[n][m];
                n += direction[0];
                m += direction[1];
            }
        }

        return count;
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        board = new int[N][N];
        int lineCount = info[1];

        while (lineCount-- > 0) {
            String[] lineInfo = bufferedReader.readLine().split(" ");
            if (lineInfo[2].equals("U") || lineInfo[2].equals("D")) {
                verticalLineList.add(new Line(Integer.parseInt(lineInfo[0]) - 1, Integer.parseInt(lineInfo[1]) - 1, DIRECTION_MAP.get(lineInfo[2])));
            } else {
                horizontalLineList.add(new Line(Integer.parseInt(lineInfo[0]) - 1, Integer.parseInt(lineInfo[1]) - 1, DIRECTION_MAP.get(lineInfo[2])));
            }
        }
    }

    static class Line {
        int n;
        int m;
        int[] direction;

        public Line(int n, int m, int[] direction) {
            this.n = n;
            this.m = m;
            this.direction = direction;
        }
    }
}
