/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23037
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PassionOfFive {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String input) {
        return Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .map(PassionOfFive::powerOfFive)
                .sum();
    }

    private static int powerOfFive(int number) {
        return (int) Math.pow(number, 5);
    }
}
