/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1855
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Password {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int columnCount = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();

        System.out.print(solution(input, columnCount));
    }

    private static String solution(String input, int columnCount) {
        char[][] grid = createGrid(input, columnCount);

        return IntStream.range(0, columnCount)
                .mapToObj(col -> Arrays.stream(grid).map(chars -> String.valueOf(chars[col]))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining());
    }

    private static char[][] createGrid(String input, int columnCount) {
        char[][] grid = new char[input.length() / columnCount][columnCount];
        int inputIndex = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < columnCount; col++) {
                if (row % 2 == 0) {
                    grid[row][col] = input.charAt(inputIndex++);
                } else {
                    grid[row][columnCount - 1 - col] = input.charAt(inputIndex++);
                }
            }
        }
        return grid;
    }
}
