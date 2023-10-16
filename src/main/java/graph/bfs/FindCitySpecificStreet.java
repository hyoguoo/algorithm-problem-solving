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
import java.util.*;

public class FindCitySpecificStreet {

    static final int LINKED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cityCount = info[0];
        int streetCount = info[1];
        int distance = info[2];
        int startCity = info[3];

        List<Integer>[] linkedCities = new List[cityCount + 1];
        for (int i = 0; i < linkedCities.length; i++) linkedCities[i] = new ArrayList<>();
        for (int i = 0; i < streetCount; i++) {
            int[] streetInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            linkedCities[streetInfo[0]].add(streetInfo[1]);
        }

        List<Integer> solution = solution(linkedCities, distance, startCity);
        if (solution.isEmpty()) System.out.println(-1);
        else solution.forEach(System.out::println);
    }

    private static List<Integer> solution(List<Integer>[] linkedCities, int distance, int startCity) {
        int[] distances = new int[linkedCities.length];
        Arrays.fill(distances, Integer.MAX_VALUE);

        Queue<City> queue = new LinkedList<>();
        queue.add(new City(startCity, 0));

        while (!queue.isEmpty()) {
            City city = queue.poll();
            int cityNumber = city.cityNumber;
            int cityDistance = city.distance;

            if (distances[cityNumber] < cityDistance) continue;
            distances[cityNumber] = cityDistance;

            for (int linkedCity : linkedCities[cityNumber]) {
                int linkedCityDistance = cityDistance + LINKED;
                if (distances[linkedCity] <= linkedCityDistance) continue;
                queue.add(new City(linkedCity, linkedCityDistance));
            }
        }

        return searchCitiesByDistance(distances, distance);
    }

    private static List<Integer> searchCitiesByDistance(int[] distances, int distance) {
        List<Integer> cityList = new ArrayList<>();

        for (int i = 1; i < distances.length; i++) {
            if (distances[i] == distance) {
                cityList.add(i);
            }
        }

        return cityList;
    }

    static class City {
        private final int cityNumber;
        private final int distance;

        public City(int cityNumber, int distance) {
            this.cityNumber = cityNumber;
            this.distance = distance;
        }
    }
}
