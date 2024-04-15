/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1822
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

public class DifferenceSets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbersA = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbersB = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        printResult(solution(numbersA, numbersB));
    }

    private static int[] solution(int[] numbersA, int[] numbersB) {
        Set<Integer> setA = new HashSet<>();

        Arrays.stream(numbersA).forEach(setA::add);

        for (int number : numbersB) {
            setA.remove(number);
        }

        return setA.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void printResult(int[] differenceSet) {
        if (differenceSet.length == 0) {
            System.out.print(0);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(differenceSet.length).append("\n");
            Arrays.stream(differenceSet).forEach(i -> stringBuilder.append(i).append(" "));
            System.out.print(stringBuilder.toString().trim());
        }
    }
}
