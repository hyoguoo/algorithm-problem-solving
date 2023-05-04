/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17074
 * Cheat Level: 5
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers, getNotSortedIndex(numbers)));
    }

    private static int solution(int[] numbers, List<Integer> notSortedIndex) {
        if (notSortedIndex.size() == 0) return numbers.length;
        else if (notSortedIndex.size() > 1) return 0;
        else {
            int index = notSortedIndex.get(0);
            if (index == 0) {
                if (numbers[index] <= numbers[index + 2]) return 2;
                return 1;
            }
            else if (index == numbers.length - 2) {
                if (numbers[index - 1] <= numbers[index + 1]) return 2;
                return 1;
            }
            else {
                int count = 0;
                if (numbers[index - 1] <= numbers[index + 1]) count++;
                if (numbers[index] <= numbers[index + 2]) count++;
                return count;
            }
        }
    }

    private static List<Integer> getNotSortedIndex(int[] numbers) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                indexList.add(i);
            }
        }
        return indexList;
    }
}
