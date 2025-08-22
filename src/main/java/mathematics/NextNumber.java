/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4880
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (numbers[0] == 0 && numbers[1] == 0 && numbers[2] == 0) {
                break;
            }
            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(int[] numbers) {
        int difference1 = numbers[1] - numbers[0];
        int difference2 = numbers[2] - numbers[1];

        return difference1 == difference2
                ? new Result(Progression.ARITHMETIC, numbers[2] + difference1)
                : new Result(Progression.GEOMETRIC, numbers[2] * (numbers[1] / numbers[0]));
    }

    enum Progression {
        ARITHMETIC("AP"), GEOMETRIC("GP");

        private final String name;

        Progression(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Result {

        private final Progression progression;
        private final int nextNumber;

        public Result(Progression progression, int nextNumber) {
            this.progression = progression;
            this.nextNumber = nextNumber;
        }

        @Override
        public String toString() {
            return String.format("%s %d", progression, nextNumber);
        }
    }
}
