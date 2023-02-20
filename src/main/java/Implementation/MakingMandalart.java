/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27495
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakingMandalart {

    final static int N = 9;
    final static int[][] AROUND = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    final static int[][] SUB_TARGET = {{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 7}, {7, 1}, {7, 4}, {7, 7}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[][] mandalart = new String[N][N];
        for (int i = 0; i < N; i++) {
            mandalart[i] = bufferedReader.readLine().split(" ");
        }

        List<Target> result = getResult(mandalart);
        printResult(result);
    }

    private static void printResult(List<Target> result) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            Target target = result.get(i);
            String targetString = target.target;
            List<String> detailTargetList = target.detailTargetList;
            stringBuilder.append("#").append(i + 1).append(". ").append(targetString).append("\n");
            for (int j = 0; j < detailTargetList.size(); j++) {
                String detailTarget = detailTargetList.get(j);
                stringBuilder.append("#").append(i + 1).append("-").append(j + 1).append(". ").append(detailTarget).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }

    private static List<Target> getResult(String[][] mandalart) {
        List<Target> targetList = new ArrayList<>();

        for (int[] subTargetCoordinate : SUB_TARGET) {
            int targetX = subTargetCoordinate[0];
            int targetY = subTargetCoordinate[1];
            String target = mandalart[targetX][targetY];
            List<String> detailTargetList = new ArrayList<>();
            for (int[] around : AROUND) {
                int x = targetX + around[0];
                int y = targetY + around[1];
                String detailTarget = mandalart[x][y];
                detailTargetList.add(detailTarget);
            }
            targetList.add(new Target(target, detailTargetList));
        }
        Collections.sort(targetList);

        return targetList;
    }

    static class Target implements Comparable<Target> {
        String target;
        List<String> detailTargetList;

        public Target(String target, List<String> detailTargetList) {
            this.target = target;
            this.detailTargetList = detailTargetList;
            Collections.sort(this.detailTargetList);
        }

        @Override
        public int compareTo(Target o) {
            return this.target.compareTo(o.target);
        }
    }
}
