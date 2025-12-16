/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2408
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

public class LargeNumberCalculation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(bufferedReader.readLine());
        BigInteger startNumber = new BigInteger(bufferedReader.readLine());
        Operation[] operations = new Operation[numberCount - 1];

        for (int i = 0; i < numberCount - 1; i++) {
            Operator operator = Operator.fromSymbol(bufferedReader.readLine().charAt(0));
            BigInteger number = new BigInteger(bufferedReader.readLine());
            operations[i] = new Operation(operator, number);
        }

        System.out.print(solution(startNumber, operations));
    }

    private static BigInteger solution(BigInteger startValue, Operation[] operations) {
        BigInteger result = BigInteger.ZERO;
        BigInteger current = startValue;
        Operator pending = Operator.ADDITION;

        for (Operation operation : operations) {
            Operator op = operation.operator;
            BigInteger value = operation.number;

            if (op == Operator.MULTIPLICATION || op == Operator.DIVISION) {
                current = op.apply(current, value);
            } else {
                result = pending.apply(result, current);
                pending = op;
                current = value;
            }
        }

        return pending.apply(result, current);
    }

    private static BigInteger floorDivide(BigInteger dividend, BigInteger divisor) {
        BigInteger quotient = dividend.divide(divisor);
        BigInteger remainder = dividend.remainder(divisor);

        boolean needFloorCorrection =
                remainder.signum() != 0 && dividend.signum() != divisor.signum();

        return needFloorCorrection
                ? quotient.subtract(BigInteger.ONE)
                : quotient;
    }

    enum Operator {
        ADDITION('+', BigInteger::add),
        SUBTRACTION('-', BigInteger::subtract),
        MULTIPLICATION('*', BigInteger::multiply),
        DIVISION('/', LargeNumberCalculation::floorDivide);

        private final char symbol;
        private final BinaryOperator<BigInteger> operationFunction;

        Operator(char symbol, BinaryOperator<BigInteger> operationFunction) {
            this.symbol = symbol;
            this.operationFunction = operationFunction;
        }

        public static Operator fromSymbol(char symbol) {
            return Arrays.stream(values())
                    .filter(op -> op.symbol == symbol)
                    .findFirst()
                    .orElseThrow();
        }

        public BigInteger apply(BigInteger a, BigInteger b) {
            return operationFunction.apply(a, b);
        }
    }

    static class Operation {

        private final Operator operator;
        private final BigInteger number;

        public Operation(Operator operator, BigInteger number) {
            this.operator = operator;
            this.number = number;
        }
    }
}
