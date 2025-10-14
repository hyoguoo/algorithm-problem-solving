/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1592
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YoungsikAndFriends {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2]));
    }

    private static int solution(int numberOfFriends, int targetReceives, int step) {
        int[] receiveCounts = new int[numberOfFriends];
        int currentIndex = 0;
        receiveCounts[0] = 1;

        for (int throwsCount = 0; ; throwsCount++) {
            if (receiveCounts[currentIndex] >= targetReceives) {
                return throwsCount;
            }

            currentIndex = (receiveCounts[currentIndex] % 2 == 1)
                    ? (currentIndex + step) % numberOfFriends
                    : Math.floorMod(currentIndex - step, numberOfFriends);

            receiveCounts[currentIndex]++;
        }
    }
}
