/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2857
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FBI {

    private static final int AGENT_COUNT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] agents = new String[AGENT_COUNT];

        for (int i = 0; i < AGENT_COUNT; i++) {
            agents[i] = bufferedReader.readLine();
        }

        int[] result = solution(agents);

        System.out.print(
                result.length > 0
                        ? Arrays.stream(result)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
                        : "HE GOT AWAY!"
        );
    }

    private static int[] solution(String[] agents) {
        return IntStream.range(0, agents.length)
                .filter(i -> agents[i].contains("FBI"))
                .map(i -> i + 1)
                .toArray();
    }
}
