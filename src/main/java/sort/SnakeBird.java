/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16435
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SnakeBird {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int snakeLength = info[1];
        int[] fruits = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(fruits, snakeLength));
    }

    private static int solution(int[] fruits, int snakeLength) {
        Arrays.sort(fruits);

        for (int fruit : fruits) {
            if (fruit <= snakeLength) snakeLength++;
            else break;
        }

        return snakeLength;
    }
}
