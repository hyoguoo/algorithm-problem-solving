/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13877
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhichBaseAnyway {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            String[] info = bufferedReader.readLine().split(" ");
            String testNumber = info[0];
            String numberString = info[1];

            stringBuilder
                    .append(testNumber)
                    .append(" ")
                    .append(solution(numberString))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(String numberString) {
        int octalValue;
        try {
            octalValue = Integer.parseInt(numberString, 8);
        } catch (NumberFormatException e) {
            octalValue = 0;
        }

        int decimalValue = Integer.parseInt(numberString, 10);
        int hexadecimalValue = Integer.parseInt(numberString, 16);

        return new Result(octalValue, decimalValue, hexadecimalValue);
    }

    static class Result {

        private final int octal;
        private final int decimal;
        private final int hexadecimal;

        public Result(int octal, int decimal, int hexadecimal) {
            this.octal = octal;
            this.decimal = decimal;
            this.hexadecimal = hexadecimal;
        }

        @Override
        public String toString() {
            return octal + " " + decimal + " " + hexadecimal;
        }
    }
}
