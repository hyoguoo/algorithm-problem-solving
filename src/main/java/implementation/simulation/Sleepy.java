/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9519
 * Cheat Level: 0
 * Algorithm: Simulation / Implementation / String
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sleepy {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int changeCount = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();

        System.out.print(solution(input, changeCount));
    }

    private static String solution(String originInput, int changeCount) {
        List<String> modifiedString = getString(originInput);
        int loopCount = changeCount % modifiedString.size();

        return modifiedString.size() == 1
                ? modifiedString.get(0)
                : modifiedString.get(modifiedString.size() - loopCount);
    }

    private static List<String> getString(String originInput) {
        List<String> modifiedString = new ArrayList<>();
        modifiedString.add(originInput);
        while (true) {
            String nextString = calculateNextString(modifiedString.get(modifiedString.size() - 1));
            if (modifiedString.get(0).equals(nextString)) {
                return modifiedString;
            }
            modifiedString.add(nextString);
        }
    }

    private static String calculateNextString(String previousString) {
        StringBuilder stringBuilder = new StringBuilder();
        int toModifyStringLength = previousString.length() - 1;

        stringBuilder.append(previousString.charAt(0));
        for (int i = 1; i <= toModifyStringLength / 2; i++) {
            stringBuilder.append(previousString.charAt(previousString.length() - i));
            stringBuilder.append(previousString.charAt(i));
        }
        if (toModifyStringLength % 2 == 1) {
            stringBuilder.append(previousString.charAt(previousString.length() / 2));
        }

        return stringBuilder.toString();
    }
}
