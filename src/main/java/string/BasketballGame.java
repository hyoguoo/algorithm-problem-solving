/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1159
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasketballGame {

    private static final int ALPHABET_COUNT = 26;
    private static final int ALPHABET_START_ASCII = 97;
    private static final int TARGET_PLAYER_COUNT = 5;
    private static final String NO_PLAYER = "PREDAJA";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int playerCount = Integer.parseInt(bufferedReader.readLine());

        String[] playerNames = new String[playerCount];

        for (int i = 0; i < playerCount; i++) {
            playerNames[i] = bufferedReader.readLine();
        }

        System.out.print(solution(playerNames));
    }

    private static String solution(String[] playerNames) {
        int[] alphabetCount = new int[ALPHABET_COUNT];

        for (String playerName : playerNames) {
            alphabetCount[playerName.charAt(0) - ALPHABET_START_ASCII]++;
        }

        String result = IntStream.range(0, ALPHABET_COUNT)
                .filter(i -> alphabetCount[i] >= TARGET_PLAYER_COUNT)
                .mapToObj(i -> String.valueOf((char) (i + ALPHABET_START_ASCII)))
                .collect(Collectors.joining());

        return result.isEmpty() ? NO_PLAYER : result;
    }
}
