/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17496
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Starfruit {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalDays = input[0];
        int growthDays = input[1];
        int plantSpace = input[2];
        int fruitPrice = input[3];

        System.out.print(solution(totalDays, growthDays, plantSpace, fruitPrice));
    }

    private static int solution(int totalDays, int growthDays, int plantSpace, int fruitPrice) {
        return (totalDays - 1) / growthDays * plantSpace * fruitPrice;
    }
}
