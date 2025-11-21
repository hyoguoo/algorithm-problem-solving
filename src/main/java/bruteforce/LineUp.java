/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1681
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LineUp {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static int solution(int studentCount, int forbiddenDigit) {
        int assignedCount = 0;
        int currentLabel = 0;

        while (assignedCount < studentCount) {
            currentLabel++;

            if (!containsForbiddenDigit(currentLabel, forbiddenDigit)) {
                assignedCount++;
            }
        }

        return currentLabel;
    }

    private static boolean containsForbiddenDigit(int number, int forbiddenDigit) {
        while (number > 0) {
            int digit = number % 10;
            if (digit == forbiddenDigit) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
