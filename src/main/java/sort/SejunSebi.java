/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1524
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SejunSebi {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            bufferedReader.readLine();
            bufferedReader.readLine();
            int[] sejunPowers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] sebiPowers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder
                    .append(solution(sejunPowers, sebiPowers))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(int[] sejunPowers, int[] sebiPowers) {
        if (sejunPowers.length == 0 && sebiPowers.length == 0) {
            return Result.DRAW;
        }

        Queue<Integer> sortedSejunPowers = Arrays.stream(sejunPowers)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> sortedSebiPowers = Arrays.stream(sebiPowers)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        while (true) {
            if (sortedSebiPowers.isEmpty()) {
                return Result.SEJUN;
            }
            if (sortedSejunPowers.isEmpty()) {
                return Result.SEBI;
            }

            if (sortedSejunPowers.peek() < sortedSebiPowers.peek()) {
                sortedSejunPowers.poll();
            } else {
                sortedSebiPowers.poll();
            }
        }
    }

    enum Result {
        SEJUN("S"),
        SEBI("B"),
        DRAW("C");

        private final String representation;

        Result(String representation) {
            this.representation = representation;
        }

        @Override
        public String toString() {
            return this.representation;
        }
    }
}
