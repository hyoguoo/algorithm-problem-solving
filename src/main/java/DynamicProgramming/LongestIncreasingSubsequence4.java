/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14002
 * Cheat Level: 0
 * Algorithm: Dynamic Programing / LIS
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        NumberList[] dp = solution(numbers);

        int maxIndex = getMaxIndex(dp);
        System.out.println(dp[maxIndex].size());
        System.out.println(printLIS(dp, maxIndex));
    }

    private static String printLIS(NumberList[] dp, int maxIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> numbers = dp[maxIndex].numbers;
        for (Integer number : numbers) stringBuilder.append(number).append(" ");
        return stringBuilder.toString();
    }

    private static int getMaxIndex(NumberList[] dp) {
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[maxIndex].size() < dp[i].size()) maxIndex = i;
        }
        return maxIndex;
    }

    private static NumberList[] solution(int[] numbers) {
        NumberList[] dp = new NumberList[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = new NumberList(numbers[i]);
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && dp[i].size() < dp[j].size() + 1) {
                    dp[i] = new NumberList(dp[j], numbers[i]);
                }
            }
        }

        return dp;
    }
}

class NumberList {
    List<Integer> numbers = new ArrayList<>();

    public NumberList(int number) {
        numbers.add(number);
    }

    public NumberList(NumberList numberList, int number) {
        numbers.addAll(numberList.numbers);
        numbers.add(number);
    }

    public int size() {
        return numbers.size();
    }
}