/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 5주차 문제 1
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AntsAndAphids {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int length = infos[0];
        int distance = infos[1];
        ArrayList<Integer[]> ants = new ArrayList<>();
        ArrayList<Integer[]> aphids = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < length; j++) {
                if (line[j] == 1) ants.add(new Integer[]{i, j});
                if (line[j] == 2) aphids.add(new Integer[]{i, j});
            }
        }
        System.out.println(solution(ants, aphids, distance));
    }

    public static int solution(ArrayList<Integer[]> ants, ArrayList<Integer[]> aphids, int distance) {
        int count = 0;
        for (Integer[] ant : ants) {
            for (Integer[] aphid : aphids) {
                if (getManhattanDistance(ant, aphid) <= distance) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int getManhattanDistance(Integer[] p1, Integer[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
