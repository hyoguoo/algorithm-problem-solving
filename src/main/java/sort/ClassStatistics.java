/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5800
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClassStatistics {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int classCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= classCount; i++) {
            int[] scores = getScores();
            stringBuilder.append("Class ").append(i).append("\n");
            stringBuilder.append(getClassInfo(scores)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String getClassInfo(int[] scores) {
        return new ClassInfo(scores).toString();
    }

    private static int[] getScores() throws IOException {
        String[] input = bufferedReader.readLine().split(" ");
        int[] scores = new int[input.length - 1];

        for (int i = 1; i < input.length; i++) {
            scores[i - 1] = Integer.parseInt(input[i]);
        }

        return scores;
    }

    static class ClassInfo {
        int max;
        int min;
        int gap;

        public ClassInfo(int[] scores) {
            Arrays.sort(scores);
            this.max = scores[scores.length - 1];
            this.min = scores[0];
            this.gap = this.getGap(scores);
        }

        private int getGap(int[] scores) {
            int maxGap = 0;

            for (int i = 1; i < scores.length; i++) {
                maxGap = Math.max(maxGap, scores[i] - scores[i - 1]);
            }

            return maxGap;
        }

        @Override
        public String toString() {
            return "Max " + this.max + ", Min " + this.min + ", Largest gap " + this.gap;
        }
    }
}
