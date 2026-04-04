/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15726
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        long c = Long.parseLong(stringTokenizer.nextToken());

        System.out.print(solution(new InputNumbers(a, b, c)));
    }

    private static long solution(InputNumbers inputNumbers) {
        double maxResult = 0;

        for (Operation operation : Operation.values()) {
            maxResult = Math.max(maxResult, operation.apply(inputNumbers));
        }

        return (long) maxResult;
    }

    enum Operation {
        MULTIPLY_THEN_DIVIDE {
            @Override
            double apply(InputNumbers inputNumbers) {
                return (double) inputNumbers.a * inputNumbers.b / inputNumbers.c;
            }
        },
        DIVIDE_THEN_MULTIPLY {
            @Override
            double apply(InputNumbers inputNumbers) {
                return (double) inputNumbers.a / inputNumbers.b * inputNumbers.c;
            }
        };

        abstract double apply(InputNumbers inputNumbers);
    }

    private static class InputNumbers {

        long a;
        long b;
        long c;

        public InputNumbers(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
