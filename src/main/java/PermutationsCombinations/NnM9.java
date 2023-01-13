/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15663
 * Cheat Level: 0
 * Algorithm: Permutation / Backtracking
 */

package PermutationsCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NnM9 {

    static final List<int[]> list = new ArrayList<>();
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        int[] result = new int[input[1]];
        boolean[] visited = new boolean[input[0]];
        recursion(input[0], input[1], result, visited, 0);

        removeDuplicates();
        printList();
    }

    private static void printList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] numbers : list) {
            for (int number : numbers) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void removeDuplicates() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Arrays.equals(list.get(i), list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    private static void recursion(int N, int M, int[] result, boolean[] visited, int depth) {
        if (depth == M) {
            int[] temp = new int[M];
            System.arraycopy(result, 0, temp, 0, M);
            list.add(temp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                recursion(N, M, result, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
