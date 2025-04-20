/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11945
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HotTaiyaki {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lineCount = info[0];

        String[] inputs = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            inputs[i] = bufferedReader.readLine();
        }

        System.out.print(solution(inputs));
    }

    private static String solution(String[] inputs) {
        return Arrays.stream(inputs)
                .map(input -> new StringBuilder(input).reverse().toString())
                .collect(Collectors.joining("\n"));
    }
}
