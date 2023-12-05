/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1138
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandInLine {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers).toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            int height = i + 1;
            int leftCount = numbers[i];
            result.add(leftCount, height);
        }

        return result;
    }
}
