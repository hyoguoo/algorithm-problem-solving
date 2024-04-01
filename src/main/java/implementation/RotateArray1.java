/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16926
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotateArray1 {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rotateCount = info[2];
        int[][] array = parseArray(info);

        System.out.print(solution(array, rotateCount));
    }

    private static int[][] parseArray(int[] info) throws IOException {
        int nSize = info[0];
        int mSize = info[1];
        int[][] array = new int[nSize][mSize];

        for (int n = 0; n < nSize; n++) {
            array[n] = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return array;
    }

    private static String solution(int[][] array, int rotateCount) {
        rotateArrayByGroup(
                array,
                rotateCount,
                Math.min(array.length, array[0].length) / 2,
                0
        );

        return toStringArray(array);
    }

    private static void rotateArrayByGroup(
            int[][] array,
            int rotateCount,
            int groupLength,
            int offset
    ) {
        if (offset >= groupLength) {
            return;
        }

        for (int r = 0; r < rotateCount; r++) {
            rotateGroup(array, offset, groupLength);
        }

        rotateArrayByGroup(array, rotateCount, groupLength, offset + 1);
    }

    private static void rotateGroup(int[][] array, int offset, int groupLength) {
        int n = offset;
        int m = offset;
        int temp = array[offset][offset];

        for (Direction direction : Direction.values()) {
            while (true) {
                int nextN = n + direction.n;
                int nextM = m + direction.m;

                if (!isInBound(array, offset, nextN, nextM)) {
                    break;
                }

                array[n][m] = array[nextN][nextM];
                n = nextN;
                m = nextM;
            }
        }

        if (isNotSingleElement(offset, groupLength)) {
            array[offset + 1][offset] = temp;
        }
    }

    private static boolean isInBound(int[][] array, int offset, int n, int m) {
        return offset <= n && n < array.length - offset &&
                offset <= m && m < array[0].length - offset;
    }

    private static boolean isNotSingleElement(int offset, int groupLength) {
        return offset + 1 <= groupLength;
    }

    private static String toStringArray(int[][] rotatedArray) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] line : rotatedArray) {
            for (int m = 0; m < rotatedArray[0].length; m++) {
                stringBuilder.append(line[m]).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString().trim();
    }

    enum Direction {
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1),
        UP(-1, 0);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
