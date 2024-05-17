/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1713
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class NominateCandidates {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        int[] votes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(target, votes));
    }

    private static String solution(int target, int[] votes) {
        PriorityQueue<Candidate> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.recommendCount == o2.recommendCount) {
                        return o2.time - o1.time;
                    }
                    return o1.recommendCount - o2.recommendCount;
                }
        );

        for (int vote : votes) {
            Optional<Candidate> candidate = findCandidate(priorityQueue, vote);

            if (candidate.isPresent()) {
                candidate.get().recommend();
            } else {
                if (priorityQueue.size() == target) {
                    priorityQueue.poll();
                }
                priorityQueue.add(new Candidate(vote));
            }

            updateCandidateTimes(priorityQueue);
        }

        return getSortedCandidate(priorityQueue);
    }

    private static void updateCandidateTimes(PriorityQueue<Candidate> priorityQueue) {
        priorityQueue.forEach(Candidate::updateTime);
        PriorityQueue<Candidate> temp = new PriorityQueue<>(priorityQueue);
        priorityQueue.clear();
        priorityQueue.addAll(temp);
    }

    private static String getSortedCandidate(PriorityQueue<Candidate> priorityQueue) {
        StringBuilder stringBuilder = new StringBuilder();

        priorityQueue.stream()
                .sorted(Comparator.comparingInt(Candidate::getNumber))
                .forEach(candidate -> stringBuilder.append(candidate.getNumber()).append(" "));

        return stringBuilder.toString().trim();
    }

    private static Optional<Candidate> findCandidate(
            PriorityQueue<Candidate> priorityQueue,
            int vote
    ) {
        return priorityQueue.stream()
                .filter(candidate -> candidate.getNumber() == vote)
                .findFirst();
    }

    static class Candidate {

        private final int number;
        private int recommendCount;
        private int time;

        public Candidate(int number) {
            this.number = number;
            this.recommendCount = 1;
            this.time = 0;
        }

        public void recommend() {
            recommendCount++;
        }

        public void updateTime() {
            time++;
        }

        public int getNumber() {
            return number;
        }
    }
}
