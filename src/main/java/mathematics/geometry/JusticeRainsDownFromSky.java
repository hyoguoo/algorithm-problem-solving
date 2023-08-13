/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13411
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry / Sort
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JusticeRainsDownFromSky {

    public static void main(String[] args) throws IOException {
        List<Missile> missileList = getInput();
        sort(missileList);
        printResult(missileList);
    }

    private static void printResult(List<Missile> missileList) {
        StringBuilder stringBuilder = new StringBuilder();
        missileList.forEach(missile -> stringBuilder.append(missile.index).append("\n"));
        System.out.println(stringBuilder);
    }

    private static void sort(List<Missile> missileList) {
        missileList.sort((o1, o2) -> {
            double distance1 = Math.sqrt(Math.pow(o1.targetX, 2) + Math.pow(o1.targetY, 2));
            double distance2 = Math.sqrt(Math.pow(o2.targetX, 2) + Math.pow(o2.targetY, 2));
            if (distance1 / o1.speed == distance2 / o2.speed) return Integer.compare(o1.index, o2.index);
            return Double.compare(distance1 / o1.speed, distance2 / o2.speed);
        });
    }

    private static List<Missile> getInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Missile> missileList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int[] missileInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            missileList.add(new Missile(i, missileInfo[0], missileInfo[1], missileInfo[2]));
        }
        return missileList;
    }

    static class Missile {
        int index;
        int targetX;
        int targetY;
        int speed;

        public Missile(int index, int targetX, int targetY, int speed) {
            this.index = index;
            this.targetX = targetX;
            this.targetY = targetY;
            this.speed = speed;
        }
    }
}
