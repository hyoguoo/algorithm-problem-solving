/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3568
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iSharp {
    public static String baseOperator;
    public static String type;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        String base = input[0];
        type = removeSpecialCharacters(base);
        baseOperator = base.replace(type, "");

        String[] variables = getVariables(input);
        solution(variables);
    }

    private static String[] getVariables(String[] input) {
        String[] result = new String[input.length - 1];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < input.length; i++) {
            result[i - 1] = input[i];
            stringBuilder.append(result[i - 1]);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString().split(",");
    }

    private static void solution(String[] variables) {
        for (String variable : variables) {
            String variableName = removeSpecialCharacters(variable);
            String operator = variable.replace(variableName, "");
            printVariable(variableName, reverseOperator(operator));
        }

    }

    private static String reverseOperator(String operator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = operator.length() - 1; i >= 0; i--) {
            stringBuilder.append(operator.charAt(i));
        }
        return stringBuilder.toString().replace("][", "[]");
    }

    private static String removeSpecialCharacters(String variable) {
        return variable.replace("*", "").replace("&", "").replace("[", "").replace("]", "");
    }

    private static void printVariable(String variableName, String operator) {
        System.out.println(type + baseOperator + operator + " " + variableName + ";");
    }
}
