/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11971
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SpeedingViolation {

    private static final int ROAD_LENGTH = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sectionCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int limitSectionCount = sectionCounts[0];
        int measuredSectionCount = sectionCounts[1];

        Section[] limitSections = new Section[limitSectionCount];
        for (int i = 0; i < limitSectionCount; i++) {
            int[] intervalInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            limitSections[i] = new Section(intervalInfo[0], intervalInfo[1]);
        }
        Section[] measuredSections = new Section[measuredSectionCount];
        for (int i = 0; i < measuredSectionCount; i++) {
            int[] intervalInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            measuredSections[i] = new Section(intervalInfo[0], intervalInfo[1]);
        }

        System.out.print(solution(limitSections, measuredSections));
    }

    private static int solution(Section[] limitSections, Section[] measuredSections) {
        int[] limitSpeeds = buildSpeedMapBySection(limitSections);
        int[] measuredSpeeds = buildSpeedMapBySection(measuredSections);

        return IntStream.rangeClosed(1, ROAD_LENGTH)
                .map(i -> Math.max(measuredSpeeds[i] - limitSpeeds[i], 0))
                .max()
                .orElse(0);
    }

    private static int[] buildSpeedMapBySection(Section[] sections) {
        int[] speedMap = new int[ROAD_LENGTH + 1];

        int position = 1;
        for (Section section : sections) {
            for (int i = 0; i < section.distance; i++) {
                speedMap[position++] = section.speed;
            }
        }

        return speedMap;
    }

    static class Section {

        private final int distance;
        private final int speed;

        public Section(int distance, int speed) {
            this.distance = distance;
            this.speed = speed;
        }
    }
}
