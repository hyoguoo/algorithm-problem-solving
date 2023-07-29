/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2477
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MelonField {

    final static int LINE_COUNT = 6;
    final static Deque<Line> lines = new ArrayDeque<>();
    static int melonsPerSquareMeter;
    static int maximumWidthDistance = 0;
    static int maximumHeightDistance = 0;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int equalDirectionsCount = 0;
        int partialWidth;
        int partialHeight;

        while (true) {
            Line currentLine = lines.pollFirst();
            Line nextLine = getNthElement(lines, 1);

            if (currentLine.direction == nextLine.direction) {
                equalDirectionsCount++;
                if (equalDirectionsCount == 2) {
                    partialWidth = currentLine.distance;
                    partialHeight = lines.peek().distance;
                    break;
                }
            } else {
                equalDirectionsCount = 0;
            }
            lines.addLast(currentLine);
        }

        return (maximumWidthDistance * maximumHeightDistance - partialWidth * partialHeight) * melonsPerSquareMeter;
    }

    public static <T> T getNthElement(Deque<T> deque, int index) {
        if (index >= 0 && index < deque.size()) return new ArrayList<>(deque).get(index);
        else return null;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        melonsPerSquareMeter = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < LINE_COUNT; i++) {
            int[] lineInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Direction direction = Direction.values()[lineInfo[0] - 1];
            updateMaxDistances(direction, lineInfo[1]);
            lines.add(new Line(direction, lineInfo[1]));
        }
    }

    private static void updateMaxDistances(Direction direction, int distance) {
        if (direction == Direction.EAST || direction == Direction.WEST) {
            maximumWidthDistance = Math.max(maximumWidthDistance, distance);
        } else {
            maximumHeightDistance = Math.max(maximumHeightDistance, distance);
        }
    }

    enum Direction {
        EAST, WEST, SOUTH, NORTH
    }

    static class Line {
        Direction direction;
        int distance;

        public Line(Direction direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }
}
