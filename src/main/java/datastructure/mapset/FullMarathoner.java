/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10546
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FullMarathoner {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(bufferedReader.readLine());
        String[] participants = new String[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            participants[i] = bufferedReader.readLine();
        }
        String[] completions = new String[peopleCount - 1];
        for (int i = 0; i < peopleCount - 1; i++) {
            completions[i] = bufferedReader.readLine();
        }

        System.out.print(solution(participants, completions));
    }

    private static String solution(String[] participants, String[] completions) {
        Map<String, Integer> participantMap = Arrays.stream(participants)
                .collect(Collectors.toMap(p -> p, p -> 1, Integer::sum));

        Arrays.stream(completions).forEach(completion ->
                participantMap.merge(completion, -1, Integer::sum)
        );

        return participantMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }
}
