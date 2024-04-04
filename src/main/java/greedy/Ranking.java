/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2012
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ranking {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        parseHopeRanking()
                )
        );
    }

    private static int[] parseHopeRanking() throws IOException {
        int studentCount = Integer.parseInt(BUFFERED_READER.readLine());
        int[] hopeRanking = new int[studentCount + 1];

        for (int i = 1; i <= studentCount; i++) {
            hopeRanking[i] = Integer.parseInt(BUFFERED_READER.readLine());
        }
        return hopeRanking;
    }

    private static long solution(int[] hopeRanking) {
        Arrays.sort(hopeRanking);

        return calculateUnsatisfiedRanking(hopeRanking);
    }

    private static long calculateUnsatisfiedRanking(int[] hopeRanking) {
        long unsatisfiedRanking = 0;

        for (int i = 1; i < hopeRanking.length; i++) {
            unsatisfiedRanking += Math.abs(i - hopeRanking[i]);
        }

        return unsatisfiedRanking;
    }
}
