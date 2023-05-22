/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2473
 * Cheat Level: 2
 * Algorithm: Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeSolution {

    public static void main(String[] args) throws IOException {
        printResult(solution(getNumbers()));
    }

    private static long[] getNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(numbers);
        return numbers;
    }

    private static Answer solution(long[] numbers) {
        Answer answer = new Answer(numbers[0], numbers[1], numbers[numbers.length - 1], Math.abs(numbers[0] + numbers[1] + numbers[numbers.length - 1]));

        for (int x = 0; x <= numbers.length - 3; x++) {
            int y = x + 1;
            int z = numbers.length - 1;

            while (y < z) {
                long sum = numbers[x] + numbers[y] + numbers[z];
                long absSum = Math.abs(sum);
                if (absSum < answer.difference) {
                    answer = new Answer(numbers[x], numbers[y], numbers[z], absSum);
                }

                if (sum < 0) y++;
                else if (sum > 0) z--;
                else break;
            }
        }

        return answer;
    }

    private static void printResult(Answer answer) {
        System.out.println(answer.x + " " + answer.y + " " + answer.z);
    }


    static class Answer {
        long x;
        long y;
        long z;
        long difference;

        public Answer(long x, long y, long z, long difference) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.difference = difference;
        }
    }
}
