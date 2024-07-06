/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10823
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Plus2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String input = bufferedReader.readLine();
            if (input == null) {
                break;
            }
            stringBuilder.append(input);
        }

        System.out.print(solution(stringBuilder.toString()));
    }

    private static int solution(String numberString) {
        return Arrays.stream(numberString.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
