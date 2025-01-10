/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30502
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WakameNotPlant {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int plantCount = info[0];
        int experimentCount = info[1];

        Experiment[] experiments = new Experiment[experimentCount];
        for (int i = 0; i < experimentCount; i++) {
            experiments[i] = new Experiment(bufferedReader.readLine());
        }

        System.out.print(solution(plantCount, experiments));
    }

    private static String solution(int plantCount, Experiment[] experiments) {
        PlantInfo[] plantInfos = processPlantInfos(plantCount, experiments);

        PlantCountResult plantCounts = calculatePlantCounts(plantInfos);

        return plantCounts.minCount + " " + plantCounts.maxCount;
    }

    private static PlantInfo[] processPlantInfos(int plantCount, Experiment[] experiments) {
        PlantInfo[] plantInfos = initializePlantInfos(plantCount);

        for (Experiment experiment : experiments) {
            PlantInfo plantInfo = plantInfos[experiment.plantNumber];
            if (experiment.plantFunction == PlantFunction.PHOTOSYNTHESIS) {
                plantInfo.photosynthesis = experiment.isFunction ? PlantStatus.POSSIBLE : PlantStatus.IMPOSSIBLE;
            } else {
                plantInfo.motility = experiment.isFunction ? PlantStatus.POSSIBLE : PlantStatus.IMPOSSIBLE;
            }
        }

        return plantInfos;
    }

    private static PlantInfo[] initializePlantInfos(int plantCount) {
        PlantInfo[] plantInfos = new PlantInfo[plantCount + 1];

        for (int i = 1; i <= plantCount; i++) {
            plantInfos[i] = new PlantInfo();
        }

        return plantInfos;
    }

    private static PlantCountResult calculatePlantCounts(PlantInfo[] plantInfos) {
        int minPlantCount = 0;
        int maxPlantCount = 0;

        for (int i = 1; i < plantInfos.length; i++) {
            PlantInfo plantInfo = plantInfos[i];
            if (plantInfo.isPlant()) {
                minPlantCount++;
                maxPlantCount++;
            } else if (plantInfo.isUnknown()) {
                maxPlantCount++;
            }
        }

        return new PlantCountResult(minPlantCount, maxPlantCount);
    }

    enum PlantFunction {
        PHOTOSYNTHESIS("P"),
        MOTILITY("M");

        private final String value;

        PlantFunction(String value) {
            this.value = value;
        }

        public static PlantFunction of(String value) {
            return Arrays.stream(values())
                    .filter(plantFunction -> plantFunction.value.equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum PlantStatus {
        POSSIBLE,
        IMPOSSIBLE,
        UNKNOWN
    }

    private static class PlantCountResult {

        private final int minCount;
        private final int maxCount;

        public PlantCountResult(int minCount, int maxCount) {
            this.minCount = minCount;
            this.maxCount = maxCount;
        }
    }

    static class PlantInfo {

        private PlantStatus photosynthesis;
        private PlantStatus motility;

        public PlantInfo() {
            this.photosynthesis = PlantStatus.UNKNOWN;
            this.motility = PlantStatus.UNKNOWN;
        }

        public boolean isPlant() {
            return photosynthesis == PlantStatus.POSSIBLE && motility == PlantStatus.IMPOSSIBLE;
        }

        public boolean isUnknown() {
            return (photosynthesis == PlantStatus.UNKNOWN && motility == PlantStatus.UNKNOWN) ||
                    (photosynthesis == PlantStatus.POSSIBLE && motility == PlantStatus.UNKNOWN) ||
                    (photosynthesis == PlantStatus.UNKNOWN && motility == PlantStatus.IMPOSSIBLE);
        }
    }

    static class Experiment {

        private final int plantNumber;
        private final PlantFunction plantFunction;
        private final boolean isFunction;

        public Experiment(String input) {
            String[] info = input.split(" ");
            this.plantNumber = Integer.parseInt(info[0]);
            this.plantFunction = PlantFunction.of(info[1]);
            this.isFunction = info[2].equals("1");
        }
    }
}
