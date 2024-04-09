/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18310
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Antenna {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseNumbers()));
    }

    private static int[] parseNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();

        return Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int solution(int[] numbers) {
        Arrays.sort(numbers);

        return numbers[(numbers.length - 1) / 2];
    }
}
