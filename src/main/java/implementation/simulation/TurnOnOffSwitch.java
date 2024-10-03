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
        int[] switches = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int queryCount = Integer.parseInt(bufferedReader.readLine());

        Query[] queries = new Query[queryCount];
        for (int i = 0; i < queryCount; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            queries[i] = new Query(Integer.parseInt(query[0]), Integer.parseInt(query[1]));
        }

        System.out.print(solution(switches, queries));
    }

    public static String solution(int[] switches, Query[] queries) {
        Switch switcher = new Switch(switches);

        Arrays.stream(queries)
                .forEach(switcher::executeQuery);

        return switcher.toString();
    }

    enum SwitchType {
        MULTIPLE(1),
        SYMMETRIC(2);

        private final int value;

        SwitchType(int value) {
            this.value = value;
        }

        public static SwitchType of(int value) {
            return Arrays.stream(values())
                    .filter(switchType -> switchType.value == value)
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Query {

        private final SwitchType type;
        private final int index;

        public Query(int type, int index) {
            this.type = SwitchType.of(type);
            this.index = index;
        }
    }

    static class Switch {

        boolean[] switches;

        public Switch(int[] switches) {
            this.switches = new boolean[switches.length + 1];
            for (int i = 1; i < this.switches.length; i++) {
                this.switches[i] = switches[i - 1] == 1;
            }
        }

        public void executeQuery(Query query) {
            switch (query.type) {
                case MULTIPLE:
                    switchMultiple(query.index);
                    break;
                case SYMMETRIC:
                    switchSymmetrically(query.index);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private void switchMultiple(int number) {
            for (int i = number; i < switches.length; i += number) {
                switches[i] = !switches[i];
            }
        }

        private void switchSymmetrically(int center) {
            int left = center - 1;
            int right = center + 1;

            switches[center] = !switches[center];
            while (left >= 1 && right < switches.length) {
                if (switches[left] != switches[right]) {
                    break;
                }
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
                stringBuilder
                        .append(switches[i] ? 1 : 0)
                        .append(" ");
                if (i % LINE_LENGTH == 0) {
                    stringBuilder.append("\n");
                }
            }

            return stringBuilder.toString().trim();
        }
    }
}
