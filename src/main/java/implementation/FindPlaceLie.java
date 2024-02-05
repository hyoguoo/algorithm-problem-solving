/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1652
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPlaceLie {

    static final char EMPTY = '.';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }

        solution(map);
    }

    private static void solution(char[][] map) {
        int rowCount = 0;
        int colCount = 0;

        for (char[] chars : map) {
            rowCount += findPlaceLie(chars);
        }

        for (int i = 0; i < map.length; i++) {
            char[] chars = new char[map.length];
            for (int j = 0; j < map.length; j++) {
                chars[j] = map[j][i];
            }
            colCount += findPlaceLie(chars);
        }

        System.out.print(rowCount + " " + colCount);
    }

    private static int findPlaceLie(char[] chars) {
        int count = 0;
        int length = 0;

        for (char aChar : chars) {
            if (aChar == EMPTY) {
                length++;
            } else {
                if (length >= 2) count++;
                length = 0;
            }
        }

        if (length >= 2) {
            count++;
        }

        return count;
    }
}
