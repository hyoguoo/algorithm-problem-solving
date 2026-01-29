/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34722
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class HowManyExaminers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantCount = Integer.parseInt(bufferedReader.readLine());

        Participant[] participants = new Participant[participantCount];
        for (int i = 0; i < participantCount; i++) {
            int[] data = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            participants[i] = new Participant(data[0], data[1], data[2], data[3]);
        }

        System.out.print(solution(participants));
    }

    private static long solution(Participant[] participants) {
        return Arrays.stream(participants)
                .filter(p -> QualificationCriteria.BOJ_SOLVED.isQualified(p.getBojSolved()) ||
                        QualificationCriteria.CODEFORCES_RATING.isQualified(p.getCfRating()) ||
                        QualificationCriteria.ATCODER_RATING.isQualified(p.getAtcoderRating()) ||
                        QualificationCriteria.ICPC_RANK.isQualified(p.getIcpcRank()))
                .count();
    }

    enum QualificationCriteria {
        BOJ_SOLVED(1000, false),
        CODEFORCES_RATING(1600, false),
        ATCODER_RATING(1500, false),
        ICPC_RANK(30, true);

        private final int threshold;
        private final IntPredicate qualifier;

        QualificationCriteria(int threshold, boolean isIcpRule) {
            this.threshold = threshold;
            if (isIcpRule) {
                this.qualifier = value -> value != -1 && value <= this.threshold;
            } else {
                this.qualifier = value -> value >= this.threshold;
            }
        }

        public boolean isQualified(int value) {
            return qualifier.test(value);
        }
    }

    static class Participant {

        private final int bojSolved;
        private final int cfRating;
        private final int atcoderRating;
        private final int icpcRank;

        public Participant(int bojSolved, int cfRating, int atcoderRating, int icpcRank) {
            this.bojSolved = bojSolved;
            this.cfRating = cfRating;
            this.atcoderRating = atcoderRating;
            this.icpcRank = icpcRank;
        }

        public int getBojSolved() {
            return bojSolved;
        }

        public int getCfRating() {
            return cfRating;
        }

        public int getAtcoderRating() {
            return atcoderRating;
        }

        public int getIcpcRank() {
            return icpcRank;
        }
    }
}
