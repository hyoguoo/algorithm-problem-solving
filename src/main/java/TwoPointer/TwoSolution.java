/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2467 / 2470
 * Cheat Level: 0
 * Algorithm: Two Pointer
 */

package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        Answer answer = solution(numbers);
        System.out.println(answer.number1 + " " + answer.number2);
    }

    private static Answer solution(int[] numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        Answer answer = new Answer(numbers[0], numbers[numbers.length - 1], Math.abs(numbers[0] + numbers[numbers.length - 1]));

        while (startIndex < endIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];
            if (Math.abs(sum) < answer.difference) {
                answer = new Answer(numbers[startIndex], numbers[endIndex], Math.abs(sum));
            }

            if (sum < 0) startIndex++;
            else if (sum > 0) endIndex--;
            else break;

        }

        return answer;
    }

    static class Answer {
        int number1;
        int number2;
        int difference;

        public Answer(int number1, int number2, int difference) {
            this.number1 = number1;
            this.number2 = number2;
            this.difference = difference;
        }
    }
}
