/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23351
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Watering {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2], info[3]));
    }

    private static int solution(int potCount, int initWater, int wateringRange, int waterIncrease) {
        int[] potsWater = new int[potCount];
        Arrays.fill(potsWater, initWater);

        int days = 1;
        int index = 0;
        while (true) {
            for (int i = index; i < index + wateringRange; i++) {
                potsWater[i % potCount] += waterIncrease;
            }

            for (int i = 0; i < potsWater.length; i++) {
                potsWater[i]--;
                if (potsWater[i] <= 0) {
                    return days;
                }
            }

            days++;
            index = (index + wateringRange) % potCount;
        }
    }
}
