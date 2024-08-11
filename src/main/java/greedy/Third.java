/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5619
 * Cheat Level: 0
 * Algorithm: Greedy / Brute Force
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Third {

    private static final int CANDIDATE_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        Arrays.sort(numbers);
        int count = 0;
        int[] answerCandidates = new int[CANDIDATE_LENGTH];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (count == CANDIDATE_LENGTH) {
                    break;
                }
                answerCandidates[count++] = Integer.parseInt(numbers[i] + "" + numbers[j]);
                answerCandidates[count++] = Integer.parseInt(numbers[j] + "" + numbers[i]);
            }
        }
        Arrays.sort(answerCandidates);

        return answerCandidates[2];
    }
}
