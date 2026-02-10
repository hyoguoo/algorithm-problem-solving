/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2037
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextMessage {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int pressTime = info[0];
        int waitTime = info[1];
        String message = bufferedReader.readLine();

        System.out.print(solution(message, pressTime, waitTime));
    }

    public static int solution(String message, int pressTime, int waitTime) {
        int totalTime = 0;
        int prevButton = -1;

        for (char c : message.toCharArray()) {
            KeypadChar currentKeypadChar = KeypadChar.getByKeypadChar(c);
            int currentButton = currentKeypadChar.getButton();
            int currentPresses = currentKeypadChar.getPresses();

            if (prevButton != -1 && currentButton == prevButton && currentButton != KeypadChar.SPACE.getButton()) {
                totalTime += waitTime;
            }

            totalTime += currentPresses * pressTime;

            prevButton = currentButton;
        }

        return totalTime;
    }

    enum KeypadChar {
        SPACE(' ', 1, 1),
        A('A', 2, 1), B('B', 2, 2), C('C', 2, 3),
        D('D', 3, 1), E('E', 3, 2), F('F', 3, 3),
        G('G', 4, 1), H('H', 4, 2), I('I', 4, 3),
        J('J', 5, 1), K('K', 5, 2), L('L', 5, 3),
        M('M', 6, 1), N('N', 6, 2), O('O', 6, 3),
        P('P', 7, 1), Q('Q', 7, 2), R('R', 7, 3), S('S', 7, 4),
        T('T', 8, 1), U('U', 8, 2), V('V', 8, 3),
        W('W', 9, 1), X('X', 9, 2), Y('Y', 9, 3), Z('Z', 9, 4);

        private static final Map<Character, KeypadChar> BY_CHARACTER = new HashMap<>();

        static {
            Arrays.stream(values())
                    .forEach(kc -> BY_CHARACTER.put(kc.getCharacter(), kc));
        }

        private final char character;
        private final int button;
        private final int presses;

        KeypadChar(char character, int button, int presses) {
            this.character = character;
            this.button = button;
            this.presses = presses;
        }

        public static KeypadChar getByKeypadChar(char character) {
            return BY_CHARACTER.get(character);
        }

        public char getCharacter() {
            return character;
        }

        public int getButton() {
            return button;
        }

        public int getPresses() {
            return presses;
        }
    }
}
