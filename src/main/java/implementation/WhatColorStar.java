/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30676
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WhatColorStar {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static Color solution(int wavelength) {
        return Color.of(wavelength);
    }

    enum Color {
        RED(620, 781, "Red"),
        ORANGE(590, 620, "Orange"),
        YELLOW(570, 590, "Yellow"),
        GREEN(495, 570, "Green"),
        BLUE(450, 495, "Blue"),
        INDIGO(425, 450, "Indigo"),
        VIOLET(380, 425, "Violet");

        private final int min;
        private final int max;
        private final String name;

        Color(int min, int max, String name) {
            this.min = min;
            this.max = max;
            this.name = name;
        }

        public static Color of(int wavelength) {
            return Arrays.stream(values())
                    .filter(color -> color.contains(wavelength))
                    .findFirst()
                    .orElseThrow();
        }

        public boolean contains(int wavelength) {
            return min <= wavelength && wavelength < max;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
