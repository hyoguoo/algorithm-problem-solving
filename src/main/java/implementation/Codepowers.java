/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26007
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codepowers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int queryCount = info[1];
        int targetRating = info[2];
        int initRating = info[3];

        int[] ratingIncreases = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Query> queries = new ArrayList<>();
        for (int i = 0; i < queryCount; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queries.add(new Query(input[0], input[1]));
        }

        solution(targetRating, initRating, ratingIncreases, queries);
    }

    private static void solution(int targetRating, int initRating, int[] ratingIncreases, List<Query> queries) {
        int[] ratings = calculateRating(initRating, ratingIncreases);
        int[] lowRatingCount = calculateLowRatingCount(targetRating, ratings);

        printResult(queries, lowRatingCount);
    }

    private static int[] calculateRating(int initRating, int[] ratingIncreases) {
        int[] ratings = new int[ratingIncreases.length + 1];
        ratings[0] = initRating;

        for (int i = 1; i < ratings.length; i++) {
            ratings[i] = ratings[i - 1] + ratingIncreases[i - 1];
        }

        return ratings;
    }

    private static int[] calculateLowRatingCount(int targetRating, int[] ratings) {
        int[] llowRatingCount = new int[ratings.length];
        
        for (int i = 1; i < llowRatingCount.length; i++) {
            if (ratings[i] < targetRating) llowRatingCount[i] = llowRatingCount[i - 1] + 1;
            else llowRatingCount[i] = llowRatingCount[i - 1];
        }

        return llowRatingCount;
    }

    private static void printResult(List<Query> queries, int[] lowRatingCount) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Query query : queries) {
            stringBuilder.append(lowRatingCount[query.rightRound - 1] - lowRatingCount[query.leftRound - 1]).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    static class Query {
        int leftRound;
        int rightRound;

        public Query(int leftRound, int rightRound) {
            this.leftRound = leftRound;
            this.rightRound = rightRound;
        }
    }
}
