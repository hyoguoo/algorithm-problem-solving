/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1026
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Treasure {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers1, numbers2));
    }

    private static int solution(int[] numbers1, int[] numbers2) {
        Arrays.sort(numbers1);
        Arrays.sort(numbers2);

        int sum = 0;

        for (int i = 0; i < numbers1.length; i++) {
            sum += numbers1[i] * numbers2[numbers2.length - 1 - i];
        }

        return sum;
    }
}
