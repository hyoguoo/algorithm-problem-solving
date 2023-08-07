/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16931
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindPerimeter {

    static int[][] MAP;
    static int N, M;
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int sum = 0;

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                int height = MAP[n][m];
                for (int[] DIRECTION : DIRECTIONS) {
                    int nextN = n + DIRECTION[0];
                    int nextM = m + DIRECTION[1];

                    if (isOutMap(nextN, nextM)) {
                        sum += height;
                        continue;
                    }

                    int nextHeight = MAP[nextN][nextM];
                    if (height > nextHeight) sum += height - nextHeight;
                }
            }
        }

        return sum + N * M * 2;
    }

    private static boolean isOutMap(int n, int m) {
        return n < 0 || n >= N || m < 0 || m >= M;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        MAP = new int[N][M];
        for (int n = 0; n < N; n++) {
            MAP[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
