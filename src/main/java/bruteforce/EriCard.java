/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15728
 * Cheat Level: 0
 * Algorithm: Implementation / Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EriCard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int blockCardCount = info[1];
        int[] sharedCards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] teamCards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(sharedCards, teamCards, blockCardCount));
    }

    private static int solution(int[] sharedCards, int[] teamCards, int blockCardCount) {
        int maxSharedCard = Arrays.stream(sharedCards).max().orElseThrow();
        int minSharedCard = Arrays.stream(sharedCards).min().orElseThrow();

        return Arrays.stream(teamCards)
                .map(t -> calculateBestScore(t, maxSharedCard, minSharedCard))
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(blockCardCount)
                .findFirst()
                .orElseThrow();
    }

    private static int calculateBestScore(int teamCard, int maxSharedCard, int minSharedCard) {
        return Math.max(teamCard * maxSharedCard, teamCard * minSharedCard);
    }
}
