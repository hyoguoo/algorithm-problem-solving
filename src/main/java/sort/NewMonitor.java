/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20949
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class NewMonitor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int monitorCount = Integer.parseInt(bufferedReader.readLine());
        Monitor[] monitors = new Monitor[monitorCount];

        for (int i = 0; i < monitorCount; i++) {
            int[] monitorInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            monitors[i] = new Monitor(i + 1, monitorInfo[0], monitorInfo[1]);
        }

        System.out.print(solution(monitors));
    }

    private static String solution(Monitor[] monitors) {
        return Arrays.stream(monitors)
                .sorted()
                .map(monitor -> String.valueOf(monitor.id))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    static class Monitor implements Comparable<Monitor> {

        private final int id;
        private final int widthPixel;
        private final int heightPixel;

        public Monitor(int id, int widthPixel, int heightPixel) {
            this.id = id;
            this.widthPixel = widthPixel;
            this.heightPixel = heightPixel;
        }

        public long calculatePpKey() {
            long w = widthPixel;
            long h = heightPixel;
            return w * w + h * h;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Monitor monitor = (Monitor) o;
            return id == monitor.id && widthPixel == monitor.widthPixel && heightPixel == monitor.heightPixel;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, widthPixel, heightPixel);
        }

        @Override
        public int compareTo(Monitor o) {
            int cmp = Long.compare(o.calculatePpKey(), this.calculatePpKey());
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(this.id, o.id);
        }
    }
}
