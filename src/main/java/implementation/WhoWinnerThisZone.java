/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20154
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WhoWinnerThisZone {

    private static final Map<Character, Integer> POINTS = new HashMap<>();

    static {
        POINTS.put('A', 3);
        POINTS.put('B', 2);
        POINTS.put('C', 1);
        POINTS.put('D', 2);
        POINTS.put('E', 3);
        POINTS.put('F', 3);
        POINTS.put('G', 3);
        POINTS.put('H', 3);
        POINTS.put('I', 1);
        POINTS.put('J', 1);
        POINTS.put('K', 3);
        POINTS.put('L', 1);
        POINTS.put('M', 3);
        POINTS.put('N', 3);
        POINTS.put('O', 1);
        POINTS.put('P', 2);
        POINTS.put('Q', 2);
        POINTS.put('R', 2);
        POINTS.put('S', 1);
        POINTS.put('T', 2);
        POINTS.put('U', 1);
        POINTS.put('V', 1);
        POINTS.put('W', 2);
        POINTS.put('X', 2);
        POINTS.put('Y', 2);
        POINTS.put('Z', 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()) ? "I'm a winner!" : "You're the winner?");
    }

    private static boolean solution(String s) {
        String values = convertValue(s);

        while (values.length() > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < values.length(); i += 2) {
                if (values.length() <= i + 1) {
                    stringBuilder.append(values.charAt(i));
                } else {
                    int sum = calculateNextValue(values, i);
                    stringBuilder.append(sum);
                }
            }
            values = stringBuilder.toString();
        }
        return Integer.parseInt(values) % 2 == 1;
    }

    private static int calculateNextValue(String values, int i) {
        return (Integer.parseInt(String.valueOf(values.charAt(i))) +
                Integer.parseInt(String.valueOf(values.charAt(i + 1)))) % 10;
    }

    private static String convertValue(String s) {
        return s.chars()
                .mapToObj(c -> String.valueOf(POINTS.get((char) c)))
                .collect(Collectors.joining());
    }
}
