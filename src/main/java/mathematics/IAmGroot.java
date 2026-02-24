/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17283
 * Cheat Level: 0
 * Algorithm: Mathematics / Implementation
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IAmGroot {

    private static final int STOP_THRESHOLD = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int initialLength = Integer.parseInt(bufferedReader.readLine());
        int ratio = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(initialLength, ratio));
    }

    private static int solution(int initialLength, int ratio) {
        int totalLength = 0;
        int currentLevelLength = initialLength;
        int branchCount = 2;

        while (true) {
            currentLevelLength = calculateNextLength(currentLevelLength, ratio);

            if (isStopGrowth(currentLevelLength)) {
                break;
            }

            totalLength += currentLevelLength * branchCount;
            branchCount *= 2;
        }

        return totalLength;
    }

    private static int calculateNextLength(int currentLength, int ratio) {
        return (currentLength * ratio) / 100;
    }

    private static boolean isStopGrowth(int length) {
        return length <= STOP_THRESHOLD;
    }
}
