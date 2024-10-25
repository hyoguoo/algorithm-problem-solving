/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3040
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SnowWhiteAndSevenDwarfs {

    private static final int DWARF_COUNT = 9;
    private static final int TOTAL_DWARF_SUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[DWARF_COUNT];

        for (int i = 0; i < DWARF_COUNT; i++) {
            dwarfs[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(dwarfs));
    }

    private static String solution(int[] dwarfs) {
        int sum = Arrays.stream(dwarfs).sum();

        for (int i = 0; i < DWARF_COUNT; i++) {
            for (int j = i + 1; j < DWARF_COUNT; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == TOTAL_DWARF_SUM) {
                    return getAnswer(dwarfs, i, j);
                }
            }
        }

        throw new IllegalArgumentException();
    }

    private static String getAnswer(int[] dwarfs, int n1, int n2) {
        return Arrays.stream(dwarfs)
                .filter(dwarf -> dwarf != dwarfs[n1] && dwarf != dwarfs[n2])
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + "\n" + b)
                .orElseThrow(IllegalArgumentException::new);
    }
}
