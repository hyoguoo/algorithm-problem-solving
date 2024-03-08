/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2961
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DoYoungDeliciousFood {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Food[] foods = new Food[n];

        for (int i = 0; i < n; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            foods[i] = new Food(info[0], info[1]);
        }

        System.out.print(solution(foods));
    }

    private static long solution(Food[] foods) {
        long min = Long.MAX_VALUE;

        for (int i = 1; i <= foods.length; i++) {
            boolean[] visited = new boolean[foods.length];
            min = Math.min(min, backtracking(foods, visited, 1, 0, 0, i));
        }

        return min;
    }

    private static long backtracking(
            Food[] foods,
            boolean[] visited,
            int sour,
            int bitter,
            int count,
            int target
    ) {
        if (count == target) {
            return Math.abs(sour - bitter);
        }

        long min = Long.MAX_VALUE;

        for (int i = 0; i < foods.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                min = Math.min(
                        min,
                        backtracking(
                                foods,
                                visited,
                                sour * foods[i].sour,
                                bitter + foods[i].bitter,
                                count + 1,
                                target
                        )
                );
                visited[i] = false;
            }
        }

        return min;
    }

    static class Food {

        int sour;
        int bitter;

        public Food(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }
}
