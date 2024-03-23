/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2587
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepresentativeValue2 {

    static final int NUMBER_OF_ELEMENTS = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[NUMBER_OF_ELEMENTS];

        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        Arrays.sort(numbers);

        int mean = Arrays.stream(numbers).sum() / NUMBER_OF_ELEMENTS;
        int median = numbers[NUMBER_OF_ELEMENTS / 2];

        return mean + "\n" + median;
    }
}
