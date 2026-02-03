/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13866
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AssigningTeams {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] skillLevels = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(skillLevels));
    }

    private static int solution(int[] skillLevels) {
        Arrays.sort(skillLevels);

        return IntStream.range(0, skillLevels.length / 2)
                .map(i -> skillLevels[i] + skillLevels[skillLevels.length - 1 - i])
                .summaryStatistics()
                .getMax()
                - IntStream.range(0, skillLevels.length / 2)
                .map(i -> skillLevels[i] + skillLevels[skillLevels.length - 1 - i])
                .summaryStatistics()
                .getMin();
    }
}
