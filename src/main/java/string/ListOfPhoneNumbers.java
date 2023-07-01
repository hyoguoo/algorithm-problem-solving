/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5052
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListOfPhoneNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        for (int test = 0; test < testCount; test++) {
            int listCount = Integer.parseInt(bufferedReader.readLine());
            List<String> phoneNumberList = new ArrayList<>();
            for (int list = 0; list < listCount; list++) phoneNumberList.add(bufferedReader.readLine());
            System.out.println(solution(phoneNumberList) ? "YES" : "NO");
        }
    }

    private static boolean solution(List<String> phoneNumberList) {
        phoneNumberList.sort(String::compareTo);
        for (int i = 0; i < phoneNumberList.size() - 1; i++) {
            if (phoneNumberList.get(i + 1).startsWith(phoneNumberList.get(i))) return false;
        }
        return true;
    }
}
