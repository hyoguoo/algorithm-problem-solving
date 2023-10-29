/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10867
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveDuplicatesSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(numbers);
    }

    private static void solution(int[] numbers) {
        Arrays.sort(numbers);
        StringBuilder stringBuilder = new StringBuilder();
        int previous = numbers[0];
        stringBuilder.append(previous).append(" ");

        for (int i = 1; i < numbers.length; i++) {
            if (previous == numbers[i]) continue;
            previous = numbers[i];
            stringBuilder.append(previous).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
