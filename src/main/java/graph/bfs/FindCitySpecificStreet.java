/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18352
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

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

public class FindCitySpecificStreet {

    private static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int cityCount = info[0];
        int streetCount = info[1];
        int targetDistance = info[2];
        int startCityIndex = info[3];

        Map<Integer, List<Integer>> cityStreetMap = new HashMap<>();

        for (int i = 0; i < streetCount; i++) {
            int[] streetInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int cityAIndex = streetInfo[0];
            int cityBIndex = streetInfo[1];

            cityStreetMap.computeIfAbsent(cityAIndex, k -> new ArrayList<>()).add(cityBIndex);
        }

        System.out.print(
                solution(
                        cityStreetMap, cityCount,
                        startCityIndex, targetDistance
                )
        );
    }

    private static String solution(
            Map<Integer, List<Integer>> cityStreetMap,
            int cityCount,
            int startCityIndex,
            int targetDistance
    ) {
        int[] distanceFromStartCity = initDistance(cityCount);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCityIndex);
        distanceFromStartCity[startCityIndex] = 0;

        while (!queue.isEmpty()) {
            int currentCityIndex = queue.poll();
            for (int nextCityIndex : cityStreetMap.getOrDefault(currentCityIndex, new ArrayList<>())) {
                if (distanceFromStartCity[nextCityIndex] == NOT_VISITED) {
                    distanceFromStartCity[nextCityIndex] = distanceFromStartCity[currentCityIndex] + 1;
                    queue.add(nextCityIndex);
                }
            }
        }

        return formatTargetDistanceCities(cityCount, targetDistance, distanceFromStartCity);
    }

    private static int[] initDistance(int cityCount) {
        int[] distanceFromStartCity = new int[cityCount + 1];
        Arrays.fill(distanceFromStartCity, NOT_VISITED);
        return distanceFromStartCity;
    }

    private static String formatTargetDistanceCities(int cityCount, int targetDistance, int[] distanceFromStartCity) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isExist = false;

        for (int i = 1; i <= cityCount; i++) {
            if (distanceFromStartCity[i] == targetDistance) {
                stringBuilder.append(i).append("\n");
                isExist = true;
            }
        }

        return isExist
                ? stringBuilder.toString().trim()
                : "-1";
    }
}
