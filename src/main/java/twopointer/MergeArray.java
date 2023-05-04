/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11728
 * Cheat Level: 3
 * Algorithm: Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] array1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = merge(array1, array2);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : result) stringBuilder.append(i).append(" ");
        System.out.println(stringBuilder);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) result[index++] = array1[index1++];
            else result[index++] = array2[index2++];
        }
        while (index1 < array1.length) result[index++] = array1[index1++];
        while (index2 < array2.length) result[index++] = array2[index2++];
        return result;
    }
}
