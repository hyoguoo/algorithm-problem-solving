/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1268
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PickTempCaptain {

    private static final int GRADE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());

        int[][] students = new int[studentCount][GRADE];

        for (int i = 0; i < studentCount; i++) {
            students[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(students));
    }

    private static int solution(int[][] students) {
        int[] overlapCount = getOverlapCount(students);

        return getMaxIndex(overlapCount) + 1;
    }

    private static int[] getOverlapCount(int[][] students) {
        int[] overlapCount = new int[students.length];

        for (int i = 0; i < students.length; i++) {
            overlapCount[i] = getCount(students, i);
        }

        return overlapCount;
    }

    private static int getCount(int[][] students, int i) {
        boolean[] isOverlap = new boolean[students.length];

        for (int j = 0; j < students.length; j++) {
            if (i == j) {
                continue;
            }

            for (int k = 0; k < GRADE; k++) {
                if (students[i][k] == students[j][k]) {
                    isOverlap[j] = true;
                }
            }
        }

        int count = 0;

        for (int j = 0; j < students.length; j++) {
            if (isOverlap[j]) {
                count++;
            }
        }
        return count;
    }

    private static int getMaxIndex(int[] overlapCount) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < overlapCount.length; i++) {
            if (overlapCount[i] > max) {
                max = overlapCount[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
