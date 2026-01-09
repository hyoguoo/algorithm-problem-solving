/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9455
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Box {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rows = info[0];
            int cols = info[1];

            int[][] grid = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                grid[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            stringBuilder
                    .append(solution(grid, rows, cols))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[][] grid, int rows, int cols) {
        int totalDistance = 0;

        for (int col = 0; col < cols; col++) {
            int nextBottom = rows - 1;

            for (int row = rows - 1; row >= 0; row--) {
                if (grid[row][col] == 1) {
                    totalDistance += (nextBottom - row);
                    nextBottom--;
                }
            }
        }

        return totalDistance;
    }
}
