/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1469
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequencesBetweenShims {

    private static final int NOT_VISITED = -1;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        Arrays.sort(numbers);
        int[] temp = new int[numbers.length * 2];
        Arrays.fill(temp, NOT_VISITED);
        recursive(numbers, 0, temp, new boolean[numbers.length]);

        return result == null
                ? "-1"
                : Arrays.toString(result).replaceAll("[\\[\\],]", "");
    }

    private static boolean recursive(int[] numbers, int index, int[] temp, boolean[] isUsed) {
        if (isAllUsed(isUsed)) {
            result = Arrays.copyOf(temp, temp.length);
            return true;
        }

        for (int i = index; i < temp.length; i++) {
            if (temp[i] != NOT_VISITED) {
                continue;
            }

            for (int j = 0; j < numbers.length; j++) {
                int value = numbers[j];
                int shimIndex = i + value + 1;
                if (isUsed[j] ||
                        shimIndex >= temp.length ||
                        temp[shimIndex] != NOT_VISITED) {
                    continue;
                }

                temp[i] = value;
                temp[shimIndex] = value;
                isUsed[j] = true;
                if (recursive(numbers, i + 1, temp, isUsed)) {
                    return true;
                }
                temp[i] = NOT_VISITED;
                temp[shimIndex] = NOT_VISITED;
                isUsed[j] = false;
            }
        }

        return false;
    }

    private static boolean isAllUsed(boolean[] isUsed) {
        for (boolean used : isUsed) {
            if (!used) {
                return false;
            }
        }

        return true;
    }
}
