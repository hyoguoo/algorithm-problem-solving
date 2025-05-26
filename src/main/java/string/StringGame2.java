/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20437
 * Cheat Level: 0
 * Algorithm: String / Sliding Window
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringGame2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String input = bufferedReader.readLine();
            int containingLength = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(input, containingLength)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static ResultQuery solution(String input, int containingLength) {
        Map<Character, Integer> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        List<Character> validCharList = charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= containingLength)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (validCharList.isEmpty()) {
            return new ResultQuery(-1, -1);
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;

        for (char c : validCharList) {
            int[] indices = new int[input.length()];
            int index = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == c) {
                    indices[index++] = i;
                }
            }

            for (int i = 0; i <= index - containingLength; i++) {
                int start = indices[i];
                int end = indices[i + containingLength - 1];
                int length = end - start + 1;

                minLength = Math.min(minLength, length);
                maxLength = Math.max(maxLength, length);
            }
        }

        return new ResultQuery(minLength, maxLength);
    }

    static class ResultQuery {

        private final int minLength;
        private final int maxLength;

        public ResultQuery(int minLength, int maxLength) {
            this.minLength = minLength;
            this.maxLength = maxLength;
        }

        @Override
        public String toString() {
            if (minLength == -1 && maxLength == -1) {
                return "-1";
            }
            return minLength + " " + maxLength;
        }
    }
}
