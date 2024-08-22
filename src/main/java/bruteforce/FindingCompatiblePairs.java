/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14911
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindingCompatiblePairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(numbers, sum));
    }

    private static String solution(int[] numbers, int sum) {
        Set<String> duplicateCheckSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    String pair = numbers[i] + " " + numbers[j];
                    if (duplicateCheckSet.contains(pair)) {
                        continue;
                    }
                    duplicateCheckSet.add(pair);
                    result.add(pair);
                }
            }
        }

        if (result.isEmpty()) {
            return "0";
        }
        return String.join(" ", result) + "\n" + result.size();
    }
}
