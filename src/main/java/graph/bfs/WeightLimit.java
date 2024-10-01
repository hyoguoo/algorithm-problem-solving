/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1939
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightLimit {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int islandCount = info[0];
        int bridgeCount = info[1];

        Map<Integer, List<Bridge>> map = new HashMap<>();

        for (int i = 0; i < bridgeCount; i++) {
            int[] bridgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int start = bridgeInfo[0];
            int end = bridgeInfo[1];
            int weightLimit = bridgeInfo[2];

            map.computeIfAbsent(start, key -> new ArrayList<>()).add(new Bridge(end, weightLimit));
            map.computeIfAbsent(end, key -> new ArrayList<>()).add(new Bridge(start, weightLimit));
        }

        int[] targetInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = targetInfo[0];
        int end = targetInfo[1];

        System.out.print(solution(map, islandCount, start, end));
    }

    private static int solution(Map<Integer, List<Bridge>> map, int islandCount, int start, int end) {
        PriorityQueue<Position> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(p -> -p.weight)
        );
        int[] visitedMaxWeight = new int[islandCount + 1];
        priorityQueue.add(new Position(start, Integer.MAX_VALUE));
        visitedMaxWeight[start] = Integer.MAX_VALUE;

        while (!priorityQueue.isEmpty()) {
            Position current = priorityQueue.poll();

            if (current.island == end) {
                return current.weight;
            }

            for (Bridge bridge : map.getOrDefault(current.island, new ArrayList<>())) {
                int nextWeight = Math.min(current.weight, bridge.weightLimit);
                if (nextWeight > visitedMaxWeight[bridge.end]) {
                    priorityQueue.add(new Position(bridge.end, nextWeight));
                    visitedMaxWeight[bridge.end] = nextWeight;
                }
            }
        }

        throw new IllegalArgumentException();
    }


    static class Position {

        private final int island;
        private final int weight;

        public Position(int island, int weight) {
            this.island = island;
            this.weight = weight;
        }
    }

    static class Bridge {

        private final int end;
        private final int weightLimit;

        public Bridge(int end, int weightLimit) {
            this.end = end;
            this.weightLimit = weightLimit;
        }
    }
}
