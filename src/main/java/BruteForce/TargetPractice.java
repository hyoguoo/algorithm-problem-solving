/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27958
 * Cheat Level: 0
 * Algorithm: Brute Force / Implementation / Simulation
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetPractice {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static int BASED_BONUS_POINT = 10;
    static int N, BULLET_COUNT;
    static int[] BULLETS_DAMAGE;
    static int[][] TARGET;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(simulate());
    }

    private static int simulate() {
        List<int[]> permutations = getPermutations(N, BULLET_COUNT);
        int maxScore = 0;

        for (int[] permutation : permutations) {
            maxScore = Math.max(maxScore, getScore(permutation, copyMap(TARGET), copyMap(TARGET)));
        }

        return maxScore;
    }

    private static int getScore(int[] bullets, int[][] hp, int[][] score) {
        int currentScore = 0;

        for (int x = 0; x < BULLET_COUNT; x++) {
            int i = bullets[x] - 1;
            int j = getMostLeftIndex(hp, i);
            if (j == -1) continue;

            int damage = BULLETS_DAMAGE[x];
            int targetHP = hp[i][j];
            int targetScore = score[i][j];

            if (targetHP >= BASED_BONUS_POINT) {
                currentScore += targetScore;
                hp[i][j] = 0;
            } else {
                if (damage >= targetHP) {
                    currentScore += targetScore;
                    hp[i][j] = 0;
                    int dividedTarget = targetScore / 4;
                    for (int[] direction : DIRECTIONS) {
                        int nextI = i + direction[0];
                        int nextJ = j + direction[1];
                        if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N) continue;
                        if (hp[nextI][nextJ] != 0) continue;
                        hp[nextI][nextJ] = dividedTarget;
                        score[nextI][nextJ] = dividedTarget;
                    }
                } else {
                    hp[i][j] -= damage;
                }
            }
        }

        return currentScore;
    }

    private static int getMostLeftIndex(int[][] map, int i) {
        for (int j = 0; j < N; j++) {
            if (map[i][j] != 0) return j;
        }
        return -1;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
        return copiedMap;
    }

    private static List<int[]> getPermutations(int x, int n) {
        List<int[]> result = new ArrayList<>();
        int[] nums = new int[n];
        backtrack(result, nums, x, 0);
        return result;
    }

    private static void backtrack(List<int[]> result, int[] nums, int x, int start) {
        if (start == nums.length) {
            result.add(nums.clone());
        } else {
            for (int i = 1; i <= x; i++) {
                nums[start] = i;
                backtrack(result, nums, x, start + 1);
            }
        }
    }


    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        BULLET_COUNT = Integer.parseInt(bufferedReader.readLine());
        TARGET = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] point = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                TARGET[i][j] = point[j];
            }
        }
        BULLETS_DAMAGE = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
