/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 3
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestManhattanDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sortArray(numberArray);
        int result = getManhattanDistance(numberArray);
        System.out.println(result);
    }

    public static int getManhattanDistance(int[] numberArray) {
        return Math.abs(numberArray[3] - numberArray[0]) + Math.abs(numberArray[2] - numberArray[1]);
    }

    public static void sortArray(int[] numberArray) {
        Arrays.sort(numberArray);
    }
}
