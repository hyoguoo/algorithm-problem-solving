/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11816
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class OctalDecimalHexadecimal {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OptionalInt result = solution(bufferedReader.readLine());
        System.out.print(result.orElse(-1));
    }

    private static OptionalInt solution(String input) {
        return NumberBase.fromInput(input).parse(input);
    }

    enum NumberBase {
        HEX(16, "0x"),
        OCT(8, "0"),
        DEC(10, "");

        private final int radix;
        private final String prefix;

        NumberBase(int radix, String prefix) {
            this.radix = radix;
            this.prefix = prefix;
        }

        static NumberBase fromInput(String input) {
            return Arrays.stream(values())
                    .filter(base -> !base.prefix.isEmpty() && input.startsWith(base.prefix))
                    .findFirst()
                    .orElse(DEC);
        }

        OptionalInt parse(String input) {
            try {
                String value = prefix.isEmpty() ? input : input.substring(prefix.length());
                return OptionalInt.of(Integer.parseInt(value, radix));
            } catch (NumberFormatException e) {
                return OptionalInt.empty();
            }
        }
    }
}
