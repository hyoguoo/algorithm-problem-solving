/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11509
 * Cheat Level: 4
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShotBalloons {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] arrows = new int[1000002];
        int count = 0;

        for (int number : numbers) {
            if (arrows[number + 1] > 0) arrows[number + 1]--;
            else count++;
            arrows[number]++;
        }


        return count;
    }
}
