/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1392
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MusicNotes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] notes = new int[info[0]];
        int[] queries = new int[info[1]];

        for (int i = 0; i < info[0]; i++) {
            notes[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < info[1]; i++) {
            queries[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(
                Arrays.stream(solution(notes, queries))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private static int[] solution(int[] notes, int[] queries) {
        int[] prefixSums = new int[notes.length + 1];
        for (int i = 0; i < notes.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + notes[i];
        }
        return Arrays.stream(queries)
                .map(query -> findNoteIndex(prefixSums, query))
                .toArray();
    }

    private static int findNoteIndex(int[] prefixSums, int query) {
        return IntStream.range(0, prefixSums.length)
                .filter(i -> prefixSums[i] > query)
                .findFirst()
                .orElseThrow();
    }
}
