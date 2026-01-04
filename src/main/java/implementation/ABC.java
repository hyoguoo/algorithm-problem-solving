/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3047
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ABC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String abc = bufferedReader.readLine();

        System.out.print(solution(numbers, abc));
    }

    private static String solution(int[] numbers, String abc) {
        int[] sorted = Arrays.stream(numbers)
                .sorted()
                .toArray();

        return abc.chars()
                .mapToObj(c -> {
                    if (c == 'A') {
                        return String.valueOf(sorted[0]);
                    } else if (c == 'B') {
                        return String.valueOf(sorted[1]);
                    } else if (c == 'C') {
                        return String.valueOf(sorted[2]);
                    } else {
                        throw new IllegalArgumentException();
                    }
                })
                .collect(Collectors.joining(" "));
    }
}
