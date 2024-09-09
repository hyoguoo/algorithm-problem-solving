/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10709
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Weatherman {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];

        WeatherSymbol[][] weatherMap = new WeatherSymbol[sizeN][sizeM];

        for (int i = 0; i < sizeN; i++) {
            char[] weatherInfo = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < sizeM; j++) {
                weatherMap[i][j] = WeatherSymbol.of(weatherInfo[j]);
            }
        }

        System.out.print(solution(weatherMap));
    }

    private static String solution(WeatherSymbol[][] weatherMap) {
        return arrayToString(getCloudDistanceMap(weatherMap));
    }

    private static int[][] getCloudDistanceMap(WeatherSymbol[][] weatherMap) {
        return IntStream.range(0, weatherMap.length)
                .mapToObj(n -> IntStream.range(0, weatherMap[0].length)
                        .map(m -> calculateCloudDistanceLeft(weatherMap, n, m))
                        .toArray())
                .toArray(int[][]::new);
    }

    private static String arrayToString(int[][] array) {
        return Arrays.stream(array)
                .map(line -> Arrays.stream(line)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    private static int calculateCloudDistanceLeft(WeatherSymbol[][] weatherMap, int n, int m) {
        int distance = 0;

        for (int currentM = m; currentM >= 0; currentM--) {
            if (weatherMap[n][currentM] == WeatherSymbol.CLOUD) {
                return distance;
            }
            distance++;
        }

        return -1;
    }

    enum WeatherSymbol {
        CLOUD('c'),
        SUNNY('.');

        private final char value;

        WeatherSymbol(char value) {
            this.value = value;
        }

        public static WeatherSymbol of(char value) {
            return Arrays.stream(values())
                    .filter(weatherSymbol -> weatherSymbol.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
