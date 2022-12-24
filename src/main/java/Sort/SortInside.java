/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1427
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortInside {

    static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 0; i--) stringBuilder.append(numbers[i]);
        System.out.println(stringBuilder);
    }
}
