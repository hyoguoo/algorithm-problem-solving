/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2503
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BullsAndCows {

    final static int[] NUMBER = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    final static List<int[]> permutation = Permutation.permutation(NUMBER, 3);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int number = numbers[0];
            int[] src = {number / 100, number / 10 % 10, number % 10};
            int strike = numbers[1];
            int ball = numbers[2];

            solution(src, strike, ball);
        }

        System.out.println(permutation.size());
    }

    private static void solution(int[] src, int strike, int ball) {
        for (int i = 0; i < permutation.size(); i++) {
            int[] dist = permutation.get(i);
            int strikeCount = 0;
            int ballCount = 0;

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (src[j] == dist[k]) {
                        if (j == k) strikeCount++;
                        else ballCount++;
                    }
                }
            }

            if (strike != strikeCount || ball != ballCount) {
                permutation.remove(i);
                i--;
            }
        }
    }

}

class Permutation {
    public static List<int[]> permutation(int[] arr, int r) {
        List<int[]> result = new ArrayList<>();
        permutation(arr, 0, r, result);
        return result;
    }

    private static void permutation(int[] arr, int i, int r, List<int[]> result) {
        if (i == r) {
            result.add(Arrays.copyOf(arr, r));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            permutation(arr, i + 1, r, result);
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
