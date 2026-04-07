/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21735
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class RollingSnowball {

    private static final int INIT_SIZE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int timeLimit = info[1];

        int[] snowAmounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(snowAmounts, timeLimit));
    }

    private static int solution(int[] snowAmounts, int timeLimit) {
        return bruteforce(snowAmounts, timeLimit, 0, 0, INIT_SIZE);
    }

    private static int bruteforce(int[] snowAmounts,
            int timeLimit,
            int currentPosition,
            int currentTime,
            int currentSize) {
        if (currentTime >= timeLimit) {
            return currentSize;
        }

        return Arrays.stream(MoveStrategy.values())
                .map(moveStrategy -> {
                    int nextPosition = currentPosition + moveStrategy.distance;
                    if (nextPosition <= snowAmounts.length) {
                        int nextSize = moveStrategy.calculateNewSize(currentSize, snowAmounts[nextPosition - 1]);
                        return bruteforce(snowAmounts, timeLimit, nextPosition, currentTime + 1, nextSize);
                    }
                    return currentSize;
                })
                .reduce(currentSize, Math::max);
    }

    enum MoveStrategy {
        ROLL(1, Integer::sum),
        THROW(2, (currentSize, snowAmount) -> (currentSize / 2) + snowAmount);

        private final int distance;
        private final IntBinaryOperator sizeCalculator;

        MoveStrategy(int distance, IntBinaryOperator sizeCalculator) {
            this.distance = distance;
            this.sizeCalculator = sizeCalculator;
        }

        public int calculateNewSize(int currentSize, int snowAmount) {
            return sizeCalculator.applyAsInt(currentSize, snowAmount);
        }
    }
}
