/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4619
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Root {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int target = info[0];
            int power = info[1];

            if (target == 0 && power == 0) {
                break;
            }

            stringBuilder.append(solution(target, power))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int target, int power) {
        double approxRoot = Math.pow(target, 1.0 / power);

        int baseFloor = (int) Math.floor(approxRoot);
        int baseCeil = (int) Math.ceil(approxRoot);

        int closestBase = baseFloor;
        long minDiff = Long.MAX_VALUE;

        for (int candidate = baseFloor - 1; candidate <= baseCeil + 1; candidate++) {
            if (candidate <= 0) {
                continue;
            }

            long value = pow(candidate, power);
            long diff = Math.abs(value - target);

            if (diff < minDiff) {
                minDiff = diff;
                closestBase = candidate;
            }
        }

        return closestBase;
    }

    private static long pow(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}
