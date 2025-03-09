/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9316
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HelloJudge {

    private static final String PRINT_FORMAT = "Hello World, Judge %d!";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> String.format(PRINT_FORMAT, i))
                .collect(Collectors.joining("\n"));
    }
}
