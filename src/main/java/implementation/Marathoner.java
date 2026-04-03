/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9339
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Marathoner {

    private static final int CERTIFICATE_LIMIT_MINUTES = 360;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            bufferedReader.readLine();
            Set<Integer> academyStudentIds = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(HashSet::new));

            int totalParticipantCount = Integer.parseInt(bufferedReader.readLine().trim());
            ParticipantResult[] results = new ParticipantResult[totalParticipantCount];
            for (int i = 0; i < totalParticipantCount; i++) {
                int[] info = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .toArray();
                results[i] = new ParticipantResult(info[0], info[1], info[2]);
            }

            resultBuilder.append(solution(academyStudentIds, results)).append("\n");
        }

        System.out.print(resultBuilder.toString().trim());
    }

    private static Result solution(Set<Integer> academyStudentIds, ParticipantResult[] results) {
        int bestStudentId = -1;
        int bestTime = Integer.MAX_VALUE;
        int certificateCount = 0;

        for (ParticipantResult result : results) {
            if (!academyStudentIds.contains(result.id) || result.isDroppedOut()) {
                continue;
            }

            int totalMinutes = result.getTotalMinutes();

            if (totalMinutes <= CERTIFICATE_LIMIT_MINUTES) {
                certificateCount++;
                if (totalMinutes < bestTime) {
                    bestTime = totalMinutes;
                    bestStudentId = result.id;
                }
            }
        }

        return new Result(bestStudentId, certificateCount);
    }

    static class Result {

        private final int bestStudentId;
        private final int certificateCount;

        public Result(int bestStudentId, int certificateCount) {
            this.bestStudentId = bestStudentId;
            this.certificateCount = certificateCount;
        }

        @Override
        public String toString() {
            return bestStudentId + " " + certificateCount;
        }
    }

    static class ParticipantResult {

        private final int id;
        private final int hours;
        private final int minutes;

        public ParticipantResult(int id, int hours, int minutes) {
            this.id = id;
            this.hours = hours;
            this.minutes = minutes;
        }

        public boolean isDroppedOut() {
            return hours == -1 || minutes == -1;
        }

        public int getTotalMinutes() {
            return hours * 60 + minutes;
        }
    }
}
