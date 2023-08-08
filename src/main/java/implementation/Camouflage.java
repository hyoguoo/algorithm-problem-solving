/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 42578
 * Cheat Level: 0
 * Algorithm: Implementation / Hash Map
 */

package implementation;

import java.util.HashMap;

public class Camouflage {

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        System.out.println(camouflage.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        return map.values().stream()
                .reduce(1, (a, b) -> a * (b + 1)) - 1;
    }
}
