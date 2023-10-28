/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1269
 * Cheat Level: 0
 * Algorithm: Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceSet {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers1, numbers2));
    }

    private static int solution(int[] numbers1, int[] numbers2) {
        Set<Integer> set1 = getSet(numbers1);
        Set<Integer> set2 = getSet(numbers2);

        return getSymmetricDifference(set1, set2).size() + getSymmetricDifference(set2, set1).size();
    }

    private static Set<Integer> getSymmetricDifference(Set<Integer> originalSet, Set<Integer> otherSet) {
        Set<Integer> set = new HashSet<>(originalSet);

        for (Integer i : otherSet) set.remove(i);

        return set;
    }

    private static Set<Integer> getSet(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            set.add(number);
        }

        return set;
    }
}
