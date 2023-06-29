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
import java.util.LinkedList;
import java.util.List;

public class NominateCandidates {

    final static List<Candidate> candidateList = new LinkedList<>();
    static int CANDIDATE_COUNT;
    static int[] nominations;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        candidateList.sort(Comparator.comparingInt(o -> o.number));
        printResult();
    }

    private static void simulation() {
        for (int i = 0; i < nominations.length; i++) {
            solution(i);
        }
    }

    private static void solution(int time) {
        int number = nominations[time];
        Candidate existCandidate = findEqualNumber(number);
        if (existCandidate != null) {
            existCandidate.count++;
        } else {
            if (candidateList.size() < CANDIDATE_COUNT) {
                candidateList.add(new Candidate(number, 1, time));
            } else {
                int minIndex = getRemoveCandidateIndex();
                candidateList.remove(minIndex);
                candidateList.add(new Candidate(number, 1, time));
            }
        }
    }

    private static int getRemoveCandidateIndex() {
        int minCount = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < candidateList.size(); i++) {
            Candidate candidate = candidateList.get(i);
            if (candidate.count < minCount) {
                minCount = candidate.count;
                minTime = candidate.time;
                minIndex = i;
            } else if (candidate.count == minCount) {
                if (candidate.time < minTime) {
                    minTime = candidate.time;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    private static Candidate findEqualNumber(int number) {
        for (Candidate candidate : candidateList) {
            if (candidate.number == number) {
                return candidate;
            }
        }
        return null;
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Candidate candidate : candidateList) {
            stringBuilder.append(candidate.number).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CANDIDATE_COUNT = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        nominations = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static class Candidate {
        int number;
        int count;
        int time;

        public Candidate(int number, int count, int time) {
            this.number = number;
            this.count = count;
            this.time = time;
        }
    }
}
