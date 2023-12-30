/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2170
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DrawLine {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lines[i] = new Line(info[0], info[1]);
        }

        System.out.println(solution(lines));
    }

    private static int solution(Line[] lines) {
        Arrays.sort(lines, (o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        });

        int currentEnd = lines[0].end;
        int length = currentEnd - lines[0].start;

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].start <= currentEnd && currentEnd < lines[i].end) {
                length += lines[i].end - currentEnd;
                currentEnd = lines[i].end;
            } else if (currentEnd < lines[i].start) {
                length += lines[i].end - lines[i].start;
                currentEnd = lines[i].end;
            }
        }

        return length;
    }

    static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
