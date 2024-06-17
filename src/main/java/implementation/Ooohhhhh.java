/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15922
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ooohhhhh {

    public static void main(String[] args) throws IOException {
        LineSegment[] lineSegments = parseLineSegments();

        System.out.print(solution(lineSegments));
    }

    private static LineSegment[] parseLineSegments() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineSegmentCount = Integer.parseInt(bufferedReader.readLine());

        LineSegment[] lineSegments = new LineSegment[lineSegmentCount];

        for (int i = 0; i < lineSegmentCount; i++) {
            int[] lineSegmentInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            lineSegments[i] = new LineSegment(lineSegmentInfo[0], lineSegmentInfo[1]);
        }
        return lineSegments;
    }

    private static int solution(LineSegment[] lineSegments) {
        int end = lineSegments[0].getEnd();
        int result = lineSegments[0].getLength();

        for (LineSegment lineSegment : lineSegments) {
            if (lineSegment.isFullyOverlapped(end)) {
                continue;
            } else if (lineSegment.isPartiallyOverlapped(end)) {
                result += lineSegment.getEnd() - end;
            } else {
                result += lineSegment.getLength();
            }
            end = lineSegment.getEnd();
        }

        return result;
    }

    static class LineSegment {

        private final int start;
        private final int end;

        public LineSegment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public boolean isFullyOverlapped(int end) {
            return this.end <= end;
        }

        public boolean isPartiallyOverlapped(int end) {
            return this.start <= end;
        }

        public int getLength() {
            return end - start;
        }
    }
}
