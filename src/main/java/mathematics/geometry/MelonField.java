/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2477
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MelonField {

    private static final int LINE_COUNT = 6;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int melonsPerSquareMeter = Integer.parseInt(bufferedReader.readLine());

        Line[] lines = new Line[LINE_COUNT];
        for (int i = 0; i < LINE_COUNT; i++) {
            int[] lineInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            lines[i] = new Line(Direction.of(lineInfo[0]), lineInfo[1]);
        }

        System.out.print(solution(lines, melonsPerSquareMeter));
    }

    private static int solution(Line[] lines, int melonsPerSquareMeter) {
        return calculateArea(lines) * melonsPerSquareMeter;
    }

    private static int calculateArea(Line[] lines) {
        Pair maxVertical = getMaxLengthInfo(lines, List.of(Direction.NORTH, Direction.SOUTH));
        Pair maxHorizontal = getMaxLengthInfo(lines, List.of(Direction.EAST, Direction.WEST));

        int partialArea = calculatePartialArea(lines, maxVertical, maxHorizontal);

        return maxHorizontal.distance * maxVertical.distance - partialArea;
    }

    private static Pair getMaxLengthInfo(Line[] lines, List<Direction> directions) {
        return Arrays.stream(lines)
                .filter(line -> directions.contains(line.direction))
                .max(Comparator.comparingInt(line -> line.distance))
                .map(line -> new Pair(Arrays.asList(lines).indexOf(line), line.distance))
                .orElseThrow(IllegalArgumentException::new);
    }

    private static int calculatePartialArea(Line[] lines, Pair maxVertical, Pair maxHorizontal) {
        int verticalLeftIndex = getLeftIndex(maxVertical.index, lines.length);
        int verticalRightIndex = getRightIndex(maxVertical.index, lines.length);
        int horizontalLeftIndex = getLeftIndex(maxHorizontal.index, lines.length);
        int horizontalRightIndex = getRightIndex(maxHorizontal.index, lines.length);

        int partialVertical = Math.abs(lines[verticalLeftIndex].distance - lines[verticalRightIndex].distance);
        int partialHorizontal = Math.abs(lines[horizontalLeftIndex].distance - lines[horizontalRightIndex].distance);

        return partialVertical * partialHorizontal;
    }

    private static int getLeftIndex(int index, int length) {
        return (index - 1 + length) % length;
    }

    private static int getRightIndex(int index, int length) {
        return (index + 1) % length;
    }

    enum Direction {
        EAST(1),
        WEST(2),
        SOUTH(3),
        NORTH(4);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public static Direction of(int value) {
            return Arrays.stream(values())
                    .filter(direction -> direction.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class Line {

        private final Direction direction;
        private final int distance;

        public Line(Direction direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }

    static class Pair {

        private final int index;
        private final int distance;

        public Pair(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
