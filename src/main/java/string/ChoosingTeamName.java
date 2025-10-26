/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1296
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class ChoosingTeamName {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String myName = bufferedReader.readLine();
        int teamNameCount = Integer.parseInt(bufferedReader.readLine());

        String[] teamNames = new String[teamNameCount];

        for (int i = 0; i < teamNameCount; i++) {
            teamNames[i] = bufferedReader.readLine();
        }

        System.out.print(solution(teamNames, myName));
    }

    private static String solution(String[] teamNames, String myName) {
        Map<LoveCharacter, Integer> loveCountMap = new EnumMap<>(LoveCharacter.class);
        countLoveCharacters(loveCountMap, myName);

        return Arrays.stream(teamNames)
                .max((teamName1, teamName2) -> compareTeamNames(loveCountMap, teamName1, teamName2))
                .orElseThrow();
    }

    private static int compareTeamNames(Map<LoveCharacter, Integer> loveCountMap, String teamName1, String teamName2) {
        int loveScore1 = getLoveScore(new EnumMap<>(loveCountMap), teamName1);
        int loveScore2 = getLoveScore(new EnumMap<>(loveCountMap), teamName2);

        if (loveScore1 == loveScore2) {
            return teamName2.compareTo(teamName1);
        }

        return Integer.compare(loveScore1, loveScore2);
    }

    private static int getLoveScore(Map<LoveCharacter, Integer> loveCountMap, String teamName) {
        countLoveCharacters(loveCountMap, teamName);
        return calculateLoveScore(loveCountMap);
    }

    private static void countLoveCharacters(Map<LoveCharacter, Integer> loveCountMap, String name) {
        for (char character : name.toCharArray()) {
            Optional<LoveCharacter> loveCharacterOptional = LoveCharacter.fromChar(character);
            loveCharacterOptional.ifPresent(loveCharacter ->
                    loveCountMap.put(loveCharacter, loveCountMap.getOrDefault(loveCharacter, 0) + 1)
            );
        }
    }

    private static int calculateLoveScore(Map<LoveCharacter, Integer> loveCountMap) {
        int lCount = loveCountMap.getOrDefault(LoveCharacter.L, 0);
        int oCount = loveCountMap.getOrDefault(LoveCharacter.O, 0);
        int vCount = loveCountMap.getOrDefault(LoveCharacter.V, 0);
        int eCount = loveCountMap.getOrDefault(LoveCharacter.E, 0);

        return ((lCount + oCount) *
                (lCount + vCount) *
                (lCount + eCount) *
                (oCount + vCount) *
                (oCount + eCount) *
                (vCount + eCount)) % 100;
    }

    enum LoveCharacter {
        L('L'),
        O('O'),
        V('V'),
        E('E');

        private final char character;

        LoveCharacter(char character) {
            this.character = character;
        }

        public static Optional<LoveCharacter> fromChar(char character) {
            return Arrays.stream(LoveCharacter.values())
                    .filter(loveCharacter -> loveCharacter.character == character)
                    .findFirst();
        }
    }
}
