/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2606
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

public class Virus {

    public static final int START_COMPUTER_INDEX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(bufferedReader.readLine());
        int networkCount = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, List<Integer>> computerNetworkMap = new HashMap<>();

        for (int i = 0; i < networkCount; i++) {
            int[] networkInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int computerA = networkInfo[0];
            int computerB = networkInfo[1];

            computerNetworkMap.computeIfAbsent(computerA, k -> new ArrayList<>()).add(computerB);
            computerNetworkMap.computeIfAbsent(computerB, k -> new ArrayList<>()).add(computerA);
        }

        System.out.print(solution(computerNetworkMap, computerCount));
    }

    private static int solution(Map<Integer, List<Integer>> computerNetworkMap, int computerCount) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[computerCount + 1];
        queue.add(START_COMPUTER_INDEX);
        visited[START_COMPUTER_INDEX] = true;

        while (!queue.isEmpty()) {
            int currentComputer = queue.poll();
            for (int connectedComputer : computerNetworkMap.getOrDefault(currentComputer, new ArrayList<>())) {
                if (!visited[connectedComputer]) {
                    queue.add(connectedComputer);
                    visited[connectedComputer] = true;
                }
            }
        }

        return IntStream.range(1, visited.length)
                .map(i -> visited[i] ? 1 : 0)
                .sum() - 1;
    }
}
