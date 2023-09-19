/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: -
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SliceString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();
        String[] charSeparators = bufferedReader.readLine().split(" ");

        bufferedReader.readLine();
        String[] numberSeparators = bufferedReader.readLine().split(" ");

        bufferedReader.readLine();
        String[] mergeStrings = bufferedReader.readLine().split(" ");

        bufferedReader.readLine();
        String criteria = bufferedReader.readLine();

        List<String> splitList = new ArrayList<>();
        splitList.add(" ");
        for (String numberSeparator : numberSeparators) {
            if (splitList.contains(numberSeparator)) continue;
            splitList.add(numberSeparator);
        }
        for (String string : charSeparators) {
            if (splitList.contains(string)) continue;
            splitList.add(string);
        }

        for (String mergeString : mergeStrings) {
            if (!criteria.contains(mergeString)) continue;
            splitList.remove(mergeString);
        }

        System.out.println(splitList.isEmpty() ? criteria : toResult(criteria, splitList));
    }

    private static String toResult(String criteria, List<String> splitList) {
        List<String> resultList = new ArrayList<>();
        String[] split = criteria.split(splitList.toString());
        for (String string : split) {
            if (string.isEmpty()) continue;
            resultList.add(string);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : resultList) stringBuilder.append(string).append("\n");
        return stringBuilder.toString();
    }
}
