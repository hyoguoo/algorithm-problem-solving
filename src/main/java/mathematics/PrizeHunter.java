/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15953
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrizeHunter {

    static RankPrize[] firstFestivalPrizes = {
            new RankPrize(1, 5000000),
            new RankPrize(3, 3000000),
            new RankPrize(6, 2000000),
            new RankPrize(10, 500000),
            new RankPrize(15, 300000),
            new RankPrize(21, 100000)
    };
    static RankPrize[] secondFestivalPrizes = {
            new RankPrize(1, 5120000),
            new RankPrize(3, 2560000),
            new RankPrize(7, 1280000),
            new RankPrize(15, 640000),
            new RankPrize(31, 320000)
    };

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int firstFestivalRank = info[0];
            int secondFestivalRank = info[1];

            stringBuilder
                    .append(solution(firstFestivalRank, secondFestivalRank))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int firstFestivalRank, int secondFestivalRank) {
        return getPrize(firstFestivalPrizes, firstFestivalRank)
                + getPrize(secondFestivalPrizes, secondFestivalRank);
    }

    static int getPrize(RankPrize[] prizes, int rank) {
        if (rank == 0) {
            return 0;
        }

        return Arrays.stream(prizes)
                .filter(prize -> rank <= prize.rankThreshold)
                .findFirst()
                .map(prize -> prize.prizeAmount)
                .orElse(0);
    }

    static class RankPrize {

        int rankThreshold;
        int prizeAmount;

        public RankPrize(int rankThreshold, int prizeAmount) {
            this.rankThreshold = rankThreshold;
            this.prizeAmount = prizeAmount;
        }
    }
}
