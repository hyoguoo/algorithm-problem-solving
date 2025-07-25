/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1233
 * Cheat Level: 0
 * Algorithm: Brute Force / Implementation
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Dice {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dicesFaceCount = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(dicesFaceCount));
    }

    private static int solution(int[] dicesFaceCount) {
        Map<Integer, Integer> sumFrequency = new TreeMap<>();
        dfs(dicesFaceCount, 0, 0, sumFrequency);

        return sumFrequency.entrySet().stream()
                .max(Comparator.comparing(Map.Entry<Integer, Integer>::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    private static void dfs(int[] faces, int index, int currentSum, Map<Integer, Integer> frequencyMap) {
        if (index == faces.length) {
            frequencyMap.put(currentSum, frequencyMap.getOrDefault(currentSum, 0) + 1);
            return;
        }

        for (int i = 1; i <= faces[index]; i++) {
            dfs(faces, index + 1, currentSum + i, frequencyMap);
        }
    }
}
