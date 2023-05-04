/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13164
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HappyKindergarten {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int K = info[1];
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> difference = getDifference(heights);

        System.out.println(solution(difference, K));
    }

    private static int solution(List<Integer> difference, int K) {
        int offset = getOffsetLargestValues(difference, K);
        int sum = 0;

        for (int i = offset; i < difference.size(); i++) sum += difference.get(i);
        return sum;
    }

    private static int getOffsetLargestValues(List<Integer> difference, int K) {
        difference.sort(Collections.reverseOrder());
        return K - 1;
    }

    private static List<Integer> getDifference(int[] heights) {
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < heights.length - 1; i++) difference.add(heights[i + 1] - heights[i]);
        return difference;
    }
}
