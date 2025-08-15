/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30923
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Cognac3DPrinters {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] heights = Arrays.stream(("0 " + bufferedReader.readLine() + " 0").split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(heights));
    }

    private static long solution(long[] heights) {
        long frontBackArea = Arrays.stream(heights).sum() * 2;
        long topBottomArea = Arrays.stream(heights)
                .filter(height -> height > 0)
                .count() * 2;
        long sideArea = IntStream.range(1, heights.length)
                .mapToLong(i -> Math.abs(heights[i] - heights[i - 1]))
                .sum();

        return frontBackArea + topBottomArea + sideArea;
    }
}
