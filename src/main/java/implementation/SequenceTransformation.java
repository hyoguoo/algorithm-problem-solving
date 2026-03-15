/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1551
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SequenceTransformation {

    private static final String SPACE = " ";
    private static final String COMMA = ",";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bufferedReader.readLine().split(SPACE);
        int transformationCount = Integer.parseInt(info[1]);

        int[] sequence = Arrays.stream(bufferedReader.readLine().split(COMMA))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(new InputData(transformationCount, sequence)));
    }

    private static String solution(InputData inputData) {
        int[] currentSequence = inputData.getSequence();

        for (int i = 0; i < inputData.getTransformationCount(); i++) {
            if (currentSequence.length <= 1) {
                break;
            }
            int[] nextSequence = new int[currentSequence.length - 1];
            for (int j = 0; j < currentSequence.length - 1; j++) {
                nextSequence[j] = currentSequence[j + 1] - currentSequence[j];
            }
            currentSequence = nextSequence;
        }

        return Arrays.stream(currentSequence)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(COMMA));
    }

    private static class InputData {

        private final int transformationCount;
        private final int[] sequence;

        public InputData(int transformationCount, int[] sequence) {
            this.transformationCount = transformationCount;
            this.sequence = sequence;
        }

        public int getTransformationCount() {
            return transformationCount;
        }

        public int[] getSequence() {
            return sequence;
        }
    }
}
