/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2870
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MathHomework {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.print(solution(words));
    }

    private static String solution(String[] words) {
        List<String> numbers = extractNumbers(words);

        numbers.sort(numberComparator());

        return listToString(numbers);
    }

    private static List<String> extractNumbers(String[] words) {
        List<String> numbers = new ArrayList<>();
        final String regex = "\\D";

        for (String word : words) {
            String[] split = word.split(regex);
            for (String s : split) {
                if (!s.isEmpty()) {
                    numbers.add(removeLeadingZeros(s));
                }
            }
        }

        return numbers;
    }

    private static String removeLeadingZeros(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }

        if (index == s.length()) {
            return "0";
        } else {
            return s.substring(index);
        }
    }

    private static Comparator<String> numberComparator() {
        return (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        };
    }

    private static String listToString(List<String> numbers) {
        StringBuilder result = new StringBuilder();

        for (String number : numbers) {
            result.append(number).append("\n");
        }

        return result.toString().trim();
    }
}
