/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2628
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[1];
        int m = info[0];
        int cutCount = Integer.parseInt(bufferedReader.readLine());
        List<Cut> cuts = new ArrayList<>();

        for (int i = 0; i < cutCount; i++) {
            int[] cutInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            cuts.add(new Cut(cutInfo[0], cutInfo[1]));
        }

        System.out.print(solution(n, m, cuts));
    }

    private static int solution(int n, int m, List<Cut> cuts) {
        List<Integer> widthIndexList = new ArrayList<>(List.of(0, m));
        List<Integer> heightIndexList = new ArrayList<>(List.of(0, n));

        for (Cut cut : cuts) {
            if (cut.direction == Direction.HORIZONTAL) {
                heightIndexList.add(cut.index);
            } else {
                widthIndexList.add(cut.index);
            }
        }

        heightIndexList.sort(Integer::compareTo);
        widthIndexList.sort(Integer::compareTo);

        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < heightIndexList.size() - 1; i++) {
            int height = heightIndexList.get(i + 1) - heightIndexList.get(i);
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        for (int i = 0; i < widthIndexList.size() - 1; i++) {
            int width = widthIndexList.get(i + 1) - widthIndexList.get(i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth * maxHeight;
    }

    enum Direction {
        HORIZONTAL(0),
        VERTICAL(1);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public static Direction valueOf(int value) {
            return Arrays.stream(values())
                    .filter(direction -> direction.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class Cut {

        Direction direction;
        int index;

        public Cut(int directionValue, int index) {
            this.direction = Direction.valueOf(directionValue);
            this.index = index;
        }
    }
}
