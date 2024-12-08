/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10431
 * Cheat Level: 0
 * Algorithm: Simulation / Implementation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeightOrdering {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] heights = Arrays.copyOfRange(info, 1, info.length);
            stringBuilder
                    .append(i)
                    .append(" ")
                    .append(solution(heights))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] heights) {
        int count = 0;
        List<Integer> heightList = new ArrayList<>();

        for (int height : heights) {
            heightList.add(height);
            int currentIndex = heightList.size() - 1;
            int compareIndex = currentIndex - 1;
            while (compareIndex >= 0 && heightList.get(currentIndex) < heightList.get(compareIndex)) {
                Collections.swap(heightList, currentIndex, compareIndex);
                count++;
                currentIndex--;
                compareIndex--;
            }
        }

        return count;
    }
}
