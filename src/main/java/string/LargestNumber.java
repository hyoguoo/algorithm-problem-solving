/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 42746
 * Cheat Level: 0
 * Algorithm: String / Sort
 */


package string;

import java.util.Arrays;

public class LargestNumber {

    public String solution(int[] numbers) {
        String[] strings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        if (strings[0].equals("0")) return "0";

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) stringBuilder.append(string);
        return stringBuilder.toString();
    }
}
