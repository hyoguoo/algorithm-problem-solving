/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 1
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfPaths {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long result = getPaths(length, numberArray);
        System.out.println(result);
    }

    public static long getPaths(int length, int[] numberArray) {
        long result = 1;
        for (int i = 0; i < length; i++) {
            result *= numberArray[i];
        }
        return result;
    }
}
