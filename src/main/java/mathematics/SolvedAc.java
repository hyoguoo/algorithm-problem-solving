/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18110
 * Cheat Level: 0
 * Algorithm: Mathematics / Implementation
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolvedAc {

    final static float PERCENTAGE = 0.15f;

    public static void main(String[] args) throws IOException {
        List<Integer> difficultyLevelList = init();
        System.out.println(solution(difficultyLevelList));
    }

    private static int solution(List<Integer> difficultyLevelList) {
        int excludedCount = getExcludedCount(difficultyLevelList.size());
        List<Integer> validList = getValidList(difficultyLevelList, excludedCount);

        return getAverage(validList);
    }

    private static int getExcludedCount(int totalCount) {
        return Math.round(totalCount * PERCENTAGE);
    }

    private static List<Integer> getValidList(List<Integer> difficultyLevelList, int excludedCount) {
        return difficultyLevelList.subList(excludedCount, difficultyLevelList.size() - excludedCount);
    }

    private static int getAverage(List<Integer> validList) {
        return (int) Math.round(validList.stream().mapToInt(Integer::intValue).average().orElse(0));
    }

    private static List<Integer> init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        List<Integer> difficultyLevelList = new ArrayList<>();
        for (int i = 0; i < count; i++) difficultyLevelList.add(Integer.parseInt(bufferedReader.readLine()));

        Collections.sort(difficultyLevelList);
        return difficultyLevelList;
    }
}
