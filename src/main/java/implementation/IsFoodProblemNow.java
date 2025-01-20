/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12787
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class IsFoodProblemNow {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            String[] info = bufferedReader.readLine().split(" ");
            Type type = Type.of(info[0]);
            String input = info[1];

            String result = solution(type, input);
            stringBuilder.append(result).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(Type type, String input) {
        return type.function.apply(input);
    }

    private static String ivp8ToInteger(String input) {
        BigInteger result = BigInteger.ZERO;

        String[] ipv8 = input.split("\\.");

        for (int i = ipv8.length - 1; i >= 0; i--) {
            BigInteger value = BigInteger.valueOf(Long.parseLong(ipv8[i]));
            result = result.add(value.shiftLeft((ipv8.length - 1 - i) * 8));
        }

        return result.toString();
    }

    private static String integerToIpv8(String input) {
        BigInteger value = new BigInteger(input);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            BigInteger mask = BigInteger.valueOf(255L);
            BigInteger result = value.and(mask);
            stringBuilder.insert(0, result);
            value = value.shiftRight(8);
            if (i != 7) {
                stringBuilder.insert(0, ".");
            }
        }

        return stringBuilder.toString();
    }

    enum Type {
        IPV8("1", IsFoodProblemNow::ivp8ToInteger),
        INTEGERS("2", IsFoodProblemNow::integerToIpv8);

        private final String value;
        private final UnaryOperator<String> function;

        Type(String value, UnaryOperator<String> function) {
            this.value = value;
            this.function = function;
        }

        public static Type of(String value) {
            return Arrays.stream(Type.values())
                    .filter(v -> v.value.equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}

