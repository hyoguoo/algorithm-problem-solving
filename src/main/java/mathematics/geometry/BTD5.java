/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22238
 * Cheat Level: 3
 * Algorithm: Mathematics / Geometry / Implementation
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BTD5 {

    final static List<Integer> targetList = new ArrayList<>();
    final static List<Damage> damageList = new ArrayList<>();
    static int targetX, targetY;

    public static void main(String[] args) throws IOException {
        init();

        List<Integer> result = solution();
        printResult(result);
    }

    private static List<Integer> solution() {
        targetList.sort(Integer::compareTo);

        List<Integer> result = new ArrayList<>();
        int totalDamage = 0;
        int left = 0;

        for (Damage damage : damageList) {
            if (targetList.size() == left || (damage.x != targetX || damage.y != targetY)) {
                result.add(targetList.size() - left);
                continue;
            }

            totalDamage += damage.damage;
            int right = targetList.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (targetList.get(mid) <= totalDamage) left = mid + 1;
                else right = mid - 1;
            }

            result.add(targetList.size() - left);
        }

        return result;
    }

    public static int[] getDir(int x, int y) {
        if (x == 0 && y == 0) return new int[]{0, 0};
        else if (x == 0 && y < 0) return new int[]{0, -1};
        else if (x == 0) return new int[]{0, 1};
        else if (y == 0 && x < 0) return new int[]{-1, 0};
        else if (y == 0) return new int[]{1, 0};
        else {
            int g = gcd(Math.abs(x), Math.abs(y));
            x = x / g;
            y = y / g;
            return new int[]{x, y};
        }
    }

    public static int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    private static void printResult(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : result) {
            stringBuilder.append(integer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] countInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int targetCount = countInfo[0];
        int gunCount = countInfo[1];
        int x = 0;
        int y = 0;
        while (targetCount-- > 0) {
            int[] targetInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x = targetInfo[0];
            y = targetInfo[1];
            targetList.add(targetInfo[2]);
        }
        int[] gcdInfo = getDir(x, y);
        targetX = gcdInfo[0];
        targetY = gcdInfo[1];

        while (gunCount-- > 0) {
            int[] gunInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            damageList.add(new Damage(gunInfo[0], gunInfo[1], gunInfo[2]));
        }
    }

    static class Damage {
        int x;
        int y;
        int damage;

        public Damage(int x, int y, int damage) {
            int[] dir = getDir(x, y);
            this.x = dir[0];
            this.y = dir[1];
            this.damage = damage;
        }
    }
}
