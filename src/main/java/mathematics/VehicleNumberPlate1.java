/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16968
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class VehicleNumberPlate1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VehiclePlate vehiclePlate = new VehiclePlate(bufferedReader.readLine());

        System.out.print(solution(vehiclePlate));
    }

    private static int solution(VehiclePlate vehiclePlate) {
        String format = vehiclePlate.getFormat();

        return IntStream.range(0, format.length())
                .map(index -> calculatePossibilities(format, index))
                .reduce(1, (a, b) -> a * b);
    }

    private static int calculatePossibilities(String format, int index) {
        PlateType currentType = PlateType.of(format.charAt(index));
        int availableChoices = currentType.getAvailableChoices();

        return isConsecutive(format, index) ? availableChoices - 1 : availableChoices;
    }

    private static boolean isConsecutive(String format, int index) {
        return index > 0 && format.charAt(index - 1) == format.charAt(index);
    }

    enum PlateType {
        CHARACTER('c', 26),
        DIGIT('d', 10);

        private final char symbol;
        private final int availableChoices;

        PlateType(char symbol, int availableChoices) {
            this.symbol = symbol;
            this.availableChoices = availableChoices;
        }

        public static PlateType of(char symbol) {
            for (PlateType type : values()) {
                if (type.symbol == symbol) {
                    return type;
                }
            }
            throw new IllegalArgumentException();
        }

        public int getAvailableChoices() {
            return availableChoices;
        }
    }

    static class VehiclePlate {

        private final String format;

        public VehiclePlate(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
        }
    }
}
