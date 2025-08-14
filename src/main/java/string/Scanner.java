/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3035
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Scanner {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeY = info[0];
        int sizeX = info[1];
        int scaleY = info[2];
        int scaleX = info[3];
        char[][] input = new char[sizeY][sizeX];

        for (int i = 0; i < sizeY; i++) {
            input[i] = bufferedReader.readLine().toCharArray();
        }

        System.out.print(
                Arrays.stream(solution(input, scaleY, scaleX))
                        .map(String::new)
                        .collect(Collectors.joining("\n"))
        );
    }

    private static char[][] solution(char[][] input, int scaleY, int scaleX) {
        return IntStream.range(0, input.length * scaleY)
                .mapToObj(row ->
                        IntStream.range(0, input[0].length * scaleX)
                                .mapToObj(col -> String.valueOf(input[row / scaleY][col / scaleX]))
                                .collect(Collectors.joining())
                                .toCharArray()
                )
                .toArray(char[][]::new);
    }
}
