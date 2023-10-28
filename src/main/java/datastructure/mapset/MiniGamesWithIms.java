/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25757
 * Cheat Level: 0
 * Algorithm: Implementation / Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MiniGamesWithIms {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] gameInfo = bufferedReader.readLine().split(" ");
        int gameCount = Integer.parseInt(gameInfo[0]);
        String gameType = gameInfo[1];

        final Map<String, Integer> nameMap = new HashMap<>();
        int needPeople = getNeedPeople(gameType);
        int count = 0;

        for (int i = 0; i < gameCount; i++) {
            String name = bufferedReader.readLine();
            if (!nameMap.containsKey(name)) {
                nameMap.put(name, 0);
                count++;
            }
        }
        System.out.println(count / needPeople);
    }

    private static int getNeedPeople(String gameType) {
        if (gameType.equals("Y")) return 1;
        if (gameType.equals("F")) return 2;
        if (gameType.equals("O")) return 3;
        return -1;
    }
}
