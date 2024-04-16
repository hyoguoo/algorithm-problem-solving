/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1755
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlayingNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static String solution(int startNumber, int endNumber) {
        return formatNumbers(generateNumberList(startNumber, endNumber));
    }

    private static List<Number> generateNumberList(int startNumber, int endNumber) {
        List<Number> numbers = new ArrayList<>();

        for (int i = startNumber; i <= endNumber; i++) {
            numbers.add(new Number(i));
        }

        numbers.sort(Number::compareTo);
        return numbers;
    }

    private static String formatNumbers(List<Number> numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i).value);
            if (i % 10 == 9) {
                stringBuilder.append("\n");
            } else {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString().trim();
    }

    static class Number implements Comparable<Number> {

        static final String[] NUMBER_STRING = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        int value;
        String stringNumber;

        public Number(int value) {
            this.value = value;
            this.stringNumber = Arrays.stream(String.valueOf(value).split(""))
                    .map(s -> NUMBER_STRING[Integer.parseInt(s)])
                    .reduce("", String::concat);
        }

        @Override
        public int compareTo(Number o) {
            return this.stringNumber.compareTo(o.stringNumber);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Number number = (Number) o;
            return value == number.value && Objects.equals(stringNumber, number.stringNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, stringNumber);
        }
    }
}
