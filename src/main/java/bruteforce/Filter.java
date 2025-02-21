/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1895
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Filter {

    private static final int FILTER_SIZE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = sizeInfo[0];
        int sizeM = sizeInfo[1];

        int[][] image = new int[sizeN][sizeM];

        for (int n = 0; n < sizeN; n++) {
            image[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int base = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(image, base));
    }

    private static long solution(int[][] image, int base) {
        int[][] filteredImage = new int[image.length - FILTER_SIZE + 1][image[0].length - FILTER_SIZE + 1];

        for (int n = 0; n < image.length - FILTER_SIZE + 1; n++) {
            for (int m = 0; m < image[0].length - FILTER_SIZE + 1; m++) {
                int[] filter = getFilter(image, n, m);
                int median = getMedian(filter);
                filteredImage[n][m] = median;
            }
        }

        return Arrays.stream(filteredImage)
                .flatMapToInt(Arrays::stream)
                .filter(pixel -> pixel >= base)
                .count();
    }

    private static int getMedian(int[] filter) {
        return Arrays.stream(filter)
                .sorted()
                .toArray()[filter.length / 2];
    }

    private static int[] getFilter(int[][] image, int n, int m) {
        int[] filter = new int[FILTER_SIZE * FILTER_SIZE];

        int index = 0;
        for (int i = n; i < n + FILTER_SIZE; i++) {
            for (int j = m; j < m + FILTER_SIZE; j++) {
                filter[index++] = image[i][j];
            }
        }

        return filter;
    }
}
