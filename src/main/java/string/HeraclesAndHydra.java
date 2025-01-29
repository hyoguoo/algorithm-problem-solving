/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10205
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeraclesAndHydra {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int dataSetCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= dataSetCount; i++) {
            int hydraHeadCount = Integer.parseInt(bufferedReader.readLine());
            Action[] actions = Arrays.stream(bufferedReader.readLine().split(""))
                    .map(Action::of)
                    .toArray(Action[]::new);

            stringBuilder.append("Data Set ").append(i).append(":\n")
                    .append(solution(hydraHeadCount, actions))
                    .append("\n\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int hydraHeadCount, Action[] actions) {
        return Arrays.stream(actions)
                .reduce(hydraHeadCount, (headCount, action) -> action.headCountCalculator.calculate(headCount), Integer::sum);
    }

    enum Action {
        CUT_HEAD("c", h -> h + 1),
        BURN("b", h -> h - 1);

        private final String value;
        private final HeadCountCalculator headCountCalculator;

        Action(String value, HeadCountCalculator headCountCalculator) {
            this.value = value;
            this.headCountCalculator = headCountCalculator;
        }

        public static Action of(String value) {
            return Arrays.stream(values())
                    .filter(a -> a.value.equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    interface HeadCountCalculator {

        int calculate(int headCount);
    }
}
