/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2847
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RAZINE {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] scores = new int[N];
        for (int n = 0; n < N; n++) scores[n] = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solution(scores));
    }

    private static int solution(int[] scores) {
        if (scores.length == 1) return 0;

        int result = 0;

        for (int i = scores.length - 2; i >= 0; i--) {
            int currentScore = scores[i];
            int nextScore = scores[i + 1];
            if (currentScore >= nextScore) {
                result += currentScore - nextScore + 1;
                scores[i] = nextScore - 1;
            }
        }

        return result;
    }
}
