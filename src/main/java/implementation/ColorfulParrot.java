/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28445
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class ColorfulParrot {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] fatherColors = bufferedReader.readLine().split(" ");
        String[] motherColors = bufferedReader.readLine().split(" ");

        System.out.print(solution(fatherColors[0], fatherColors[1], motherColors[0], motherColors[1]));
    }

    private static String solution(String fatherBodyColor,
            String fatherTailColor,
            String motherBodyColor,
            String motherTailColor) {
        SortedSet<String> colorSet = new TreeSet<>();
        colorSet.add(fatherBodyColor);
        colorSet.add(fatherTailColor);
        colorSet.add(motherBodyColor);
        colorSet.add(motherTailColor);

        return buildResult(colorSet);
    }

    private static String buildResult(SortedSet<String> colors) {
        StringBuilder resultBuilder = new StringBuilder();
        for (String bodyColor : colors) {
            for (String tailColor : colors) {
                resultBuilder
                        .append(bodyColor)
                        .append(" ")
                        .append(tailColor)
                        .append("\n");
            }
        }
        return resultBuilder.toString();
    }
}
