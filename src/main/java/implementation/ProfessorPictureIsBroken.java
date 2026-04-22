/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20205
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorPictureIsBroken {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int originalSize = info[0];
        int scaleFactor = info[1];

        Pixel[][] pixels = new Pixel[originalSize][originalSize];

        for (int row = 0; row < originalSize; row++) {
            int[] rowPixels = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < originalSize; col++) {
                pixels[row][col] = Pixel.of(rowPixels[col]);
            }
        }

        Bitmap bitmap = new Bitmap(originalSize, scaleFactor, pixels);

        System.out.print(solution(bitmap));
    }

    private static String solution(Bitmap bitmap) {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < bitmap.getSize(); row++) {
            String expandedRow = expandRow(bitmap, row);
            for (int scaleRow = 0; scaleRow < bitmap.getScaleFactor(); scaleRow++) {
                result.append(expandedRow).append(System.lineSeparator());
            }
        }

        return result.toString().trim();
    }

    private static String expandRow(Bitmap bitmap, int row) {
        StringBuilder expandedRow = new StringBuilder();
        for (int col = 0; col < bitmap.getSize(); col++) {
            Pixel pixel = bitmap.getPixels()[row][col];
            for (int scaleCol = 0; scaleCol < bitmap.getScaleFactor(); scaleCol++) {
                expandedRow.append(pixel.getValue()).append(" ");
            }
        }
        return expandedRow.toString().trim();
    }

    private enum Pixel {
        ZERO(0), ONE(1);

        private final int value;

        Pixel(int value) {
            this.value = value;
        }

        public static Pixel of(int value) {
            return value == 0 ? ZERO : ONE;
        }

        public int getValue() {
            return value;
        }
    }

    private static class Bitmap {

        private final int size;
        private final int scaleFactor;
        private final Pixel[][] pixels;

        public Bitmap(int size, int scaleFactor, Pixel[][] pixels) {
            this.size = size;
            this.scaleFactor = scaleFactor;
            this.pixels = pixels;
        }

        public int getSize() {
            return size;
        }

        public int getScaleFactor() {
            return scaleFactor;
        }

        public Pixel[][] getPixels() {
            return pixels;
        }
    }
}
