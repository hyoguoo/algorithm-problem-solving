/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31395
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfSortedContiguousSubsequences {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static long solution(int[] numbers) {
        long count = numbers.length;
        int currentValue = numbers[0];
        int currentCount = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (currentValue < numbers[i]) {
                count += currentCount;
                currentCount++;
            } else {
                currentCount = 1;
            }
            currentValue = numbers[i];
        }

        return count;
    }
}

/*
1 2 3 4 5 1
1
1 2
1 2 3 / 2 3
1 2 3 4 / 2 3 4 / 3 4
1 2 3 4 5 / 2 3 4 5 / 3 4 5 / 4 5
 */
