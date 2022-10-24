/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 2주차 문제 4
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ImplementingBomb {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int arrayLength = array[0];
        int bombLength = array[1];

        int count = 0;
        for (int i = 0; i < bombLength; i++) {
            int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int num1 = numberArray[0];
            int num2 = numberArray[1];
            int plus = 5;
            if (num1 <= 1 || num1 >= arrayLength) plus--;
            if (num2 <= 1 || num2 >= arrayLength) plus--;
            count += plus;
        }
        if (arrayLength == 1) System.out.println(bombLength);
        else System.out.println(count);
    }
}
