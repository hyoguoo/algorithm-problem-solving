/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11576
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaseConversion {

    static final int MAX_SIZE = 32;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] baseInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int originalBase = baseInfo[0];
        int targetBase = baseInfo[1];
        bufferedReader.readLine();
        int[] originalNumber = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(originalNumber, originalBase, targetBase));
    }

    private static String solution(int[] originalNumber, int originalBase, int targetBase) {
        int decimalNumber = convertToDecimal(originalNumber, originalBase);
        int[] targetNumber = convertToTarget(decimalNumber, targetBase);
        return convertToReverseString(targetNumber);
    }

    private static int convertToDecimal(int[] originalNumber, int originalBase) {
        int result = 0;

        for (int i = 0; i < originalNumber.length; i++) {
            result += (int) (originalNumber[i] *
                    Math.pow(originalBase, originalNumber.length - (double) (i + 1)));
        }

        return result;
    }

    private static int[] convertToTarget(int decimalNumber, int targetBase) {
        int[] result = new int[MAX_SIZE];
        int index = 0;

        while (decimalNumber > 0) {
            result[index++] = decimalNumber % targetBase;
            decimalNumber /= targetBase;
        }

        return Arrays.copyOf(result, index);
    }

    private static String convertToReverseString(int[] targetNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = targetNumber.length - 1; i >= 0; i--) {
            stringBuilder.append(targetNumber[i]).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
