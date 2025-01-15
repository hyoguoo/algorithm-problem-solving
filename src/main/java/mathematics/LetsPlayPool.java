/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32642
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class LetsPlayPool {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        Weather[] weathers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Weather::of)
                .toArray(Weather[]::new);

        System.out.print(solution(weathers));
    }

    private static long solution(Weather[] weathers) {
        long totalAngry = 0;
        long currentAngry = 0;

        for (Weather weather : weathers) {
            currentAngry = weather.angryCalculator.apply(currentAngry);
            totalAngry += currentAngry;
        }

        return totalAngry;
    }

    enum Weather {
        SUNNY(0, v -> v - 1),
        RAINY(1, v -> v + 1);

        private final int value;
        private final UnaryOperator<Long> angryCalculator;

        Weather(int value, UnaryOperator<Long> angryCalculator) {
            this.value = value;
            this.angryCalculator = angryCalculator;
        }

        public static Weather of(int value) {
            return Arrays.stream(values())
                    .filter(weather -> weather.value == value)
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
