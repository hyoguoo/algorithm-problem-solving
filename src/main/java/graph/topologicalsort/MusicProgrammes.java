/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2623
 * Cheat Level: 2
 * Algorithm: Graph / Topological Sort
 */

package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MusicProgrammes {

    static int[] inDegree;
    static int VERTEX_COUNT;
    static List<Integer>[] ADJACENCY_LIST;

    public static void main(String[] args) throws IOException {
        init();
        printResult(solution());
    }

    private static void printResult(List<Integer> result) {
        if (result == null) {
            System.out.println(0);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach(integer -> stringBuilder.append(integer).append("\n"));

        System.out.println(stringBuilder);
    }

    private static List<Integer> solution() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < inDegree.length; i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            if (result.size() > VERTEX_COUNT) return null;
            Integer from = queue.poll();
            result.add(from);
            for (Integer integer : ADJACENCY_LIST[from]) {
                inDegree[integer]--;
                if (inDegree[integer] == 0) queue.add(integer);
            }
        }

        return result.size() == VERTEX_COUNT ? result : null;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        int adjacencyInfoCount = info[1];
        inDegree = new int[VERTEX_COUNT + 1];
        ADJACENCY_LIST = new List[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) ADJACENCY_LIST[i] = new ArrayList<>();
        for (int i = 0; i < adjacencyInfoCount; i++) {
            int[] adjacencyInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < adjacencyInfo.length - 1; j++) {
                int from = adjacencyInfo[j];
                int to = adjacencyInfo[j + 1];
                ADJACENCY_LIST[from].add(to);
                inDegree[to]++;
            }
        }
    }
}
