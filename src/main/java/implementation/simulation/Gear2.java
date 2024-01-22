/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15662
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gear2 {

    static int gearCount;
    static final int GEAR_SIZE = 8;
    static final int LEFT_INDEX = 6;
    static final int RIGHT_INDEX = 2;
    static final int CLOCKWISE = 1;
    static final int COUNTER_CLOCKWISE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        gearCount = Integer.parseInt(bufferedReader.readLine());

        int[][] gears = new int[gearCount][GEAR_SIZE];

        for (int i = 0; i < gearCount; i++) {
            gears[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int rotateCount = Integer.parseInt(bufferedReader.readLine());
        Rotate[] rotates = new Rotate[rotateCount];

        for (int i = 0; i < rotateCount; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rotates[i] = new Rotate(input[0] - 1, input[1]);
        }

        System.out.println(solution(gears, rotates));
    }

    private static int solution(int[][] gears, Rotate[] rotates) {
        for (Rotate rotate : rotates) {
            List<Rotate> rotateGearList = getRotateGears(rotate.gearIndex, rotate.direction, gears);
            rotateGears(gears, rotateGearList);
        }

        return getCount(gears);
    }

    private static List<Rotate> getRotateGears(int gearIndex, int originalDirection, int[][] gears) {
        List<Rotate> rotateGears = new ArrayList<>();
        int left = gearIndex - 1;
        int right = gearIndex + 1;

        rotateGears.add(new Rotate(gearIndex, originalDirection));

        while (left >= 0) {
            if (gears[left][RIGHT_INDEX] != gears[left + 1][LEFT_INDEX]) {
                int direction = (gearIndex - left) % 2 == 0 ? originalDirection : originalDirection * -1;
                rotateGears.add(new Rotate(left, direction));
                left--;
            } else {
                break;
            }
        }

        while (right < gearCount) {
            if (gears[right][LEFT_INDEX] != gears[right - 1][RIGHT_INDEX]) {
                int direction = (right - gearIndex) % 2 == 0 ? originalDirection : originalDirection * -1;
                rotateGears.add(new Rotate(right, direction));
                right++;
            } else {
                break;
            }
        }

        return rotateGears;
    }

    private static void rotateGears(int[][] gears, List<Rotate> rotateGears) {
        rotateGears.forEach(gear -> rotate(gears, gear.gearIndex, gear.direction));
    }

    private static void rotate(int[][] gears, int gearIndex, int direction) {
        if (direction == CLOCKWISE) {
            int temp = gears[gearIndex][GEAR_SIZE - 1];
            for (int i = GEAR_SIZE - 1; i > 0; i--) {
                gears[gearIndex][i] = gears[gearIndex][i - 1];
            }
            gears[gearIndex][0] = temp;
        } else if (direction == COUNTER_CLOCKWISE) {
            int temp = gears[gearIndex][0];
            for (int i = 0; i < GEAR_SIZE - 1; i++) {
                gears[gearIndex][i] = gears[gearIndex][i + 1];
            }
            gears[gearIndex][GEAR_SIZE - 1] = temp;
        }
    }

    private static int getCount(int[][] gears) {
        int count = 0;
        for (int i = 0; i < gearCount; i++) {
            if (gears[i][0] == 1) count++;
        }
        return count;
    }

    static class Rotate {
        int gearIndex;
        int direction;

        public Rotate(int gearIndex, int direction) {
            this.gearIndex = gearIndex;
            this.direction = direction;
        }
    }
}
