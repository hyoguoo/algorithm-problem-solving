/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4673
 * Cheat Level: 0
 * Algorithm: Brute Force / Mathematics
 */

package BruteForce;

public class SelfNumber {

    public static void main(String[] args) {
        boolean[] checkNumber = findCheckNumber();
        System.out.println(getResult(checkNumber));
    }

    private static boolean[] findCheckNumber() {
        boolean[] check = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            int n = d(i);
            if (n < 10001) check[n] = true;
        }
        return check;
    }

    private static StringBuilder getResult(boolean[] check) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 10001; i++) if (!check[i]) stringBuilder.append(i).append("\n");
        return stringBuilder;
    }

    private static int d(int i) {
        int sum = i;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
