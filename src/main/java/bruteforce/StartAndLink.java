/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14889
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartAndLink {

    static int min = Integer.MAX_VALUE;
    static int[][] members;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(min);
    }

    private static void solution() {
        getMembers(new ArrayList<>());
    }

    private static void getMembers(List<Integer> team) {
        if (team.size() == members.length / 2) {
            min = Math.min(min, getDiffScore(team));
            return;
        }

        int lastIndex = team.isEmpty() ? -1 : team.get(team.size() - 1);
        for (int i = lastIndex + 1; i < members.length; i++) {
            team.add(i);
            getMembers(team);
            team.remove(team.size() - 1);
        }
    }

    private static int getDiffScore(List<Integer> team) {
        return Math.abs(getTeamScore(team) - getTeamScore(getAnotherTeam(team)));
    }

    private static List<Integer> getAnotherTeam(List<Integer> team) {
        return IntStream.range(0, members.length)
                .filter(i -> !team.contains(i))
                .boxed()
                .collect(Collectors.toList());
    }

    private static int getTeamScore(List<Integer> team) {
        int score = 0;

        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                score += members[team.get(i)][team.get(j)];
                score += members[team.get(j)][team.get(i)];
            }
        }

        return score;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        members = new int[N][N];
        for (int n = 0; n < N; n++) {
            members[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
