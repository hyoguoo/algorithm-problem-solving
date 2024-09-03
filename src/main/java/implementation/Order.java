/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9011
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int[] numbers) {
        List<Integer> availableNumberList = getAvailableNumberList(numbers);
        int[] answer = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i--) {
            int diff = i - numbers[i];

            if (diff < 0) {
                return "IMPOSSIBLE";
            }

            answer[i] = availableNumberList.remove(diff);
        }

        return Arrays.toString(answer).replaceAll("[\\[\\],]", "");
    }

    private static List<Integer> getAvailableNumberList(int[] numbers) {
        List<Integer> availableNumberList = new ArrayList<>();
        for (int i = numbers.length; i > 0; i--) {
            availableNumberList.add(i);
        }
        return availableNumberList;
    }
}
