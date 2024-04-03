/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25305
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutLine {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int limit = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, limit));
    }

    private static int solution(int[] numbers, int limit) {
        Arrays.sort(numbers);

        return numbers[numbers.length - limit];
    }
}
