/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1076
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Resistance {

    private static final int MAX_COLOR = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Color[] colors = new Color[MAX_COLOR];
        for (int i = 0; i < MAX_COLOR; i++) {
            colors[i] = Color.of(bufferedReader.readLine());
        }

        System.out.print(solution(colors));
    }

    private static long solution(Color[] colors) {
        return (colors[0].value * 10L + colors[1].value) * colors[2].multiplier;
    }

    enum Color {
        BLACK("black", 0, 1),
        BROWN("brown", 1, 10),
        RED("red", 2, 100),
        ORANGE("orange", 3, 1000),
        YELLOW("yellow", 4, 10000),
        GREEN("green", 5, 100000),
        BLUE("blue", 6, 1000000),
        VIOLET("violet", 7, 10000000),
        GREY("grey", 8, 100000000),
        WHITE("white", 9, 1000000000);

        private final String colorName;
        private final int value;
        private final int multiplier;

        Color(String colorName, int value, int multiplier) {
            this.colorName = colorName;
            this.value = value;
            this.multiplier = multiplier;
        }

        public static Color of(String color) {
            return Arrays.stream(Color.values())
                    .filter(c -> c.colorName.equals(color))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
