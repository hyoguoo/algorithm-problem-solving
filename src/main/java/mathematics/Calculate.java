/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14614
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Calculate {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Input.from(bufferedReader)));
    }

    private static long solution(Input input) {
        return input.getParity() == Parity.ODD
                ? input.a ^ input.b
                : input.a;
    }

    enum Parity {
        EVEN, ODD;

        public static Parity from(BigInteger number) {
            return number.testBit(0) ? ODD : EVEN;
        }
    }

    static class Input {

        private final long a;
        private final long b;
        private final BigInteger xorCount;

        public Input(long a, long b, BigInteger xorCount) {
            this.a = a;
            this.b = b;
            this.xorCount = xorCount;
        }

        public static Input from(BufferedReader bufferedReader) throws IOException {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            return new Input(
                    Long.parseLong(stringTokenizer.nextToken()),
                    Long.parseLong(stringTokenizer.nextToken()),
                    new BigInteger(stringTokenizer.nextToken())
            );
        }

        public Parity getParity() {
            return Parity.from(xorCount);
        }
    }
}
