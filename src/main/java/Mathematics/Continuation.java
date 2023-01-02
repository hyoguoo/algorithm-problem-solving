/*
 * goormlevel
 * https://level.goorm.io
 * 출제 그라운드: 지속
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Continuation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        while (numbers.length > 1) {
            int multiplyNumber = getMultiplyNumbers(numbers);
            numbers = intToArray(multiplyNumber);
            count++;
        }

        System.out.println(count);
    }

    public static int[] intToArray(int numbers) {
        return Arrays.stream(Integer.toString(numbers).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int getMultiplyNumbers(int[] numbers) {
        int result = 1;
        for (int number : numbers) result *= number;
        return result;
    }
}
