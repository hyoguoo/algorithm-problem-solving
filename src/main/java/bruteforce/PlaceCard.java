/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5568
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PlaceCard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(bufferedReader.readLine());
        int pickCount = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[cardCount];

        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(cards, pickCount));
    }

    private static int solution(int[] cards, int pickCount) {
        Set<Integer> uniqueCombinations = new HashSet<>();
        generatePermutations(cards, new int[pickCount], new boolean[cards.length], uniqueCombinations, 0, pickCount);
        return uniqueCombinations.size();
    }

    private static void generatePermutations(int[] cards,
            int[] selectedCards,
            boolean[] visited,
            Set<Integer> uniqueCombinations,
            int depth,
            int pickCount) {
        if (depth == pickCount) {
            uniqueCombinations.add(
                    Integer.parseInt(
                            Arrays.stream(selectedCards)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining())
                    )
            );
            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            selectedCards[depth] = cards[i];
            generatePermutations(cards, selectedCards, visited, uniqueCombinations, depth + 1, pickCount);
            visited[i] = false;
        }
    }
}
