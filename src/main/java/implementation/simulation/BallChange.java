/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10813
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BallChange {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ballCount = info[0];
        int changeCount = info[1];

        int[] balls = getBallsArray(ballCount);

        for (int i = 0; i < changeCount; i++) {
            int[] changeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            swapBalls(changeInfo, balls);
        }

        printArray(balls);
    }

    private static void swapBalls(int[] changeInfo, int[] balls) {
        int ball1 = changeInfo[0];
        int ball2 = changeInfo[1];
        int temp = balls[ball1];
        balls[ball1] = balls[ball2];
        balls[ball2] = temp;
    }

    private static int[] getBallsArray(int ballCount) {
        int[] balls = new int[ballCount + 1];
        for (int i = 1; i <= ballCount; i++) balls[i] = i;
        return balls;
    }

    private static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= array.length - 1; i++) stringBuilder.append(array[i]).append(" ");
        System.out.print(stringBuilder);
    }
}
