/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10989
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortNumbers3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[length];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) numbers[i] = Integer.parseInt(bufferedReader.readLine());
        Arrays.sort(numbers);

        for (int number : numbers) stringBuilder.append(number).append("\n");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        System.out.println(stringBuilder);
    }
}
