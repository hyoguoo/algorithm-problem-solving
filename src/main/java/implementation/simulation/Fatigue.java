/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22864
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fatigue {

    private static final int DAY_HOURS = 24;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2], info[3]));
    }

    private static int solution(int fatigueIncrease, int workPerHour, int fatigueDecrease, int maxFatigue) {
        int fatigue = 0;
        int totalWork = 0;

        for (int hour = 0; hour < DAY_HOURS; hour++) {
            if (fatigue + fatigueIncrease <= maxFatigue) {
                fatigue += fatigueIncrease;
                totalWork += workPerHour;
            } else {
                fatigue -= fatigueDecrease;
                if (fatigue < 0) {
                    fatigue = 0;
                }
            }
        }

        return totalWork;
    }
}
