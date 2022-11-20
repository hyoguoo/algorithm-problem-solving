/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1292
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EasyProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startIndex = numbers[0];
        int endIndex = numbers[1];

        System.out.println(solution(startIndex, endIndex));
    }

    private static int solution(int startIndex, int endIndex) {
        int sum = 0;
        int currentNumber = 1;
        int index = 0;

        while (true) {
            for (int i = 1; i <= currentNumber; i++) {
                index++;
                if (startIndex <= index && index <= endIndex) sum += currentNumber;
                if (index == endIndex) return sum;
            }
            currentNumber++;
        }
    }
}
