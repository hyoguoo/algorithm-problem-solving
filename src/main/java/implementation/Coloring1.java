/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1117
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coloring1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long widthSize = info[0];
        long heightSize = info[1];
        long fold = info[2];
        long dividedCount = info[3] + 1;
        long x1 = info[4];
        long y1 = info[5];
        long x2 = info[6];
        long y2 = info[7];

        System.out.print(solution(widthSize, heightSize, fold, dividedCount, x1, y1, x2, y2));
    }

    private static long solution(
            long widthSize,
            long heightSize,
            long fold,
            long dividedCount,
            long x1,
            long y1,
            long x2,
            long y2
    ) {
        long total = widthSize * heightSize;
        long overlapped = Long.min(widthSize - fold, fold);
        long unpaintedArea = calculateUnpaintedArea(dividedCount, x1, y1, x2, y2, overlapped);

        return total - unpaintedArea;
    }

    private static long calculateUnpaintedArea(
            long dividedCount,
            long x1,
            long y1,
            long x2,
            long y2,
            long overlapped
    ) {
        long height = y2 - y1;
        if (x2 > overlapped) {
            if (overlapped > x1) {
                return height * (x2 + overlapped - 2 * x1) * dividedCount;

            } else {
                return height * (x2 - x1) * dividedCount;
            }
        } else {
            return height * 2 * (x2 - x1) * dividedCount;
        }
    }
}
