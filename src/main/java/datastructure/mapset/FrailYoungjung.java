/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14670
 * Cheat Level: 0
 * Algorithm: Implementation / Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.StringJoiner;

public class FrailYoungjung {

    private static final String YOU_DIED = "YOU DIED";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int medicineTypeCount = Integer.parseInt(bufferedReader.readLine().trim());

        MedicineCabinet cabinet = new MedicineCabinet();
        for (int i = 0; i < medicineTypeCount; i++) {
            int[] pair = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int effectCode = pair[0];
            int medicineName = pair[1];
            cabinet.stock(effectCode, medicineName);
        }

        int symptomRequestsCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<int[]> symptomRequests = new ArrayList<>(symptomRequestsCount);
        for (int i = 0; i < symptomRequestsCount; i++) {
            String[] split = bufferedReader.readLine().split(" ");
            int[] tokens = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            int[] symptoms = Arrays.copyOfRange(tokens, 1, tokens.length);
            symptomRequests.add(symptoms);
        }

        System.out.print(String.join("\n", solution(cabinet, symptomRequests)));
    }

    static List<String> solution(MedicineCabinet cabinet, List<int[]> requests) {
        List<String> lines = new ArrayList<>(requests.size());
        for (int[] symptoms : requests) {
            boolean died = false;
            StringJoiner joiner = new StringJoiner(" ");
            for (int symptom : symptoms) {
                OptionalInt name = cabinet.findNameByEffect(symptom);
                if (name.isEmpty()) {
                    died = true;
                    break;
                }
                joiner.add(Integer.toString(name.getAsInt()));
            }
            lines.add(died ? YOU_DIED : joiner.toString());
        }
        return lines;
    }


    static final class MedicineCabinet {

        private final Map<Integer, Integer> effectToName = new HashMap<>();

        void stock(int effect, int name) {
            effectToName.put(effect, name);
        }

        OptionalInt findNameByEffect(int effect) {
            Integer v = effectToName.get(effect);
            return v == null ? OptionalInt.empty() : OptionalInt.of(v);
        }
    }
}
