/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2776
 * Cheat Level: 0
 * Algorithm: Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MemorizationKing {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] note1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bufferedReader.readLine();
            int[] note2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Boolean> solution = solution(note1, note2);
            stringBuilder.append(print(solution)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static List<Boolean> solution(int[] note1, int[] note2) {
        Set<Integer> note1Set = Arrays.stream(note1).boxed().collect(Collectors.toSet());

        return Arrays.stream(note2)
                .mapToObj(note1Set::contains)
                .collect(Collectors.toList());
    }

    private static String print(List<Boolean> solution) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Boolean b : solution) {
            stringBuilder.append(Boolean.TRUE.equals(b) ? 1 : 0).append("\n");
        }

        return stringBuilder.toString().trim();
    }
}
