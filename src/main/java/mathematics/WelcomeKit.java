/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30802
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WelcomeKit {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantCount = Integer.parseInt(bufferedReader.readLine());
        int[] shirtNeededCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bundleSizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int shirtBundleSize = bundleSizeInfo[0];
        int pencilBundleSize = bundleSizeInfo[1];

        System.out.print(
                solution(participantCount, shirtNeededCounts, shirtBundleSize, pencilBundleSize)
        );
    }

    private static String solution(
            int participantCount,
            int[] shirtNeededCounts,
            int shirtBundleSize,
            int pencilBundleSize
    ) {
        int shirtBundlesNeeded = 0;

        for (int shirtNeeded : shirtNeededCounts) {
            shirtBundlesNeeded += (int) Math.ceil((double) shirtNeeded / shirtBundleSize);
        }

        int pencilBundlesNeeded= participantCount / pencilBundleSize;
        int remainderCount = participantCount % pencilBundleSize;

        return shirtBundlesNeeded + "\n" + pencilBundlesNeeded + " " + remainderCount;
    }
}
