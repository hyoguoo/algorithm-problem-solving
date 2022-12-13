/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11723
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetProblem {

    static final boolean[] exist = new boolean[21];
    static final StringBuilder stringBuilder = new StringBuilder();
    static final String ADD = "add";
    static final String REMOVE = "remove";
    static final String CHECK = "check";
    static final String TOGGLE = "toggle";
    static final String ALL = "all";
    static final String EMPTY = "empty";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            String[] input = bufferedReader.readLine().split(" ");

            action(input);
        }

        if (stringBuilder.length() > 1) stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

    private static void action(String[] input) {
        String command = input[0];
        int number = input.length > 1 ? Integer.parseInt(input[1]) : 0;
        switch (command) {
            case ADD:
                exist[number] = true;
                break;
            case REMOVE:
                exist[number] = false;
                break;
            case CHECK:
                stringBuilder.append(exist[number] ? 1 : 0).append("\n");
                break;
            case TOGGLE:
                exist[number] = !exist[number];
                break;
            case ALL:
                for (int i = 1; i <= 20; i++) exist[i] = true;
                break;
            case EMPTY:
                for (int i = 1; i <= 20; i++) exist[i] = false;
                break;
        }
    }
}
