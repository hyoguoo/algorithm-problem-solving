/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17276
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayRotation {

    final static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < count; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = info[0];
            int rotateCount = getRotateCount(info[1]);
            int[][] array = new int[N][N];
            for (int j = 0; j < N; j++) {
                array[j] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int[][] rotatedArray = rotateArrayNTimes(array, rotateCount);
            appendArray(rotatedArray);
        }
        System.out.println(stringBuilder);
    }

    private static int getRotateCount(int rotate) {
        while (rotate < 0) rotate += 360;
        return rotate % 360 / 45;
    }

    private static void appendArray(int[][] rotatedArray) {
        for (int[] ints : rotatedArray) {
            for (int j = 0; j < rotatedArray.length; j++) {
                stringBuilder.append(ints[j]).append(" ");
            }
            stringBuilder.append("\n");
        }
    }

    private static int[][] rotateArrayNTimes(int[][] array, int count) {
        for (int i = 0; i < count; i++) array = rotateArray45(array);
        return array;
    }

    private static int[][] rotateArray45(int[][] srcArray) {
        int N = srcArray.length;
        int[][] rotatedArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) rotatedArray[i][N / 2] = srcArray[i][j];
                else if (i == N / 2) rotatedArray[j][j] = srcArray[i][j];
                else if (j == N / 2) rotatedArray[i][N - 1 - i] = srcArray[i][j];
                else if (i + j == N - 1) rotatedArray[N / 2][j] = srcArray[i][j];
                else rotatedArray[i][j] = srcArray[i][j];
            }
        }
        return rotatedArray;
    }
}
