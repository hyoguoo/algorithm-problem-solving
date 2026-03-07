/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31067
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DaoRacingCompetition {

    private static final int IMPOSSIBLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int extendableLength = info[1];
        int[] trackLengths = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(trackLengths, extendableLength));
    }

    private static int solution(int[] trackLengths, int extendableLength) {
        State state = new State(trackLengths[0]);

        return IntStream.range(1, trackLengths.length)
                .allMatch(i -> state.updateIfPossible(trackLengths[i], extendableLength))
                ? state.getCounter()
                : IMPOSSIBLE;
    }

    private static class State {

        private int prevValue;
        private int counter;

        public State(int prevValue) {
            this.prevValue = prevValue;
            this.counter = 0;
        }

        public boolean updateIfPossible(int currentLength, int extendableLength) {
            int current = currentLength;
            if (current <= prevValue) {
                current += extendableLength;
                counter++;
            }

            if (current <= prevValue) {
                return false;
            }

            prevValue = current;
            return true;
        }

        public int getCounter() {
            return counter;
        }
    }
}
