/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2985
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers[0], numbers[1], numbers[2]));
    }

    private static Expression solution(int number1, int number2, int number3) {
        for (Operator operator1 : Operator.values()) {
            for (Operator operator2 : Operator.values()) {
                Expression expression = new Expression(number1, operator1, number2, operator2, number3);
                if (expression.isValid()) {
                    return expression;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    enum Operator {
        ADDITION("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/"),
        EQUALS("=");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    static class Expression {

        private final int number1;
        private final Operator operator1;
        private final int number2;
        private final Operator operator2;
        private final int number3;

        public Expression(int number1, Operator operator1, int number2, Operator operator2, int number3) {
            this.number1 = number1;
            this.operator1 = operator1;
            this.number2 = number2;
            this.operator2 = operator2;
            this.number3 = number3;
        }

        public boolean isValid() {
            if (operator1 == Operator.EQUALS) {
                return number1 == calculate(number2, operator2, number3);
            } else if (operator2 == Operator.EQUALS) {
                return calculate(number1, operator1, number2) == number3;
            }
            return false;
        }

        private int calculate(int num1, Operator operator, int num2) {
            switch (operator) {
                case ADDITION:
                    return num1 + num2;
                case SUBTRACTION:
                    return num1 - num2;
                case MULTIPLICATION:
                    return num1 * num2;
                case DIVISION:
                    return num1 / num2;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public String toString() {
            return String.format("%d%s%d%s%d", number1, operator1, number2, operator2, number3);
        }
    }
}
