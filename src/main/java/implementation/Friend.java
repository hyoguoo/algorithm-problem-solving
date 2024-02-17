/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1058
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Friend {

    static final char IS_FRIEND = 'Y';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        boolean[][] friends = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                friends[i][j] = line.charAt(j) == IS_FRIEND;
            }
        }

        System.out.print(solution(friends));
    }

    private static int solution(boolean[][] friends) {
        return IntStream.range(0, friends.length)
                .map(i -> countFriends(friends, i))
                .max()
                .orElse(0);
    }

    private static int countFriends(boolean[][] friends, int me) {
        int count = 0;

        for (int firend = 0; firend < friends.length; firend++) {
            if (me == firend) {
                continue;
            }

            if (friends[me][firend]) {
                count++;
            } else {
                for (int middle = 0; middle < friends.length; middle++) {
                    if (friends[me][middle] && friends[firend][middle]) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}
