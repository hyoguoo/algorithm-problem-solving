/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11256
 * Cheat Level: 0
 * Algorithm: Sort / Greedy
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class JellyBean {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int jellyBeanCount = info[0];
            int boxCount = info[1];

            Box[] boxes = new Box[boxCount];

            for (int i = 0; i < boxCount; i++) {
                int[] boxInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                boxes[i] = new Box(boxInfo[0], boxInfo[1]);
            }

            stringBuilder.append(solution(boxes, jellyBeanCount)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(Box[] boxes, int jellyBeanCount) {
        return Arrays.stream(boxes)
                .sorted()
                .map(box -> box.height * box.width)
                .reduce(
                        new Accumulator(0, 0),
                        (acc, beans) -> acc.add(beans, jellyBeanCount),
                        (a, b) -> a
                )
                .boxCount;
    }

    static class Accumulator {

        int jellyBeanSum;
        int boxCount;

        public Accumulator(int jellyBeanSum, int boxCount) {
            this.jellyBeanSum = jellyBeanSum;
            this.boxCount = boxCount;
        }

        public Accumulator add(int beans, int targetJellyBeanCount) {
            if (jellyBeanSum >= targetJellyBeanCount) {
                return this;
            }
            return new Accumulator(jellyBeanSum + beans, boxCount + 1);
        }
    }

    static class Box implements Comparable<Box> {

        private final int height;
        private final int width;

        public Box(int height, int width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Box box = (Box) o;
            return height == box.height && width == box.width;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, width);
        }

        @Override
        public int compareTo(Box o) {
            return o.height * o.width - this.height * this.width;
        }
    }
}
