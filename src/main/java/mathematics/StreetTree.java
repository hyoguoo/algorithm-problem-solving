/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2485
 * Cheat Level: 0
 * Algorithm: Mathematics / GCD
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreetTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Integer> differences = new ArrayList<>();
        int previous = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i < n; i++) {
            int current = Integer.parseInt(bufferedReader.readLine());
            differences.add(current - previous);
            previous = current;
        }

        System.out.println(solution(differences));
    }

    private static int solution(List<Integer> differences) {
        int gcd = differences.get(0);

        for (int i = 1; i < differences.size(); i++) {
            gcd = gcd(gcd, differences.get(i));
        }

        int result = gcd;
        return differences.stream()
                .mapToInt(difference -> difference / result - 1)
                .sum();
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
