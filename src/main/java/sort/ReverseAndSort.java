/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5648
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseAndSort {

    public static void main(String[] args) throws Exception {
        List<String> inputList = parseInput();

        System.out.print(solution(inputList));
    }

    private static List<String> parseInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLineTokens = new StringTokenizer(bufferedReader.readLine());
        firstLineTokens.nextToken();

        List<String> inputList = new ArrayList<>();

        while (firstLineTokens.hasMoreTokens()) {
            inputList.add(firstLineTokens.nextToken());
        }

        bufferedReader.lines()
                .forEach(line -> {
                    StringTokenizer lineTokens = new StringTokenizer(line);
                    while (lineTokens.hasMoreTokens()) {
                        inputList.add(lineTokens.nextToken());
                    }
                });

        return inputList;
    }

    private static String solution(List<String> input) {
        return String.join(
                "\n",
                input.stream()
                        .map(s -> new StringBuilder(s).reverse().toString())
                        .map(Long::parseLong)
                        .sorted()
                        .map(String::valueOf)
                        .toArray(String[]::new)
        );
    }
}
