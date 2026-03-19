/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11094
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SimonSays {

    private static final String PREFIX = "Simon says";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(bufferedReader.readLine());

        String[] inputs = new String[inputCount];

        for (int i = 0; i < inputCount; i++) {
            inputs[i] = bufferedReader.readLine();
        }

        System.out.print(Arrays.stream(solution(inputs)).collect(Collectors.joining(System.lineSeparator())));
    }

    private static String[] solution(String[] inputs) {
        return Arrays.stream(inputs)
                .filter(s -> s.startsWith(PREFIX))
                .map(s -> s.replaceFirst(PREFIX, ""))
                .toArray(String[]::new);
    }
}
