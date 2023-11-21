/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2910
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortFrequency {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        printByFrequency(solution(numbers));
    }

    private static Map<Integer, Integer> solution(int[] numbers) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int number : numbers) {
            if (map.containsKey(number)) map.put(number, map.get(number) + 1);
            else map.put(number, 1);
        }

        return map;
    }

    private static void printByFrequency(Map<Integer, Integer> map) {
        List<Integer> keySet = getSortFrequency(map);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : keySet) {
            for (int i = 0; i < map.get(integer); i++) stringBuilder.append(integer).append(" ");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static List<Integer> getSortFrequency(Map<Integer, Integer> map) {
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
        return keySet;
    }
}
