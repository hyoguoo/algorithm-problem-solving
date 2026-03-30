/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28419
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Addition {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] sequence = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(sequence));
    }

    private static long solution(long[] sequence) {
        long oddSum = 0;
        long evenSum = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (Parity.of(i + 1) == Parity.ODD) {
                oddSum += sequence[i];
            } else {
                evenSum += sequence[i];
            }
        }

        if (sequence.length == 3 && oddSum > evenSum) {
            return -1;
        }

        return Math.abs(oddSum - evenSum);
    }

    enum Parity {
        ODD, EVEN;

        public static Parity of(int value) {
            return value % 2 != 0 ? ODD : EVEN;
        }
    }
}
