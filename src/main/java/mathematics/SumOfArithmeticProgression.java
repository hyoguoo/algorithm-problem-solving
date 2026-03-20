/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28115
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SumOfArithmeticProgression {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] originalSequence = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(originalSequence));
    }

    private static Result solution(long[] originalSequence) {
        return isArithmeticProgression(originalSequence)
                ? new Result(ResultStatus.YES, originalSequence, new long[originalSequence.length])
                : new Result(ResultStatus.NO, null, null);
    }

    private static boolean isArithmeticProgression(long[] sequence) {
        if (sequence.length <= 2) {
            return true;
        }

        long commonDifference = sequence[1] - sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != commonDifference) {
                return false;
            }
        }

        return true;
    }

    enum ResultStatus {
        YES, NO
    }

    static class Result {

        private final ResultStatus resultStatus;
        private final long[] firstSequence;
        private final long[] secondSequence;

        public Result(ResultStatus resultStatus, long[] firstSequence, long[] secondSequence) {
            this.resultStatus = resultStatus;
            this.firstSequence = firstSequence;
            this.secondSequence = secondSequence;
        }

        @Override
        public String toString() {
            if (resultStatus == ResultStatus.NO) {
                return ResultStatus.NO.name();
            }

            return String.join(
                    System.lineSeparator(),
                    ResultStatus.YES.name(),
                    formatSequence(firstSequence),
                    formatSequence(secondSequence)
            );
        }

        private String formatSequence(long[] sequence) {
            return Arrays.stream(sequence)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }
}
