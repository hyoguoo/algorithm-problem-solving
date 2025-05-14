/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13163
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AddingGodToNickname {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nicknameCount = Integer.parseInt(bufferedReader.readLine());
        String[] nicknames = new String[nicknameCount];

        for (int i = 0; i < nicknameCount; i++) {
            nicknames[i] = bufferedReader.readLine();
        }

        System.out.print(solution(nicknames));
    }

    private static String solution(String[] nicknames) {
        return Arrays.stream(nicknames)
                .map(AddingGodToNickname::convertNickname)
                .collect(Collectors.joining("\n"));
    }

    private static String convertNickname(String nickname) {
        return Arrays.stream(nickname.split(" "))
                .skip(1)
                .collect(Collectors.joining("", "god", ""));
    }
}
