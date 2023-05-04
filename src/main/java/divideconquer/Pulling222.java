/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17829
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pulling222 {

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < length; j++) {
                matrix[i][j] = numbers[j];
            }
        }

        System.out.println(solution(0, 0, length));
    }

    private static int solution(int x, int y, int length) {
        if (length == 2) {
            return getSecondLargestValue(matrix[x][y], matrix[x][y + 1], matrix[x + 1][y], matrix[x + 1][y + 1]);
        }

        int halfLength = length / 2;
        return getSecondLargestValue(
                solution(x, y, halfLength),
                solution(x, y + halfLength, halfLength),
                solution(x + halfLength, y, halfLength),
                solution(x + halfLength, y + halfLength, halfLength)
        );
    }

    private static int getSecondLargestValue(int number1, int number2, int number3, int number4) {
        int[] numbers = {number1, number2, number3, number4};
        Arrays.sort(numbers);
        return numbers[2];
    }
}
