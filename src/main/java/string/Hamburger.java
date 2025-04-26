/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32751
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;

public class Hamburger {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] materialsCount = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        EnumMap<Material, Integer> materialsCountMap = new EnumMap<>(Material.class);
        for (int i = 0; i < materialsCount.length; i++) {
            materialsCountMap.put(Material.values()[i], materialsCount[i]);
        }
        Material[] materials = Arrays.stream(bufferedReader.readLine().split(""))
                .map(Material::of)
                .toArray(Material[]::new);

        System.out.print(solution(materials, materialsCountMap) ? "Yes" : "No");
    }

    private static boolean solution(Material[] materials, EnumMap<Material, Integer> materialsCountMap) {
        return Arrays.stream(materials)
                .allMatch(material ->
                        canUseMaterial(materialsCountMap, material) &&
                        isValidBreadPlacement(materials, Arrays.asList(materials).indexOf(material)) &&
                        isDifferentMaterialBehind(materials, Arrays.asList(materials).indexOf(material), material));
    }

    private static boolean canUseMaterial(EnumMap<Material, Integer> materialsCountMap, Material material) {
        int materialCount = materialsCountMap.get(material);
        if (materialCount == 0) {
            return false;
        }
        materialsCountMap.put(material, materialCount - 1);
        return true;
    }

    private static boolean isValidBreadPlacement(Material[] materials, int i) {
        return !(i == 0 || i == materials.length - 1) || materials[i].equals(Material.BREAD);
    }

    private static boolean isDifferentMaterialBehind(Material[] materials, int i, Material material) {
        if (i < materials.length - 1) {
            Material nextMaterial = materials[i + 1];
            return material != nextMaterial;
        }
        return true;
    }

    enum Material {
        BREAD("a"),
        PATTY("b"),
        LETTUCE("c"),
        TOMATO("d");

        private final String value;

        Material(String value) {
            this.value = value;
        }

        public static Material of(String value) {
            return Arrays.stream(Material.values())
                    .filter(material -> material.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
