/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28086
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BinaryOperator;

public class BeautifulGirlComputerParubittoChan {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String rawFormula = bufferedReader.readLine();

        System.out.print(solution(rawFormula));
    }

    private static String solution(String rawFormula) {
        Formula formula = parseExpression(rawFormula);
        if (formula.isInvalidOperation()) {
            return "invalid";
        }
        long result = formula.evaluate();
        return Long.toString(result, 8);
    }

    private static Formula parseExpression(String rawFormula) {
        int operatorIndex = getOperatorIndex(rawFormula);
        String operatorSymbol = String.valueOf(rawFormula.charAt(operatorIndex));
        Operator operator = Operator.of(operatorSymbol);

        long leftOperand = Long.parseLong(rawFormula.substring(0, operatorIndex), 8);
        long rightOperand = Long.parseLong(rawFormula.substring(operatorIndex + 1), 8);

        return new Formula(leftOperand, operator, rightOperand);
    }

    private static int getOperatorIndex(String formula) {
        for (int i = 1; i < formula.length(); i++) {
            if (Operator.isOperator(formula.charAt(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    enum Operator {
        PLUS("+", Math::addExact),
        MINUS("-", Math::subtractExact),
        MULTIPLY("*", Math::multiplyExact),
        DIVIDE("/", Math::floorDiv);

        private final String symbol;
        private final BinaryOperator<Long> operation;

        Operator(String symbol, BinaryOperator<Long> operation) {
            this.symbol = symbol;
            this.operation = operation;
        }

        public static Operator of(String symbol) {
            return Arrays.stream(values())
                    .filter(operator -> operator.symbol.equals(symbol))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public static boolean isOperator(char c) {
            return Arrays.stream(values())
                    .anyMatch(operator -> operator.symbol.charAt(0) == c);
        }

        public long operate(long a, long b) {
            return operation.apply(a, b);
        }
    }

    static class Formula {

        private final long a;
        private final Operator operator;
        private final long b;

        public Formula(long a, Operator operator, long b) {
            this.a = a;
            this.operator = operator;
            this.b = b;
        }

        public long evaluate() {
            return operator.operate(a, b);
        }

        public boolean isInvalidOperation() {
            return operator == Operator.DIVIDE && b == 0;
        }
    }
}
