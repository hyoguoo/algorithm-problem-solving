/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17207
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Revert {

    private static final String[] PEOPLE_NAME = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
    private static final int PERSON_COUNT = PEOPLE_NAME.length;
    private static final int WORK_COUNT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] difficulty = new int[PERSON_COUNT][WORK_COUNT];
        int[][] time = new int[PERSON_COUNT][WORK_COUNT];

        for (int i = 0; i < PERSON_COUNT; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            difficulty[i] = input;
        }

        for (int i = 0; i < PERSON_COUNT; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            time[i] = input;
        }

        System.out.print(solution(difficulty, time));
    }

    private static String solution(int[][] difficulty, int[][] time) {
        int[] totalWorkloads = calculateTotalWorkLoads(difficulty, time);

        return findLeastBusyPersonFromEnd(totalWorkloads);
    }

    private static String findLeastBusyPersonFromEnd(int[] totalWorkloads) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = PERSON_COUNT - 1; i >= 0; i--) {
            if (totalWorkloads[i] < min) {
                min = totalWorkloads[i];
                minIndex = i;
            }
        }

        return PEOPLE_NAME[minIndex];
    }

    private static int[] calculateTotalWorkLoads(int[][] difficulty, int[][] time) {
        int[][] workloads = calculateWorkloads(difficulty, time);

        return Arrays.stream(workloads)
                .mapToInt(workload -> Arrays.stream(workload).sum())
                .toArray();
    }

    private static int[][] calculateWorkloads(int[][] difficulty, int[][] time) {
        int[][] workloads = new int[PERSON_COUNT][WORK_COUNT];

        for (int p = 0; p < PERSON_COUNT; p++) {
            for (int w = 0; w < WORK_COUNT; w++) {
                for (int i = 0; i < PERSON_COUNT; i++) {
                    workloads[p][w] += difficulty[p][i] * time[i][w];
                }
            }
        }

        return workloads;
    }
}
