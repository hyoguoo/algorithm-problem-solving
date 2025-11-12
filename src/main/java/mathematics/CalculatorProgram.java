/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5613
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorProgram {

    private static final String EQUALS_SIGN = "=";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int initialNumber = Integer.parseInt(bufferedReader.readLine());

        List<Expression> expressions = new ArrayList<>();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(EQUALS_SIGN)) {
                break;
            }
            Operation operation = Operation.fromSymbol(input);
            int number = Integer.parseInt(bufferedReader.readLine());
            expressions.add(new Expression(operation, number));
        }

        System.out.print(solution(initialNumber, expressions));
    }

    private static int solution(int initialNumber, List<Expression> expressions) {
        return expressions.stream()
                .reduce(
                        initialNumber,
                        (currentResult, expression) ->
                                expression.operation.apply(currentResult, expression.number),
                        Integer::sum
                );
    }

    static class Expression {
        private final Operation operation;
        private final int number;

        public Expression(Operation operation, int number) {
            this.operation = operation;
            this.number = number;
        }
    }

    enum Operation {
        ADDITION("+") {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        },
        SUBTRACTION("-") {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        },
        MULTIPLICATION("*") {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        },
        DIVISION("/") {
            @Override
            public int apply(int a, int b) {
                return a / b;
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public abstract int apply(int a, int b);

        public static Operation fromSymbol(String symbol) {
            return Arrays.stream(Operation.values())
                    .filter(op -> op.symbol.equals(symbol))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
