/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1205
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindRank {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays
                .stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (info[0] == 0) {
            System.out.print(1);
            return;
        }

        int[] scores = Arrays
                .stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(scores, info[1], info[2]));
    }

    private static int solution(int[] scores, int myScore, int rankLimit) {
        int rank = 1;
        int sameScoreCount = 0;

        for (int score : scores) {
            if (score > myScore) {
                rank++;
            } else if (score == myScore) {
                sameScoreCount++;
            }
        }

        return rank + sameScoreCount > rankLimit
                ? -1
                : rank;
    }
}
