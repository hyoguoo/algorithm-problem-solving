/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20208
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JinwooMintChocolateMilk {

    private static final int HOME = 1;
    private static final int MILK = 2;
    private static int mintHp = 0;
    private static int maxCount = 0;
    private static Coordinate homeCoordinate;
    private static ArrayList<Coordinate> milks;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int[][] map = new int[sizeN][sizeN];
        int hp = info[1];
        mintHp = info[2];
        milks = new ArrayList<>();
        for (int i = 0; i < sizeN; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < sizeN; j++) {
                map[i][j] = input[j];
                if (map[i][j] == HOME) {
                    homeCoordinate = new Coordinate(i, j);
                } else if (map[i][j] == MILK) {
                    milks.add(new Coordinate(i, j));
                }
            }
        }

        solution(hp);
        System.out.print(maxCount);
    }

    public static void solution(int currentHp) {
        boolean[] visited = new boolean[milks.size()];
        for (int i = 0; i < milks.size(); i++) {
            Coordinate milk = milks.get(i);
            int distance =
                    Math.abs(homeCoordinate.n - milk.n) + Math.abs(homeCoordinate.m - milk.m);
            if (distance <= currentHp) {
                findMaxNum(visited, milk, i, currentHp - distance + mintHp, 1);
            }
        }
    }

    public static void findMaxNum(
            boolean[] visited,
            Coordinate currentCoordinate,
            int index,
            int currentHp,
            int count
    ) {
        visited[index] = true;
        for (int i = 0; i < milks.size(); i++) {
            if (!visited[i]) {
                Coordinate nextMilk = milks.get(i);
                int distance =
                        Math.abs(currentCoordinate.n - nextMilk.n)
                                + Math.abs(currentCoordinate.m - nextMilk.m);
                if (distance <= currentHp) {
                    findMaxNum(visited, nextMilk, i, currentHp - distance + mintHp, count + 1);
                }
            }
        }
        int distance =
                Math.abs(homeCoordinate.n - currentCoordinate.n)
                        + Math.abs(homeCoordinate.m - currentCoordinate.m);
        if (distance <= currentHp) {
            maxCount = Math.max(maxCount, count);
        }

        visited[index] = false;
    }

    static class Coordinate {

        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
