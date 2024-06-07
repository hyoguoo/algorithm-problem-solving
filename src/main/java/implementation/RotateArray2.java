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

public class RotateArray2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        int rotateCount = info[2];
        int[][] array = new int[sizeN][sizeM];
        for (int n = 0; n < sizeN; n++) {
            array[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(array, rotateCount));
    }

    private static String solution(int[][] array, int rotateCount) {
        return printArray(rotateArrayNTimes(array, rotateCount));
    }

    private static String printArray(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] line : array) {
            for (int j = 0; j < array[0].length; j++) {
                stringBuilder.append(line[j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private static int[][] rotateArrayNTimes(int[][] array, int rotateCount) {
        int[][] result = new int[array.length][array[0].length];
        int maxDepth = calculateDepth(array);

        for (int depth = 0; depth < maxDepth; depth++) {
            int[] temp = getPerimeterElements(array, depth);
            int[] rotatedTemp = rotateArray(temp, rotateCount);

            assignRotatedElements(result, rotatedTemp, depth);
        }

        return result;
    }

    private static int calculateDepth(int[][] array) {
        return Math.min(array.length, array[0].length) / 2;
    }

    private static int[] getPerimeterElements(int[][] array, int depth) {
        int[] temp = new int[calculatePerimeter(array, depth)];

        int index = 0;
        for (int i = depth; i < array.length - depth; i++) {
            temp[index++] = array[i][depth];
        }
        for (int i = depth + 1; i < array[0].length - depth; i++) {
            temp[index++] = array[array.length - depth - 1][i];
        }
        for (int i = array.length - depth - 2; i >= depth; i--) {
            temp[index++] = array[i][array[0].length - depth - 1];
        }
        for (int i = array[0].length - depth - 2; i > depth; i--) {
            temp[index++] = array[depth][i];
        }

        return temp;
    }

    private static int[] rotateArray(int[] array, int rotateCount) {
        int[] rotatedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            rotatedArray[(i + rotateCount) % array.length] = array[i];
        }

        return rotatedArray;
    }

    private static void assignRotatedElements(int[][] result, int[] rotatedTemp, int depth) {
        int index = 0;

        for (int i = depth; i < result.length - depth; i++) {
            result[i][depth] = rotatedTemp[index++];
        }
        for (int i = depth + 1; i < result[0].length - depth; i++) {
            result[result.length - depth - 1][i] = rotatedTemp[index++];
        }
        for (int i = result.length - depth - 2; i >= depth; i--) {
            result[i][result[0].length - depth - 1] = rotatedTemp[index++];
        }
        for (int i = result[0].length - depth - 2; i > depth; i--) {
            result[depth][i] = rotatedTemp[index++];
        }
    }

    private static int calculatePerimeter(int[][] array, int d) {
        return (array.length - d * 2) * 2 + (array[0].length - d * 2) * 2 - 4;
    }
}
