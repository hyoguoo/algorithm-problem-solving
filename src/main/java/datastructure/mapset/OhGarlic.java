/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32978
 * Cheat Level: 0
 * Algorithm: Set / Implementation
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OhGarlic {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] allIngredients = bufferedReader.readLine().split(" ");
        String[] usedIngredients = bufferedReader.readLine().split(" ");

        System.out.print(solution(allIngredients, usedIngredients));
    }

    public static String solution(String[] allIngredients, String[] usedIngredients) {
        Set<String> usedIngredientSet = new HashSet<>(Arrays.asList(usedIngredients));

        return Arrays.stream(allIngredients)
                .filter(ingredient -> !usedIngredientSet.contains(ingredient))
                .findFirst()
                .orElse(null);
    }
}
