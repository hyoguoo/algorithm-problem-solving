/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1247
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Sign {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = 3;
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount --> 0) {
            int numberCount = Integer.parseInt(bufferedReader.readLine());
            long[] numbers = new long[numberCount];

            for (int i = 0; i < numberCount; i++) {
                numbers[i] = Long.parseLong(bufferedReader.readLine());
            }

            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static SignSymbol solution(long[] numbers) {
        BigInteger sum = Arrays.stream(numbers)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);

        switch (sum.signum()) {
            case 0:
                return SignSymbol.ZERO;
            case 1:
                return SignSymbol.POSITIVE;
            case -1:
                return SignSymbol.NEGATIVE;
            default:
                throw new IllegalStateException();
        }
    }

    enum SignSymbol {
        ZERO("0"),
        POSITIVE("+"),
        NEGATIVE("-");

        private final String symbol;

        SignSymbol(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }
}
