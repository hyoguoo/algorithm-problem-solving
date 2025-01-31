/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5533
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Unique {

    private static final int ROUND_COUNT = 3;
    private static final int MAX_SCORE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantCount = Integer.parseInt(bufferedReader.readLine());

        int[][] participants = new int[participantCount][ROUND_COUNT];

        for (int i = 0; i < participantCount; i++) {
            participants[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(participants));
    }

    private static String solution(int[][] participants) {
        int[] scores = new int[participants.length];

        for (int i = 0; i < ROUND_COUNT; i++) {
            int[] unique = new int[MAX_SCORE + 1];
            for (int[] participant : participants) {
                unique[participant[i]]++;
            }

            for (int j = 0; j < participants.length; j++) {
                if (unique[participants[j][i]] == 1) {
                    scores[j] += participants[j][i];
                }
            }
        }

        return Arrays.stream(scores)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));
    }
}
