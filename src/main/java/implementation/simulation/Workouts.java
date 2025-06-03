/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1173
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Workouts {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int needExerciseMinutes = info[0];
        int currentPulse = info[1];
        int maxPulse = info[2];
        int pulseIncreasePerExercise = info[3];
        int pulseDecreasePerRest = info[4];

        System.out.print(
                solution(needExerciseMinutes, currentPulse, maxPulse, pulseIncreasePerExercise, pulseDecreasePerRest)
        );
    }

    private static int solution(int needExerciseMinutes,
            int startPulse,
            int maxPulse,
            int pulseIncreasePerExercise,
            int pulseDecreasePerRest) {
        if (startPulse + pulseIncreasePerExercise > maxPulse) {
            return -1;
        }

        int currentExerciseMinutes = 0;
        int currentMinutes = 0;
        int currentPulse = startPulse;

        while (currentExerciseMinutes < needExerciseMinutes) {
            if (currentPulse + pulseIncreasePerExercise <= maxPulse) {
                currentPulse += pulseIncreasePerExercise;
                currentExerciseMinutes++;
            } else {
                currentPulse -= pulseDecreasePerRest;
                currentPulse = Math.max(currentPulse, startPulse);
            }
            currentMinutes++;
        }

        return currentMinutes;
    }
}
