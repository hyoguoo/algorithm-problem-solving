/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1531
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Transparent {

    private static final int PICTURE_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int paperCount = info[0];
        int needOverlappingCount = info[1];

        Paper[] papers = new Paper[paperCount];

        for (int index = 0; index < paperCount; index++) {
            int[] paperInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            papers[index] = new Paper(paperInfo[0], paperInfo[1], paperInfo[2], paperInfo[3]);
        }

        System.out.print(solution(papers, needOverlappingCount));
    }

    private static int solution(Paper[] papers, int needOverlappingCount) {
        Picture picture = new Picture();

        Arrays.stream(papers)
                .forEach(picture::drawPaper);

        return picture.countNotTransparent(needOverlappingCount);
    }

    static class Paper {

        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;

        public Paper(int x1, int y1, int x2, int y2) {
            this.x1 = x1 - 1;
            this.y1 = y1 - 1;
            this.x2 = x2 - 1;
            this.y2 = y2 - 1;
        }
    }

    static class Picture {

        private final int[][] pixels;

        public Picture() {
            this.pixels = new int[PICTURE_SIZE][PICTURE_SIZE];
        }

        public void drawPaper(Paper paper) {
            for (int x = paper.x1; x <= paper.x2; x++) {
                for (int y = paper.y1; y <= paper.y2; y++) {
                    pixels[x][y]++;
                }
            }
        }

        public int countNotTransparent(int needOverlappingCount) {
            return PICTURE_SIZE * PICTURE_SIZE -
                    (int) Arrays.stream(pixels)
                            .flatMapToInt(Arrays::stream)
                            .filter(pixel -> pixel <= needOverlappingCount)
                            .count();
        }
    }
}
