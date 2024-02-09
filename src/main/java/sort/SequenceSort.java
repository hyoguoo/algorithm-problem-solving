/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1015
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(numbers);
    }

    private static void solution(int[] numbers) {
        List<Number> numberList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            numberList.add(new Number(i, numbers[i]));
        }

        numberList.sort((o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.index - o2.index;
            }
            return o1.value - o2.value;
        });

        int[] answer = new int[numbers.length];

        for (int i = 0; i < numberList.size(); i++) {
            answer[numberList.get(i).index] = i;
        }

        printArray(answer);
    }

    private static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : array) {
            stringBuilder.append(i).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    static class Number {
        int index;
        int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
