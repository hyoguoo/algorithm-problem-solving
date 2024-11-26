/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2935
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Noise {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger number1 = new BigInteger(bufferedReader.readLine());
        Operator operator = Operator.of(bufferedReader.readLine());
        BigInteger number2 = new BigInteger(bufferedReader.readLine());

        System.out.print(solution(number1, operator, number2));
    }

    private static BigInteger solution(BigInteger number1, Operator operator, BigInteger number2) {
        return operator.operation.apply(number1, number2);
    }

    enum Operator {
        PLUS("+", BigInteger::add),
        MULTIPLY("*", BigInteger::multiply);

        private final String value;
        private final BinaryOperator<BigInteger> operation;

        Operator(String value, BinaryOperator<BigInteger> operation) {
            this.value = value;
            this.operation = operation;
        }

        public static Operator of(String value) {
            return Arrays.stream(values())
                    .filter(operator -> operator.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
