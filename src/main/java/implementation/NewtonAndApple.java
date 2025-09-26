/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13118
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class NewtonAndApple {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] peoplePositions = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] appleInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long appleX = appleInfo[0];

        System.out.print(solution(peoplePositions, appleX));
    }

    private static int solution(long[] peoplePositions, long appleX) {
        return IntStream.range(0, peoplePositions.length)
                .filter(i -> peoplePositions[i] == appleX)
                .map(i -> i + 1)
                .findFirst()
                .orElse(0);
    }
}
