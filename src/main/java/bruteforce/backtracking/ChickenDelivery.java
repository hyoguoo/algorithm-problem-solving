/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15686
 * Cheat Level: 2
 * Algorithm: Backtracking / Brute Force
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChickenDelivery {

    final static List<Chicken> chickenList = new ArrayList<>();
    final static int HOUSE = 1;
    final static int CHICKEN = 2;
    static int minDistance = Integer.MAX_VALUE;
    static int N;
    static int REMAIN;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        REMAIN = info[1];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < N; j++) {
                int value = line[j];
                if (value == CHICKEN) chickenList.add(new Chicken(i, j));
                graph[i][j] = value;
            }
        }

        recursion(0, 0);
        System.out.println(minDistance);
    }

    private static void recursion(int index, int count) {
        if (count == REMAIN) {
            minDistance = Math.min(minDistance, getDistance());
            return;
        }

        for (int i = index; i < chickenList.size(); i++) {
            Chicken chicken = chickenList.get(i);
            chicken.isUsed = true;
            recursion(i + 1, count + 1);
            chicken.isUsed = false;
        }
    }

    private static int getDistance() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == HOUSE) {
                    sum += getMinDistance(i, j);
                }
            }
        }
        return sum;
    }

    private static int getMinDistance(int i, int j) {
        int min = Integer.MAX_VALUE;
        for (Chicken chicken : chickenList) {
            if (chicken.isUsed) min = Math.min(min, Math.abs(i - chicken.x) + Math.abs(j - chicken.y));
        }
        return min;
    }
}

class Chicken {
    int x;
    int y;
    boolean isUsed;

    public Chicken(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
