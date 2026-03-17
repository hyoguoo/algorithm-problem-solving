/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10163
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ColoredPaperSubtask {

    private static final int MAX_SIZE = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int paperCount = Integer.parseInt(bufferedReader.readLine());
        Paper[] papers = new Paper[paperCount];

        for (int i = 0; i < paperCount; i++) {
            int[] paperInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            papers[i] = new Paper(i + 1, paperInfo[0], paperInfo[1], paperInfo[2], paperInfo[3]);
        }

        System.out.print(
                Arrays.stream(solution(papers))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private static int[] solution(Paper[] papers) {
        int[][] grid = paintGrid(papers);
        return countVisibleAreas(grid, papers.length);
    }

    private static int[][] paintGrid(Paper[] papers) {
        int[][] grid = new int[MAX_SIZE][MAX_SIZE];

        for (Paper paper : papers) {
            for (int x = paper.x; x < paper.x + paper.width; x++) {
                for (int y = paper.y; y < paper.y + paper.height; y++) {
                    grid[x][y] = paper.id;
                }
            }
        }

        return grid;
    }

    private static int[] countVisibleAreas(int[][] grid, int paperCount) {
        int[] visibleAreas = new int[paperCount];

        for (int x = 0; x < MAX_SIZE; x++) {
            for (int y = 0; y < MAX_SIZE; y++) {
                int paperId = grid[x][y];
                if (paperId > 0) {
                    visibleAreas[paperId - 1]++;
                }
            }
        }

        return visibleAreas;
    }

    private static class Paper {

        private final int id;
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        public Paper(int id, int x, int y, int width, int height) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
