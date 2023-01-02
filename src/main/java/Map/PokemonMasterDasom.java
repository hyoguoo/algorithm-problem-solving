/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1620
 * Cheat Level: 0
 * Algorithm: Map
 */

package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PokemonMasterDasom {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int pokemonLength = infos[0];
        int questionLength = infos[1];
        Map<String, Integer> pokemonMap = new HashMap<>();
        List<String> pokemonList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= pokemonLength; i++) {
            String key = bufferedReader.readLine();
            pokemonMap.put(key, i);
            pokemonList.add(key);
        }
        for (int i = 0; i < questionLength; i++) {
            String question = bufferedReader.readLine();
            if (isNumeric(question)) stringBuilder.append(pokemonList.get(Integer.parseInt(question) - 1)).append("\n");
            else stringBuilder.append(pokemonMap.get(question)).append("\n");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
