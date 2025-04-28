/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30703
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AdjustingTemperature {

    private static final int IMPOSSIBLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        int[] currentTemperatures = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] targetTemperatures = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] temperatureAdjustments = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(currentTemperatures, targetTemperatures, temperatureAdjustments));
    }

    private static int solution(int[] currentTemperatures, int[] targetTemperatures, int[] temperatureAdjustments) {
        int[] neededChangeCounts = IntStream.range(0, currentTemperatures.length)
                .map(i ->
                        calculateChangeCount(currentTemperatures[i], targetTemperatures[i], temperatureAdjustments[i]))
                .toArray();

        if (isImpossible(neededChangeCounts)) {
            return IMPOSSIBLE;
        }

        return Arrays.stream(neededChangeCounts).max()
                .orElseThrow();
    }

    private static boolean isImpossible(int[] neededChangeCounts) {
        return hasImpossibleChange(neededChangeCounts) ||
                hasMixedParityChangeCounts(neededChangeCounts);
    }

    private static boolean hasMixedParityChangeCounts(int[] neededChangeCounts) {
        return !Arrays.stream(neededChangeCounts).allMatch(count -> count % 2 == 0) &&
                !Arrays.stream(neededChangeCounts).allMatch(count -> count % 2 == 1);
    }

    private static boolean hasImpossibleChange(int[] neededChangeCounts) {
        return Arrays.stream(neededChangeCounts).anyMatch(count -> count == IMPOSSIBLE);
    }

    private static int calculateChangeCount(int currentTemperature, int targetTemperature, int temperatureAdjustment) {
        int temperatureDiff = Math.abs(currentTemperature - targetTemperature);
        int remainingTemperature = temperatureDiff % temperatureAdjustment;

        return remainingTemperature == 0
                ? temperatureDiff / temperatureAdjustment
                : IMPOSSIBLE;
    }
}
