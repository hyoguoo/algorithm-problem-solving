/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12788
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class IUPCBeSuccess {

    private static final int NOT_ENOUGH = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int teamCount = info[0];
        int teamMemberCount = info[1];
        int[] pencilCount = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = solution(teamCount, teamMemberCount, pencilCount);
        System.out.print(result == NOT_ENOUGH ? "STRESS" : result);
    }

    private static int solution(int teamCount, int teamMemberCount, int[] pencilCount) {
        int totalPencilCount = teamCount * teamMemberCount;
        int[] sortedPencilCount = Arrays.stream(pencilCount)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        Accumulator acc = new Accumulator();

        return IntStream.range(0, sortedPencilCount.length)
                .filter(i -> {
                    acc.add(sortedPencilCount[i]);
                    return acc.getSum() >= totalPencilCount;
                })
                .map(i -> i + 1)
                .findFirst()
                .orElse(NOT_ENOUGH);
    }

    static class Accumulator {

        private int sum;

        public Accumulator() {
            this.sum = 0;
        }

        void add(int value) {
            this.sum += value;
        }

        int getSum() {
            return this.sum;
        }
    }
}
