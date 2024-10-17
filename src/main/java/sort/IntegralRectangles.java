/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9196
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class IntegralRectangles {

    private static final int END_SIGNAL = 0;
    private static final int LIMIT = 150;
    private static final List<Rectangle> RECTANGLE_LIST = new ArrayList<>();

    static {
        for (int i = 1; i <= LIMIT; i++) {
            for (int j = i + 1; j <= LIMIT; j++) {
                RECTANGLE_LIST.add(new Rectangle(i, j));
            }
        }
        Collections.sort(RECTANGLE_LIST);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            int[] rectangleInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (rectangleInfo[0] == END_SIGNAL && rectangleInfo[1] == END_SIGNAL) {
                break;
            }
            Rectangle rectangle = new Rectangle(rectangleInfo[0], rectangleInfo[1]);

            stringBuilder.append(solution(rectangle)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Rectangle solution(Rectangle rectangle) {
        Iterator<Rectangle> iterator = RECTANGLE_LIST.iterator();

        while (iterator.hasNext()) {
            Rectangle next = iterator.next();
            if (next.equals(rectangle)) {
                return iterator.next();
            }
        }

        return rectangle;
    }

    static class Rectangle implements Comparable<Rectangle> {

        private final int height;
        private final int width;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public int getDiagonal() {
            return height * height + width * width;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Rectangle rectangle = (Rectangle) o;
            return height == rectangle.height && width == rectangle.width;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, width);
        }

        @Override
        public int compareTo(Rectangle o) {
            return this.getDiagonal() != o.getDiagonal()
                    ? this.getDiagonal() - o.getDiagonal()
                    : this.height - o.height;
        }

        @Override
        public String toString() {
            return height + " " + width;
        }
    }
}
