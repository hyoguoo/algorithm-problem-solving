/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2816
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigitalTV {

    private static final String KBS1 = "KBS1";
    private static final String KBS2 = "KBS2";
    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] channels = new String[n];

        for (int i = 0; i < n; i++) {
            channels[i] = bufferedReader.readLine();
        }

        System.out.print(solution(channels).stream().map(Enum::toString).collect(Collectors.joining()));
    }

    private static List<Button> solution(String[] channels) {
        List<Button> buttons = new ArrayList<>();

        int kbs1Index = findChannelIndex(channels, KBS1);
        moveToTop(channels, kbs1Index, 0, buttons);

        int kbs2Index = findChannelIndex(channels, KBS2);
        moveToTop(channels, kbs2Index, 1, buttons);

        return buttons;
    }

    private static int findChannelIndex(String[] channels, String name) {
        return IntStream.range(0, channels.length)
                .filter(i -> channels[i].equals(name))
                .findFirst()
                .orElse(NOT_FOUND);
    }

    private static void moveToTop(String[] channels, int fromIndex, int targetIndex, List<Button> buttons) {
        for (int i = 0; i < fromIndex; i++) {
            buttons.add(Button.DOWN_ARROW);
        }

        for (int i = fromIndex; i > targetIndex; i--) {
            swap(channels, i, i - 1);
            buttons.add(Button.UP_CHANNEL);
        }
    }

    private static void swap(String[] channels, int i, int j) {
        String temp = channels[i];
        channels[i] = channels[j];
        channels[j] = temp;
    }

    enum Button {
        DOWN_ARROW(1),
        UP_ARROW(2),
        DOWN_CHANNEL(3),
        UP_CHANNEL(4);

        private final int code;

        Button(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return String.valueOf(code);
        }
    }
}
