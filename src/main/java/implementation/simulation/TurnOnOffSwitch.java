/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1244
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TurnOnOffSwitch {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] switches = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(bufferedReader.readLine());

        Switch switcher = new Switch(switches);

        while (n-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (info[0] == 1) switcher.switchMultiple(info[1]);
            else switcher.switchSymmetrically(info[1]);
        }

        System.out.println(switcher);
    }

    static class Switch {
        boolean[] switches;

        public Switch(int[] switches) {
            this.switches = new boolean[switches.length + 1];
            for (int i = 1; i < this.switches.length; i++) {
                this.switches[i] = switches[i - 1] == 1;
            }
        }

        public void switchMultiple(int number) {
            for (int i = number; i < switches.length; i += number) {
                switches[i] = !switches[i];
            }
        }

        public void switchSymmetrically(int center) {
            int left = center - 1;
            int right = center + 1;

            switches[center] = !switches[center];
            while (left >= 1 && right < switches.length) {
                if (switches[left] != switches[right]) break;
                switches[left] = !switches[left];
                switches[right] = !switches[right];
                left--;
                right++;
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            final int LINE_LENGTH = 20;

            for (int i = 1; i < switches.length; i++) {
                stringBuilder.append(switches[i] ? 1 : 0).append(" ");
                if (i % LINE_LENGTH == 0) stringBuilder.append("\n");
            }

            return stringBuilder.toString().trim();
        }
    }
}
