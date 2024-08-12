/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9715
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SurfaceArea {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] heights = new int[info[0]][info[1]];
            for (int i = 0; i < info[0]; i++) {
                heights[i] = Arrays.stream(bufferedReader.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            stringBuilder.append(solution(heights)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int[][] heights) {
        return getTopArea(heights) * 2
                + getBehindArea(heights)
                + getFrontArea(heights)
                + getLeftArea(heights)
                + getRightArea(heights);
    }

    private static long getTopArea(int[][] heights) {
        return Arrays.stream(heights)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i != 0)
                .count();
    }

    private static long getBehindArea(int[][] heights) {
        int[] previousHeight = new int[heights[0].length];
        long sum = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (heights[i][j] > previousHeight[j]) {
                    sum += heights[i][j] - previousHeight[j];
                }
                previousHeight[j] = heights[i][j];
            }
        }

        return sum;
    }

    private static long getFrontArea(int[][] heights) {
        int[] previousHeight = new int[heights[0].length];
        long sum = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            for (int j = 0; j < heights[i].length; j++) {
                if (heights[i][j] > previousHeight[j]) {
                    sum += heights[i][j] - previousHeight[j];
                }
                previousHeight[j] = heights[i][j];
            }
        }

        return sum;
    }

    private static long getLeftArea(int[][] heights) {
        int[] previousHeight = new int[heights.length];
        long sum = 0;

        for (int i = 0; i < heights[0].length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (heights[j][i] > previousHeight[j]) {
                    sum += heights[j][i] - previousHeight[j];
                }
                previousHeight[j] = heights[j][i];
            }
        }

        return sum;
    }

    private static long getRightArea(int[][] heights) {
        int[] previousHeight = new int[heights.length];
        long sum = 0;

        for (int i = heights[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < heights.length; j++) {
                if (heights[j][i] > previousHeight[j]) {
                    sum += heights[j][i] - previousHeight[j];
                }
                previousHeight[j] = heights[j][i];
            }
        }

        return sum;
    }
}
