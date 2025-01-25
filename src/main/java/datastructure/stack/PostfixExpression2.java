/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1935
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class PostfixExpression2 {

    private static final char OPERAND_START = 'A';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int operandCount = Integer.parseInt(bufferedReader.readLine());
        String postfixExpression = bufferedReader.readLine();

        Map<Character, Double> operandMap = new HashMap<>();
        for (int i = 0; i < operandCount; i++) {
            operandMap.put((char) (OPERAND_START + i), Double.parseDouble(bufferedReader.readLine()));
        }

        System.out.printf("%.2f", solution(postfixExpression, operandMap));
    }

    private static double solution(String postfixExpression, Map<Character, Double> operandMap) {
        Deque<Double> stack = new ArrayDeque<>();

        for (char c : postfixExpression.toCharArray()) {
            if (isOperand(c)) {
                stack.push(operandMap.get(c));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                stack.push(calculate(operand1, operand2, c));
            }
        }

        return stack.pop();
    }

    private static boolean isOperand(char c) {
        return c >= OPERAND_START;
    }

    private static double calculate(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}
