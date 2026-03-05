/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30007
 * Cheat Level: 0
 * Algorithm: Mathematics / Arithmetic
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RamenFormula {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int recipeCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (recipeCount-- > 0) {
            RamenRecipe recipe = RamenRecipe.of(bufferedReader.readLine());
            stringBuilder
                    .append(solution(recipe))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder);
    }

    private static int solution(RamenRecipe recipe) {
        return recipe.getCoefficient() * (recipe.getQuantity() - 1) + recipe.getBaseWater();
    }

    private static final class RamenRecipe {

        private final int coefficient;
        private final int baseWater;
        private final int quantity;

        private RamenRecipe(int coefficient, int baseWater, int quantity) {
            this.coefficient = coefficient;
            this.baseWater = baseWater;
            this.quantity = quantity;
        }

        public static RamenRecipe of(String input) {
            String[] recipeDetails = input.split(" ");
            return new RamenRecipe(
                    Integer.parseInt(recipeDetails[0]),
                    Integer.parseInt(recipeDetails[1]),
                    Integer.parseInt(recipeDetails[2])
            );
        }

        public int getCoefficient() {
            return coefficient;
        }

        public int getBaseWater() {
            return baseWater;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
