/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10775
 * Cheat Level: 2
 * Algorithm: Greedy / Union Find
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    final static List<Integer> PLANE_LIST = new ArrayList<>();
    static int GATE_COUNT, PLANE_COUNT;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int count = 0;

        for (Integer integer : PLANE_LIST) {
            int gate = find(integer);

            if (gate == 0) break;

            union(gate, gate - 1);
            count++;
        }

        return count;
    }

    private static int find(int gate) {
        if (gate == parent[gate]) return gate;
        return parent[gate] = find(parent[gate]);
    }

    private static void union(int gate1, int gate2) {
        gate1 = find(gate1);
        gate2 = find(gate2);

        if (gate1 != gate2) parent[gate1] = gate2;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        GATE_COUNT = Integer.parseInt(bufferedReader.readLine());
        PLANE_COUNT = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < PLANE_COUNT; i++) PLANE_LIST.add(Integer.parseInt(bufferedReader.readLine()));
        parent = new int[GATE_COUNT + 1];
        for (int i = 0; i <= GATE_COUNT; i++) parent[i] = i;
    }
}
