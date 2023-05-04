/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1436
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectorShun {

    static final String SIX = "666";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.println(getNthMovie(n));
    }

    private static int getNthMovie(int n) {
        int number = 1;
        while (n > 0) {
            number++;
            if (String.valueOf(number).contains(SIX)) n--;
        }
        return number;
    }
}
