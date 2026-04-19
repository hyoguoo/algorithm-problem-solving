/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1773
 * Cheat Level: 0
 * Algorithm: Implementation / Mathematics
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FireworkShow {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int studentCount = info[0];
        int endTime = info[1];

        int[] periods = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            periods[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }

        System.out.print(solution(endTime, periods));
    }

    private static int solution(int endTime, int[] periods) {
        boolean[] isExploded = new boolean[endTime + 1];

        for (int period : periods) {
            if (period == 1) {
                return endTime;
            }
            for (int time = period; time <= endTime; time += period) {
                isExploded[time] = true;
            }
        }

        int totalExplosionTime = 0;
        for (int time = 1; time <= endTime; time++) {
            if (isExploded[time]) {
                totalExplosionTime++;
            }
        }

        return totalExplosionTime;
    }
}
