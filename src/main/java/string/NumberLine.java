/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4470
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberLine {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        String[] lines = new String[lineCount];
        for (int i = 0; i < lineCount; i++) {
            lines[i] = bufferedReader.readLine();
        }

        System.out.print(solution(lines));
    }

    private static String solution(String[] lines) {
        return IntStream.range(0, lines.length)
                .mapToObj(i -> String.format("%d. %s", i + 1, lines[i]))
                .collect(Collectors.joining("\n"));
    }
}
