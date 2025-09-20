/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16457
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
import java.util.stream.Collectors;

public class MapleStory {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int keyCount = info[0];
        int questCount = info[1];

        Quest[] quests = new Quest[questCount];
        for (int i = 0; i < questCount; i++) {
            int[] requiredKeys = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            quests[i] = new Quest(requiredKeys);
        }

        System.out.print(solution(quests, keyCount));
    }

    private static long solution(Quest[] quests, int keyCount) {
        List<Set<Integer>> combinationList = getCombinations(keyCount * 2, keyCount);

        return combinationList.stream()
                .mapToLong(combination -> countCompletableQuests(quests, combination))
                .max()
                .orElse(0L);
    }

    private static List<Set<Integer>> getCombinations(int n, int r) {
        List<Set<Integer>> combinationList = new ArrayList<>();
        generateCombinations(combinationList, new HashSet<>(), 1, n, r);
        return combinationList;
    }

    private static void generateCombinations(List<Set<Integer>> combinations,
            Set<Integer> current,
            int start,
            int n,
            int r) {
        if (current.size() == r) {
            combinations.add(new HashSet<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(combinations, current, i + 1, n, r);
            current.remove(i);
        }
    }

    private static long countCompletableQuests(Quest[] quests, Set<Integer> combination) {
        return Arrays.stream(quests)
                .filter(quest -> quest.canComplete(combination))
                .count();
    }

    static class Quest {

        private final List<Integer> requiredKeyList;

        public Quest(int[] requiredKeys) {
            this.requiredKeyList = Arrays.stream(requiredKeys).boxed().collect(Collectors.toList());
        }

        public boolean canComplete(Set<Integer> availableKeys) {
            return availableKeys.containsAll(requiredKeyList);
        }
    }
}
